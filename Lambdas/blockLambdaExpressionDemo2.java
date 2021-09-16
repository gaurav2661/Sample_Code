package com.racloop.Lambdas;

public class blockLambdaExpressionDemo2 {
    @java.lang.FunctionalInterface
            //compiler would know this is will have single abstract method, and it is a functional interface
    interface FunctionalInterface{
        boolean isLeapYear(int inputYear);
    }
    public static void main(String[] args){
        FunctionalInterface leapYear =year->
        {
            if((year%400==0)||(year%4==0)&&(year%100!=0))
                return true;
            else
                return false;
        };
        //calling lambda function
        if(leapYear.isLeapYear(2020)){
            System.out.println("it is a leap year");
        }
        else
            System.out.println("non leap year");
    }
}
