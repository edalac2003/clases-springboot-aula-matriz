package com.java.programming.ejercicios.java.programming.ii.junio;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edala
 */
public class TestConcurrencyAPI {
    public static void main(String[] args) {
        useCallable();        
    }
    
    public static void useRunnable(){
        //        ExecutorService threadPool = new ThreadPoolExecutor(3, 5, 60, TimeUnit.SECONDS, new SynchronousQueue<>());
        ExecutorService threadPool = new ThreadPoolExecutor(3, 10, 60, TimeUnit.SECONDS, new SynchronousQueue<>());
        
        Runnable task1 = () -> System.out.println("Ejecutando Tarea 1 por el hilo " + Thread.currentThread().getName());
        Runnable task2 = () -> System.out.println("Ejecutando Tarea 2 por el hilo "  + Thread.currentThread().getName());
        Runnable task3 = () -> System.out.println("Ejecutando Tarea 1 por el hilo " + Thread.currentThread().getName());
        Runnable task4 = () -> System.out.println("Ejecutando Tarea 2 por el hilo "  + Thread.currentThread().getName());
        Runnable task5 = () -> System.out.println("Ejecutando Tarea 1 por el hilo " + Thread.currentThread().getName());
        Runnable task6 = () -> System.out.println("Ejecutando Tarea 2 por el hilo "  + Thread.currentThread().getName());
        Runnable task7 = () -> System.out.println("Ejecutando Tarea 1 por el hilo " + Thread.currentThread().getName());
        Runnable task8 = () -> System.out.println("Ejecutando Tarea 2 por el hilo "  + Thread.currentThread().getName());
        
        threadPool.execute(task1);
        threadPool.execute(task2);
        threadPool.execute(task3);
        threadPool.execute(task4);
        threadPool.execute(task5);
        threadPool.execute(task6);
        threadPool.execute(task7);
        threadPool.execute(task8);
        
        System.out.println("Aqui se podrian ejecutar tareas adicionales, en el hilo:  "  + Thread.currentThread().getName());
        
        threadPool.shutdown();
        try {
            threadPool.awaitTermination(0, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestConcurrencyAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void useCallable(){
        ExecutorService executorServiceFixed = Executors.newFixedThreadPool(5);
        ExecutorService executorService2 = Executors.newCachedThreadPool();
        ExecutorService executorService3 = Executors.newScheduledThreadPool(10);
        ExecutorService executorService4 = Executors.newSingleThreadExecutor();
        
        Callable<String> callableTask = () -> { 
            System.out.println("Ejecutando Callable " + Thread.currentThread().getName());
            Thread.sleep(5000);
            return "NOs vemos mas tarde. . .";
        };
        
        Future<String> taskResult = executorServiceFixed.submit(callableTask);
        while(!taskResult.isDone()){
            System.out.println("Realizar otras actividades!!!!");
        }
        
        try {
            System.out.println("Finalizó la tarea.  Resultado: " + taskResult.get());
        } catch (InterruptedException ex) {
            Logger.getLogger(TestConcurrencyAPI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(TestConcurrencyAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        executorServiceFixed.shutdown();
        try {
            executorServiceFixed.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestConcurrencyAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
