package com.racloop.Lambdas;

import java.util.function.Predicate;

public class PredicateChaining {
    public static void main(String[] args){
        //creating predicate
        Predicate<Integer> greaterThanTen = i-> i>10;
        //creating predicate
        Predicate<Integer> lessThanTwenty= i-> i<20;
        /**
         * test(T t) : Evaluates this predicate on the given argument.boolean test(T t)
         * test(T t)
         * Parameters:
         * t - the input argument
         * Returns:
         * true if the input argument matches the predicate, otherwise false
         */
        boolean result = greaterThanTen.and(lessThanTwenty).test(15);
        System.out.println(result);

        boolean rs = lessThanTwenty.and(greaterThanTen).negate().test(34);
        //negate() : Returns a predicate that represents the logical negation of this predicate.
        //default Predicate negate()
        System.out.println(rs);
    }
}
