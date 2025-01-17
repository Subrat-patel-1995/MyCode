package org.DSA.ds.tree;

import java.util.*;

public class practiceTree {

        //Question no 102
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result=new ArrayList<>();
            if(root==null){
                return result;
            }
            Queue<TreeNode> list=new LinkedList<>();
            list.offer(root);
            while (!list.isEmpty()){
                int levelSize=list.size();
                List<Integer> levelContents=new ArrayList<>();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node=list.poll();
                    if(node.left!=null){
                        list.add(node.left);
                    }
                    if(node.right!=null){
                        list.add(node.right);
                    }
                    levelContents.add(node.val);
                }
                result.add(levelContents);
            }
            return result;
        }

        //Question no 637
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> result=new ArrayList<>();
            if(root==null){
                return result;
            }
            Queue<TreeNode> list=new LinkedList<>();
            list.offer(root);
            while (!list.isEmpty()){
                int levelSize=list.size();
                Double levelContents=0.0;
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node=list.poll();
                    if(node.left!=null){
                        list.add(node.left);
                    }
                    if(node.right!=null){
                        list.add(node.right);
                    }
                    levelContents+=node.val;
                }
                //calculate average!

                result.add(levelContents/levelSize);
            }
            return result;
        }

        //Question No 103
        //ZigZag level orders.
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result=new ArrayList<>();
            if(root==null){
                return result;
            }
            LinkedList<TreeNode> list=new LinkedList<>();
            list.offer(root);
            boolean isReverseOrder=false;
            while (!list.isEmpty()){
                int levelSize=list.size();
                List<Integer> levelContents=new ArrayList<>();
                if(isReverseOrder) {
                    for (int i = 0; i < levelSize; i++) {
                        TreeNode node = list.pollLast();
                        if (node.right != null) {
                            list.addFirst(node.right);
                        }
                        if (node.left != null) {
                            list.addFirst(node.left);
                        }

                        levelContents.add(node.val);
                    }
                    isReverseOrder=false;
                }else {
                    for (int i = 0; i < levelSize; i++) {
                        TreeNode node = list.poll();
                        if (node.left != null) {
                            list.add(node.left);
                        }
                        if (node.right != null) {
                            list.add(node.right);
                        }
                        levelContents.add(node.val);
                    }
                    isReverseOrder=true;

                }
                result.add(levelContents);
            }
            return result;
        }

        //Question no 107
        public List<List<Integer>> levelOrderBottom(TreeNode root){
            List<List<Integer>> result=new ArrayList<>();
            if(root==null){
                return result;
            }
            LinkedList<TreeNode> list=new LinkedList<>();
            list.add(root);

            while (!list.isEmpty()){
                List<Integer>level=new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    TreeNode node=list.poll();
                    if(node.left!=null){
                       list.add(node.left);
                    }
                    if(node.right!=null){
                        list.add(node.right);
                    }
                    level.add(node.val);
                }
                result.add(0,level);
            }
            return result;
        }

        //Qestion no 429
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> result=new ArrayList<>();
            if(root==null){
                return result;
            }
            Queue<Node> list=new LinkedList<>();
            list.offer(root);
            while (!list.isEmpty()){
                int levelSize=list.size();
                List<Integer> levelContents=new ArrayList<>();
                for (int i = 0; i < levelSize; i++) {
                    Node node=list.poll();
                    List<Node> children=node.children;
                   int childSize=children.size();
                    for (int j = 0; j < childSize; j++) {
                        list.offer(children.get(j));
                    }
                    levelContents.add(node.val);
                }
                result.add(levelContents);
            }
            return result;
        }

        //Question   590
        public List<Integer> postorder(Node root) {
            List<Integer> result=new ArrayList<>();
            if(root==null){
                return result;
            }
            Deque<Node> list=new LinkedList<>();
            list.offer(root);
            while (!list.isEmpty()){
                int levelSize=list.size();
                for (int i = 0; i < levelSize; i++) {
                    Node node=list.poll();
                    List<Node> children=node.children;
                    int childSize=children.size();
                    for (int j = 0; j < childSize; j++) {
                        list.addFirst(children.get(j));
                    }
                    result.add(0,node.val);
                }
            }
            return result;
        }

    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


}
