
/**
 * Abstract class Shape - Abstract superclass defining common functionality for all shapes.
 * 
 * @author Joseph/others
 * @version 0.1
 */
public abstract class Shape
{
    
    abstract double perimeter();
    abstract double area();
    //abstract Posn getPosition();
    abstract boolean inside(Posn p);
    //abstract boolean overlap();
    abstract Shape translate(Posn x);
    //abstract Shape dialate(double n);
    //abstract Shape reflect(line l);
    //abstract Shape rotate(double a);
    
}
