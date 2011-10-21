

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TriangleTest{
    Posn aposn;
    Posn bposn;
    Posn cposn;
    Triangle abc;
    
    Posn dposn;
    Posn eposn;
    Posn fposn;
    Triangle def;
    
    Posn gposn;
    Posn hposn;
    Posn iposn;
    Triangle ghi;
    
    @Before
    public void setUp(){
        aposn=new Posn(0.0, 0.0);
        bposn=new Posn(0.0, 3.0);
        cposn=new Posn(4.0, 0.0);
        abc=new Triangle(aposn, bposn, cposn);
        dposn=new Posn(0.0, 5.0);
        eposn=new Posn(3.0, 0.0);
        fposn=new Posn(-3.0, 0.0);
        def=new Triangle(dposn, eposn, fposn);
        gposn=new Posn(1.0, -1.0);
        hposn=new Posn(2.0, -2.0);
        iposn=new Posn(3.0, -1.0);
        ghi=new Triangle(gposn, hposn, iposn);
    }
    
    @Test
    public void testGetB(){
        assertEquals(abc.getB(), bposn);
        assertEquals(def.getB(), eposn);
        assertEquals(ghi.getB(), hposn);
    }
    @Test
    public void testGetC(){
        assertEquals(abc.getC(), cposn);
        assertEquals(def.getC(), fposn);
        assertEquals(ghi.getC(), iposn);
    }
    @Test
    public void testGetA(){
        assertEquals(abc.getAnchor(), aposn);
        assertEquals(def.getAnchor(), dposn);
        assertEquals(ghi.getAnchor(), gposn);
    }
    @Test
    public void testToString(){
        assertEquals(abc.toString(), "((0.0, 0.0), (0.0, 3.0), (4.0, 0.0))");
        assertEquals(def.toString(), "((0.0, 5.0), (3.0, 0.0), (-3.0, 0.0))");
        assertEquals(ghi.toString(), "((1.0, -1.0), (2.0, -2.0), (3.0, -1.0))");
    }
    
     
    @Test
    public void testInside(){
        assertTrue(abc.inside(new Posn(1,1)));
        assertTrue(abc.inside(new Posn(2,1.1)));
        assertTrue(abc.inside(new Posn(0.5,2)));
        assertFalse(abc.inside(new Posn(-1,-1)));
        assertTrue(def.inside(new Posn(-1,2)));
        assertTrue(def.inside(new Posn(-2,1)));
    }
    
    @Test
    public void testTranslate(){
        Posn temp = new Posn(10,10);
        assertEquals(abc.translate(temp),new Triangle(aposn.add(temp), bposn.add(temp), cposn.add(temp)));
        temp = new Posn(-10,50);
        assertEquals(def.translate(temp),new Triangle(dposn.add(temp), eposn.add(temp), fposn.add(temp)));
    }
    
    
    @Test
    public void testPerimeter(){
        assertEquals(abc.perimeter(),12.0,0);
        assertEquals(def.perimeter(),17.6619037896906,0);
        assertEquals(ghi.perimeter(),4.82842712474619,0);
    }

    @Test
    public void testGetCenter(){
        assertEquals(ghi.getCenter().getX(), 2.0,0);
        assertEquals(ghi.getCenter().getY(), (1.0+1.0/3.0)*-1.0,0.001);
        assertEquals(def.getCenter().getX(), 0.0,0);
        assertEquals(def.getCenter().getY(), 1+2.0/3.0,0.001);
        assertEquals(abc.getCenter().getX(), 1+1.0/3.0,0.001);
        assertEquals(abc.getCenter().getY(), 1.0,0);
    }
}
