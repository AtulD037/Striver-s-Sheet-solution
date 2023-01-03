package Recursion;

public class NumbersExample {
    // Write a function that takes in a number and print it
    // Print number from 1 to n

    static void printInRevOrder(int n){
        if (n==0){
            return;
        }
        System.out.println(n);
        printInRevOrder(n-1);
    }

    static void print(int n){
        if (n==11){
            return;
        }
        System.out.println(n);
        print(n+1);


    }

    public static void main(String[] args) {
        printInRevOrder(10);
        print(1);
    }
}
