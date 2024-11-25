package org.interview;

public class SingleTonClass {

    private static volatile SingleTonClass instance=null;
    private SingleTonClass(){

    }

    public static SingleTonClass getInstance(){
        if(instance==null){
            synchronized (SingleTonClass.class) {
                if(instance==null) {
                    return new SingleTonClass();
                }
            }
        }
        return instance;
    }

}
