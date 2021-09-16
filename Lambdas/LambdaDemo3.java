package com.racloop.Lambdas;

public class LambdaDemo3 {
    @java.lang.FunctionalInterface
            //compiler would know this is will have single abstract method, and it is a functional interface
    interface FunctionalInterface1{
        int operation(int x,int y);
    }
    @java.lang.FunctionalInterface
            //compiler would know this is will have single abstract method, and it is a functional interface
    interface FunctionalInterface2{
        void sayMessage(String message);
    }
    public static void main(String[] args){
        // lambda expression for addition for two parameters
        // data type for x and y is optional.
        // This expression implements 'FunctionalInterface1' interface

        FunctionalInterface1 add =(int x,int y) -> x+y;

        // lambda expression multiplication for two parameters
        // This expression also implements 'FunctionalInterface1' interface

        FunctionalInterface1 multiply = (int x,int y) -> x*y;

        // lambda expression for single parameter
        // This expression implements 'FunctionalInterface2' interface

        FunctionalInterface2 message = (String x)-> System.out.println(x);

        System.out.println("Addition is : "+ add.operation(6,7));
        System.out.println("Addition is : "+ multiply.operation(6,7));
        message.sayMessage("hello");



    }
}
