package com.java.programming.ejercicios.java.programming.ii.junio;

import java.util.concurrent.RecursiveTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edala
 */
public class ForkJoinSumNaturalNumber extends RecursiveTask<Long>{

    private final long[] numbers;
    private final int start;
    private final int end;

    private ForkJoinSumNaturalNumber(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    public ForkJoinSumNaturalNumber(long[] numbers) {
        this(numbers, 0, numbers.length);
    }
    
    @Override
    protected Long compute() {
        int length = end - start;
        if(length <= 1_000){
            return computeSequentally();
        }
        
        ForkJoinSumNaturalNumber leftTask = new ForkJoinSumNaturalNumber(numbers, start, start + length / 2);
        leftTask.fork();
        ForkJoinSumNaturalNumber rigth = new ForkJoinSumNaturalNumber(numbers, start + length / 2, end);
        
        Long rigthResult = rigth.compute();        
        Long leftResult = leftTask.join();
        
        return leftResult + rigthResult;
    }
    
    public Long computeSequentally(){
        long sum = 0;
//        System.out.println("Hilo: " + Thread.currentThread().getName());
        
        for (int i = start; i < end; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(ForkJoinSumNaturalNumber.class.getName()).log(Level.SEVERE, null, ex);
            }
            sum += numbers[i];            
        }
        return sum;
    }
}
