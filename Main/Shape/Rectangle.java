public class Rectangle extends Shape
{
    Posn anchor;
    double length;
    double width;
    double rotation;
    
    Rectangle (Posn c, double a, double b) {
        anchor=c;
        length=a;
        width=b;
        rotation = 0;
    }
    
    Rectangle (Posn p, double x, double y, double z){
        anchor=p;
        length=x;
        width = y;
        rotation = z;
    }
    
    public Posn getAnchor () {
        return this.anchor;
    }
    
    public double getLength () {
        return this.length;
    }
    
    public double getWidth () {
        return this.width;
    }
    
    public double getRotation () {
        return this.rotation;
    }
    
    public String toString () {
        return "(" + this.anchor.toString() + ", " + this.length + ", " + this.width + ", " +rotation+ ")";
    }
    
    public boolean equals (Object o) {
        if (o instanceof Rectangle){
            return (o.toString().equals(this.toString()));
        }
        return false;
    }
    
    public double perimeter() {
        return ((this.getWidth() * 2) + (this.getLength() * 2));
    }
    
    public double area() {
        return (this.getWidth() * this.getLength());
    }
    
  //  public Posn getPosition () {
    //    if (rotation == 0){
      //      return new Posn ((anchor.getX() + (length / 2)), (anchor.getY() + (width / 2)));
   // }

    
    public boolean inside(Posn p) {
        if (p.getX() >= this.anchor.getX() && p.getX() <= (this.anchor.getX() + this.getLength()) 
            && p.getY() >= this.anchor.getY() && p.getY() <= (this.anchor.getY() + this.getWidth())){
                return true;
            }
            return false;
        }
        
    public Rectangle translate(Posn x) {
        return new Rectangle (this.getAnchor().add(x), this.getLength(), this.getWidth(), this.getRotation());
    }
    
    public Rectangle dialate(double n) {
        return new Rectangle (anchor, this.getLength() * n, this.getWidth() * n, this.getRotation());
    }
    
  //  public Rectangle rotate (double d) {
        
    
                

}
