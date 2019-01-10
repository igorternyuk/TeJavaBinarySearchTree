/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.igorternyuk.bst;

/**
 * 
 * @author Igor Ternyuk <xmonad gmail.com>
 */
public class Node<T> {
    private T data;
    private Node<T> leftChild;
    private Node<T> rightChild;
    
    public Node(T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }
    
    public boolean hasLeftChild(){
        return this.leftChild != null;
    }
    
    public boolean hasRightChild(){
        return this.rightChild != null;
    }
    
    @Override
    public String toString() {
        return data.toString();
    }
}
