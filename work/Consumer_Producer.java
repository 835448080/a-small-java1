package org.work;

/**
 * Created by qin on 17-8-12.
 */
class Clerk{
    int product;

    public synchronized  void pruduceProuct(){
        if (product < 20){
            product++;
            System.out.print("Produce " + product);
            notifyAll();
        }
        else{
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumerProduct(){
        if (product > 0){
            product--;
            System.out.print("Consumer" + product);
            notifyAll();
        }
        else{
            try{
                wait();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

/*生产者，使用Runable接口*/
class Producer implements Runnable{
    Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.print("");

        while(true){
            clerk.pruduceProuct();
        }
    }

}

/* 消费者，使用Runable接口 */
class Consumer implements Runnable{
    Clerk clerk;

    public Consumer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while(true){
            clerk.consumerProduct();
        }
    }

}

/*测试代码*/
public class Consumer_Producer {
    public static void main(String[] arg){
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);

        Thread productThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        productThread.setName("Producer");
        consumerThread.setName("Consumer");
        productThread.start();
        consumerThread.start();
    }
}