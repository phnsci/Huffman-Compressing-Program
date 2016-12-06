import java.util.*;
import java.util.Arrays;

public class SortCharacterList {
  
  public static List<CharacterList> sortList(List<CharacterList> a) {
    CharacterList[] cl = a.toArray(new CharacterList[a.size()]);
    quicksort(cl);
    List<CharacterList> sortedList = new ArrayList<CharacterList>();
    for(int i = 0; i < cl.length; i++) {
      sortedList.add(cl[i]);
    }
    return sortedList;
  }
  
  private static void quicksort(CharacterList[] a) {
    quicksort(a, 0, a.length - 1);
  }
  
  private static void quicksort(CharacterList[] a, int left, int right) {
    if (left < right) {
      int pivotIndex = partition(a, left, right);
      quicksort(a, left, pivotIndex);
      quicksort(a, pivotIndex + 1, right);
    }
  }
  
  private static void swap(CharacterList[] a, int i, int j) {
    int temp = a[i].getCount();
    a[i].setCount(a[j].getCount());
    a[j].setCount(temp);
  }
  
  private static int partition(CharacterList[] a, int left, int right) {
    //printArray(a, left, right);
    Integer pivotValue = a[left].getCount();
    int i = left; // index going from left to right
    int j = right; // index going from right to left
    while (i < j) {
      /**
       * In each iteration, we will identify a number from left side which
       * is greater then the pivot value, and also we will identify a number
       * from right side which is less then the pivot value. Once the search
       * is done, then we exchange both numbers.
       */
      while (i < a.length && a[i].getCount() <= pivotValue)
        i++;
      while (a[j].getCount() > pivotValue)
        j--;
      if (i < j)
        swap(a, i, j);
    }
    swap(a, left, j);
    //printArray(a, left, right);
    return j; // a[j] = end of left array
  }
  
  public static void main(String[] args) {
    List<CharacterList> list = new ArrayList<CharacterList>();
    list.add(new CharacterList('a', 2));
    list.add(new CharacterList('b', 4));
    list.add(new CharacterList('c', 1));
    list.add(new CharacterList('d', 6));
    System.out.println("Before sort:");
    for (int i = 0; i < list.size(); i++) {
      System.out.println("i: " + i + " " + "Character: " + list.get(i).getChar() + "  Occurence: " + list.get(i).getCount());
    }
    System.out.println("After sort:");
    List<CharacterList> sortedList = sortList(list);
    for (int i = 0; i < list.size(); i++) {
      System.out.println("i: " + i + " " + "Character: " + sortedList.get(i).getChar() + "  Occurence: " + sortedList.get(i).getCount());
    }
  }
  
  
  
  
  
}