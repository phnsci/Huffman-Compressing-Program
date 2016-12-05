import java.util.*;
import java.util.Arrays;

public class CharacterList {
  
  private char value;
  private int count = 0;

  public CharacterList() {
  }
  
  
  public CharacterList(char v, int c) {
    this.value = v;
    this.count = c;
  }
  
  public void increment() {
    this.count++;
  }
  
  public char getChar() {
    return this.value;
  }
  
  public int getCount() {
    return this.count;
  }
  
  public void setChar(char ch) {
    this.value = ch;
  }
  
  public void setCount(int count) {
    this.count = count;
  }
  
  public static void main(String [] args) {
    String str = "abbcccctttayyyzz";
    char [] original = str.toCharArray();
    
    /* create a sorted character array, going through alphabet order */
    char [] sorted = str.toCharArray();
    Arrays.sort(sorted);
    
    /* an array list which stores an array of CharacterList objects */
    List<CharacterList> list = new ArrayList<CharacterList>();
    
    /* create the first CharacaterList object int the array list */
    CharacterList e = new CharacterList(sorted[0], 1);
    list.add(e);
    
    CharacterList oldchar = new CharacterList();
    
    oldchar = e;
    System.out.println(sorted);
    
    /* iterate through the new sorted character array*/
    for (int i = 1; i < sorted.length; i++) {
      /* if find new character */
      if (sorted[i] != sorted[i -1]) {
        CharacterList newchar = new CharacterList(); 
        newchar.setChar(sorted[i]);
        newchar.setCount(1);
        oldchar = newchar;
        list.add(newchar);
      }
      /* if the character is repeated */
      else {
        oldchar.increment();
      }
    }
    
    for (int i = 0; i < list.size(); i++) {
      System.out.println("i: " + i +   "Character: " + list.get(i).getChar() + "  Occurence: " + list.get(i).getCount());
    }
  }
}

