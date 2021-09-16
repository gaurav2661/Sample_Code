package com.racloop.Lambdas;

import java.util.function.Predicate;

public class Predicate_into_function {
    public static void main(String[] args){
        pred(10,(i)-> i<11);
    }
    //this is how one passes predicate to a function as arguments
    static void pred(int x, Predicate<Integer> predicate){
        if(predicate.test(x)){
            System.out.println("number : "+ x);
        }
    }
}
