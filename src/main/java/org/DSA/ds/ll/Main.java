package org.DSA.ds.ll;

import org.DSA.ds.ll.DoubleLL;

public class Main {
    public static void main(String[] args) {
       /* CustomLinkedList<Integer> customLinkedList=new CustomLinkedList<Integer>();
        customLinkedList.insertFirst(1);
        customLinkedList.insertFirst(2);
        customLinkedList.insertFirst(3);
        customLinkedList.insertFirst(4);
        customLinkedList.insert(33,1);

        System.out.println(customLinkedList.deleteFirst());
        customLinkedList.display();
*/
        CustomLinkedList<Integer> dll=new CustomLinkedList<>();
        dll.insertFirst(1);
        dll.insertFirst(2);
        dll.insertFirst(3);
        dll.insertFirst(4);
        dll.insertFirst(5);

        dll.insertUsingRecursion(99,0);

        dll.display();



    }
}
