import java.io.*;
import java.util.*;
import java.net.*;
import java.nio.file.*;

public class FileReader {
  
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
  
  public static void writeFile(String fileName, String fileContent) throws IOException {
    BufferedWriter bufferedWriter = null;
    try {
      File newFile = new File(Paths.get(fileName).toString());
      if (!newFile.exists()) {
        newFile.createNewFile();
      }
      Writer writer = new FileWriter(newFile);
      bufferedWriter = new BufferedWriter(writer);
      bufferedWriter.write(fileContent);
    } catch (IOException e) {
      e.printStackTrace();
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
    FileReader.writeFile("textWrite.txt", "This is a test.");
  }
}