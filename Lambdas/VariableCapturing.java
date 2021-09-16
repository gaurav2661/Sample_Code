package com.racloop.Lambdas;

/**
 * when a lambda expression uses a local variable from its enclosing scope,
 * a special situation is created that is referred to as a variable capture.
 * In this case, a lambda expression may only use local variables that are effectively final.
 * An effectively final variable is one whose value does not change after it is first assigned.
 * There is no need to explicitly declare such a variable as final, although doing so would not be an error.
 */
public class VariableCapturing {
    @java.lang.FunctionalInterface
    //compiler would know this is will have single abstract method, and it is a functional interface
    interface FunctionalInterface{
        void myFunction();
    }

    /**
     * Lambda expressions can use variables defined in an outer scope. We refer to these lambdas as capturing lambdas.
     * They can capture static variables, instance variables, and local variables,
     * but only local variables must be final or effectively final.
     */
    int data=180;
    public static void main(String[] args){
        int data1=180;
        VariableCapturing v= new VariableCapturing();
        FunctionalInterface f = ()->
        {
            System.out.println("DATA 1 : "+ v.data);
            v.data+=500;
            System.out.println("DATA 2 : "+ data1);

        };
        f.myFunction();
        v.data+=300;
        System.out.println("DATA 3 : "+ v.data);
    }
}
