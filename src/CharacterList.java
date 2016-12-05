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
}

