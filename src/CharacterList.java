/**
 * The CharacterList is the representation of the node in the Huffman tree
 * Each CharacterList instance object has the character it gonna represent,
 * the counter of that character in the string
 * In order to create connection with other nodes in the Huffman tree, each 
 * CharacterList instance object also has two pointer pointing to two nodes 
 * below it.
 * 
 * @author Phong Nguyen - phn10
 * @author Joel Rand - jsr99
 */ 

import java.util.*;
import java.util.Arrays;

public class CharacterList {
  
  
  private char value;         // the character will store in this object
  private int count;      // the counter of the above character 
  CharacterList left;
  CharacterList right;
  ArrayList<Boolean> code;
  
 /**
  * class constructor 
  */
  public CharacterList() {
    this.value = '0';
    this.count = 0;
    this.left = null;
    this.right = null;
    this.code = new ArrayList<Boolean>();
  }
 
 /** 
  * class constructor
  * @param v character 
  * @param c the counter of that character in the string
  */
  public CharacterList(char v, int c) {
    this.value = v;
    this.count = c;
    this.left = null;
    this.right = null;
    this.code = new ArrayList<Boolean>();
  }
 
 /**
  * increase the counter of the character stored
  * in this object by one
  * @return Nothing
  */
  public void increment() {
    this.count++;
  }
 
 /**
  * get the character stored inside this object
  * @return The character stored in this object
  */
  public char getChar() {
    return this.value;
  }
  
  /**
   * get the counter of the character stored in this object
   * @return The counter of the character stored in this object
   */
  public int getCount() {
    return this.count;
  }
  
  /**
   * set the character stored in this object
   * @param ch the character we gonna store
   * @return Nothing
   */
  public void setChar(char ch) {
    this.value = ch;
  }
  
  
  /**
   * set the counter of the character stored in this object
   * @param count the counter of the character in this object
   * @return Nothing
   */
  public void setCount(int count) {
    this.count = count;
  }
  
  public void setLeft(CharacterList left) {
    this.left = left;
  }
  
  public void setRight(CharacterList right) {
    this.right = right;
  }
  
  public boolean hasLeft() {
    return (this.left != null);
  }
  
  public boolean hasRight() {
    return (this.right != null);
  }
  
  public CharacterList getLeft() {
    return this.left;
  }
  
  public CharacterList getRight() {
    return this.right;
  }
  
  public void setCode(ArrayList<Boolean> code) {
    this.code = code;
  }
  
  public ArrayList<Boolean> getCode() {
    return this.code;
  }
}