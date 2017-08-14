package org.work;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by qin on 17-8-8.
 */
public class test1 {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(new FileInputStream("/home/qin/test2.txt"));   //保存原始数据的txt文档
        String a ="";
        int b;
        double yus=0,shus=0,yings=0,id=0;
        double yys=0,shuys=0,yingys=0,zongfen=0,zongjg=0;


        while((b=reader.read())!=-1){
            char c = (char) b;
            a+=String.valueOf(c);//buffer
        }
        System.out.println(a);
        String[] strings=a.replaceAll("\r", "").split("\n");
        LinkedList<String> list=new LinkedList<String>();

        ArrayList list1=new ArrayList();
        for(int c=0;c<strings.length;c++) {
            list.add(strings[c]);
        }
        list1.add(list.get(0)+"总分\n");

        for (int i = 1; i < list.size(); i++) {
            id++;
            String[] s1 = list.get(i).split(" ");
            double yu=Integer.valueOf(s1[2]);
            double shu=Integer.valueOf(s1[3]);
            double ying=Integer.valueOf(s1[4]);
            if(yu>=60){
                yus++;
                if (yu>=85){
                    yys++;
                }
            }
            if(shu>=60){
                shus++;
                if (shu>=85){
                    shuys++;
                }
            }
            if (ying>=60){
                yings++;
                if (ying>=85){
                    yingys++;
                }
            }


//            String s2=list.get(i);
//            String zf=String.valueOf(zongfen);
//            String s3=s2+" "+zf+"\n";
//            list1.add(s3);
        }
        zongjg=yus+shus+yings;
 //       System.out.println(zongjg);
        zongfen=yys+shuys+yingys;//System.out.println(shus);
        double yl=yus / id;
        int yul=(int)(yl*100);
        double sl=shus / id;
        int shul=(int)(sl*100);
        double yil=shus / id;
        int yingl=(int)(yil*100);

        double yls=yys / id;
        int ywyx=(int)(yls*100);
        double shuls=shuys / id;
        int sxyx=(int)(shuls*100);
        double yingls=yingys / id;
        int yyyx=(int)(yingls*100);
        id=id*3;

        double zjg=zongjg/id;
        int zjgl=(int)(zjg*100);
//        System.out.println(zjg);
        double zyx=zongfen / id;
//        System.out.println(zyx);
        int zyxl=(int)(zyx*100);
//        System.out.println("语文及格率："+yul+"%"+"语文优秀率"+ywyx+"%");
//        System.out.println("数学及格率："+shul+"%"+"数学优秀率"+sxyx+"%");
//        System.out.println("英语及格率："+yingl+"%"+"英语优秀率"+yyyx+"%");
//        System.out.println("总成绩及格率："+zjgl+"%"+"总成绩优秀率"+zyxl+"%");
        String qq="语文及格率"+String.valueOf(yul)+"%"+"语文优秀率"+String.valueOf(ywyx)+"%\n"+
                "数学及格率"+String.valueOf(shul)+"%"+"数学优秀率"+String.valueOf(sxyx)+"%\n"+
                "英语及格率："+String.valueOf(yingl)+"%"+"英语优秀率"+String.valueOf(yyyx)+"%\n"+
                "总成绩及格率："+String.valueOf(zjgl)+"%"+"总成绩优秀率"+String.valueOf(zyxl)+"%\n";





        OutputStream os=new FileOutputStream(new File("/home/qin/b23.txt"));
        os.write(qq.getBytes());
        os.flush();

    }
}

