package org.DSA.oops;

public class SingleTonUtils {
    public static void main(String[] args) {
        CustomSingleTonClass one=CustomSingleTonClass.getInstance();
        CustomSingleTonClass two=CustomSingleTonClass.getInstance();
        System.out.println(one==two);
    }

}
class CustomSingleTonClass{
    private static volatile CustomSingleTonClass instance=null;
    private CustomSingleTonClass(){

    }
    public static synchronized CustomSingleTonClass getInstance(){
        if(instance==null){
            instance=new CustomSingleTonClass();
        }
        return instance;
    }

}
