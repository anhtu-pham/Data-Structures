public class NumArrayList implements NumList{
  
  // array that stores data for NumArrayList list
  private double[] array = null;
  
  // size that stores number of elements in the list
  private int size = 0;
  
  // isIncreasinglySorted stores value indicating whether the list has increasing sorted order or not
  private boolean isIncreasinglySorted = true;
  
  /**
   * Initialize array with default initial capacity of 10
   * Time complexity: O(1)
   */
  public NumArrayList(){
    array = new double[10];
  }
  
  /**
   * Initialize array with initial capacity, throw exception if capacity is negative
   * Time complexity: O(1)
   */
  public NumArrayList(int capacity){
    // Time complexity: O(1)
    if(capacity >= 0){
      array = new double[capacity];
    }
    // Time complexity: O(1)
    else{
      throw new IllegalArgumentException();
    }
  }
  
  /**
   * Return the number of elements in the list (number of elements that array currently stores)
   * Time complexity: O(1)
   */
  public int size(){
    return size;
  }
  
  /**
   * Return the number of elements that array can currently store
   * Time complexity: O(1)
   */
  public int capacity(){
    return array.length;
  }
  
  /**
   * Add value of input to the end of list
   * Time complexity: O(n) (n is the list's size)
   */
  public void add(double value){
    // If list's size is smaller than list's capacity, just add value after list's currently last element
    // Time complexity: O(1)
    if(size() < capacity()){
      array[size()] = value;
    }
    // Otherwise, create newArray with larger capacity, copy elements from array to newArray, add value after list's currently last element in newArray,then assign newArray to array
    // Time complexity: O(n) (n is the list's size)
    else{
      double[] newArray = new double[capacity() + 10];
      for(int i = 0; i < capacity(); i = i + 1){
        newArray[i] = array[i];
      }
      newArray[capacity()] = value;
      array = newArray;
    }
    // After adding 1 element to the list, list's size must be increased by 1
    size = size() + 1;
    // If list's size is higher than 1 and added element is smaller than its previous element, set isIncreasinglySorted as false
    if(size() > 1 && array[size() - 2] > array[size() - 1]){
      isIncreasinglySorted = false;
    }
  }
  
  /**
   * Insert element before element with index i in the list
   * Time complexity: O(n) (n is the list's size)
   */
  public void insert(int i, double value){
    // Check if i is non-negative
    if(i >= 0){
      // Use add method if the list has i or fewer elements
      // Time complexity: O(n) (n is the list's size)
      if(i >= size()){
        add(value);
      }
      else{
        // If list's size is smaller than list's capacity, shift all elements from element currently with index i to the right; new elemeent with index i is value from input
        // Time complexity: O(n) (n is the list's size)
        if(size() < capacity()){
          for(int j = size() - 1; j >= i; j = j - 1){
            array[j + 1] = array[j];
          }
          array[i] = value;
        }
        // Otherwise, create newArray with larger capacity with same elements from index 0 to index (i - 1), elements with index i to list's end shifted to the right, new elemeent with index i being value from input, then assign newArray to array
        // Time complexity: O(n) (n is the list's size)
        else{
          double[] newArray = new double[capacity() + 10];
          for(int j = 0; j <= capacity(); j = j + 1){
            if(j < i){
              newArray[j] = array[j];
            }
            else if(j > i){
              newArray[j] = array[j - 1];
            }
            else{
              newArray[j] = value;
            }
          }
          array = newArray;
        }
        // After inserting 1 element in the list, list's size must be increased by 1
        size = size() + 1;
        // If i is 0, if inserted element is higher than its next element, set isIncreasinglySorted as false
        if(i == 0){
          if(array[i] > array[i + 1]){
            isIncreasinglySorted = false;
          }
        }
        // If i positive, if inserted element is smaller than its previous element or higher than its next element, set isIncreasinglySorted as false
        else{
          if(array[i - 1] > array[i] || array[i] > array[i + 1]){
            isIncreasinglySorted = false;
          }
        }
      }
    }
  }
  
  /**
   * Remove element with index i from the list
   * Time complexity: O(n) (n is the list's size)
   */
  public void remove(int i){
    // If i is smaller than list's size and non-negative, shift all elements after element with index i to the left
    // Time complexity: O(n) (n is the list's size)
    if(i >= 0 && i < size()){
      for(int j = i; j < (size() - 1); j = j + 1){
        array[j] = array[j + 1];
      }
      array[size() - 1] = 0.0;
      // After removing 1 element from the list, list's size must be decreased by 1
      size = size() - 1;
      // Check if the list is in increasing sorted order and assign the checking result to isIncreasinglySorted
      isIncreasinglySorted = checkWhetherSorted();
    }
    // If i is higher than or equal to list's size, do nothing, so time complexity for this case is O(1)
  }
  
  /**
   * Check if the list contains value in input
   * Time complexity: O(n) (n is the list's size)
   */
  public boolean contains(double value){
    // If an element in the list is equal to input value, the list contains input value, so return true
    for(int i = 0; i < size(); i = i + 1){
      if(value == array[i]){
        return true;
      }
    }
    // After iterating through the list and no elements in the list are equal to input value, the list does not contain input value, so return false
    return false;
  }
  
  /**
   * Find elements with index i in the list
   * Time complexity: O(1)
   */
  public double lookup(int i){
    // If i is smaller than list's size and non-negative, required element is element with index i of array; do nothing if i is equal to or higher than list's size
    // Time complexity: O(1)
    if(i < size() && i >= 0){
      return array[i];
    }
    // Otherwise, throw IndexOutOfBoundsException exception
    // Time complexity: O(1)
    else{
      throw new IndexOutOfBoundsException();
    }
  }
  
  /**
   * Check if this list has same elements as elements of otherList
   * If otherList is in NumArrayList, time complexity: O(n) (n is the list's size)
   * If otherList is in NumLinkedList, Time complexity: O(n^2) (n is the list's size)
   * If otherList is null or lists' sizes are not equal, time complexity: O(1)
   */
  public boolean equals(NumList otherList){
    // Check if otherList is not null and list's size is equal to size of otherList; return false if at least one of these conditions fails
    // If otherList is in NumArrayList, time complexity: O(n) (n is the list's size)
    // If otherList is in NumLinkedList, Time complexity: O(n^2) (n is the list's size)
    if(otherList != null && size() == otherList.size()){
      // Compare each pair of elements having same indices; return false if pair's elements are not equal to each other; return true after perceiving that all pairs' elements are equal to each other
      for(int i = 0; i < size(); i = i + 1){
        if(lookup(i) != otherList.lookup(i)){
          return false;
        }
      }
      return true;
    }
    // If otherList is null or lists' sizes are not equal, return false
    // Time complexity: O(1)
    else{
      return false;
    }
  }
  
  /**
   * Remove all duplicates of elements in the list
   * Time complexity: O(n^2) (n is the list's size)
   */
  public void removeDuplicates(){
    // removed is used to check if examined element has been removed when iterating through the list
    boolean removed = false;
    // Iterate through the list
    for(int i = 0; i < size(); i = i + 1){
      // In each iteration, set removed to false, then remove examined element only if it is equal to at least one of its left elements and examined element has not been removed (remove the duplicate); removed is set to true after removing
      removed = false;
      for(int j = 0; j < i; j = j + 1){
        if(array[i] == array[j] && !removed){
          remove(i);
          removed = true;
        }
      }
      // After removing the duplicate, elements after removed element are shift to the left, so i needs to be decreased by 1 to contine with the next element after it is shifted
      if(removed){
        i = i - 1;
      }
    }
  }
  
  /**
   * Return the contents of the list in string representation
   * Time complexity: O(n) (n is the list's size)
   */
  public String toString(){
    // If list is not empty, append elements to variable builder of StringBuilder type, append spaces where necessary, return builder's string representation
    // Time complexity: O(n) (n is the list's size)
    if(size() > 0){
      StringBuilder builder = new StringBuilder();
      for(int i = 0; i < size() - 1; i = i + 1){
        builder.append(array[i] + " ");
      }
      builder.append(array[size() - 1]);
      return builder.toString();
    }
    // If list is empty, just return ""
    // Time complexity: O(1)
    else{
      return "";
    }
  }
  
  /**
   * Check if the list is in increasing sorted order
   * Time complexity: O(1)
   */
  public boolean isSorted(){
    return isIncreasinglySorted;
  }
  
  /**
   * Check if the list is in increasing sorted order after removing element
   * Time complexity: O(n) (n is the list's size)
   */
  private boolean checkWhetherSorted(){
    // Iterate through the list; in each iteration, if the examined element is smaller than or equal to its previous element, return false
    for(int i = 1; i < size(); i = i + 1){
      if(array[i] < array[i - 1]){
        return false;
      }
    }
    // If list's size is smaller than 2 or all examined elements are higher than their previous elements, return true
    // If list's size is smaller than 2, time complexity is O(1)
    return true;
  }
  
  /**
   * Reverse the list's elements
   * Time complexity: O(n) (n is the list's size)
   */
  public void reverse(){
    // Use a loop with integer i going from 0 to the highest integer that is lower than size() / 2
    for(int i = 0; i < (size() / 2); i = i + 1){
      // Swap element with index i with element with index (size() - 1 - i) in each iteration in the loop
      double savedNumber = array[i];
      array[i] = array[size() - 1 - i];
      array[size() - 1 - i] = savedNumber;
    }
    // Check if the list is in increasing sorted order and assign the checking result to isIncreasinglySorted
    isIncreasinglySorted = checkWhetherSorted();
  }
  
  /**
   * Create a new NumList which is a union of list1 and list2 in input and does not have any duplicates
   */
  public NumList union(NumList list1, NumList list2){
    // In large case when list1 and list2 have increasingly sorted orders
    // In this case, when each of all lookup methods takes O(1), this case's time complexity is O(m + n) (m is list1's size and n is list2's size)
    if(list1.isSorted() && list2.isSorted()){
      // newList stores the union of list1 and list2
      NumList newList = new NumArrayList(list1.size() + list2.size());
      // indexList1 stores examined index of list1
      int indexList1 = 0;
      // indexList2 stores examined index of list2
      int indexList2 = 0;
      // In case when list1's size is 0
      if(list1.size() == 0){
        // If list2's size is not 0, add list2's first element to newList and increase indexList2 by 1
        if(list2.size() > 0){
          newList.add(list2.lookup(indexList2));
          indexList2 = indexList2 + 1;
        }
      }
      // In case when list1's size is not 0, if list2's size is 0, add list1's first element to newList, increase indexList1 by 1
      else if(list2.size() == 0){
        newList.add(list1.lookup(indexList1));
        indexList1 = indexList1 + 1;
      }
      // In case when list1's size and list2's size are both positive
      else{
        // If element with indexList1 index in list1 is smaller than element with indexList2 in list2, add that of list1 to newList and continue with next element of smaller element
        if(list1.lookup(indexList1) < list2.lookup(indexList2)){
          newList.add(list1.lookup(indexList1));
          indexList1 = indexList1 + 1;
        }
        // If element with indexList1 index in list1 is higher than element with indexList2 in list2, add that of list2 to newList and continue with next element of smaller element
        else if(list1.lookup(indexList1) > list2.lookup(indexList2)){
          newList.add(list2.lookup(indexList2));
          indexList2 = indexList2 + 1;
        }
        // If element with indexList1 index in list1 is equal to element with indexList2 in list2, add that of list1 to newList and continue with next elements in both lists
        else{
          newList.add(list1.lookup(indexList1));
          indexList1 = indexList1 + 1;
          indexList2 = indexList2 + 1;
        }
      }
      // Iterate until reaching at least one of two lists' ends
      while(indexList1 < list1.size() && indexList2 < list2.size()){
        /**
         * If element with indexList1 index in list1 is smaller than element with indexList2 in list2, and if that of list1 is not equal to newList's current last element
         * add that of list1 to newList and continue with larger element and next element of smaller element
         */
        if(list1.lookup(indexList1) < list2.lookup(indexList2)){
          if(list1.lookup(indexList1) != newList.lookup(newList.size() - 1)){
            newList.add(list1.lookup(indexList1));
          }
          indexList1 = indexList1 + 1;
        }
        /**
         * If element with indexList1 index in list1 is higher than element with indexList2 in list2, and if that of list2 is not equal to newList's current last element
         * add that of list2 to newList and continue with larger element and next element of smaller element
         */
        else if(list1.lookup(indexList1) > list2.lookup(indexList2)){
          if(list2.lookup(indexList2) != newList.lookup(newList.size() - 1)){
            newList.add(list2.lookup(indexList2));
          }
          indexList2 = indexList2 + 1;
        }
        // If element with indexList1 index in list1 is equal to element with indexList2 in list2, add that of list1 to newList and continue with next elements in both lists
        else{
          if(list1.lookup(indexList1) != newList.lookup(newList.size() - 1)){
            newList.add(list1.lookup(indexList1));
          }
          indexList1 = indexList1 + 1;
          indexList2 = indexList2 + 1;
        }
      }
      // If an element of list1's remaining is higher than newList's current last element, add that element of list1's remaining to newList and continue with next element of list1's remaining
      while(indexList1 < list1.size()){
        if(list1.lookup(indexList1) > newList.lookup(newList.size() - 1)){
          newList.add(list1.lookup(indexList1));
        }
        indexList1 = indexList1 + 1;
      }
      // If an element of list2's remaining is higher than newList's current last element, add that element of list2's remaining to newList and continue with next element of list2's remaining
      while(indexList2 < list2.size()){
        if(list2.lookup(indexList2) > newList.lookup(newList.size() - 1)){
          newList.add(list2.lookup(indexList2));
        }
        indexList2 = indexList2 + 1;
      }
      return newList;
    }
    // Time complexity: O((m + n)^2) (m is list1's size and n is list2's size)
    else{
      // newList stores the union of list1 and list2
      NumList newList = new NumLinkedList();
      // insert each of elements from the end to beginning of list2 to newList's beginning
      for(int i = list2.size() - 1; i >= 0; i = i - 1){
        newList.insert(0, list2.lookup(i));
      }
      // insert each of elements from the end to beginning of list1 to newList's beginning
      for(int j = list1.size() - 1; j >= 0; j = j - 1){
        newList.insert(0, list1.lookup(j));
      }
      newList.removeDuplicates();
      return newList;
    }
  }
}