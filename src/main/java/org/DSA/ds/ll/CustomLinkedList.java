package org.DSA.ds.ll;

public class CustomLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    CustomLinkedList(){}

    //Connstant time
    public void insertFirst(T value) {
        Node<T> newNode  = new Node<>(value);
        newNode.next=head;
        head=newNode;
        if(tail==null){
            tail=head;
        }
        size++;

    }
    //Constant Time
    public void insertLast(T value){
        Node<T> newNode  = new Node<>(value);
        if(tail==null){
            insertFirst(value);
            return;
        }
        tail.next=newNode;
        tail=newNode;
        size++;

    }
    public void insert(T value,int index){
        if(index==0){
            insertFirst(value);
            return;
        }
        
        if (index==size) {
            insertLast(value);
            return;
        }


        Node<T> temp=head;
        for (int i = 1; i < index; i++) {
            temp=temp.next;
        }
        Node<T> newNode  = new Node<>(value,temp.next);
        temp.next=newNode;
        size++;
    }
    public void insertUsingRecursion(T value,int index){
        insertUsingRecursion(value,index,head);
    }

    //insert using recursion
    private void insertUsingRecursion(T value,int index,Node<T> prev){
       if(index==0){
           Node<T> newNode=new Node<>(value);
           newNode.next=prev.next.next;
           prev.next=newNode;
           size++;
           return;
       }

       insertUsingRecursion(value,index-1,prev.next);
    }

    public T deleteFirst(){
        T value= head.value;
        head=head.next;
        if(head==null){
            tail=null;
        }
        size--;
        return value;
    }

    public T deleteLast(){
       if(size<=1){
           return deleteFirst();
       }
       Node<T> secondLast=referenceNodeOfIndex(size-2);
       T value= secondLast.value;
       secondLast.next=null;
       size--;
       return value;
    }
    public T delete(int index) {
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }
        Node<T> prev = referenceNodeOfIndex(index - 1);
        T val=prev.next.value;
        prev.next=prev.next.next;
        size--;
        return val;

    }
    public Node<T> referenceNodeOfIndex(int index){
        Node<T> temp = null;
        for (int i = 0; i < index; i++) {
            temp=head.next;
        }
        return temp;
    }
    public void display(){
        Node<T>temp=head;
        System.out.print("START-> ");
        while (temp!=null){
            System.out.print(temp.value+" ,");
            temp=temp.next;
        }
        System.out.print(" ->END");
    }

    private static class Node <T>{
      private T value;
      private Node<T> next;
      public Node(T value){
          this.value=value;
      }
      public Node(T value,Node<T> node){
          this.value=value;
          this.next=node;
      }
    }
}
