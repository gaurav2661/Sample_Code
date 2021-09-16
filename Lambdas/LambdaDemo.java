package com.racloop.Lambdas;

/**
 * java program to demonstrate lambda expression to implement a user defined
 * functional interface
 * a sample functional interface (an interface with single
 * abstract method
 */
interface  FunctionalInterface{
    //an abstract method
    void abstraction(int x);

    //a non-abstract method

    default void normal(){
        System.out.println("this is default method");
    }
}
public class LambdaDemo  {

    public static void main(String[] args){

        FunctionalInterface f1=(int x)-> System.out.println(2*x);
        /**
         * (argument list)arrow token (body of lambda expression
         * (int arg1 ,String arg2) -> {System.out.println("Two arguments"+arg1+" and "+arg2);}
         * syntax
         *
         * lambda operator -> body
         *
         *
         * lambda expression can be
         *
         * Zero parameter:
         * () -> System.out.println("Zero parameter lambda");
         *
         * One parameter:–
         * (p) -> System.out.println("One parameter: " + p);
         * It is not mandatory to use parentheses, if the type of that variable can be inferred from the context
         *
         * Multiple parameters :
         * (p1, p2) -> System.out.println("Multiple parameters: " + p1 + ", " + p2);
         */

            //this calls above lambda expression and prints 10
            f1.abstraction(5);


    }


}
