import java.util.*;
public class Demonstration{
  
  public static void main(String[] args){
    /* -------------------- DEMONSTRATION FOR BINARY SEARCH TREE -------------------- */
    System.out.println("DEMONSTRATION FOR BINARY SEARCH TREE");
    // value in type String
    System.out.println("A binary search tree called tree1 is created with key in type Integer and value in type String");
    BinarySearchTree<Integer, String> tree1 = new BinarySearchTree<Integer, String>();
    tree1.insert(2, "2");
    tree1.insert(1, "1");
    tree1.insert(4, "4");
    tree1.insert(5, "5");
    tree1.insert(9, "9");
    tree1.insert(3, "3");
    tree1.insert(6, "6");
    tree1.insert(7, "7");
    tree1.insert(10, "10");
    tree1.insert(12, "12");
    tree1.insert(11, "11");
    System.out.println("  Insert 2, 1, 4, 5, 9, 3, 6, 7, 10, 12, 11 in tree1");
    System.out.print("    tree1 in inorder traversal after inserting 2, 1, 4, 5, 9, 3, 6, 7, 10, 12, 11 in tree1: ");
    System.out.println(tree1.inorderRec());
    tree1.delete(4);
    System.out.println("  Delete 4 from tree1");
    System.out.print("    tree1 in inorder traversal after deleting 4 from tree1: ");
    System.out.println(tree1.inorderRec());
    tree1.delete(9);
    System.out.println("  Delete 9 from tree1");
    System.out.print("    tree1 in inorder traversal after deleting 9 from tree1: ");
    System.out.println(tree1.inorderRec());
    System.out.print("  tree1 in inorder traversal: ");
    System.out.println(tree1.inorderRec());
    System.out.print("  Searching 12 in tree1: ");
    System.out.println(tree1.search(12));
    System.out.print("  Searching 4 in tree1: ");
    System.out.println(tree1.search(4));
    System.out.print("  Find the 3rd smallest element in tree1: ");
    System.out.println(tree1.kthSmallest(3));
    
    // value in type Double
    System.out.println("A binary search tree called tree2 is created with key in type Integer and value in type Double");
    BinarySearchTree<Integer, Double> tree2 = new BinarySearchTree<Integer, Double>();
    tree2.insert(2, 2.0);
    tree2.insert(1, 1.0);
    tree2.insert(4, 4.0);
    tree2.insert(5, 5.0);
    tree2.insert(9, 9.0);
    tree2.insert(3, 3.0);
    tree2.insert(6, 6.0);
    tree2.insert(7, 7.0);
    tree2.insert(10, 10.0);
    tree2.insert(12, 12.0);
    tree2.insert(11, 11.0);
    System.out.println("  Insert 2, 1, 4, 5, 9, 3, 6, 7, 10, 12, 11 in tree2");
    System.out.print("    tree2 in inorder traversal after inserting 2, 1, 4, 5, 9, 3, 6, 7, 10, 12, 11 in tree2: ");
    System.out.println(tree2.inorderRec());
    tree2.delete(4);
    System.out.println("  Delete 4 from tree2");
    System.out.print("    tree2 in inorder traversal after deleting 4 from tree2: ");
    System.out.println(tree2.inorderRec());
    tree2.delete(9);
    System.out.println("  Delete 9 from tree2");
    System.out.print("    tree2 in inorder traversal after deleting 9 from tree2: ");
    System.out.println(tree2.inorderRec());
    System.out.print("  tree2 in inorder traversal: ");
    System.out.println(tree2.inorderRec());
    System.out.print("  Searching 12 in tree2: ");
    System.out.println(tree2.search(12));
    System.out.print("  Searching 4 in tree2: ");
    System.out.println(tree2.search(4));
    System.out.print("  Find the 3rd smallest element in tree2: ");
    System.out.println(tree2.kthSmallest(3));
    
    // value in type Float
    System.out.println("A binary search tree called tree3 is created with key in type Integer and value in type Float");
    BinarySearchTree<Integer, Float> tree3 = new BinarySearchTree<Integer, Float>();
    tree3.insert(2, new Float(2));
    tree3.insert(1, new Float(1));
    tree3.insert(4, new Float(4));
    tree3.insert(5, new Float(5));
    tree3.insert(9, new Float(9));
    tree3.insert(3, new Float(3));
    tree3.insert(6, new Float(6));
    tree3.insert(7, new Float(7));
    tree3.insert(10, new Float(10));
    tree3.insert(12, new Float(12));
    tree3.insert(11, new Float(11));
    System.out.println("  Insert 2, 1, 4, 5, 9, 3, 6, 7, 10, 12, 11 in tree3");
    System.out.print("    tree3 in inorder traversal after inserting 2, 1, 4, 5, 9, 3, 6, 7, 10, 12, 11 in tree3: ");
    System.out.println(tree3.inorderRec());
    tree3.delete(4);
    System.out.println("  Delete 4 from tree3");
    System.out.print("    tree3 in inorder traversal after deleting 4 from tree3: ");
    System.out.println(tree3.inorderRec());
    tree3.delete(9);
    System.out.println("  Delete 9 from tree3");
    System.out.print("    tree3 in inorder traversal after deleting 9 from tree3: ");
    System.out.println(tree3.inorderRec());
    System.out.print("  tree3 in inorder traversal: ");
    System.out.println(tree3.inorderRec());
    System.out.print("  Searching 12 in tree3: ");
    System.out.println(tree3.search(12));
    System.out.print("  Searching 4 in tree3: ");
    System.out.println(tree3.search(4));
    System.out.print("  Find the 3rd smallest element in tree3: ");
    System.out.println(tree3.kthSmallest(3));
    
    // An example using the key-value pairs
    // key in type Float and value in type String
    System.out.println("A binary search tree called exampleBSTree is created with key in type Float and value in type String");
    BinarySearchTree<Float, String> exampleBSTree = new BinarySearchTree<Float, String>();
    exampleBSTree.insert(new Float(2), "2");
    exampleBSTree.insert(new Float(1), "1");
    exampleBSTree.insert(new Float(4), "4");
    exampleBSTree.insert(new Float(5), "5");
    exampleBSTree.insert(new Float(9), "9");
    exampleBSTree.insert(new Float(3), "3");
    exampleBSTree.insert(new Float(6), "6");
    exampleBSTree.insert(new Float(7), "7");
    exampleBSTree.insert(new Float(10), "10");
    exampleBSTree.insert(new Float(12), "12");
    exampleBSTree.insert(new Float(11), "11");
    System.out.println("  Insert 2, 1, 4, 5, 9, 3, 6, 7, 10, 12, 11 in exampleBSTree");
    System.out.print("    exampleBSTree in inorder traversal after inserting 2, 1, 4, 5, 9, 3, 6, 7, 10, 12, 11 in exampleBSTree: ");
    System.out.println(exampleBSTree.inorderRec());
    exampleBSTree.delete(new Float(4));
    System.out.println("  Delete 4 from exampleBSTree");
    System.out.print("    exampleBSTree in inorder traversal after deleting 4 from exampleBSTree: ");
    System.out.println(exampleBSTree.inorderRec());
    exampleBSTree.delete(new Float(9));
    System.out.println("  Delete 9 from exampleBSTree");
    System.out.print("    exampleBSTree in inorder traversal after deleting 9 from exampleBSTree: ");
    System.out.println(exampleBSTree.inorderRec());
    System.out.print("  exampleBSTree in inorder traversal: ");
    System.out.println(exampleBSTree.inorderRec());
    System.out.print("  Searching 12 in exampleBSTree: ");
    System.out.println(exampleBSTree.search(new Float(12)));
    System.out.print("  Searching 4 in exampleBSTree: ");
    System.out.println(exampleBSTree.search(new Float(4)));
    System.out.print("  Find the 3rd smallest element in exampleBSTree: ");
    System.out.println(exampleBSTree.kthSmallest(3));
    
    /* -------------------- DEMONSTRATION FOR AVL TREE -------------------- */
    System.out.println("DEMONSTRATION FOR AVL TREE");
    // value in type String
    System.out.println("An AVL tree called tree4 is created with key in type Integer and value in type String");
    AVLTree<Integer, String> tree4 = new AVLTree<Integer, String>();
    tree4.insert(2, "2");
    tree4.insert(1, "1");
    tree4.insert(4, "4");
    tree4.insert(5, "5");
    tree4.insert(9, "9");
    tree4.insert(3, "3");
    tree4.insert(6, "6");
    tree4.insert(7, "7");
    tree4.insert(10, "10");
    tree4.insert(12, "12");
    tree4.insert(11, "11");
    System.out.println("  Insert 2, 1, 4, 5, 9, 3, 6, 7, 10, 12, 11 in tree4");
    System.out.print("    tree4 in inorder traversal after inserting 2, 1, 4, 5, 9, 3, 6, 7, 10, 12, 11 in tree4: ");
    System.out.println(tree4.inorderRec());
    tree4.delete(4);
    System.out.println("  Delete 4 from tree4");
    System.out.print("    tree4 in inorder traversal after deleting 4 from tree4: ");
    System.out.println(tree4.inorderRec());
    tree4.delete(9);
    System.out.println("  Delete 9 from tree4");
    System.out.print("    tree4 in inorder traversal after deleting 9 from tree4: ");
    System.out.println(tree4.inorderRec());
    System.out.print("  tree4 in inorder traversal: ");
    System.out.println(tree4.inorderRec());
    System.out.print("  Searching 12 in tree4: ");
    System.out.println(tree4.search(12));
    System.out.print("  Searching 4 in tree4: ");
    System.out.println(tree4.search(4));
    System.out.print("  Find the 3rd smallest element in tree4: ");
    System.out.println(tree4.kthSmallest(3));
    
    // value in type Double
    System.out.println("An AVL tree called tree5 is created with key in type Integer and value in type Double");
    AVLTree<Integer, Double> tree5 = new AVLTree<Integer, Double>();
    tree5.insert(2, 2.0);
    tree5.insert(1, 1.0);
    tree5.insert(4, 4.0);
    tree5.insert(5, 5.0);
    tree5.insert(9, 9.0);
    tree5.insert(3, 3.0);
    tree5.insert(6, 6.0);
    tree5.insert(7, 7.0);
    tree5.insert(10, 10.0);
    tree5.insert(12, 12.0);
    tree5.insert(11, 11.0);
    System.out.println("  Insert 2, 1, 4, 5, 9, 3, 6, 7, 10, 12, 11 in tree5");
    System.out.print("    tree5 in inorder traversal after inserting 2, 1, 4, 5, 9, 3, 6, 7, 10, 12, 11 in tree5: ");
    System.out.println(tree5.inorderRec());
    tree5.delete(4);
    System.out.println("  Delete 4 from tree5");
    System.out.print("    tree5 in inorder traversal after deleting 4 from tree5: ");
    System.out.println(tree5.inorderRec());
    tree5.delete(9);
    System.out.println("  Delete 9 from tree5");
    System.out.print("    tree5 in inorder traversal after deleting 9 from tree5: ");
    System.out.println(tree5.inorderRec());
    System.out.print("  tree5 in inorder traversal: ");
    System.out.println(tree5.inorderRec());
    System.out.print("  Searching 12 in tree5: ");
    System.out.println(tree5.search(12));
    System.out.print("  Searching 4 in tree5: ");
    System.out.println(tree5.search(4));
    System.out.print("  Find the 3rd smallest element in tree5: ");
    System.out.println(tree5.kthSmallest(3));
    
    // value in type Float
    System.out.println("An AVL tree tree called tree6 is created with key in type Integer and value in type Float");
    AVLTree<Integer, Float> tree6 = new AVLTree<Integer, Float>();
    tree6.insert(2, new Float(2));
    tree6.insert(1, new Float(1));
    tree6.insert(4, new Float(4));
    tree6.insert(5, new Float(5));
    tree6.insert(9, new Float(9));
    tree6.insert(3, new Float(3));
    tree6.insert(6, new Float(6));
    tree6.insert(7, new Float(7));
    tree6.insert(10, new Float(10));
    tree6.insert(12, new Float(12));
    tree6.insert(11, new Float(11));
    System.out.println("  Insert 2, 1, 4, 5, 9, 3, 6, 7, 10, 12, 11 in tree6");
    System.out.print("    tree6 in inorder traversal after inserting 2, 1, 4, 5, 9, 3, 6, 7, 10, 12, 11 in tree6: ");
    System.out.println(tree6.inorderRec());
    tree6.delete(4);
    System.out.println("  Delete 4 from tree6");
    System.out.print("    tree6 in inorder traversal after deleting 4 from tree6: ");
    System.out.println(tree6.inorderRec());
    tree6.delete(9);
    System.out.println("  Delete 9 from tree6");
    System.out.print("    tree6 in inorder traversal after deleting 9 from tree6: ");
    System.out.println(tree6.inorderRec());
    System.out.print("  tree6 in inorder traversal: ");
    System.out.println(tree6.inorderRec());
    System.out.print("  Searching 12 in tree6: ");
    System.out.println(tree6.search(12));
    System.out.print("  Searching 4 in tree6: ");
    System.out.println(tree6.search(4));
    System.out.print("  Find the 3rd smallest element in tree6: ");
    System.out.println(tree6.kthSmallest(3));
    
    // An example using the key-value pairs
    // key in type Float and value in type String
    System.out.println("An AVL tree called exampleAVLTree is created with key in type Float and value in type String");
    AVLTree<Float, String> exampleAVLTree = new AVLTree<Float, String>();
    exampleAVLTree.insert(new Float(2), "2");
    exampleAVLTree.insert(new Float(1), "1");
    exampleAVLTree.insert(new Float(4), "4");
    exampleAVLTree.insert(new Float(5), "5");
    exampleAVLTree.insert(new Float(9), "9");
    exampleAVLTree.insert(new Float(3), "3");
    exampleAVLTree.insert(new Float(6), "6");
    exampleAVLTree.insert(new Float(7), "7");
    exampleAVLTree.insert(new Float(10), "10");
    exampleAVLTree.insert(new Float(12), "12");
    exampleAVLTree.insert(new Float(11), "11");
    System.out.println("  Insert 2, 1, 4, 5, 9, 3, 6, 7, 10, 12, 11 in exampleAVLTree");
    System.out.print("    exampleAVLTree in inorder traversal after inserting 2, 1, 4, 5, 9, 3, 6, 7, 10, 12, 11 in exampleAVLTree: ");
    System.out.println(exampleAVLTree.inorderRec());
    exampleAVLTree.delete(new Float(4));
    System.out.println("  Delete 4 from exampleAVLTree");
    System.out.print("    exampleAVLTree in inorder traversal after deleting 4 from exampleAVLTree: ");
    System.out.println(exampleAVLTree.inorderRec());
    exampleAVLTree.delete(new Float(9));
    System.out.println("  Delete 9 from exampleAVLTree");
    System.out.print("    exampleAVLTree in inorder traversal after deleting 9 from exampleAVLTree: ");
    System.out.println(exampleAVLTree.inorderRec());
    System.out.print("  exampleAVLTree in inorder traversal: ");
    System.out.println(exampleAVLTree.inorderRec());
    System.out.print("  Searching 12 in exampleAVLTree: ");
    System.out.println(exampleAVLTree.search(new Float(12)));
    System.out.print("  Searching 4 in exampleAVLTree: ");
    System.out.println(exampleAVLTree.search(new Float(4)));
    System.out.print("  Find the 3rd smallest element in exampleAVLTree: ");
    System.out.println(exampleAVLTree.kthSmallest(3));
    
    System.out.println("Show Efficiency Of AVL Tree:");
    System.out.println("  An AVL tree called efficientTree is created with key in type Integer and value in type String");
    AVLTree<Integer, String> efficientTree = new AVLTree<Integer, String>();
    System.out.println("  A binary search tree called inefficientTree is created with key in type Integer and value in type String");
    BinarySearchTree<Integer, String> inefficientTree = new BinarySearchTree<Integer, String>();
    System.out.println("  Both efficientTree and inefficientTree have nodes inserted in the trees, nodes deleted from the trees, and nodes searched with equal pairs of key and value");
    System.out.println("    Insert nodes from 0 to 999 in efficientTree");
    for(int i = 0; i < 1000; i = i + 1){
      efficientTree.insert(i, "" + i);
    }
    System.out.println("    Print nodes from 100 to 349 gained by searching with efficientTree");
    System.out.print("    ");
    for(int i = 100; i < 350; i = i + 1){
      System.out.print(efficientTree.search(i) + " ");
    }
    System.out.println("");
    System.out.println("    Delete nodes from 100 to 199 in efficientTree");
    for(int i = 100; i < 200; i = i + 1){
      efficientTree.delete(i);
    }
    System.out.println("    Print all existing nodes gained by searching in efficientTree after all insertions and deletions for efficientTree");
    System.out.print("    ");
    for(int i = 0; i < 1000; i = i + 1){
      if(efficientTree.search(i) != null){
        System.out.print(efficientTree.search(i) + " ");
      }
    }
    System.out.println("");
    System.out.println("    Finish all insertion, search, and deletion for efficientTree");
    System.out.println("    Insert nodes from 0 to 999 in inefficientTree");
    for(int i = 0; i < 1000; i = i + 1){
      inefficientTree.insert(i, "" + i);
    }
    System.out.println("    Print nodes from 100 to 349 gained by searching with inefficientTree");
    System.out.print("    ");
    for(int i = 100; i < 350; i = i + 1){
      System.out.print(inefficientTree.search(i)+ " ");
    }
    System.out.println("");
    System.out.println("    Delete nodes from 100 to 199 in inefficientTree");
    for(int i = 100; i < 200; i = i + 1){
      inefficientTree.delete(i);
    }
    System.out.println("    Print all existing nodes gained by searching in inefficientTree after all insertions and deletions for inefficientTree");
    System.out.print("    ");
    for(int i = 0; i < 1000; i = i + 1){
      if(inefficientTree.search(i) != null){
        System.out.print(inefficientTree.search(i) + " ");
      }
    }
    System.out.println("");
    System.out.println("    Finish all insertion, search, and deletion for inefficientTree");
    System.out.println("  efficientTree has much smaller height than inefficientTree as efficientTree rebalances the node when there is at least one node that makes the tree become unbalanced");
    System.out.println("  Therefore, for inefficientTree, each of insertion, search, and deletion may take much longer time when there is large number of data that make the tree become very unbalanced");
    System.out.println("  In this case, the binary search tree takes time complexity of O(N) for each of insertion, search, and deletion while the AVL tree takes time complexity of O(logN) for each of insertion, search, and deletion (N is number of nodes in the tree)");
  }
}