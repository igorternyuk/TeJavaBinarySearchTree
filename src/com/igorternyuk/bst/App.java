/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.igorternyuk.bst;

public class App {

    /**`
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Tree<Integer> tree = new BinarySearchTree<>();
        //Random random = new Random();
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
        tree.insert(21);
        tree.insert(11);
        tree.print();
        System.out.println("Max element = " + tree.getMax());
        System.out.println("Min element = " + tree.getMin());
        System.out.println("Size = " + tree.size());
        System.out.println("H = " + tree.getHeight());
        System.out.println("MaxWidth = " + tree.getMaxWidth());
        System.out.println("\nPreorder:");
        tree.preorderTraversal(tree.getRoot(), data -> { System.out.print(data + "-");});
        System.out.println("\nInorder");
        tree.inorderTraversal(tree.getRoot(), data -> { System.out.print(data + "-");});
        System.out.println("\nPostorder");
        tree.postorderTraversal(tree.getRoot(), data -> { System.out.print(data + "-");});
        System.out.println("\n");
        
        tree.remove(10);
        tree.print();
        
        /*Tree<String> stringTree = new BinarySearchTree<>();
        stringTree.insert("LinuxMint");
        stringTree.insert("Debian");
        stringTree.insert("Ubuntu");
        stringTree.insert("ArchLinux");
        stringTree.insert("Manjaro");
        stringTree.insert("SlackWare");
        stringTree.insert("Gentoo");
        stringTree.insert("AltLinux");
        stringTree.insert("CentOS");
        stringTree.insert("OpenSuse");
        stringTree.insert("RedHat");
        stringTree.insert("Fedora");
        stringTree.insert("MacOS");
        stringTree.insert("Windows");
        stringTree.insert("Android");
        stringTree.print();
        System.out.println("Max element = " + stringTree.getMax());
        System.out.println("Min element = " + stringTree.getMin());
        System.out.println("Size = " + stringTree.size());
        System.out.println("H = " + stringTree.getHeight());
        System.out.println("MaxWidth = " + stringTree.getMaxWidth());
        System.out.println("\nPreorder:");
        stringTree.preorderTraversal(stringTree.getRoot()
                , data -> { System.out.print(data + "-");});
        System.out.println("\nInorder");
        stringTree.inorderTraversal(stringTree.getRoot()
                , data -> { System.out.print(data + "-");});
        System.out.println("\nPostorder");
        stringTree.postorderTraversal(stringTree.getRoot()
                , data -> { System.out.print(data + "-");});*/
    }
    
}
