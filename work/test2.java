package org.work;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.*;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;

import static org.work.test2.arrayBlockingQueue;


/**
 * Created by qin on 17-8-10.
 */
public class test2 implements Runnable{

    static ArrayBlockingQueue arrayBlockingQueue=new ArrayBlockingQueue(0);

    static String Q=null;
    static String H=null;
    static String[] s1=null;
    static LinkedList list=null;

    Thread t1=new Thread(new Read(H));

    Thread t2=new Thread(new Calculation(list));

    Thread t3=new Thread(new Output(s1));
    //ArrayBlockingQueue queue=new ArrayBlockingQueue(3);
    public test2(String Q){this.H=Q;}

    public test2(LinkedList list) {this.list=list;}



    public test2(String[] strings1) {this.s1=strings1;}

    public static void main(String[] args) throws IOException, InterruptedException {

        Q="/home/qin/test2.txt";
        new Thread(new test2(Q)).start();

    }

    @Override
    public void run() {
        t1.start();
        try {
            t2.sleep(100);



        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        queue.add(t1);
//        queue.add(t2);
//        queue.add(t3);
//        for (int a=0;a<=queue.size();a++){
//            queue.take();
//        }
    }
}


class Read implements Runnable{

    String QQ=null;

    public Read(String H) {this.QQ=H;}


    @Override
    public void run() {
        System.out.println(QQ);

        try {
            StringBuffer stringBuffer =new StringBuffer();
            LinkedList list=new LinkedList();
            InputStreamReader reader=new InputStreamReader(new FileInputStream(QQ));
            int b;
            while ((b=reader.read())!=-1){
                char c=(char) b;
                stringBuffer.append(String.valueOf(c));
            }String a = String.valueOf(stringBuffer);
            String[] strings=a.split("\n");
            for(int i=0;i<=strings.length-1;i++){
                list.add(strings[i]);
            }
            arrayBlockingQueue.add(list);



        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
class Calculation implements Runnable{
    LinkedList list=null;

    public Calculation(LinkedList list) {this.list=list;}

    public static void main(String[] args) throws InterruptedException {
         arrayBlockingQueue.put(0);
    }

    @Override
    public void run() {
        if (arrayBlockingQueue.size()>0){

        }

        double cn=0,cnn=0,mn=0,mnn=0,en=0,enn=0,score=0,scoren=0;
        int id=0;
        String[] strings=null;
        for (int j=1;j<list.size();j++){
            id++;
            strings=((String) list.get(j)).split(" ");
            double C=Integer.valueOf(strings[2]);
            double M=Integer.valueOf(strings[3]);
            double E=Integer.valueOf(strings[4]);
            if(C>=60){
                cn++;
                if (C>=85){
                    cnn++;
                }
            }
            if(M>=60){
                mn++;
                if (M>=85){
                    mnn++;
                }
            }
            if(E>=60){
                en++;
                if (E>=85){
                    enn++;
                }
            }
        }
        score=cn+mn+en;
        scoren=cnn+mnn+enn;
        double chinse=cn / id;
        int ce=(int)(chinse*100);
        double mouth=mn / id;
        int mt=(int)(mouth*100);
        double english=en / id;
        int eh=(int)(english*100);

        double chinse1=cnn / id;
        int ce1=(int)(chinse1*100);
        double mouth1=mnn / id;
        int mt1=(int)(mouth1*100);
        double english1=enn / id;
        int eh1=(int)(english1*100);
        id=id*3;
        double scorej=score / id;
        int se=(int)(scorej*100);
        double scorey=scoren / id;
        int sey=(int)(scorey*100);

        String a="语文及格率"+String.valueOf(ce)+"%"+"语文优秀率"+String.valueOf(ce1)+"%\n"+
                "数学及格率"+String.valueOf(mt)+"%"+"数学优秀率"+String.valueOf(mt1)+"%\n"+
                "英语及格率："+String.valueOf(eh)+"%"+"英语优秀率"+String.valueOf(eh1)+"%\n"+
                "总成绩及格率："+String.valueOf(se)+"%"+"总成绩优秀率"+String.valueOf(sey)+"%\n";
        String[] strings1=a.split(" ");

        test2 test2=new test2(strings1);
        System.out.println(123);

    }
}
class Output implements Runnable{
    String[] ww=null;
    String a=null;
    public Output(String[] qq) {this.ww=qq;}

    @Override
    public void run() {
        for(int i=0;i<=ww.length;i++){
            String a=ww[i];
        }
        OutputStream os = null;
        try {
            os = new FileOutputStream(new File("/home/qin/b23.txt"));

            os.write(a.getBytes());
            os.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}




