package com.reflaction.I;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * Created by qin on 17-8-31.
 */
public class Reflect {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        try {
            Class c=Class.forName("com.reflaction.I.Y");
            XY t=(XY) c.newInstance();
            t.show();//打印Ｙ的方法
            XY x=new X();//X Class
            Class xc=Class.forName("com.reflaction.I.X");
            System.out.println(xc.isInstance(x));//isINstance() 与new() 的区别
            //它们的区别在于创建对象的方式不一样，
            // 前者是使用类加载机制，后者是创建一个新类。
            System.out.println(t instanceof XY);//instanceof 判断左面是不是右面创建的对象
            System.out.println(t instanceof X);//
            System.out.println(t instanceof Y);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
