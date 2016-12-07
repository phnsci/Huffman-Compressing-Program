/**
 * HuffmanTree class have functions:
 * buildTree which receive an arraylist of CharacterList and return
 * a Huffman tree. The Huffman tree at this step is simple. We just merge
 * two characters having the lowest frequency. This method is simple but 
 * doesn't fully optimize the compression. We'll work more on this on the 
 * final version
 *
 * @author: Phong Nguyen - phn10
 * @author: Joel Rand -jsr99
 */

import java.util.*;

public class HuffmanTree {
  public static void buildTree(ArrayList<CharacterList> list) {
    int size = list.size();
    
    
      for (int i = 0; i < list.size(); i++) {
        System.out.print(list.get(i).getChar() + " ");
      }
    
    // the base case is there are at least 2 nodes in the array list
    if (size >= 2) {
      // quick sort the list
      SortCharacterList.sortList(list);
      
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
      
      System.out.println();
      // recursivly call the function
      buildTree(list);
    }
  }
  
  public static void enCode(CharacterList node) {
    ArrayList<Boolean> newCode = new ArrayList<Boolean>();
    enCode(node, newCode);
  }
    
  public static void enCode(CharacterList node, ArrayList<Boolean> code) {
    
    ArrayList<Boolean> newCode = new ArrayList<Boolean>();
    
    // if the node is not leaf
    if (node.hasLeft() || node.hasRight()) {
      System.out.println("New Code: " + code);
      if (node.hasLeft()) {
        System.out.println("go left");
        
        for (int i = 0; i < code.size(); i++)
          newCode.add(code.get(i));
        
        newCode.add(true);
        
        node.setCode(newCode);
        node = node.getLeft();
        enCode(node, newCode);
      }
      if (node.hasRight()) {
        System.out.println("go right");
        
        for (int i = 0; i < code.size(); i++)
          newCode.add(code.get(i));
        
        newCode.add(false);
        
        node.setCode(newCode);
        node = node.getRight();
        enCode(node, newCode);
      }
    } else {
      System.out.println("set code: "+ code);
      node.setCode(code);
    }
  }
}