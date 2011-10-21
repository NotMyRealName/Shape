public class LineTest extends junit.framework.TestCase
{
    Line a;
    Line b;
    Line c;
    
    Line d;
    Line e;
    Line f;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    
    public void setUp()
    {
        a = new Line(new Posn(0,0),new Posn(10,10));
        b = new Line(new Posn(5,5),new Posn(3,1));
        c = new Line(new Posn(3,10),new Posn(10,1432));
        
        d = new Line(new Posn(0,0),new Posn(0,1));
        e = new Line(new Posn(10,10), new Posn(9,10));
        f = new Line(new Posn(10,10), new Posn(9,9));
    }
    
    
    public void testGetX(){
        assertEquals(a.getX(),new Posn(0,0));
        assertEquals(b.getX(),new Posn(5,5));
        assertEquals(c.getX(),new Posn(3,10));
    }
    
    
    public void testGetY(){
        assertEquals(a.getY(),new Posn(10,10));
        assertEquals(b.getY(),new Posn(3,1));
        assertEquals(c.getY(),new Posn(10,1432));
    }
    
    
    public void testSlope(){
        assertEquals(a.slope(),1.0,Double.NaN);
        assertEquals(c.slope(),203.14285714286,0.01);
        assertEquals(f.slope(),1.0,Double.NaN);
    }
    
    
    public void testIntersect(){
        assertEquals(d.intersect(e), new Posn(0,10));
        assertEquals(d.intersect(f), new Posn(0,0));
        assertEquals(e.intersect(f), new Posn(10,10));
    }
    
    
    public void testEquals(){
        assertFalse(d.equals(e));
        assertFalse(f.equals(a));
        assertTrue(d.equals(d));
    }
    
     
    public void testConvexHull(){
        assertEquals(Math.abs(d.convexHull(new Posn(1,0))),1.0,Double.NaN);
        assertEquals(Math.abs(d.convexHull(new Posn(-1,0))),1.0,Double.NaN);
        assertEquals(Math.abs(a.convexHull(new Posn(0,10))),100.0,Double.NaN);
    }
    
    
    public void testColinear(){
        assertTrue(d.colinear(new Posn(0,100)));
        assertFalse(d.colinear(new Posn(100,100)));
        assertTrue(a.colinear(new Posn(20,20)));
    }
    
}
