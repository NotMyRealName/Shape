
public class Line
{
    private Posn x; //1
    private Posn y; //2
    
    public Line(Posn _x, Posn _y){
        x=_x;
        y=_y;
    }
    
    public Posn getX(){
        return x;
    }
    
    public Posn getY(){
        return y;
    }
    
    public double slope(){
        return
        (
            (x.getY()-y.getY())
            /
            (x.getX()-y.getX())
        );
    }
    
    public Posn intersect(Line other){
        double x1 = this.getX().getX();
        double x2 = this.getY().getX();
        double x3 = other.getX().getX();
        double x4 = other.getY().getX();
        
        double y1 = this.getX().getY();
        double y2 = this.getY().getY();
        double y3 = other.getX().getY();
        double y4 = other.getY().getY();
        
        double ua = ((x4-x3)*(y1-y3) - (y4-y3)*(x1-x3))
                    /
                    ((y4-y3)*(x2-x1) - (x4-x3)*(y2-y1));
                    
        double ub = ((x2-x1)*(y1-y3) - (y2-y1)*(x1-x3))
                    /
                    ((y4-y3)*(x2-x1) - (x4-x3)*(y2-y1));
                    
        return new Posn(x1+ua*(x2-x1),y1+ua*(y2-y1));
    }
    
    public boolean colinear(Posn p){
        return convexHull(p)==0;
    }
    
    public double convexHull(Posn p){
        double Ax = x.getX();
        double Bx = y.getX();
        
        double Ay = x.getY();
        double By = y.getY();
        
        double Cx = p.getX();
        double Cy = p.getY();
        
        return (Bx-Ax)*(Cy-Ay)-(By-Ay)*(Cx-Ax);
    }
    
    public boolean equals(Object o){
        if(o instanceof Line){
           Line temp = (Line)o;
           return ((temp.getX().equals(x))&&(temp.getY().equals(y)));
        }
        return false;
    }
    
    public double degrees(){
        return Math.acos(
                            (this.getX().getY()-this.getX().getX())*(this.getY().getY()-this.getY().getX())
                            /
                            Math.abs(this.getX().getY()-this.getX().getX())*Math.abs(this.getY().getY()-this.getY().getX()));
        
                         
    }
}
