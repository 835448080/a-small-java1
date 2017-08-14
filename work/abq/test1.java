package org.work.abq;



import java.io.*;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

import static java.lang.Thread.sleep;


/**
 * Created by qin on 17-8-10.
 */
class Read implements Runnable{
    public static ArrayBlockingQueue Queue=new ArrayBlockingQueue(15);

    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(new Read());
        t1.start();
        Thread t2=new Thread(new Calculation());
        t2.sleep(100);
        t2.start();
        Thread t3=new Thread(new Output());
        t3.sleep(100);
        t3.start();
        Thread t4=new Thread(new adjustment());
        t4.sleep(100);
        t4.start();



    }

    @Override
    public void run() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            InputStreamReader reader = new InputStreamReader(new FileInputStream("/home/qin/test2.txt"));
            int b;
            while ((b = reader.read()) != -1) {
                char c = (char) b;
                stringBuffer.append(String.valueOf(c));
            }
            String a = String.valueOf(stringBuffer);
            String[] strings = a.split("\n");
            for (int i = 0; i <= strings.length - 1; i++) {
                Queue.offer(strings[i]);

            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
class Calculation implements Runnable {
    public static ArrayBlockingQueue q=new ArrayBlockingQueue(15);

    public static HashMap map=new HashMap();
    public static String[] xx=null;
    String chinese="";
    String math="";
    String enghish="";
    @Override
    public void run() {
        double cn = 0, cnn = 0, mn = 0, mnn = 0, en = 0, enn = 0, score = 0, scoren = 0;
        int id=0;

        int a=Read.Queue.size();
        for (int i = 0; i < a; i++) {
            id++;
            try {
                String[] strings= ((String) Read.Queue.take()).split(" ");
                double C = Integer.valueOf(strings[2]);
                chinese+=String.valueOf(C)+" ";
                double M = Integer.valueOf(strings[3]);
                math+=String.valueOf(M)+" ";
                double E = Integer.valueOf(strings[4]);
                enghish+=String.valueOf(E)+" ";
                if (C >= 60) {
                    cn++;
                    if (C >= 85) {
                        cnn++;
                    }
                }
                if (M >= 60) {
                    mn++;
                    if (M >= 85) {
                        mnn++;
                    }
                }
                if (E >= 60) {
                    en++;
                    if (E >= 85) {
                        enn++;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
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

        String b="语文及格率"+String.valueOf(ce)+"%"+"语文优秀率"+String.valueOf(ce1)+"%\n"+
                "数学及格率"+String.valueOf(mt)+"%"+"数学优秀率"+String.valueOf(mt1)+"%\n"+
                "英语及格率"+String.valueOf(eh)+"%"+"英语优秀率"+String.valueOf(eh1)+"%\n"+
                "总成绩及格率："+String.valueOf(se)+"%"+"总成绩优秀率"+String.valueOf(sey)+"%\n";
        String a1="语文及格率"+String.valueOf(ce)+"%"+","+
                "数学及格率"+String.valueOf(mt)+"%"+","+
                "英语及格率"+String.valueOf(eh)+"%"+","+
                "总成绩及格率"+String.valueOf(se)+"%";
        String a2= "语文优秀率"+String.valueOf(ce1)+"%"+
                "数学优秀率"+String.valueOf(mt1)+"%"+
                "英语优秀率"+String.valueOf(eh1)+"%"+
                "总成绩优秀率"+String.valueOf(sey)+"%";
        xx=a1.split(",");
        for (int i=0;i<xx.length;i++){
            System.out.println(xx[i]);
        }




        map.put("语文",chinese);
        map.put("数学",math);
        map.put("英语",enghish);




        try {
            q.put(xx);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



class Output implements Runnable{
    int b=6;
    Map<String, String> map1 = Calculation.map;
    public static ArrayBlockingQueue e=new ArrayBlockingQueue(5);




    @Override
    public void run() {
//
                try {
                    String[]  a = (String[]) Calculation.q.take();


                    for (int i=0;i<a.length;i++){

                        String[] b=a[i].split("及格率|%");
                        System.out.println(b);
                        int c=Integer.valueOf(b[1]);
                        if (c<50){
                            String key=b[0];
                            String value = key+" "+map1.get(key);
                            System.out.println(value);
                            e.put(value);
                            continue;

                        }else {
                            String bc=a[i];
                            OutputStream os=null;
                            os = new FileOutputStream(new File("/home/qin/b23.txt"));
                            os.write(bc.getBytes());
                            os.flush();
                    }
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

//            int q= Integer.parseInt(b[1]);
//            if (q<50) {
//                System.out.println(a[0]);
//                }

//
//        OutputStream os = null;
//        try {
//            String a= (String) Calculation.q.take();
//            os = new FileOutputStream(new File("/home/qin/b23.txt"));
//
//            os.write(a.getBytes());
//            os.flush();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }
}

class adjustment implements Runnable{


    String d="";
    double id;
    double af;


    @Override
    public void run() {
        try {
            String a= (String) Output.e.take();

            String[] b = a.split(" ");
            String first=b[0];
            for (int i=1;i<b.length;i++) {
                String c= b[i];
                c=c.substring(0,2);
                int cc=Integer.valueOf(c);
                    if (cc<=60){
                        cc=cc+5;
                    }
                d+=String.valueOf(cc)+" ";
            }
            System.out.println(d);
            String[] strings=d.split(" ");
            af=strings.length;
            for (int i=0;i<af;i++){

                int d=Integer.valueOf(strings[i]);
                if (d>60){
                    id++;
                }
            }
            System.out.println(id+" "+af);
            int d=(int)((id/af)*100);
            String dd=first+"及格率"+d+"%";
            Calculation.map.put(first,d);
            Calculation.q.put(dd);


//            String[] strings=d.split(" ");
//            for (int i = 0; i<strings.length; i++){
//                System.out.println(strings[i]);
//            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}




