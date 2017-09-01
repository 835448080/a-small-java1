package com.reflaction.work;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Created by qin on 17-8-31.
 */
public class Reflaction {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Scanner scanner=new Scanner(System.in);
        Class clazz=Class.forName("com.classloader.Hello");
        Method[] methods=clazz.getMethods();
        for(int i=0;i<methods.length;i++){
            System.out.println(methods[i]+"\n");
        }
        methods[0].invoke(clazz);
    }

}
