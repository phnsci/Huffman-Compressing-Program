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
  
  
  private String value;         // the character will store in this object
  private int count;          // the counter of the above character in the string
  CharacterList left;         // left node
  CharacterList right;        // right node 
  ArrayList<Boolean> code;    // Huffman code for this node
  
 /**
  * class constructor 
  */
  public CharacterList() {
    this.value = "0";
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
  public CharacterList(String v, int c) {
    this.value = v;
    this.count = c;
    this.left = null;
    this.right = null;
    this.code = new ArrayList<Boolean>();
  }
 
 /**
  * increase the counter of the character stored
  * in this object by one
  */
  public void increment() {
    this.count++;
  }
 
 /**
  * get the character stored inside this object
  * @return the character stored in this object
  */
  public String getChar() {
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
   */
  public void setChar(String ch) {
    this.value = ch;
  }
  
  public void appendChar(char c) {
	  this.value += c;
  }
  
  /**
   * set the counter of the character stored in this object
   * @param count the counter of the character in this object
   */
  public void setCount(int count) {
    this.count = count;
  }
  
  /**
   * setup the left node
   * @param left the value of the left node
   */
  public void setLeft(CharacterList left) {
    this.left = left;
  }
  
  /**
   * setup the right node
   * @param right the value of the right node
   */
  public void setRight(CharacterList right) {
    this.right = right;
  }
  
  /**
   * check if this node has left node
   * @return true if it has left node
   */
  public boolean hasLeft() {
    return (this.left != null);
  }
  
  /**
   * check if this node has right node
   * @return true if it has right node
   */
  public boolean hasRight() {
    return (this.right != null);
  }
  
  /**
   * get the left node of this node
   * @return the left node of this node 
   */
  public CharacterList getLeft() {
    return this.left;
  }
  
  /**
   * get the right node of this node
   * @return the right node of this node
   */
  public CharacterList getRight() {
    return this.right;
  }
  
  /**
   * set the Huffman code value of this node
   * @param code the desired code we want to setup
   */
  public void setCode(ArrayList<Boolean> code) {
    this.code = code;
  }
  
  /**
   * get the Huffman code of this node
   * @return the Huffman code of this node
   */
  public ArrayList<Boolean> getCode() {
    return this.code;
  }
  
  public void printChild() {
	  System.out.println("_____________");
	  if (this.hasLeft())
		  System.out.println("left: " + this.getLeft().getCount());
	  if (this.hasRight())
		  System.out.println("right: " + this.getRight().getCount());
  }
}