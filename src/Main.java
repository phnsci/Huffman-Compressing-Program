import java.io.*;
import java.util.*;
import java.net.*;
import java.nio.file.*;

public class Main {
  public static void main(String[] args) throws IOException {
  	
		String str = FileReader.readFile(args[0]);
    char [] original = str.toCharArray();
    
    // create a sorted character array, going through alphabet order 
    char [] sorted = str.toCharArray();
    Arrays.sort(sorted);
    
    // an array list which stores an array of CharacterList objects 
    List<CharacterList> list = new ArrayList<CharacterList>();
    
    // create the first CharacaterList object int the array list 
    CharacterList e = new CharacterList(sorted[0], 1);
    list.add(e);
   
    CharacterList oldchar = new CharacterList();
    oldchar = e;

    // iterate through the new sorted character array
    for (int i = 1; i < sorted.length; i++) {
      // if find new character 
      if (sorted[i] != sorted[i -1]) {
        CharacterList newchar = new CharacterList(); 
        newchar.setChar(sorted[i]);
        newchar.setCount(1);
        oldchar = newchar;
        list.add(newchar);
      }
      // if the character is repeated 
      else {
        oldchar.increment();
      }
    }
    
    for (int i = 0; i < list.size(); i++) {
      System.out.println("i: " + i +   "Character: " + list.get(i).getChar() + "  Occurence: " + list.get(i).getCount());
    }
  }
}

