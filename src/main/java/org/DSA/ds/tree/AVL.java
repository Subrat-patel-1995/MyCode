package org.DSA.ds.tree;

public class AVL {
    private Node root;

    public int height() {
        return height(root);
    }
    public int height(Node node){
        if(node==null){
            return -1;
        }
        return node.height;
    }
    public boolean isEmpty(){
        return root==null;
    }
    public void display(int num){
        if(num==1)
            preOrderDisplay(root,"Root Node :");
        else if (num==2) {
            inOrderDisplay(root,"Root Node :");
        } else if (num==3) {
            postOrderDisplay(root,"Root Node :");
        }
    }
    //pre order display
    private void preOrderDisplay(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.value);
        preOrderDisplay(node.left,"This is Left Child of "+node.value+" :");
        preOrderDisplay(node.right,"This is Right Child of "+node.value+" :");

    }

    //In order display
    private void inOrderDisplay(Node node, String details) {
        if (node == null) {
            return;
        }
        inOrderDisplay(node.left,"This is Left Child of "+node.value+" :");
        System.out.println(details + node.value);
        inOrderDisplay(node.right,"This is Right Child of "+node.value+" :");

    }
    private void postOrderDisplay(Node node, String details) {
        if (node == null) {
            return;
        }
        postOrderDisplay(node.left,"This is Left Child of "+node.value+" :");
        postOrderDisplay(node.right,"This is Right Child of "+node.value+" :");
        System.out.println(details + node.value);
    }

    public void insert(int value){
        root=insert(value,root);
    }
    public void insert(int[] nums){
        if(isSortedEitherOrder(nums)){
            insertSorted(nums);
        }else {
            for (int i = 0; i < nums.length; i++) {
                insert(i);
            }
        }
    }
    private void insertSorted(int[] nums){
        insertSorted(nums,0, nums.length);
    }
    private void insertSorted(int[] nums,int start,int end) {
        if (start >= end) {
            return;
        }
        int mid=(start+end)/2;
        insert(nums[mid]);
        insertSorted(nums,start,mid);
        insertSorted(nums,mid+1,end);

    }
    public boolean isSortedEitherOrder(int[] arr) {
        boolean ascending = true;
        boolean descending = true;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) ascending = false;
            if (arr[i] < arr[i + 1]) descending = false;

            // If both flags are false, the array is unsorted
            if (!ascending && !descending) {
                return false;
            }
        }
        return true; // Array is sorted in either ascending or descending order
    }
    private Node insert(int value, Node node){
        if(node==null){
            node= new Node(value);
            return node;
        }
        if(value < node.value){
            node.left=insert(value,node.left);
        } if(value > node.value) {
            node.right=insert(value,node.right);
        }
        node.height=Math.max(height(node.right),height(node.left))+1;
        return rotate(node);
    }

    private Node rotate(Node node) {
        if (height(node.left) - height(node.right) > 1) {
            // left heavy
            if(height(node.left.left) - height(node.left.right) > 0) {
                // left left case
                return rightRotate(node);
            }
            if(height(node.left.left) - height(node.left.right) < 0) {
                // left right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if (height(node.left) - height(node.right) < -1) {
            // right heavy
            if(height(node.right.left) - height(node.right.right) < 0) {
                // right right case
                return leftRotate(node);
            }
            if(height(node.right.left) - height(node.right.right) > 0) {
                // left right case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    public Node rightRotate(Node p) {
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);

        return c;
    }

    public Node leftRotate(Node c) {
        Node p = c.right;
        Node t = p.left;

        p.left = c;
        c.right = t;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);

        return p;
    }

    public boolean balanced(){
        return balanced(root);
    }
    public boolean balanced(Node node){
        if(node==null){
            return true;
        }
        return Math.abs(height(node.left)-height(node.right))<=1 && balanced(node.left) && balanced(node.right);
    }
    class Node {
        private Node left;
        private Node right;
        private int value;
        private int height;

        public Node() {

        }

        public Node(int value) {
            this.value = value;
        }
        public int getValue(){
            return value;
        }

    }
        public static void main(String[] args) {
            AVL tree = new AVL();

            for(int i=0; i < 1000; i++) {
                tree.insert(i);
            }
            tree.display(1);

            System.out.println(tree.height());
        }

}
