
public class Posn{

    double x;
    double y;
       
    public Posn(double i, double j){
        this.x = i;
        this.y = j;
    }
    
    public double getX(){
        return this.x;
    }
    
    public double getY(){
        return this.y;
    }
    
    public boolean equals (Object o) {
        if (o instanceof Posn){
            Posn that = (Posn) o;
            return ((this.x == that.x) && (this.y == that.y));
        }
        return false;
    }
    
    public String toString(){
        return "(" +x+ ", " +y+ ")";
    }
    
    double distance(Posn p){
        return (Math.sqrt
                    (((p.getX() - x) * (p.getX() - x))
                    +
                    ((p.getY() - y) * (p.getY() - y))
                    ));
    }
                
    Posn add(Posn a){
        return new Posn(x+a.getX(),y+a.getY());
    }
    
    Posn subtract(Posn a){
        return new Posn(x-a.getX(), y-a.getY());
    }
    
    Posn multiply(Posn a){
        return new Posn(a.getX()*x, a.getY()*y);
    }
    
    Posn multiply(double amt){
        return multiply(new Posn(amt,amt));
    }
    
    Posn reflect(Line other){
        double n = -(1/other.slope());
        if(other.slope()==0||other.slope()==-0){
            return new Posn(this.x, this.y+2*((other.getX().getY()-this.y)));
        }
        double deltay = n;
        double deltax = 1;
        
        Posn second = new Posn(this.getX()+deltax,this.getY()+deltay);
        Line perp = new Line(this,second);
        
        Posn intersection = other.intersect(perp);
        
        if(n==0){
            return new Posn(this.x+this.distance(intersection)*2,this.y);
        }
        
        Posn reflect = intersection.subtract(this);
        return reflect;
    }
    
    Posn rotate(Posn center, double theta){
        //theta = Math.toRadians(theta);
        theta*=-1;
        return new Posn(
                        Math.cos(theta)*(x-center.getX())-Math.sin(theta)*(y-center.getY())+center.getX(),
                        Math.sin(theta)*(x-center.getX())+Math.cos(theta)*(y-center.getY())+center.getY());
    }
}
