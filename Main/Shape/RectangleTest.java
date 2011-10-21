
public class RectangleTest extends junit.framework.TestCase
{

Posn a;
Posn b;
Posn e;
Posn p0;
Posn p1;
Posn p2;
Posn p3;
Posn p4;
Posn p5;
Posn p6;
Posn p7;
Posn p8;
Posn p9;
Posn p10;
Posn p11;
Posn p12;
Rectangle c;
Rectangle d;
Rectangle f;
Rectangle g;
Rectangle p;

 public void setUp() {
   a = new Posn (4,7);
   b = new Posn (2,1);
   e = new Posn (2,1);
   p0 = new Posn (2,2);
   p1 = new Posn (4,2);
   p2 = new Posn (2,4);
   p3 = new Posn (4,6);
   p4 = new Posn (6,4);
   p5 = new Posn (0,4);
   p6 = new Posn (4,0);
   p7 = new Posn (4,8);
   p8 = new Posn (8,4);
   p9 = new Posn (4,4);
   p10 = new Posn (0,0);
   p11 = new Posn (-4,0);
   p12 = new Posn (0,-4);
   c = new Rectangle (a,4,6);
   d = new Rectangle (b,7,8);
   f = new Rectangle (e,7,8);
   g = new Rectangle (b,7,8,30);
   p = new Rectangle (p0,4,4);
   
  }
  
  
  public void testRectangle (Posn cc, double aa, double bb) {
      Rectangle expected = c;
      Rectangle actual = c;
      assertTrue("Dayyyum.", (expected == actual));
    }
  
    
    public void testGetAnchor() {
        Posn expected = a;
        Posn actual = c.getAnchor();
        assertTrue("Mama Mia", (expected == actual));
        
        Posn expected2 = b;
        Posn actual2 = d.getAnchor();
        assertTrue("Ola Hola.", (expected2 == actual2));
    }
    
    
    public void testGetLength() {
        double expected = 4; 
        double actual = c.getLength();
        assertTrue("Mhuhuhua.", (expected == actual));
        
        double expected2 = 7;
        double actual2 = d.getLength();
        assertTrue("Da Beazt", (expected2 == actual2));
    }
    
    
     public void testGetWidth() {
        double expected = 6; 
        double actual = c.getWidth();
        assertTrue("Mhuhuhua.", (expected == actual));
        
        double expected2 = 8;
        double actual2 = d.getWidth();
        assertTrue("Da Beazt", (expected2 == actual2));
    }
    
    
    public void testGetRotation() {
        assertEquals(0.0, p.getRotation());
        assertEquals(30.0, g.getRotation());
    }
    
    
    public void testToString() {
        String expected = "((4.0, 7.0), 4.0, 6.0, 0.0)";
        String actual = c.toString();
        assertEquals(expected , actual);
        
        String expected2 = "((2.0, 1.0), 7.0, 8.0, 30.0)";
        String actual2 = g.toString();
        assertEquals(expected2 , actual2);
    }
    
    
    public void testEquals() {
        boolean expected = true;
        boolean actual = d.equals(f);
        assertTrue("OMG", (expected == actual));
        
        assertEquals(false, c.equals(d));
        
        assertEquals(false, g.equals(f));
    }
    
    
    public void testPerimeter() {
        assertEquals(20.0, c.perimeter());
    
        assertEquals(30.0, d.perimeter());
    }
    
    
    public void testArea() {
        assertEquals(24.0, c.area());
    
        assertEquals(56.0, d.area());
    }
    
    
 //   public void testGetPosition() {
   //     assertEquals(new Posn(6.0, 10.0), c.getPosition());
    //   
     //   assertEquals(new Posn(5.5, 5.0), d.getPosition());
    //}
    
    
    public void testInside() {
        assertEquals(true, p.inside(p0));
        
        assertEquals(true, p.inside(p1));
        
        assertEquals(true, p.inside(p2));
        
        assertEquals(true, p.inside(p3));
        
        assertEquals(true, p.inside(p4));
        
        assertEquals(false, p.inside(p5));
        
        assertEquals(false, p.inside(p6));
        
        assertEquals(false, p.inside(p7));
        
        assertEquals(false, p.inside(p8));
        
        assertEquals(true, p.inside(p9));
    }
   
    
    public void testTranslate() {
        assertEquals(new Rectangle((new Posn(2,2)),4,4), p.translate(p10));
        
        assertEquals(new Rectangle((new Posn(2,6)),4,4), p.translate(p5));
        
        assertEquals(new Rectangle((new Posn(6,2)),4,4), p.translate(p6));
        
        assertEquals(new Rectangle((new Posn(-2,2)),4,4), p.translate(p11));
        
        assertEquals(new Rectangle((new Posn(2,-2)),4,4), p.translate(p12));
        
        assertEquals(new Rectangle((new Posn(4,4)),4,4), p.translate(p0));
    
        assertEquals(new Rectangle((new Posn(4,3)),7,8,30), g.translate(p0));
    }
    
    
    public void testDialate() {
        assertEquals(new Rectangle(p0,8,8), p.dialate(2));
        
        assertEquals(new Rectangle(p0,-8,-8), p.dialate(-2));
        
        assertEquals(new Rectangle(p0,48,48), p.dialate(12));
        
        assertEquals(new Rectangle(p0,2,2), p.dialate(0.5));
       
        assertEquals(new Rectangle(b,14,16,30), g.dialate(2));
    }
    
    
 //   public void testRotate() {
   //     assertEquals(new Rectangle(p0,4,4,0), p.rotate(0));
     
     //   assertEquals(new Rectangle(p0,4,4,90), p.rotate(90));
        
       // assertEquals(new Rectangle(p0,4,4,270), p.rotate(-90));
        
        //assertEquals(new Rectangle(p0,4,4,0), p.rotate(360));        
    //}

    }
    
