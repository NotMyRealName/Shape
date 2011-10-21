class Circle extends Shape{
    Posn anchor;
    double radius;
    
    
    Circle( Posn w, double y){
        anchor=w;
        radius=y;
    }
    
    Posn getAnchor(){
        return anchor;
    }
    double getRadius(){
        return radius;
    }
    
    public String toString(){
        return "(" + anchor.toString() + ", " + radius + ")";
    }
    
    public boolean equals(Object o){
        if(o instanceof Circle){
            Circle that = (Circle) o;
            return ((anchor.equals(that.getAnchor())) && (radius == that.radius));
        }
        return false;
    }
    
    Posn getPosition(){
        return anchor;
    }
    
    double perimeter(){
        return (radius * 2 * Math.PI);
    }
    
    double area(){
        return (radius * radius * Math.PI);
    }
    
    boolean inside(Posn p){
        if(anchor.distance(p) <= radius){
            return true;
        }
        else{
            return false;
        }
    }
    
    Circle translate(Posn x){
        return (new Circle(x.add(anchor), radius));
    }
    
    Circle rotate(double a){
        return this;
    }
    
    Circle dialate(double n){
        return (new Circle(anchor, (radius * n)));
    }
    
    Circle reflect( Line l){
        return (new Circle(anchor.reflect(l), radius));
    }
    
}