/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.igorternyuk.bst;

import java.util.Random;

public class App {

    /**`
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Tree<Integer> tree = new BinarySearchTree<>();
        Random random = new Random();
        /*for(int i = 0; i < 7; ++i){
            tree.insert(random.nextInt(100));
        }*/
        tree.insert(10);
        tree.insert(15);
        tree.insert(7);
        tree.insert(17);
        tree.insert(13);
        tree.insert(9);
        tree.insert(2);
        tree.print();
        System.out.println("Max element = " + tree.getMax());
        System.out.println("Min element = " + tree.getMin());
        System.out.println("Size = " + tree.size());
        System.out.println("H = " + tree.getHeight());
        System.out.println("MaxWidth = " + tree.getMaxWidth());
        System.out.println("\nPreorder:");
        tree.preorder(tree.getRoot(), data -> { System.out.print(data + "-");});
        System.out.println("\nInorder");
        tree.inorder(tree.getRoot(), data -> { System.out.print(data + "-");});
        System.out.println("\nPostorder");
        tree.postorder(tree.getRoot(), data -> { System.out.print(data + "-");});
    }
    
}
