package org.work;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by qin on 17-8-8.
 */
public class test {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(new FileInputStream("/home/qin/test2.txt"));   //保存原始数据的txt文档
        String a ="";
        int b;

        while((b=reader.read())!=-1){
            char c = (char) b;
            a+=String.valueOf(c);
        }
        String[] strings=a.replaceAll("\r", "").split("\n");
        LinkedList<String> list=new LinkedList<String>();

        ArrayList list1=new ArrayList();
        for(int c=0;c<strings.length;c++) {
            list.add(strings[c]);
        }
        list1.add(list.get(0)+"总分\n");

            for (int i = 1; i < list.size(); i++) {

            String[] s1 = list.get(i).split(" ");
            int s=Integer.valueOf(s1[2]);
            int v=Integer.valueOf(s1[3]);
            int n=Integer.valueOf(s1[4]);
            int zongfen=s+v+n;
            String s2=list.get(i);
            String zf=String.valueOf(zongfen);
            String s3=s2+" "+zf+"\n";
            list1.add(s3);
        }
        String A="";
        for (int h=0;h<list1.size();h++){
            A += (String) list1.get(h);
        }
 //       System.out.println(A);
        OutputStream os=new FileOutputStream(new File("/home/qin/b23.txt"));
        os.write(A.getBytes());
        os.flush();

    }
}
