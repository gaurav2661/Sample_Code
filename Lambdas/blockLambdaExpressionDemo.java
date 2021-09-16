package com.racloop.Lambdas;

public class blockLambdaExpressionDemo {
    @java.lang.FunctionalInterface
            //compiler would know this is will have single abstract method, and it is a functional interface
    interface FunctionalInterface{
        int Factorial(int x);
    }
    public static void main(String[] args){
        FunctionalInterface f = n-> {
            int initial = 1;
            for(int i =1;i<=n;i++){
                initial=i*initial;
            }
            return initial;
        };
        //calling lambda function

        System.out.println("factorial of 5 : "+ f.Factorial(5));
    }
}
