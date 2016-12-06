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
    
    // the base case is there are at least 2 nodes in the array list
    if (size >= 2) {
      // get the last two nodes in the array and remove them from array list
      CharacterList node1 = list.get(size - 1);
      CharacterList node2 = list.get(size - 2);
      list.remove(size - 1);
      list.remove(size - 2);
      
      // merge these two nodes and put into the end of the array list
      CharacterList mergeNode = new CharacterList();
      mergeNode.setRight(node1);
      mergeNode.setLeft(node2);
      list.add(mergeNode);
      
      // recursivly call the function
      buildTree(list);
    }
  }
}