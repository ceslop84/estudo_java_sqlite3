package com.cartotech;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MathUtilTest {

    @Test
    public void testMdcP1Impar(){
        int a = 6, b = 3;
        int esperado = 3;
        int obtido = MathUtil.mdc(a,b);
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void testMdcP1Par(){
        int a = 4, b = 2;
        int esperado = 2;
        int obtido = MathUtil.mdc(a,b);
        assertEquals(esperado, obtido);
    }

    @Test
    public void testMdcP3(){
        int a = -4, b = 0;
        int esperado = 4;
        int obtido = MathUtil.mdc(a,b);
        assertEquals(esperado, obtido);
    }

    @Test
    public void testMdcP5(){
        int a = 6, b = 3;
        int esperado = MathUtil.mdc(b,a);
        int obtido = MathUtil.mdc(a,b);
        assertEquals(esperado, obtido);
    }
}

