import java.util.*;
import java.util.Arrays;

public class SortList {
  
  /**
   * Converts a CharacterList List to a CharacterList array, calls the quicksort method on it, and returns the values
   * to the list in reverse order.
   * @param a the list of CharacterLists to be sorted
   */
  public static void sortList(List<CharacterList> a) {
    CharacterList[] cl = a.toArray(new CharacterList[a.size()]);
    quicksort(cl);
    for(int i = 0; i < cl.length; i++) {
      a.set(i, cl[(cl.length - 1) - i]);
    }
  }
  
  /**
   * Calls quicksort on the CharacterList array. Note: this quicksort method is a modified version of the one given in
   * the textbook, made to work with CharacterLists rather than Integers.
   * @param a the array of CharacterLists derived from the sortList function
   */
  private static void quicksort(CharacterList[] a) {
    quicksort(a, 0, a.length - 1);
  }
  
  /**
   * Recursively calls quicksort with a new pivot.
   * @param a the array of CharacterLists to be sorted
   * @left the leftmost value to be sorted
   * @right the rightmost value to be sorted
   */
  private static void quicksort(CharacterList[] a, int left, int right) {
    if (left < right) {
      int pivotIndex = partition(a, left, right);
      quicksort(a, left, pivotIndex);
      quicksort(a, pivotIndex + 1, right);
    }
  }
  
  /**
   * Swaps two objects in the CharacterList array.
   * @param a the CharacterList array containing the objects to be swapped
   * @param i the first CharacterList in the swap
   * @param j the second CharacterList to be swapped with the first
   */
  private static void swap(CharacterList[] a, int i, int j) {
    CharacterList temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
  
  /**
   * Partitions through the array given by the call from quicksort.
   * @param a the CharacterList array to be partitioned through
   * @param left the leftmost value in the partition, also used as the pivot
   * @param right the rightmost value in the partition
   */
  private static int partition(CharacterList[] a, int left, int right) {
    Integer pivotValue = a[left].getCount();
    CharacterList pivot = a[left];
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
      while (a[j].getCount() >= pivotValue && a[j] != pivot)
        j--;
      if (i < j)
        swap(a, i, j);
    }
    swap(a, left, j);
    return j; // a[j] = end of left array
  }
  
  public static void main(String[] args) {
    List<CharacterList> list = new ArrayList<CharacterList>();
    list.add(new CharacterList('a', 1));
    list.add(new CharacterList('b', 2));
    list.add(new CharacterList('c', 1));
    list.add(new CharacterList('d', 1));
    System.out.println("Before sort:");
    for (int i = 0; i < list.size(); i++) {
      System.out.println("i: " + i + " " + "Character: " + list.get(i).getChar() + "  Occurence: " + list.get(i).getCount());
    }
    System.out.println("After sort:");
    sortList(list);
    for (int i = 0; i < list.size(); i++) {
      System.out.println("i: " + i + " " + "Character: " + list.get(i).getChar() + "  Occurence: " + list.get(i).getCount());
    }
  }
  
  
  
  
  
}