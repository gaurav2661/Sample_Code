package com.racloop.Lambdas;

import java.util.function.Predicate;

public class Simple_Predicate {
    public static void main(String[] args){
        //creating predicate
        Predicate<Integer> lesserThan = i ->(i<18);

        //calling predicate method
        System.out.println(lesserThan.test(10));
        System.out.println(lesserThan.test(19));
    }
}