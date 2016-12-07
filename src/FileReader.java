import java.io.*;
import java.util.*;
import java.net.*;
import java.nio.file.*;

public class FileReader {
  
  /**
   * Takes a .txt file name as a string, and reads the contents of that file to a string. Note: the file to be read must
   * be in your current working directory, and the name given must include the ".txt". Additionally, no file greater
   * than 2GB can be read (according to the Java API).
   * @param fileName the name of the file being read
   * @return the string contained in the file
   */
  public static String readFile(String fileName) throws IOException {
    String fileText = " ";
    try {
      fileText = new String(Files.readAllBytes(Paths.get(fileName)));
      return fileText;
    }
    catch(NoSuchFileException e) {
      System.out.println("No such file.");
    }
    
    return fileText;
    
  }
  
  /**
   * Writes a string onto a .txt file. Will use an exisiting file if one of that name exists, otherwise a file of that
   * name will be created. Note: this method modifies files in the current working directory.
   * @param fileName the name of the file to be written to
   * @param fileContent the string to be written to the file
   */
  public static void writeFile(String fileName, String fileContent) throws IOException {
    BufferedWriter bufferedWriter = null;
    try {
      File newFile = new File(Paths.get(fileName).toString() + ".txt");
      if (!newFile.exists()) {
        newFile.createNewFile();
      }
      Writer writer = new FileWriter(newFile);
      bufferedWriter = new BufferedWriter(writer);
      bufferedWriter.write(fileContent);
    } catch (IOException e) {
    }
    finally {
      try{
        if(bufferedWriter != null) bufferedWriter.close();
      } 
      catch(Exception ex) { 
      }
    }
  }
  
  public static void main(String[] args) throws IOException {
    System.out.println(FileReader.readFile("Text.txt"));
    FileReader.writeFile("textWrite", "This is a test.");
  }
}