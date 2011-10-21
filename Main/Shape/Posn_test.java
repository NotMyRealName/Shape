
public class Posn_test extends junit.framework.TestCase
{
    Posn a;
    Posn b;
    Posn c;
    Posn d;
    Posn e;
    Posn f;
    Posn g;
    Posn h;
    Posn i;
    Posn j;
    Posn k;
    Posn l;
    Posn m;
    Posn n;
    Posn o;
    Posn p;
    Posn q;
    Posn r;
    Posn s;
    Posn t;
    Posn u;
    Posn v;
    Posn w;
    Posn x;
    
    Line aline;
    Line bline;
    Line cline;
    Line dline;
    
    public void setUp() {
        a = new Posn(3.0, 4.0);
        b = new Posn(3.0, 6.0);
        c = new Posn(6.0, 4.0);
        d = new Posn(4.0, 5.0);
        e = new Posn(0.0, 0.0);
        n = new Posn(3.0, 0.0);
        o = new Posn(7.0, 4.0);
        p = new Posn(4.0, 3.0);
        q = new Posn(3.0, -4.0);
        v = new Posn(1.0, 0.0);
        w = new Posn(0.0, -1.0);
        x = new Posn(0.0, -2.0);
        
        f = new Posn(0.0, 2.0);
        g = new Posn(1.0, 2.0);
        aline = new Line(f, g);
        
        h = new Posn(5.0, 1.0);
        i = new Posn(5.0, 2.0);
        bline = new Line(h, i);
        
        j = new Posn(3.0, 3.0);
        k = new Posn(-3.0, -3.0);
        cline = new Line(j, k);
        
        l = new Posn(0.0, 0.0);
        m = new Posn(1.0, 0.0);
        dline = new Line(l, m);
    }
    public void testPosn(){
        assertTrue(a == a);
        assertTrue(b == b);
    }
    
    public void testGetX(){
        assertTrue(a.getX() == 3);
        assertTrue(d.getX() == 4);
    }

    public void testGetY(){
        assertTrue(d.getY() == 5);
        assertTrue(e.getY() == 0);
    }
    
    public void testEquals(){   
        assertTrue(a.equals(a));
        assertTrue(!(b.equals(a)));
    }
    
    public void testToString(){
        assertEquals(b.toString(), "(3.0, 6.0)");
        assertEquals(e.toString(), "(0.0, 0.0)");
    }
    
    public void testDistance(){
        assertEquals(a.distance(b), 2.0);
        assertEquals(a.distance(c), 3.0);
    }

    public void testSubtract(){
        assertEquals(a.subtract(e),a);
        assertEquals(a.subtract(a),e);
        assertEquals(e.subtract(d), new Posn(-4,-5));
    }
    
    public void testReflect(){
        Line linea = new Line(new Posn(0,0), new Posn(0,1));
        Line lineb = new Line(new Posn(0,0), new Posn(1,0));
        
        Line linec = new Line(new Posn(0,0), new Posn(5,-5));
        Line lined = new Line(new Posn(0,0), new Posn(-5,-5));
        
        assertEquals(new Posn(-10,0).reflect(linea),new Posn(10,0));
        assertEquals(new Posn(-10,5).reflect(lineb), new Posn(-10,-5));
        assertEquals(new Posn(2,2).reflect(linec), new Posn(-2,-2));
        assertEquals(new Posn(-2,-2).reflect(linec), new Posn(2,2));
        assertEquals(new Posn(-5,5).reflect(lined), new Posn(5,-5));
    }
    
    public void testRotate(){
        assertEquals(v.rotate(e, Math.PI / 2).getX(), w.getX(),0.0001);  
        assertEquals(v.rotate(e, Math.PI / 2).getY(), w.getY(),0.0001);  
        assertEquals(w.rotate(e, Math.PI / -2).getX(), v.getX(), 0.0001);
        assertEquals(w.rotate(e, Math.PI / -2).getY(), v.getY(), 0.0001);
        assertEquals(a.rotate(b,  0 ).getX(), a.getX(), 0.0001);
        assertEquals(a.rotate(b,  0 ).getY(), a.getY(), 0.0001);
        assertEquals(f.rotate(l, Math.PI).getX(), x.getX(), 0.0001);
        assertEquals(f.rotate(l, Math.PI).getY(), x.getY(), 0.0001);
        assertEquals(x.rotate(l, Math.PI).getX(), f.getX(), 0.0001);
        assertEquals(x.rotate(l, Math.PI).getY(), f.getY(), 0.0001);
        assertEquals(x.rotate(l, (-1 * Math.PI)).getX(), f.getX(), 0.0001);
        assertEquals(x.rotate(l, (-1 * Math.PI)).getY(), f.getY(), 0.0001);
    }
}
