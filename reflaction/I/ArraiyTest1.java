package com.reflaction.I;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by qin on 17-8-30.
 */
public class ArraiyTest1 {
    public static void main(String[] args) {
        Object arr= Array.newInstance(String.class,10);
        Array.set(arr,5,"aaaa");
        Array.set(arr,6,"bbbbbb");
        Object book1=Array.get(arr,5);
        Object book2=Array.get(arr,6);
        System.out.println(book1);
        System.out.println(book2);

    }
}
