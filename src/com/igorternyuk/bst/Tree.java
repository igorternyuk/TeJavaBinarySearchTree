/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.igorternyuk.bst;

import java.util.function.Consumer;

public interface Tree<T> {
    public Node<T> getRoot();
    public void insert(T data);
    public void remove(T data);
    public boolean contains(T key);
    public boolean isEmpty();
    public int size();
    public int getHeight();
    public int getMaxWidth();
    public T getMax();
    public T getMin();
    public void traverse(Consumer<T> visitFunc);
    public void preorder(Node<T> root, Consumer<T> work);
    public void inorder(Node<T> root, Consumer<T> work);
    public void postorder(Node<T> root, Consumer<T> work);
    public void print();
}
