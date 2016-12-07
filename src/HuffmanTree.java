/**
 * HuffmanTree class have 2 functions:
 * 1. buildTree: receive an arraylist of CharacterList and return
 * a Huffman tree using greedy algorithm
 *
 * 2. enCode: receive a node from top of the Huffman tree and percolate
 * down to the base. The function rely on the posion of the node on the 
 * tree to encode the node >>> At this time, the function doesn't work 
 * properly
 * 
 * @author: Phong Nguyen - phn10
 * @author: Joel Rand -jsr99
 */

import java.util.*;

public class HuffmanTree {
  /**
   * this function receive an arraylist of CharacterList instance object and
   * build a Huffman tree from them using greedy algorithm
   * @param list a list of CharacterList objects
   */
  public static void buildTree(ArrayList<CharacterList> list) {
    int size = list.size();
    // the base case is there are at least 2 nodes in the array list
    if (size >= 2) {
      // quick sort the list
      SortList.sortList(list);
      
      // get the last two nodes  
      // and remove them from array list
      CharacterList node1 = list.get(size - 1);
      CharacterList node2 = list.get(size - 2);
      list.remove(size - 1);
      list.remove(size - 2);
      
      // merge these two nodes and put into the end of the array list
      CharacterList mergeNode = new CharacterList();
      mergeNode.setRight(node1);
      mergeNode.setLeft(node2);
      mergeNode.setCount(node1.getCount() + node2.getCount());
      list.add(mergeNode);
      
      // recursivly call the function
      buildTree(list);
    }
  }
  
  /**
   * encode each elements in the CharacterList array using Huffman coding algorithm
   * @param node the top node of the Huffman tree
   */
  public static void enCode(CharacterList node) {
    ArrayList<Boolean> newCode = new ArrayList<Boolean>();
    enCode(node, newCode);
  }
    
  
  /**
   * encode each elements in the CharacterList array using Huffman coding algorithm
   * @param node the top node of the Huffman tree
   * @param code the code we gonna need for implementation
   */
  public static void enCode(CharacterList node, ArrayList<Boolean> code) {
    
    ArrayList<Boolean> newCode = new ArrayList<Boolean>();
    
    // if the node is not the leaf node
    if (node.hasLeft() || node.hasRight()) {
      if (node.hasLeft()) {
        for (int i = 0; i < code.size(); i++)
          newCode.add(code.get(i));
        
        newCode.add(true);
        
        node.setCode(newCode);
        node = node.getLeft();
        enCode(node, newCode);
      }
      if (node.hasRight()) {
        for (int i = 0; i < code.size(); i++)
          newCode.add(code.get(i));
        
        newCode.add(false);
        
        node.setCode(newCode);
        node = node.getRight();
        enCode(node, newCode);
      }
    } else {
      node.setCode(code);
    }
  }
}
