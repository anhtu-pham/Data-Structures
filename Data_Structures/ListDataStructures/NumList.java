public interface NumList{
  
  /**
   * Return the number of elements in the list
   */
  int size();
  
  /**
   * Return the number of elements that list can currently store
   */
  int capacity();
  
  /**
   * Add value of input to the end of list
   */
  void add(double value);
  
  /**
   * Insert element before element with index i in the list
   */
  void insert(int i, double value);
  
  /**
   * Remove element with index i from the list
   */
  void remove(int i);
  
  /**
   * Check if the list contains value in input
   */
  boolean contains(double value);
  
  /**
   * Find elements with index i in the list
   */
  double lookup(int i);
  
  /**
   * Check if this list has same elements as elements of otherList
   */
  boolean equals(NumList otherList);
  
  /**
   * Remove all duplicates of elements in the list
   */
  void removeDuplicates();
  
  /**
   * Return the contents of the list in string representation
   */
  String toString();
  
  /**
   * Check if the list is in increasingly sorted order
   */
  boolean isSorted();
  
  /**
   * Reverse the list's elements
   */
  void reverse();
  
  /**
   * Create a new NumList which is a union of list1 and list2 in input and does not have any duplicates
   */
  NumList union(NumList list1, NumList list2);
}