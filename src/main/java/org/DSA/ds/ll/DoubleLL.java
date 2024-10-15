package org.DSA.ds.ll;

public class DoubleLL<T> {

    Node<T> head;
    Node<T> tail;
    int size;

    public void insertFirst(T val) {
        Node<T> node = new Node<>(val);
        node.next = head;
        node.prev = null;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size++;

    }
    public void display(){
        Node<T> temp=head;
        while (temp!=null){
            System.out.print(temp.value+" ,");
            temp=temp.next;
        }
        System.out.print(" END");
    }
    class Node<T>{
        T value;
        private Node<T> next;
        private Node<T> prev;
        Node(T value){
            this.value=value;
        }
    }
}
