package com.cartotech;

public class MathUtil {
    
    public static int mdc(int a, int b){
        a = Math.abs(a);
        b = Math.abs(b);
        int maior = Math.max(a,b);
        int menor = Math.min(a,b);
        a = maior;
        b = menor;

        if ((b>0) && (a%b == 0)){
            return b;
        }

        if (b==0){
            if (a<0){
                return (a*-1);
            } else {
                return a;
            }
        }

        throw new UnsupportedOperationException("Caso não previsto.");
    }
}
