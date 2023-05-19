public class Demonstration{


  /**
   * Write demonstration of the code of both NumArrayList class and NumLinkedList class
   */
  public static void main(String[] args){
    System.out.println("-------------------- DEMONSTRATION FOR NumArrayList --------------------");
    System.out.println("Initialize listWithDefaultCapacity of NumArrayList with default initial capacity of 10");
    NumArrayList listWithDefaultCapacity = new NumArrayList();
    System.out.println("  listWithDefaultCapacity's initial capacity: " + listWithDefaultCapacity.capacity());
    try{
      System.out.println("When initializing NumArrayList variable, negative initial capacity in input will cause the program to throw IllegalArgumentException exception");
      NumArrayList listWithWrongInitialCapacity = new NumArrayList(-2);
    }
    catch(IllegalArgumentException exception){
      System.out.println("  After initializing listWithWrongInitialCapacity of NumArrayList with negative initial capacity (-2), IllegalArgumentException exception was thrown");
    }
    System.out.println("Initialize list of NumArrayList with initial capacity of 1");
    NumArrayList list = new NumArrayList(1);
    System.out.println("Initially, list is empty");
    System.out.println("  list's size: " + list.size());
    System.out.println("  list's initial capacity: " + list.capacity());
    System.out.println("  list's content: " + list.toString());
    System.out.println("DEMONSTRATION OF add(double value) METHOD ALONG WITH size(), capacity(), AND toString():");
    list.add(12.25);
    System.out.println("After adding 12.25 to list:");
    System.out.println("  list's size: " + list.size());
    System.out.println("  list's capacity: " + list.capacity());
    System.out.println("  list's content: " + list.toString());
    list.add(18.212);
    System.out.println("After adding 18.212 to list:");
    System.out.println("  list's size: " + list.size());
    System.out.println("  list's capacity: " + list.capacity() + " (list has to be expanded, and capacity is increased by 10)");
    System.out.println("  list's content: " + list.toString());
    System.out.println("DEMONSTRATION OF insert(int i, double value) METHOD ALONG WITH size(), capacity(), AND toString():");
    list.insert(-5, 98.125);
    System.out.println("After inserting 98.125 with index -5 (negative i) to list (list should not be changed because index cannot be negative):");
    System.out.println("  list's size: " + list.size());
    System.out.println("  list's capacity: " + list.capacity());
    System.out.println("  list's content: " + list.toString());
    list.insert(18, 25.18);
    System.out.println("After inserting 25.18 with index 18 to list (25.18 is added to list's end because 18 is higher than list's current size):");
    System.out.println("  list's size: " + list.size());
    System.out.println("  list's capacity: " + list.capacity());
    System.out.println("  list's content: " + list.toString());
    list.insert(2, 12.51);
    System.out.println("After inserting 12.51 with index 2 to list:");
    System.out.println("  list's size: " + list.size());
    System.out.println("  list's capacity: " + list.capacity());
    System.out.println("  list's content: " + list.toString());
    System.out.println("DEMONSTRATION OF remove(int i) METHOD ALONG WITH size(), capacity(), AND toString():");
    list.remove(-15);
    System.out.println("After removing element with index -15 (negative i) to list (list should not be changed because index cannot be negative):");
    System.out.println("  list's size: " + list.size());
    System.out.println("  list's capacity: " + list.capacity());
    System.out.println("  list's content: " + list.toString());
    list.remove(8);
    System.out.println("After removing element with index 8 from list (list should not be changed because 8 is higher than list's current size):");
    System.out.println("  list's size: " + list.size());
    System.out.println("  list's capacity: " + list.capacity());
    System.out.println("  list's content: " + list.toString());
    list.remove(1);
    System.out.println("After removing element with index 1 from list:");
    System.out.println("  list's size: " + list.size());
    System.out.println("  list's capacity: " + list.capacity());
    System.out.println("  list's content: " + list.toString());
    System.out.println("DEMONSTRATION OF contains(double value) METHOD:");
    System.out.println("  list contains 25.18 ? " + list.contains(25.18));
    System.out.println("  list contains 1252.16 ? " + list.contains(1252.16));
    System.out.println("DEMONSTRATION OF lookup(int i) METHOD:");
    try{
      System.out.println("  When using this method, negative i will cause the program to throw IndexOutOfBoundsException exception");
      list.lookup(-1);
    }
    catch(IndexOutOfBoundsException exception){
      System.out.println("    After using this method with negative value of i (-1), IndexOutOfBoundsException exception was thrown");
    }
    try{
      System.out.println("  When using this method, i having value that is higher than or equal to list's current size will cause the program to throw IndexOutOfBoundsException exception");
      System.out.println("    list's size: " + list.size());
      list.lookup(12);
    }
    catch(IndexOutOfBoundsException exception){
      System.out.println("    After using this method with value of i (12) that is higher than or equal to list's current size (3), IndexOutOfBoundsException exception was thrown");
    }
    System.out.println("DEMONSTRATION OF equals(NumList otherList) METHOD:");
    System.out.println("  Using equals(NumList otherList) to check if list equals null returns " + list.equals(null));
    NumArrayList otherList = new NumArrayList();
    otherList.add(12.25);
    otherList.add(18.212);
    otherList.add(25.18);
    System.out.println("  Check if list equals otherList, which now has same content as list:");
    System.out.println("    list's content: " + list.toString());
    System.out.println("    otherList's content: " + otherList.toString());
    System.out.println("    Using equals(NumList otherList) to check if list equals otherList returns " + list.equals(otherList));
    otherList.add(19.26);
    otherList.remove(1);
    System.out.println("  Check if list equals otherList, which now does not have same content as list:");
    System.out.println("    list's content: " + list.toString());
    System.out.println("    otherList's content: " + otherList.toString());
    System.out.println("    Using equals(NumList otherList) to check if list equals otherList returns " + list.equals(otherList));
    System.out.println("DEMONSTRATION OF removeDuplicates() METHOD:");
    System.out.println("  Before using removeDuplicates(), add 12.51, 528.92, 81.06, 91.22, 25.18, 81.06, 125.81 to list");
    list.add(12.51);
    list.add(528.92);
    list.add(81.06);
    list.add(91.22);
    list.add(25.18);
    list.add(81.06);
    list.add(125.81);
    System.out.println("  list's content before using removeDuplicates(): " + list.toString());
    list.removeDuplicates();
    System.out.println("  list's content after using removeDuplicates(): " + list.toString());
    System.out.println("DEMONSTRATION OF isSorted() METHOD:");
    System.out.println("  Before using isSorted(), remove element with index 3");
    list.remove(3);
    System.out.println("  list's content: " + list.toString());
    System.out.println("  list is in increasing sorted order ? " + list.isSorted());
    System.out.println("  Add 85.62 to list and insert 91.24 to list's beginning");
    list.add(85.62);
    list.insert(0, 91.24);
    System.out.println("  list's content: " + list.toString());
    System.out.println("  list is in increasing sorted order ? " + list.isSorted());
    System.out.println("DEMONSTRATION OF reverse() METHOD:");
    System.out.println("  list's content before using reverse(): " + list.toString());
    list.reverse();
    System.out.println("  list's content after using reverse(): " + list.toString());
    System.out.println("DEMONSTRATION OF union(NumList list1, NumList list2) METHOD:");
    System.out.println("  Before using union(NumList list1, NumList list2), create 2 empty lists called list1 and list2");
    NumArrayList list1 = new NumArrayList();
    NumArrayList list2 = new NumArrayList();
    // Create theList and use the method union(NumList list1, NumList list2)
    NumArrayList theList = new NumArrayList();
    System.out.println("  The content of the union of list1 and list2 by using union(NumList list1, NumList list2): " + theList.union(list1, list2).toString());
    System.out.println("  Make list1 have elements and be in increasingly sorted order");
    list1.add(12.61);
    list1.add(25.712);
    list1.add(25.712);
    list1.add(61.28);
    list1.add(126.51);
    list1.add(168.35);
    System.out.println("  The content of the union of list1 and list2 by using union(NumList list1, NumList list2): " + theList.union(list1, list2).toString());
    System.out.println("  Make list2 have elements and be in increasingly sorted order");
    list2.add(16.71);
    list2.add(24.55);
    list2.add(61.28);
    list2.add(71.32);
    list2.add(71.32);
    list2.add(126.95);
    list2.add(152.68);
    list2.add(182.91);
    System.out.println("  list1's content: " + list1.toString());
    System.out.println("  list2's content: " + list2.toString());
    System.out.println("  The content of the union of list1 and list2 by using union(NumList list1, NumList list2): " + theList.union(list1, list2).toString());
    System.out.println("  Make list1 be no longer in increasingly sorted order");
    list1.insert(0, 82.5);
    System.out.println("  list1's content: " + list1.toString());
    System.out.println("  list2's content: " + list2.toString());
    System.out.println("  The content of the union of list1 and list2 by using union(NumList list1, NumList list2): " + theList.union(list1, list2).toString());
    System.out.println("  Make list2 be no longer in increasingly sorted order");
    list2.insert(0, 126.52);
    System.out.println("  list1's content: " + list1.toString());
    System.out.println("  list2's content: " + list2.toString());
    System.out.println("  The content of the union of list1 and list2 by using union(NumList list1, NumList list2): " + theList.union(list1, list2).toString());
    System.out.println("-------------------- DEMONSTRATION FOR NumLinkedList --------------------");
    System.out.println("Initialize linkedList of NumLinkedList");
    NumLinkedList linkedList = new NumLinkedList();
    System.out.println("In NumLinkedList class, capacity() only returns the value of Integer.MAX_VALUE; linkedList's capacity: " + linkedList.capacity());
    System.out.println("Initially, linkedList is empty");
    System.out.println("  linkedList's size: " + linkedList.size());
    System.out.println("  linkedList's content: " + linkedList.toString());
    System.out.println("DEMONSTRATION OF add(double value) METHOD ALONG WITH size() AND toString():");
    linkedList.add(162.15);
    System.out.println("After adding 162.15 to linkedList:");
    System.out.println("  linkedList's size: " + linkedList.size());
    System.out.println("  linkedList's content: " + linkedList.toString());
    linkedList.add(22.16);
    System.out.println("After adding 22.16 to linkedList:");
    System.out.println("  linkedList's size: " + linkedList.size());
    System.out.println("  linkedList's content: " + linkedList.toString());
    System.out.println("DEMONSTRATION OF insert(int i, double value) METHOD ALONG WITH size() AND toString():");
    linkedList.insert(-16, 17.622);
    System.out.println("After inserting 17.622 with index -16 (negative i) to linkedList (linkedList should not be changed because index cannot be negative):");
    System.out.println("  linkedList's size: " + linkedList.size());
    System.out.println("  linkedList's content: " + linkedList.toString());
    linkedList.insert(25, 91.2);
    System.out.println("After inserting 91.2 with index 25 to linkedList (91.2 is added to linkedList's end because 25 is higher than linkedList's current size):");
    System.out.println("  linkedList's size: " + linkedList.size());
    System.out.println("  linkedList's content: " + linkedList.toString());
    linkedList.insert(1, 16.35);
    System.out.println("After inserting 16.35 with index 1 to linkedList:");
    System.out.println("  linkedList's size: " + linkedList.size());
    System.out.println("  linkedList's content: " + linkedList.toString());
    linkedList.insert(0, 6.281);
    System.out.println("After inserting 6.281 with index 0 to linkedList (insert to linkedList's beginning):");
    System.out.println("  linkedList's size: " + linkedList.size());
    System.out.println("  linkedList's content: " + linkedList.toString());
    System.out.println("DEMONSTRATION OF remove(int i) METHOD ALONG WITH size() AND toString():");
    linkedList.remove(-26);
    System.out.println("After removing element with index -26 (negative i) to linkedList (linkedList should not be changed because index cannot be negative):");
    System.out.println("  linkedList's size: " + linkedList.size());
    System.out.println("  linkedList's content: " + linkedList.toString());
    linkedList.remove(40);
    System.out.println("After removing element with index 40 from linkedList (linkedList should not be changed because 40 is higher than linkedList's current size):");
    System.out.println("  linkedList's size: " + linkedList.size());
    System.out.println("  linkedList's content: " + linkedList.toString());
    linkedList.remove(2);
    System.out.println("After removing element with index 2 from linkedList:");
    System.out.println("  linkedList's size: " + linkedList.size());
    System.out.println("  linkedList's content: " + linkedList.toString());
    linkedList.remove(0);
    System.out.println("After removing element with index 0 from linkedList (remove from linkedList's beginning):");
    System.out.println("  linkedList's size: " + linkedList.size());
    System.out.println("  linkedList's content: " + linkedList.toString());
    System.out.println("DEMONSTRATION OF contains(double value) METHOD:");
    System.out.println("  linkedList contains 22.16 ? " + linkedList.contains(22.16));
    System.out.println("  linkedList contains 682.51 ? " + linkedList.contains(682.51));
    System.out.println("DEMONSTRATION OF lookup(int i) METHOD:");
    try{
      System.out.println("  When using this method, negative i will cause the program to throw IndexOutOfBoundsException exception");
      linkedList.lookup(-2);
    }
    catch(IndexOutOfBoundsException exception){
      System.out.println("    After using this method with negative value of i (-2), IndexOutOfBoundsException exception was thrown");
    }
    try{
      System.out.println("  When using this method, i having value that is higher than or equal to linkedList's current size will cause the program to throw IndexOutOfBoundsException exception");
      System.out.println("    linkedList's size: " + linkedList.size());
      linkedList.lookup(68);
    }
    catch(IndexOutOfBoundsException exception){
      System.out.println("    After using this method with value of i (68) that is higher than or equal to linkedList's current size (3), IndexOutOfBoundsException exception was thrown");
    }
    System.out.println("DEMONSTRATION OF equals(NumList otherList) METHOD:");
    System.out.println("  linkedList is equal to null ? " + linkedList.equals(null));
    NumLinkedList anotherList = new NumLinkedList();
    anotherList.add(162.15);
    anotherList.add(22.16);
    anotherList.add(91.2);
    System.out.println("  Check if linkedList equals anotherList, which now has same content as linkedList:");
    System.out.println("    linkedList's content: " + linkedList.toString());
    System.out.println("    anotherList's content: " + anotherList.toString());
    System.out.println("    linkedList is equal to anotherList ? " + linkedList.equals(anotherList));
    anotherList.add(62.81);
    anotherList.remove(1);
    anotherList.add(152.816);
    System.out.println("  Check if linkedList equals anotherList, which now does not have same content as linkedList:");
    System.out.println("    linkedList's content: " + linkedList.toString());
    System.out.println("    anotherList's content: " + anotherList.toString());
    System.out.println("    linkedList is equal to anotherList ? " + linkedList.equals(anotherList));
    System.out.println("DEMONSTRATION OF removeDuplicates() METHOD:");
    System.out.println(" Before using removeDuplicates(), add 52.91, 27.618, 22.16, 126.75, 22.16, 162.15, 91.2, 22.16, 291.624, 22.16 to linkedList");
    linkedList.add(52.91);
    linkedList.add(27.618);
    linkedList.add(22.16);
    linkedList.add(126.75);
    linkedList.add(22.16);
    linkedList.add(162.15);
    linkedList.add(91.2);
    linkedList.add(22.16);
    linkedList.add(291.624);
    linkedList.add(22.16);
    System.out.println(" linkedList's content before using removeDuplicates(): " + linkedList.toString());
    linkedList.removeDuplicates();
    System.out.println(" linkedList's content after using removeDuplicates(): " + linkedList.toString());
    
    
    System.out.println("DEMONSTRATION OF isSorted() METHOD:");
    System.out.println("  Before using isSorted(), remove elements in a way that makes linkedList have increasing sorted order");
    linkedList.remove(0);
    linkedList.remove(1);
    linkedList.remove(2);
    System.out.println("  linkedList's content: " + linkedList.toString());
    System.out.println("  linkedList is in increasing sorted order ? " + linkedList.isSorted());
    System.out.println("  Add 25.61 to linkedList and insert 428.16 to linkedList's beginning");
    linkedList.add(25.61);
    linkedList.insert(0, 428.16);
    System.out.println("  linkedList's content: " + linkedList.toString());
    System.out.println("  linkedList is in increasing sorted order ? " + linkedList.isSorted());
    System.out.println("DEMONSTRATION OF reverse() METHOD:");
    System.out.println("  linkedList's content before using reverse(): " + linkedList.toString());
    linkedList.reverse();
    System.out.println("  linkedList's content after using reverse(): " + linkedList.toString());
    System.out.println("DEMONSTRATION OF union(NumList list1, NumList list2) METHOD:");
    System.out.println("  Before using union(NumList list1, NumList list2), create 2 empty lists called linkedList1 and linkedList2");
    NumLinkedList linkedList1 = new NumLinkedList();
    NumLinkedList linkedList2 = new NumLinkedList();
    // Create theLinkedList and use the method union(NumList list1, NumList list2)
    NumLinkedList theLinkedList = new NumLinkedList();
    System.out.println("  The content of the union of linkedList1 and linkedList2 by using union(NumList list1, NumList list2): " + theList.union(linkedList1, linkedList2).toString());
    System.out.println("  Make linkedList1 have elements and be in increasingly sorted order");
    linkedList1.add(11.62);
    linkedList1.add(51.68);
    linkedList1.add(51.68);
    linkedList1.add(125.86);
    linkedList1.add(438.51);
    linkedList1.add(623.1);
    linkedList1.add(821.54);
    System.out.println("  The content of the union of linkedList1 and linkedList2 by using union(NumList list1, NumList list2): " + theList.union(linkedList1, linkedList2).toString());
    System.out.println("  Make linkedList2 have elements and be in increasingly sorted order");
    linkedList2.add(51.26);
    linkedList2.add(125.86);
    linkedList2.add(128.17);
    linkedList2.add(324.98);
    linkedList2.add(438.51);
    linkedList2.add(568.22);
    linkedList2.add(623.1);
    linkedList2.add(872.06);
    linkedList2.add(872.06);
    System.out.println("  linkedList1's content: " + linkedList1.toString());
    System.out.println("  linkedList2's content: " + linkedList2.toString());
    System.out.println("  The content of the union of linkedList1 and linkedList2 by using union(NumList list1, NumList list2): " + theList.union(linkedList1, linkedList2).toString());
    System.out.println("  Make linkedList1 be no longer in increasingly sorted order");
    linkedList1.insert(0, 418.32);
    System.out.println("  linkedList1's content: " + linkedList1.toString());
    System.out.println("  linkedList2's content: " + linkedList2.toString());
    System.out.println("  The content of the union of linkedList1 and linkedList2 by using union(NumList list1, NumList list2): " + theList.union(linkedList1, linkedList2).toString());
    System.out.println("  Make linkedList2 be no longer in increasingly sorted order");
    linkedList2.insert(0, 591.28);
    System.out.println("  linkedList1's content: " + linkedList1.toString());
    System.out.println("  linkedList2's content: " + linkedList2.toString());
    System.out.println("  The content of the union of linkedList1 and linkedList2 by using union(NumList list1, NumList list2): " + theList.union(linkedList1, linkedList2).toString());
  }
}