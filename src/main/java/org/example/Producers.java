package org.example;

public class Producers implements Runnable{

    @Override
    public void run(){
        Thread t = Thread.currentThread();

        try{
            for(int i=0;i<5;i++){
                System.out.println(t+" producing...:");
            }
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println(e);
        }
        System.out.println(t+":exiting");
    }
}
