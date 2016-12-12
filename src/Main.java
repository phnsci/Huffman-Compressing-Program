/**
 * the Main program of the Huffman data compressing program
 */
import java.io.*;
import java.util.*;
import java.net.*;
import java.nio.file.*;

public class Main {
  /**
   * the main function of the main program. It receive a text file as input
   * and output another text file storing the encoded data
   * @param args arguments from command line
   */
  public static void main(String[] args) throws IOException {
    String str = FileReader.readFile("../DemoInput.txt");
    char [] original = str.toCharArray();
    
    // sort the str in alphabet order in store in a 
    // character array named sorted
    char [] sorted = str.toCharArray();
    Arrays.sort(sorted);
    
    // create an array list which stores an array of CharacterList objects 
    ArrayList<CharacterList> list = new ArrayList<CharacterList>();
    
    // create the first CharacaterList object int the array list 
    CharacterList e = new CharacterList(String.valueOf(sorted[0]), 1);
    list.add(e);
    
    CharacterList oldchar = new CharacterList();
    oldchar = e;
    
    // iterate through the new sorted character array
    for (int i = 1; i < sorted.length; i++) {
      // if find new character add it to the array list
      if (sorted[i] != sorted[i -1]) {
        CharacterList newchar = new CharacterList(); 
        newchar.setChar(String.valueOf(sorted[i]));
        newchar.setCount(1);
        oldchar = newchar;
        list.add(newchar);
      }
      // if the character is repeated increase the character counter
      else {
        oldchar.increment();
      }
    }
    
    // sort the arraylist by the frequency of the character in this string
    SortList.sortList(list);
    
    // make a copy of list   
    ArrayList<CharacterList> base = new ArrayList<CharacterList>();
    for (int i = 0; i < list.size(); i++) {
      base.add(list.get(i));
    }
    
    // build the Huffman tree by merging the nodes together
    HuffmanTree.buildTree(list);
    
    // encoding each character
    // the function argument is the top node
    HuffmanTree.enCode(list.get(0));
    
    // create a hash table storing pairs of character and binary representation
    // so we can get binary value out with characters representation
    Hashtable<String, ArrayList<Boolean>> table = new Hashtable<String, ArrayList<Boolean>>();
    for (int i = 0; i < base.size(); i++)
      table.put(base.get(i).getChar(), base.get(i).getCode());
    
		File file = new File("../DemoOutput.txt");
		FileOutputStream fos = new FileOutputStream(file);
		PrintStream ps = new PrintStream(fos);
		System.setOut(ps);

    // ouput to stdout
    // iterate through the character array
    for (int i = 0; i < original.length; i++) {
      // get the binary representation of each characters
      //System.out.println(list.get(original[i]));
      int char_code_size = table.get(String.valueOf(original[i])).size();
      for (int j = 0; j < char_code_size; j++) {
        BinaryStdOut.write(table.get(String.valueOf(original[i])).get(j));
      }
    }
		BinaryStdOut.flush();
	}
}
