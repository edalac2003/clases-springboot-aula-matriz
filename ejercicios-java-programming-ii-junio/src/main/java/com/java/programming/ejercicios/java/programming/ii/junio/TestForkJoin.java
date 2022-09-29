package com.java.programming.ejercicios.java.programming.ii.junio;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

/**
 *
 * @author edala
 */
public class TestForkJoin {
    public static void main(String[] args) {
        long[] numbersToSum = LongStream.rangeClosed(1, 10_000).toArray();
        
        ForkJoinSumNaturalNumber forkJoinSumNaturalNumber = new ForkJoinSumNaturalNumber(numbersToSum);        
        ForkJoinPool forkJoinPool = new ForkJoinPool(5);
        
        long start = System.currentTimeMillis();        
        Long result = sumSequentialStreams();      
//      Long result = forkJoinPool.invoke(forkJoinSumNaturalNumber);        
        long end = System.currentTimeMillis();
        
        System.out.println("El resultado de la suma es: " + result);
        System.out.println("El tiempo transcurrido fue de " + (end - start) + " ms");
        
        start = System.currentTimeMillis();        
        result = sumParallelStreams();      
//      Long result = forkJoinPool.invoke(forkJoinSumNaturalNumber);        
        end = System.currentTimeMillis();
        
        System.out.println("El resultado de la suma es: " + result);
        System.out.println("El tiempo transcurrido fue de " + (end - start) + " ms");
    }
    
    public static void computeSequentally(){
        long sum = 0;
        for (int i = 1; i <= 1_000_000; i++) {
            sum += i;            
        }
        System.out.println("Resultado " + sum);
    }
    
    public static Long sumSequentialStreams(){
        return LongStream.rangeClosed(1, 100_000_000).reduce(0, (a, b) -> a + b);
    }
    
    public static Long sumParallelStreams(){
//        LongStream.rangeClosed(1, 100_000_000).parallel().peek();
        return LongStream.rangeClosed(1, 100_000_000).parallel().reduce(0, (a, b) -> a + b);
    }
}
