/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.igorternyuk.bst;

public interface Tree<T> {
    public void insert(T data);
    public void remove(T data);
    public void size();
    public T getMax();
    public T getMin();
    public void traverse();
}
