
/**
 * Write a description of class Triangle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Triangle extends Shape
{
    private Posn anchor;
    private Posn b;
    private Posn c;
    
    private Line l_anchor;
    private Line l_b;
    private Line l_c;
    
    public Triangle(Posn _anchor, Posn _b, Posn _c)
    {
        anchor = _anchor;
        b = _b;
        c = _c;
        
        
        l_anchor = new Line(anchor,b);
        l_b = new Line(anchor,c);
        l_c = new Line(b,c);
     }
    
    public double perimeter(){
        return (anchor.distance(b)+anchor.distance(c)+b.distance(c));
    }
    
    public double area(){
        Posn baseMidp = new Posn((b.getX()+c.getX())/2,(b.getY()+c.getY())/2);
        double base = b.distance(c);
        double height = baseMidp.distance(anchor);
        return (base*height)/2;
    }
    
    public Posn getPosition(){
        double thexavg = (anchor.getX()+b.getX()+c.getX())/3;
        double theyavg = (anchor.getY()+b.getY()+c.getY())/3;
        return new Posn(thexavg,theyavg);
    }
    
    public Posn getCenter(){
        double thexavg = (anchor.getX()+b.getX()+c.getX())/3;
        double theyavg = (anchor.getY()+b.getY()+c.getY())/3;
        return new Posn(thexavg,theyavg);
    }
    
    public Posn getAnchor(){
        return anchor;
    }
    
    public Posn getB(){
        return b;
    }
    
    public Posn getC(){
        return c;
    }
    
    public boolean equals(Object o){
        if(o instanceof Triangle){
            Triangle temp = (Triangle)o;
            return ((anchor.equals(temp.getAnchor()))&&(b.equals(temp.getB()))&&(c.equals(temp.getC())));
        }
        return false;
    }
    
    public String toString(){
        return "("+anchor.toString()+", "+b.toString()+", "+c.toString()+")";
    }
    
     public boolean inside(Posn p){
        double a_num = l_anchor.convexHull(c);
        int a_sign = (a_num>0?1:-1);
        
        double b_num = l_b.convexHull(b);
        int b_sign = (b_num>0?1:-1);
        
        double c_num = l_c.convexHull(anchor);
        double c_sign = (c_num>0?1:-1);
        
        int sign_line_a = (l_anchor.convexHull(p)>0?1:-1);
        int sign_line_b = (l_b.convexHull(p)>0?1:-1);
        int sign_line_c = (l_c.convexHull(p)>0?1:-1);
        
        return ((sign_line_a==a_sign)&&(sign_line_b==b_sign)&&(sign_line_c==c_sign));
    }
    
    public Triangle translate(Posn x){
        return new Triangle(anchor.add(x),b.add(x),c.add(x));   
    }
    
    public double getOrientation(){
        return Math.atan(l_anchor.slope());
    }
    
    public Triangle dilate(double amount){
        return new Triangle(anchor.multiply(amount), b.multiply(amount), c.multiply(amount));
    }
    
    public Triangle rotate(double amount){
        return new Triangle(anchor,b.rotate(anchor,amount), c.rotate(anchor,amount));
    }

    
}
