public class CircleTest extends junit.framework.TestCase{
    Posn aposn;
    Posn bposn;
    Posn cposn;
    Posn dposn;
    Posn eposn;
    Posn fposn;
    Posn gposn;
    Posn hposn;
    Posn iposn;
    Posn jposn;
    Posn kposn;
    Posn lposn;
    Posn mposn;
    Posn nposn;
    Posn oposn;
    Posn pposn;
    Posn qposn;
    Posn rposn;
    Posn sposn;
    Posn tposn;
    Posn uposn;
    Posn vposn;
    Posn wposn;
    
    Circle a;
    Circle b;
    Circle c;
    Circle d;
    Circle e;
    Circle f;
    Circle g;
    Circle h;
    Circle i;
    Circle j;
    Circle k;
    Circle l;
    Circle m;
    Circle n;
    Circle o;
    Circle p;
    Circle q;
    
    Line aline;
    Line bline;
    Line cline;
    Line dline;
    Line eline;
    
    public void setUp(){
        aposn=new Posn(0.0, 0.0);
        bposn=new Posn(2.0, 2.0);
        cposn=new Posn(3.0, 4.0);
        dposn=new Posn(8.0, 15.0);
        eposn=new Posn(-16.5, 0.0);
        fposn=new Posn(-16.5, 0.0);
        hposn=new Posn(10.0, 0.0);
        iposn=new Posn(7.0, 2.0);
        jposn=new Posn(100.0,100.0);
        kposn=new Posn(-16.5, 0.0);
        lposn=new Posn(0.0, 2.0);
        mposn=new Posn(0.0, 200.0);
        nposn=new Posn(6.0, 0.0);
        oposn=new Posn(1.0, 0.0);
        pposn=new Posn(0.0, 1.0);
        qposn=new Posn(1.0, 1.0);
        rposn=new Posn(0.0, 100.0);
        sposn=new Posn(1.0, 100.0);
        tposn=new Posn(3.0, 3.0);
        uposn=new Posn(3.0, 5.0);
        vposn=new Posn(-2.0, -2.0);
        wposn=new Posn(5.0, -5.0);

        
        a=new Circle(aposn, 10.0);
        b=new Circle(bposn, 5.0);
        c=new Circle(cposn, 5.0);
        d=new Circle(dposn, 17.0);
        e=new Circle(eposn, 30.0);
        f=new Circle(fposn, 30.0);
        g=new Circle(aposn, 10.0);
        h=new Circle(bposn, 10.0);
        i=new Circle(eposn, 10.0);
        j=new Circle(aposn, 20.0);
        k=new Circle(bposn, -15.0);
        l=new Circle(cposn, 2.5);
        m=new Circle(dposn, -170.0);
        n=new Circle(lposn, 10.0);
        o=new Circle(mposn, 10.0);
        p=new Circle(nposn, 10.0);
        q=new Circle(vposn, 5.0);
        
        aline=new Line(aposn, oposn);
        bline=new Line(pposn, qposn);
        cline=new Line(rposn, sposn);
        dline=new Line(tposn, uposn);
        eline=new Line(aposn, wposn);
        
    }

    
    public void testGetAnchor(){
        assertEquals(aposn, a.getAnchor());
        assertEquals(bposn, b.getAnchor());
        assertEquals(cposn, c.getAnchor());
        assertEquals(dposn, d.getAnchor());
    }
    public void testGetRadius(){
        assertEquals(10.0, a.getRadius());
        assertEquals(5.0, b.getRadius());
        assertEquals(5.0, c.getRadius());
        assertEquals(17.0, d.getRadius());
    }
    
   
    public void testToString(){
       assertEquals("((0.0, 0.0), 10.0)", a.toString());
       assertEquals("((2.0, 2.0), 5.0)", b.toString());
       assertEquals("((3.0, 4.0), 5.0)", c.toString());
       assertEquals("((8.0, 15.0), 17.0)", d.toString());
    }
    
    
    public void testEquals(){
        assertEquals(a.equals(a), true);
        assertEquals(b.equals(b), true);
        assertEquals(c.equals(d), false);
        assertEquals(d.equals(c), false);
        assertEquals(e.equals(f), true);
        assertEquals(f.equals(e), true);
        assertEquals(g.equals(d), false);
        assertEquals(g.equals(a), true);
    }
    
    public void testGetPosition(){
        assertEquals(aposn, a.getAnchor());
        assertEquals(bposn, b.getAnchor());
        assertEquals(cposn, c.getAnchor());
        assertEquals(dposn, d.getAnchor());
    }
    
    public void testperimeter(){
        assertEquals(20 * Math.PI, a.perimeter());
        assertEquals(10 * Math.PI, b.perimeter());
        assertEquals(10 * Math.PI, c.perimeter());
        assertEquals(34 * Math.PI, d.perimeter());
        assertEquals(60 * Math.PI, e.perimeter());
        assertEquals(60 * Math.PI, f.perimeter());
        assertEquals(20 * Math.PI, g.perimeter());
    }
    
    public void testArea(){
        assertEquals(100 * Math.PI, a.area());
        assertEquals(25 * Math.PI, b.area());
        assertEquals(25 * Math.PI, c.area());
        assertEquals(289 * Math.PI, d.area());
        assertEquals(900 * Math.PI, e.area());
        assertEquals(900 * Math.PI, f.area());
        assertEquals(100 * Math.PI, g.area());
    }
    
    public void testInside(){
        assertEquals(a.inside(aposn), true);
        assertEquals(b.inside(cposn), true);
        assertEquals(a.inside(hposn), true);
        assertEquals(b.inside(iposn), true);
        assertEquals(!(d.inside(jposn)), true);
        assertEquals(!(f.inside(jposn)), true);
        assertEquals(d.inside(iposn), true);
    }
    
    public void testTranslate(){
        assertEquals(a.translate(aposn), a);
        assertEquals(c.translate(aposn), c);
        assertEquals(f.translate(aposn), f);
        assertEquals(a.translate(bposn), h);
        assertEquals(a.translate(kposn), i);
    }
    
    public void testRotate(){
        assertEquals(a.rotate(1), a);
        assertEquals(b.rotate(1), b);
        assertEquals(c.rotate(1), c);
        assertEquals(d.rotate(1), d);
        assertEquals(e.rotate(1), e);
        assertEquals(f.rotate(1), f);
    }
    
    public void testDialate(){
        assertEquals(a.dialate(2.0), j);
        assertEquals(b.dialate(-3.0), k);
        assertEquals(c.dialate(0.5), l);
        assertEquals(d.dialate(-10.0), m);
    }
    
    public void testReflect(){
        assertEquals(a.reflect(aline), a);
        assertEquals(a.reflect(bline), n);
        assertEquals(a.reflect(cline), o);
        assertEquals(a.reflect(dline), p);
        assertEquals(b.reflect(eline), q);
    }
  
}

