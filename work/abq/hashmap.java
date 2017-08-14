package org.work.abq;

import com.sun.org.apache.xpath.internal.functions.FuncSubstring;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by qin on 17-8-14.
 */
public class hashmap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();

        map.put("a", "zhangsan");
        map.put("b", "lisi");
        map.put("a", "wangwu");

        String value="wangwu";
        String key = "";

        for(String getKey: map.keySet()){
            if(map.get(getKey).equals(value)){
                key = getKey;
            }
        }


//
//



//            String c="83.0";
//            c=c.substring(0,2);
//            int a=Integer.valueOf(c);
            System.out.println(key);

    }

}
