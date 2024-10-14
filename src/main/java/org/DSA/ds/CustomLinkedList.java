package org.DSA.ds;

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
    public T deleteFirst(){
        T value= head.value;
        head=head.next;
        if(head==null){
            tail=null;
        }
        size--;
        return value;
    }
    public void display(){
        Node<T>temp=head;
        while (temp!=null){
            System.out.print(temp.value+" ,");
            temp=temp.next;
        }
        System.out.print(" END");
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
