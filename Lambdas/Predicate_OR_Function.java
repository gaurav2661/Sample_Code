package com.racloop.Lambdas;

import java.util.function.Predicate;

public class Predicate_OR_Function {
    public static Predicate<String > hs = new Predicate<String>() {
        @Override
        public boolean test(String s) {
            return s.length()>10;
        }
    };
    public static void main(String[] args){
        predicate_or();
    }

    private static void predicate_or() {
        Predicate<String> Ca = i->i.contains("a");
        String s="gaurav";
        boolean out = hs.or(Ca).test(s);
        System.out.println(out);
    }
}
