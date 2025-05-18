package org.DSA.ds.ll.practice;

import org.DSA.ds.ll.CustomLinkedList;

public class LlPractice {

  //insert using recursion

    //83
//    Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

    public static void main(String[] args) {
        // Creating l1: [2,4,3]
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));

        // Creating l2: [5,6,4]
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        // Adding two numbers
        ListNode result = addTwoNumbers(l1, l2);

    }
    //141
    public boolean hasCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;


    }


    //length of the cycle
    private int lengthOfCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        boolean hasCycle=false;
        int count = 0;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                hasCycle= true;
                break;
            }
        }
        if(hasCycle){
            //same thing can be done by do while loop
            slow=slow.next;
            while (slow!=fast){
                slow=slow.next;
                count++;
            }
            count++;
        }
        return count;
    }

    //142
    public ListNode detectCycle(ListNode head) {
        ListNode temp=head;
       int length=lengthOfCycle(temp);
        ListNode fast = head;
       if(length>0) {

           for (int i = 0; i < length; i++) {
               fast = fast.next;
           }
           return fast;
       }
       return null;

    }

    //202
    //https://leetcode.com/problems/happy-number/
    public boolean isHappy(int n) {
        int slow = n;
        int fast= n;

        do{
           slow=findSquareOfInt(slow);
           fast=findSquareOfInt(findSquareOfInt(fast));
        }while (fast!=slow);
        if(slow==1){
            return true;
        }
        return false;
    }
    private int findSquareOfInt(int n){
        int num=0;
        while (n>0){
            int rem=n%10;
            num+=rem*rem;
            n=n/10;
        }
        return num;
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode node=head;
        while (head.next!=null){
            if(head.val==head.next.val){
                head.next=head.next.next;
            }else {
                head=head.next;
            }
        }
        return head;
    }

    //21
    //https://leetcode.com/problems/merge-two-sorted-lists/description/?envType=problem-list-v2&envId=linked-list
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head=new ListNode();
        ListNode newList=head;
        while(list1!=null && list2!=null) {
            if (list1.val < list2.val) {
                newList.next = list1;
                list1 = list1.next;
            } else {
                newList.next = list2;
                list2 = list2.next;
            }
            newList=newList.next;
        }
       while (list1!=null){
           newList.next=list1;
           list1=list1.next;
       }
       while (list2!=null){
           newList.next=list2;
           list2=list2.next;
       }

        return head.next;
    }
    //2
    //https://leetcode.com/problems/add-two-numbers/
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // Dummy node to simplify code
        ListNode current = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10; // Get the carry for the next iteration
            current.next = new ListNode(sum % 10); // Store the last digit of sum
            current = current.next;
        }
        return dummyHead.next;
    }
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }



}
