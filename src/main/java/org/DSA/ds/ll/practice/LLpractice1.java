package org.DSA.ds.ll.practice;

public class LLpractice1 {
    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        System.out.println("Original List:");
        printList(head);

        int valToRemove = 6;
        //removeElement(head, valToRemove);
        removeNthElement(head,2);

        System.out.println("\nList after removing " + valToRemove + ":");
        printList(head);
    }
    // Helper method to print the list
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    private static void removeElement(ListNode head,int val){
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode current = dummy;
        while (current.next!=null){
            if(current.next.val==val){
                current.next=current.next.next;
            }else {
                current=current.next;
            }
        }
    }
    private static void removeNthElement(ListNode head,int num){
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode current=dummy;
        int count=1;
        while (current.next!=null){
            if(count==num){
                current.next=current.next.next;
            }else {
                current=current.next;
            }
            count++;

        }


    }

    private static class ListNode{
        ListNode next;
        int val;
        ListNode(){}
        ListNode(int val){
            this.val=val;
        }
        ListNode(ListNode node,int val){
            this.next=node;
            this.val=val;
        }
    }

}
