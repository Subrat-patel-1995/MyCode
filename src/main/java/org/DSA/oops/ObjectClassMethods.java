package org.DSA.oops;

import java.util.ArrayList;
import java.util.Vector;

public class ObjectClassMethods {

    //GarbageCollectionMethods
    public static void main1(String[] args) {
        A abc;
        for (int i = 0; i < 1000000; i++) {
            abc=new A(""+i+"");
        }
    }

    //final KeyWord
    //The valuse assigned can not be modified.
    public static void main2(String[] args) {
        final  int key=2000;
    }
    //wildCard

    public static void main(String[] args) {
     A a=new A("a class");
     print(a);
     B b=new B("b class");

    }
    private static void print(A obj) {

        System.out.println(obj.name);
    }


}
class B extends A{
    String name;

    B(String name) {
        this.name=name;
    }
}
class A{
    String name;
    A(){}
    A(String name){
       this.name=name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Destroyed====>>> "+this.name);
    }
}