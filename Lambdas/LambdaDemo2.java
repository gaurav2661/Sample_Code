package com.racloop.Lambdas;

import java.util.ArrayList;

public class LambdaDemo2 {
    //java program to demonstrate lambda expressions

    public static void main(String[] args){

        //creating an arraylist list with some elements
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(90);
        arrayList.add(91);
        arrayList.add(92);
        arrayList.add(93);
        arrayList.add(94);
        arrayList.add(95);

        /**
         * using lambda expression to print all the elements of arraylist
         */
        arrayList.forEach(n -> System.out.println(n));
        /**
         * using lambda expression to print all even elements of arraylist
         */
        arrayList.forEach(n ->{if (n%2==0) System.out.println(n);});
        /**
         * using lambda expression to print all odd elements of arraylist
         */
        arrayList.forEach(n-> {if(n%2!=0) System.out.println(n);});

        //Note that lambda expressions can only be used to implement functional interfaces
    }
}
