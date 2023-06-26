public class NumLinkedList implements NumList {

  // size that stores number of elements in the list
  private int size = 0;

  // firstNode stores the address of list's first node
  private LLNode firstNode;

  // isIncreasinglySorted stores value indicating whether the list has increasing
  // sorted order or not
  private boolean isIncreasinglySorted = true;

  /**
   * Initialize firstNode as null
   * Time complexity: 0(1)
   */
  public NumLinkedList() {
    this.firstNode = null;
  }

  /**
   * Return the number of elements in the list
   * Time complexity: 0(1)
   */
  public int size() {
    return this.size;
  }

  /**
   * Return the first node of the list
   * Time complexity: 0(1)
   */
  private LLNode getFirstNode() {
    return this.firstNode;
  }

  /**
   * Return the number of elements that list can currently store
   * Time complexity: 0(1)
   */
  public int capacity() {
    return Integer.MAX_VALUE;
  }

  /**
   * Add value of input to the end of list
   * Time complexity: O(n) (n is the list's size)
   */
  public void add(double value) {
    // When list does not have any elements, set list's first node as a new LLNode
    // with its element being input value and its next node being null
    // Time complexity: O(1)
    if (getFirstNode() == null) {
      firstNode = new LLNode(value, null);
    }
    /**
     * When list has at least 1 element, create LLNode pointer pointing at list's
     * first node,
     * move pointer until it points list's last node, set next node of list's last
     * node as new LLNode with its element being input value and its next node being
     * null
     * Time complexity: O(n) (n is the list's size)
     */
    else {
      LLNode pointer = getFirstNode();
      while (pointer.getNext() != null) {
        pointer = pointer.getNext();
      }
      pointer.setNext(new LLNode(value, null));
      // If added element is smaller than its previous element, set
      // isIncreasinglySorted as false
      if (pointer.getElement() > pointer.getNext().getElement()) {
        isIncreasinglySorted = false;
      }
    }
    // After adding 1 element to the list, list's size must be increased by 1
    size = size() + 1;
  }

  /**
   * Insert element before element with index i in the list
   * Time complexity: O(n) (n is the list's size)
   */
  public void insert(int i, double value) {
    if (i >= 0) {
      // If i is higher than or equal to list's size, use add(double value) method to
      // add the input value to the list's end
      // Time complexity: O(n) (n is the list's size)
      if (i >= size()) {
        add(value);
      } else {
        // If i is zero and smaller than list's size, the list's first node is set as a
        // new node having input value and having its next node being the previously
        // first node of the list
        // Time complexity: O(1)
        if (i == 0) {
          firstNode = new LLNode(value, getFirstNode());
          // If inserted element is higher than its next element, set isIncreasinglySorted
          // as false
          if (getFirstNode().getElement() > getFirstNode().getNext().getElement()) {
            isIncreasinglySorted = false;
          }
        }
        /**
         * If i is positive and smaller than list's size, use LLNode pointer to go to
         * the node having index (i - 1),
         * add the node with input value before the node currently having element with
         * index i and after the node having element with index (i - 1);
         * therefore, the input value becomes the element with index i
         * Time complexity: O(n) (n is the list's size)
         */
        else {
          LLNode pointer = getFirstNode();
          for (int j = 0; j < (i - 1); j = j + 1) {
            pointer = pointer.getNext();
          }
          LLNode insertedNode = new LLNode(value, pointer.getNext());
          pointer.setNext(insertedNode);
          // If inserted element is smaller than its previous element or higher than its
          // next element, set isIncreasinglySorted as false
          if (pointer.getElement() > insertedNode.getElement()
              || insertedNode.getElement() > insertedNode.getNext().getElement()) {
            isIncreasinglySorted = false;
          }
        }
        // After inserting 1 element in the list, list's size must be increased by 1
        size = size() + 1;
      }
    }
  }

  /**
   * Remove element with index i from the list
   * Time complexity: O(n) (n is the list's size)
   */
  public void remove(int i) {
    if (i >= 0 && i < size()) {
      // If i is zero and smaller than list's size, the list's first node is set as
      // the next node of the previously first node of the list
      // Time complexity: O(1)
      if (i == 0) {
        firstNode = getFirstNode().getNext();
      }
      /**
       * If i is positive and smaller than list's size, use LLNode pointer to go to
       * the node having index (i - 1),
       * create LLNode newNextNode that points to node having index (i + 1),
       * set the next node of the node that has index i as null, and set the next node
       * of the node having index (i - 1) as newNextNode
       * Time complexity: O(n) (n is the list's size)
       */
      else {
        LLNode pointer = getFirstNode();
        for (int j = 0; j < (i - 1); j = j + 1) {
          pointer = pointer.getNext();
        }
        LLNode newNextNode = pointer.getNext().getNext();
        pointer.getNext().setNext(null);
        pointer.setNext(newNextNode);
      }
      // After removing 1 element from the list, list's size must be decreased by 1
      size = size() - 1;
      // Check if the list is in increasing sorted order and assign the checking
      // result to isIncreasinglySorted
      isIncreasinglySorted = checkWhetherSorted();
    }
  }

  /**
   * Check if the list contains value in input
   * Time complexity: O(n) (n is the list's size)
   */
  public boolean contains(double value) {
    // When list is not empty, create LLNode pointer and move it until it points at
    // node having input value and return true or until pointer is null
    if (getFirstNode() != null) {
      LLNode pointer = getFirstNode();
      while (pointer != null) {
        if (pointer.getElement() == value) {
          return true;
        }
        pointer = pointer.getNext();
      }
    }
    // When the list does not contain input value (when pointer is null after while
    // loop), return false
    // When the list is empty, just return false, so time complexity for this case
    // is O(1)
    return false;
  }

  /**
   * Find elements with index i in the list
   * Time complexity: O(n) (n is the list's size)
   */
  public double lookup(int i) {
    /**
     * If i is smaller than list's size and non-negative, create LLNode pointer
     * pointing at list's first node,
     * move the pointer until it points at the node having input index, return
     * element of that node
     * Time complexity: O(n) (n is the list's size)
     */
    if (i < size() && i >= 0) {
      LLNode pointer = getFirstNode();
      for (int j = 0; j < i; j = j + 1) {
        pointer = pointer.getNext();
      }
      return pointer.getElement();
    }
    // If i is higher than or equal to list's size or i is negative, throw
    // IndexOutOfBoundsException exception
    // Time complexity: O(1)
    else {
      throw new IndexOutOfBoundsException();
    }
  }

  /**
   * Check if this list has same elements as elements of otherList
   * Time complexity: O(n^2) (n is the list's size) (lookup(int i) of
   * NumLinkedList has time complexity of O(n))
   * If otherList is null or lists' sizes are not equal, time complexity: O(1)
   */
  public boolean equals(NumList otherList) {
    // Time complexity: O(n^2) (n is the list's size) (lookup(int i) of
    // NumLinkedList has time complexity of O(n))
    // If otherList is not null and lists' sizes are equal, lists' elements are
    // compared in pairs and return false if elements in a pair are not equal
    if (otherList != null && this.size() == otherList.size()) {
      for (int i = 0; i < this.size(); i = i + 1) {
        if (this.lookup(i) != otherList.lookup(i)) {
          return false;
        }
      }
      // When elements are equal in each of all pairs or lists' sizes are both 0,
      // return true
      return true;
    }
    // If otherList is null or lists' sizes are not equal, return false
    // Time complexity: O(1)
    else {
      return false;
    }
  }

  /**
   * Remove all duplicates of elements in the list
   * Time complexity: O(n^2) (n is the list's size)
   */
  public void removeDuplicates() {
    /**
     * In case list's size is higher than 1, create LLNode lastPointer and set it as
     * list's first node and make it go through the list by using the loop;
     * in each iteration, create LLNode pointer and set it as lastPointer, make it
     * go through the list, and remove its next node if its next node's element is
     * equal to lastPointer's element
     * Time complexity: O(n^2) (n is the list's size)
     */
    if (size() > 1) {
      LLNode lastPointer = getFirstNode();
      while (lastPointer != null) {
        LLNode pointer = lastPointer;
        while (pointer.getNext() != null) {
          if (pointer.getNext().getElement() == lastPointer.getElement()) {
            LLNode newNextNode = pointer.getNext().getNext();
            pointer.setNext(newNextNode);
            size = size() - 1;
          } else {
            pointer = pointer.getNext();
          }
        }
        lastPointer = lastPointer.getNext();
      }
      // Check if the list is in increasing sorted order and assign the checking
      // result to isIncreasinglySorted
      isIncreasinglySorted = checkWhetherSorted();
    }
    // If list's size is not higher than 1, do nothing, so time complexity for this
    // case is O(1)
  }

  /**
   * Return the contents of the list in string representation
   * Time complexity: O(n) (n is the list's size)
   */
  public String toString() {
    // When list's size is positive, use StringBuilder variable to append when going
    // through the list by a LLNode pointer, and return string representation of
    // that StringBuilder variable
    // Time complexity: O(n) (n is the list's size)
    if (size() > 0) {
      StringBuilder builder = new StringBuilder();
      LLNode pointer = getFirstNode();
      while (pointer.getNext() != null) {
        builder.append(pointer.getElement() + " ");
        pointer = pointer.getNext();
      }
      builder.append(pointer.getElement());
      return builder.toString();
    }
    // If list is empty (list's size is 0), just return ""
    // Time complexity: O(1)
    else {
      return "";
    }
  }

  /**
   * Check if the list is in increasing sorted order
   * Time complexity: O(1)
   */
  public boolean isSorted() {
    return isIncreasinglySorted;
  }

  /**
   * Check if the list is in increasing sorted order after removing element
   * Time complexity: O(n) (n is the list's size)
   */
  private boolean checkWhetherSorted() {
    // In case list's size is positive, use LLNode pointer to go through the list;
    // if pointer's element is higher than or equal to pointer's next node's
    // element, return false; otherwise, return true
    // Time complexity: O(n) (n is the list's size)
    if (size() > 1) {
      LLNode pointer = getFirstNode();
      while (pointer.getNext() != null) {
        if (pointer.getElement() > pointer.getNext().getElement()) {
          return false;
        }
        pointer = pointer.getNext();
      }
    }
    // If finishing the while loop without returning false, list is increasing
    // sorted order, so return true
    // If list's size not higher than 0, just return true, and time complexity for
    // this case is O(1)
    return true;
  }

  /**
   * Help reverse() method in reversing the list's elements
   * This method repeats calling itself with input being next node of last input
   * until next node of input is null;
   * in each time, firstNode is set to its next node before another call, set next
   * node of input's next node as input and set input's next node as null after
   * that call
   * Time complexity: O(n) (n is the list's size)
   */
  private void recurReverse(LLNode node) {
    if (node.getNext() != null) {
      firstNode = node.getNext();
      recurReverse(node.getNext());
      node.getNext().setNext(node);
      node.setNext(null);
    }
  }

  /**
   * Reverse the list's elements
   * Time complexity: O(n) (n is the list's size)
   */
  public void reverse() {
    /**
     * Call recurReverse(LLNode node) with input being the list's current first node
     * Time complexity: O(n) (n is the list's size)
     */
    if (size() > 1) {
      recurReverse(getFirstNode());
      // Check if the list is in increasing sorted order and assign the checking
      // result to isIncreasinglySorted
      isIncreasinglySorted = checkWhetherSorted();
    }
    // If list's size is not higher than 1, do nothing, so time complexity for this
    // case is O(1)
  }

  /**
   * Create a new NumList which is a union of list1 and list2 in input and does
   * not have any duplicates
   * Time complexity is based on cases
   */
  public NumList union(NumList list1, NumList list2) {
    // In large case when list1 and list2 have increasingly sorted orders
    // In this case, when each of all lookup methods takes O(1), this case's time
    // complexity is O(m + n) (m is list1's size and n is list2's size)
    if (list1.isSorted() && list2.isSorted()) {
      // newList stores the union of list1 and list2
      NumList newList = new NumArrayList(list1.size() + list2.size());
      // indexList1 stores examined index of list1
      int indexList1 = 0;
      // indexList2 stores examined index of list2
      int indexList2 = 0;
      // In case when list1's size is 0
      if (list1.size() == 0) {
        // If list2's size is not 0, add list2's first element to newList and increase
        // indexList2 by 1
        if (list2.size() > 0) {
          newList.add(list2.lookup(indexList2));
          indexList2 = indexList2 + 1;
        }
      }
      // In case when list1's size is not 0, if list2's size is 0, add list1's first
      // element to newList, increase indexList1 by 1
      else if (list2.size() == 0) {
        newList.add(list1.lookup(indexList1));
        indexList1 = indexList1 + 1;
      }
      // In case when list1's size and list2's size are both positive
      else {
        // If element with indexList1 index in list1 is smaller than element with
        // indexList2 in list2, add that of list1 to newList and continue with next
        // element of smaller element
        if (list1.lookup(indexList1) < list2.lookup(indexList2)) {
          newList.add(list1.lookup(indexList1));
          indexList1 = indexList1 + 1;
        }
        // If element with indexList1 index in list1 is higher than element with
        // indexList2 in list2, add that of list2 to newList and continue with next
        // element of smaller element
        else if (list1.lookup(indexList1) > list2.lookup(indexList2)) {
          newList.add(list2.lookup(indexList2));
          indexList2 = indexList2 + 1;
        }
        // If element with indexList1 index in list1 is equal to element with indexList2
        // in list2, add that of list1 to newList and continue with next elements in
        // both lists
        else {
          newList.add(list1.lookup(indexList1));
          indexList1 = indexList1 + 1;
          indexList2 = indexList2 + 1;
        }
      }
      // Iterate until reaching at least one of two lists' ends
      while (indexList1 < list1.size() && indexList2 < list2.size()) {
        /**
         * If element with indexList1 index in list1 is smaller than element with
         * indexList2 in list2, and if that of list1 is not equal to newList's current
         * last element
         * add that of list1 to newList and continue with larger element and next
         * element of smaller element
         */
        if (list1.lookup(indexList1) < list2.lookup(indexList2)) {
          if (list1.lookup(indexList1) != newList.lookup(newList.size() - 1)) {
            newList.add(list1.lookup(indexList1));
          }
          indexList1 = indexList1 + 1;
        }
        /**
         * If element with indexList1 index in list1 is higher than element with
         * indexList2 in list2, and if that of list2 is not equal to newList's current
         * last element
         * add that of list2 to newList and continue with larger element and next
         * element of smaller element
         */
        else if (list1.lookup(indexList1) > list2.lookup(indexList2)) {
          if (list2.lookup(indexList2) != newList.lookup(newList.size() - 1)) {
            newList.add(list2.lookup(indexList2));
          }
          indexList2 = indexList2 + 1;
        }
        // If element with indexList1 index in list1 is equal to element with indexList2
        // in list2, add that of list1 to newList and continue with next elements in
        // both lists
        else {
          if (list1.lookup(indexList1) != newList.lookup(newList.size() - 1)) {
            newList.add(list1.lookup(indexList1));
          }
          indexList1 = indexList1 + 1;
          indexList2 = indexList2 + 1;
        }
      }
      // If an element of list1's remaining is higher than newList's current last
      // element, add that element of list1's remaining to newList and continue with
      // next element of list1's remaining
      while (indexList1 < list1.size()) {
        if (list1.lookup(indexList1) > newList.lookup(newList.size() - 1)) {
          newList.add(list1.lookup(indexList1));
        }
        indexList1 = indexList1 + 1;
      }
      // If an element of list2's remaining is higher than newList's current last
      // element, add that element of list2's remaining to newList and continue with
      // next element of list2's remaining
      while (indexList2 < list2.size()) {
        if (list2.lookup(indexList2) > newList.lookup(newList.size() - 1)) {
          newList.add(list2.lookup(indexList2));
        }
        indexList2 = indexList2 + 1;
      }
      return newList;
    }
    // Time complexity: O((m + n)^2) (m is list1's size and n is list2's size)
    else {
      // newList stores the union of list1 and list2
      NumList newList = new NumLinkedList();
      // insert each of elements from the end to beginning of list2 to newList's
      // beginning
      for (int i = list2.size() - 1; i >= 0; i = i - 1) {
        newList.insert(0, list2.lookup(i));
      }
      // insert each of elements from the end to beginning of list1 to newList's
      // beginning
      for (int j = list1.size() - 1; j >= 0; j = j - 1) {
        newList.insert(0, list1.lookup(j));
      }
      newList.removeDuplicates();
      return newList;
    }
  }
}