package com.racloop.Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LIst1 {
    public static void main(String[] args){
        List<Integer> list1 = new ArrayList<>();
        list1.add(23);
        list1.add(21);
        list1.add(26);
        list1.add(22);
        list1.add(20);
        list1.add(28);
        list1.add(27);
        System.out.println(list1);
        for(int element : list1){
            System.out.println("element : "+element);
            /*if(element==26){
                list1.remove(Integer.valueOf(element));//concurrent modification exception
                //prevented through iterator
                iterator(list1);
            }*/
        }
        iterator(list1);

    }

    private static void iterator(List<Integer> list1) {
        System.out.println("\ninside iterator");
        Iterator<Integer> iterator  =  list1.iterator();
        while(iterator.hasNext()){
            int e = iterator.next();
            if(e==26)
            {
                iterator.remove();
            }
        }
        System.out.println(list1);
    }
}
