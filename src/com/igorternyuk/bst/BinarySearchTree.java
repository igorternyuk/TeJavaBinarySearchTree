/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.igorternyuk.bst;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * 
 * @author Igor Ternyuk <xmonad gmail.com>
 */
public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {
    private Node<T> root;
    
    @Override
    public void insert(T newData){
        if(this.root == null){
            this.root = new Node<>(newData);
        } else {
            insertNode(newData, this.root);
        }
    }
    
    @Override
    public Node<T> getRoot(){
        return this.root;
    }
 
    @Override
    public boolean isEmpty(){
        return this.root == null;
    }
    
    private boolean find(Node<T> root, T key){
        if(root == null){
            return false;
        } else {
            if(key.compareTo(root.getData()) < 0){
                return find(root.getLeftChild(), key);
            } else if (key.compareTo(root.getData()) > 0) {
                return find(root.getRightChild(), key);
            } else {
                return true;    
            }
        }
    }
    
    @Override
    public boolean contains(T key){
        return find(this.root, key);
    }
    
    private void insertNode(T newData, Node<T> node) {
        
        if(newData.compareTo(node.getData()) < 0){
            if(node.getLeftChild() == null){
                node.setLeftChild(new Node<>(newData));
            } else {
                insertNode(newData, node.getLeftChild());
            }
            
        } else if(newData.compareTo(node.getData()) > 0){
            if(node.getRightChild() == null){
                node.setRightChild(new Node<>(newData));
            } else {
                insertNode(newData, node.getRightChild());
            }
        } else {
           node.setData(newData);
        }
    }

    @Override
    public void remove(T data) {
        delete(this.root, data);
    }
    
    private Node<T> delete(Node<T> node, T data){
        if(node == null){
            return node;
        }
        
        if(data.compareTo(node.getData()) > 0){
            node.setRightChild(delete(node.getRightChild(), data));
        } else if(data.compareTo(node.getData()) < 0){
            node.setLeftChild(delete(node.getLeftChild(), data));
        } else {
            // The node to remove is a leaf node
            if(!node.hasLeftChild() && !node.hasRightChild()){
                System.out.println("Removing leaf node...");
                return null;
            }
            
            //The node we would like to remove has one child
            if(node.hasLeftChild() ^ node.hasRightChild()){
                System.out.println("Removing the node with a single child...");
                return node.hasLeftChild() ? node.getLeftChild() : node.getRightChild();
            }
            
            //The node we are going to remove has both children
            //We are going to find max element in the left subtree
            System.out.println("Removing the node with both children...");
            Node<T> predecessor = getPredecessor(node.getLeftChild());
            node.setData(predecessor.getData());
            node.setLeftChild(delete(node.getLeftChild(), predecessor.getData()));            
        }
        return node;
    }
    
    private Node<T> getPredecessor(Node<T> node){
        if(node == null){
            return node;
        }
        while(node.hasRightChild()){
            node = node.getRightChild();
        }
        return node;
    }
    
    private int countNodes(Node<T> root){
        if(root == null){
            return 0;
        }
        return countNodes(root.getLeftChild()) + countNodes(root.getRightChild()) + 1;
    }
    
    @Override
    public int size() {
        return this.countNodes(this.root);
    }
    
    private int getHeight(Node<T> root){
        if(root == null){
            return 0;
        }
        int leftSubtreeHeight = 0;
        int rightSubtreeHeight = 0;
        if(root.hasLeftChild()){
            leftSubtreeHeight = getHeight(root.getLeftChild());
        }
        if(root.hasRightChild()){
            rightSubtreeHeight = getHeight(root.getRightChild());
        }
        return Math.max(leftSubtreeHeight, rightSubtreeHeight) + 1;
    }
    
    @Override
    public int getHeight() {
        return getHeight(this.root);
    }
    
    @Override
    public int getMaxWidth() {
        if(isEmpty()){
            return 0;
        }
        int height = this.getHeight();
        int maxWidth = 0;
        for (int lvl = 0; lvl <= height; lvl++) {
            int currentWidth = getWidth(this.root, lvl);
            if(currentWidth > maxWidth){
                maxWidth = currentWidth;
            }
        }
        return maxWidth;
    }
    
    private int getWidth(Node<T> root, int level){
        if(root == null){
            return 0;
        }
        if(level == 1){
            return 1;
        } else if(level > 1){
            return getWidth(root.getLeftChild(), level - 1)
                    + getWidth(root.getRightChild(), level - 1);
        } else {
            return 0;
        }
    }

    @Override
    public T getMin() {
        Node<T> node = this.root;
        if(node == null){
            throw new IllegalArgumentException("The node should contain some data");
        }
        while(node.hasLeftChild()){
            node = node.getLeftChild();
        }
        return node.getData();
    }
    
    
    @Override
    public T getMax() {
        Node<T> node = this.root;
        if(node == null){
            throw new IllegalArgumentException("The node should contain some data");
        }
        while(node.hasRightChild()){
            node = node.getRightChild();
        }
        return node.getData();
    }

 
    @Override
    public void preorderTraversal(Node<T> root, Consumer<T> work) {
        if(root == null){
            return;
        }
        work.accept(root.getData());
        preorderTraversal(root.getLeftChild(), work);
        preorderTraversal(root.getRightChild(), work);
    }

    @Override
    public void inorderTraversal(Node<T> root, Consumer<T> work) {
        if(root == null){
            return;
        }
        inorderTraversal(root.getLeftChild(), work);
        work.accept(root.getData());
        inorderTraversal(root.getRightChild(), work);
    }

    @Override
    public void postorderTraversal(Node<T> root, Consumer<T> work) {
        if(root == null){
            return;
        }
        postorderTraversal(root.getLeftChild(), work);
        postorderTraversal(root.getRightChild(), work);
        work.accept(root.getData());
    }

    private void walk(Node<T> root, BiConsumer<Node<T>,Integer> walkFunc, int level) {
        if(root == null){
            return;
        }
        if(root.hasRightChild()){
            walk(root.getRightChild(), walkFunc, level + 1);
        }
        walkFunc.accept(root, level);
        if(root.hasLeftChild()){
            walk(root.getLeftChild(), walkFunc, level + 1);
        }
        
    }
    
    @Override
    public void traverse(final Consumer<T> visitFunc) {
        walk(this.root, (node, level) -> {
           visitFunc.accept(node.getData());
        }, 0);
    }
    
    @Override
    public void print(){
        walk(this.root, (node, level) -> {
            if(node == null){
                return;
            }
            String data = "";
            for(int i = 0; i < level; ++i){
                data += "    ";
            }
            System.out.println(String.format("%s%s", data, node));
        }, 0);
    }
}
