package com.aditya.files.other;

import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}

class NotSolution {
    public int maxDepth(Node root) {
        if(root==null){
            return 0;
        }
        int count = 0;
        if(root.children!=null){
            for(Node child : root.children){
                count++;
                maxDepth(child);
            }
        }
        return count;
    }
}
