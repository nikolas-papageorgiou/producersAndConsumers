package org.example;

public class Main {
    public static void main(String[] args) {
        Thread t =Thread.currentThread();
        t.setName("Main");

        Thread[] producers = new Thread[3];
        for(int i= 0;i<producers.length;i++){
            producers[i] = new Thread(new Producers(),"Producer "+i);
            producers[i].start();
        }

        Thread[] consumers = new Thread[5];
        for(int i= 0;i<consumers.length;i++){
            consumers[i] = new Thread(new Consumers(),"Consumer "+i);
            consumers[i].start();
        }

        try {
            for(int i=0;i<producers.length;i++){
                producers[i].join();
            }
            for(int i=0;i<consumers.length;i++){
                consumers[i].join();
            }
        }catch (InterruptedException e){
            System.out.println(e);
        }
        System.out.println("Bye!!!!");
    }
}