import org.junit.*;
import static org.junit.Assert.*;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * A class that tests the methods of the DoubleLinkedList class and methods of nested class DoubleLinkedListIterator.
 * @author Tu Pham
 */
public class DoubleLinkedListTester{
  
  /**
   * Tests the isEmpty method of DoubleLinkedList.
   */
  @Test
  public void testIsEmpty(){
    // list is double linked list used to check whether it is empty or not before and after some adjustments
    DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
    assertTrue("When list does not have any elements, did not return true", list.isEmpty());
    list.addToFront(12);
    assertFalse("When list has 1 element, did not return false", list.isEmpty());
    list.addToFront(28);
    assertFalse("When list has many elements, did not return false", list.isEmpty());
  }
  
  /**
   * Tests the getFront method of DoubleLinkedList.
   */
  @Test
  public void testGetFront(){
    // list is double linked list used to check its front by getFront method
    DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
    assertNull("When list is empty, did not return null for front", list.getFront());
    // nodeForFront is the node set to be the front of list
    DLNode<Integer> nodeForFront = new DLNode<Integer>(251, null, null);
    list.setFront(nodeForFront);
    assertSame("The method did not return the exact value of front", nodeForFront, list.getFront());
  }
  
  /**
   * Tests the setFront method of DoubleLinkedList.
   */
  @Test
  public void testSetFront(){
    // list is double linked list used to check if its front is exact after using setFront method
    DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
    // nodeForFront is the node set to be the front of list
    DLNode<Integer> nodeForFront = new DLNode<Integer>(12, null, null);
    list.setFront(nodeForFront);
    assertSame("The front of list was not set correctly", nodeForFront, list.getFront());
  }
  
  /**
   * Tests the getBack method of DoubleLinkedList.
   */
  @Test
  public void testGetBack(){
    // list is double linked list used to check its back by getBack method
    DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
    assertNull("When list is empty, did not return null for back", list.getBack());
    // nodeForBack is the node set to be the back of list
    DLNode<Integer> nodeForBack = new DLNode<Integer>(182, null, null);
    list.setBack(nodeForBack);
    assertSame("The method did not return the exact value of back", nodeForBack, list.getBack());
  }
  
  /**
   * Tests the setBack method of DoubleLinkedList.
   */
  @Test
  public void testSetBack(){
    // list is double linked list used to check if its back is exact after using setBack method
    DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
    DLNode<Integer> nodeForBack = new DLNode<Integer>(521, null, null);
    list.setBack(nodeForBack);
    assertSame("The back of list was not set correctly", nodeForBack, list.getBack());
  }
  
  /**
   * Tests the addToFront method of DoubleLinkedList.
   */
  @Test
  public void testAddToFront(){
    // list is double linked list used to check if its elements are exact after using addToFront method
    DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
    list.addToFront(3);
    list.addToFront(2);
    list.addToFront(1);
    // head is used to store the front of list
    DLNode<Integer> head = list.getFront();
    // tail is used to store the back of list
    DLNode<Integer> tail = list.getBack();
    
    assertEquals("Testing first node of list", new Integer(1), head.getElement());
    assertEquals("Testing second node of list", new Integer(2), head.getNext().getElement());
    assertEquals("Testing third node of list", new Integer(3), head.getNext().getNext().getElement());
    assertEquals("Testing end of list", null, head.getNext().getNext().getNext());
    
    assertEquals("Testing node at back of list", new Integer(3), tail.getElement());
    assertEquals("Testing next to last node", new Integer(2), tail.getPrevious().getElement());
    assertEquals("Testing third to last node", new Integer(1), tail.getPrevious().getPrevious().getElement());
    assertEquals("Testing front of list", null, tail.getPrevious().getPrevious().getPrevious());
  }

  /**
   * Tests the addToBack method of DoubleLinkedList.
   */
  @Test
  public void testAddToBack(){
    // list is double linked list used to check if its elements are exact after using addToBack method
    DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
    list.addToBack(1);
    list.addToBack(2);
    list.addToBack(3);
    // head is used to store the front of list
    DLNode<Integer> head = list.getFront();
    // tail is used to store the back of list
    DLNode<Integer> tail = list.getBack();
      
    assertEquals("Testing last node of list", new Integer(3), tail.getElement());
    assertEquals("Testing next to last node", new Integer(2), tail.getPrevious().getElement());
    assertEquals("Testing third to last node", new Integer(1), tail.getPrevious().getPrevious().getElement());
    assertEquals("Testing front of list", null, tail.getPrevious().getPrevious().getPrevious());
    
    assertEquals("Testing node at front of list", new Integer(1), head.getElement());
    assertEquals("Testing second node of list", new Integer(2), head.getNext().getElement());
    assertEquals("Testing third node of list", new Integer(3), head.getNext().getNext().getElement());
    assertEquals("Testing end of list", null, head.getNext().getNext().getNext());
  }
  
  /**
   * Tests the equals method of DoubleLinkedList.
   */
  @Test
  public void testEquals(){
    // list is double linked list used to examine whether it is equal to comparedList to check that equals method executes correctly
    DoubleLinkedList<Double> list = new DoubleLinkedList<Double>();
    list.addToFront(2.5);
    list.addToFront(3.2);
    // comparedList is double linked list used to check whether it is equal to list
    DoubleLinkedList<Double> comparedList = new DoubleLinkedList<Double>();
    comparedList.addToFront(2.5);
    comparedList.addToFront(3.2);
    assertFalse("comparing with null did not return false", list.equals(null));
    assertFalse("comparing with object that is not a double linked list did not return false", list.equals("hello"));
    assertTrue("comparing with double linked list having same elements did not return true", list.equals(comparedList));
  }
  
  /**
   * Tests the append method of DoubleLinkedList.
   */
  @Test
  public void testAppend(){
    // testedList is the double linked list used to check if appends method execute correctly
    DoubleLinkedList<Double> testedList = new DoubleLinkedList<Double>();
    // expectedList is the double linked list having elements which are equal to the expected elements of testedList after using appends method
    DoubleLinkedList<Double> expectedList = new DoubleLinkedList<Double>();
    // list1 is the double linked list used to append to testedList
    DoubleLinkedList<Double> list1 = null;
    testedList.append(list1);
    assertEquals("when list1 is null, did not execute correctly", expectedList, testedList);
    // list2 is another double linked list used to append to testedList
    DoubleLinkedList<Double> list2 = new DoubleLinkedList<Double>();
    testedList.append(list2);
    assertEquals("when list2 is empty, did not execute correctly", expectedList, testedList);
    // list3 is another double linked list used to append to testedList
    DoubleLinkedList<Double> list3 = new DoubleLinkedList<Double>();
    list3.addToFront(2.8);
    testedList.append(list3);
    expectedList.addToFront(2.8);
    assertEquals("when testedList is empty before appending list3 to testedList and list3 is neither null nor empty, did not append correctly", expectedList, testedList);
    // list4 is another double linked list used to append to testedList
    DoubleLinkedList<Double> list4 = new DoubleLinkedList<Double>();
    list4.addToFront(825.4);
    list4.addToFront(189.2);
    testedList.append(list4);
    expectedList.addToBack(189.2);
    expectedList.addToBack(825.4);
    assertEquals("when testedList has only 1 element before appending list4 to testedList and list4 is neither null nor empty, did not append correctly", expectedList, testedList);
    // list5 is another double linked list used to append to testedList
    DoubleLinkedList<Double> list5 = new DoubleLinkedList<Double>();
    list5.addToFront(25.18);
    list5.addToFront(89.75);
    testedList.append(list5);
    testedList.addToFront(12.5);
    expectedList.addToFront(12.5);
    expectedList.addToBack(89.75);
    expectedList.addToBack(25.18);
    assertEquals("when testedList has many elements before appending list5 to testedList and list5 is neither null nor empty, did not append correctly", expectedList, testedList);
  }
  
  /**
   * Tests the removeFromFront method of DoubleLinkedList.
   */
  public void testRemoveFromFront(){
    // list is used to check if elements removed from front of list are exact and exact exception is thrown in appropriate case when using removeFromFront method
    DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
    list.addToFront(1);
    list.addToFront(2);
    list.addToFront(3);
    assertEquals("Removing first element of list", new Integer(3), list.removeFromFront());
    assertEquals("Removing a second element", new Integer(2), list.removeFromFront());
    assertEquals("Removing a third element", new Integer(1), list.removeFromFront());
    assertEquals("Removed last element of list", true, list.isEmpty());
    try{
      list.removeFromFront();
      fail("Removing from empty list did not throw an exception.");
    }
    catch(NoSuchElementException exception){
      /* everything is good */
    }
    catch(Exception e){
      fail("Removing from empty list threw the wrong type of exception.");
    }
    
    list.addToBack(4);
    list.addToBack(5);
    assertEquals("Removing element added to back of list", new Integer(4), list.removeFromFront());
    assertEquals("Removing second element added to back", new Integer(5), list.removeFromFront());
  }
  
  /**
   * Tests the double linked list iterator.
   */
  @Test
  public void testIterator(){
    // list is double linked list used to test whether the double linked list iterator executes correctly
    DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
    // Add from 5 to 1 to front of list (1 number in each iteration)
    for (int number = 5; number > 0; number --){
      list.addToFront(number);
    }
    
    /* checking that we get out what we put it */
    int number = 1;
    // Examine values when iterating through list (examine 1 value in each iteration)
    for(Integer integerOfList : list){
      assertEquals("Testing value returned by iterator", new Integer(number ++), integerOfList);
    }
    
    if(number != 6){
      fail("The iterator did not run through all the elements of the list");
    }
  }
  
  /**
   * Tests the hasNext method of double linked list iterator.
   */
  @Test
  public void testDoubleLinkedListIteratorHasNext(){
    // list is double linked list used to check whether hasNext() method executes correctly with double linked list iterator of list
    DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
    // Add from 2 to 4 to front of list (1 number in each iteration)
    for (int number = 2; number < 5; number ++){
      list.addToFront(number);
    }
    // listIterator is the double linked list iterator of list
    DoubleLinkedList<Integer>.DoubleLinkedListIterator listIterator = list.iterator();
    assertTrue("When checking if list has first element, did not return true", listIterator.hasNext());
    listIterator.next();
    assertTrue("When checking if list has middle element, did not return true", listIterator.hasNext());
    listIterator.next();
    assertTrue("When checking if list has last element, did not return true", listIterator.hasNext());
    listIterator.next();
    assertFalse("When checking if the list has an element after the last element, did not return false", listIterator.hasNext());
  }
  
  /**
   * Tests the next method of double linked list iterator.
   */
  @Test
  public void testDoubleLinkedListIteratorNext(){
    // list is double linked list used to check whether next() method executes correctly with double linked list iterator of list
    DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
    // Add from 0 to 2 to front of list (1 number in each iteration)
    for (int number = 0; number < 3; number ++){
      list.addToFront(number);
    }
    // listIterator is the double linked list iterator of list
    DoubleLinkedList<Integer>.DoubleLinkedListIterator listIterator = list.iterator();
    assertEquals("Iterator failed in returning the first element of list", new Integer(2), listIterator.next());
    assertEquals("Iterator failed in returning the middle element of list", new Integer(1), listIterator.next());
    assertEquals("Iterator failed in returning the last element of list", new Integer(0), listIterator.next());
    try{
      listIterator.next();
      fail("When iteration does not have next element, did not throw NoSuchElementException exception");
    }
    catch(NoSuchElementException exception){
    }
    catch(Exception exception){
      fail("When iteration does not have next element, did not throw NoSuchElementException exception");
    }
  }
  
  /**
   * Tests the hasPrevious method of double linked list iterator.
   */
  @Test
  public void testDoubleLinkedListIteratorHasPrevious(){
    // list is double linked list used to check whether hasPrevious() method executes correctly with double linked list iterator of list
    DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
    // Add from 2 to 4 to front of list (1 number in each iteration)
    for (int number = 2; number < 5; number ++){
      list.addToFront(number);
    }
    // listIterator is the double linked list iterator of list
    DoubleLinkedList<Integer>.DoubleLinkedListIterator listIterator = list.iterator();
    assertFalse("When checking if list has an element before first element, did not return false", listIterator.hasPrevious());
    listIterator.next();
    assertTrue("When checking if list has first element, did not return true", listIterator.hasPrevious());
    listIterator.next();
    assertTrue("When checking if list has middle element, did not return true", listIterator.hasPrevious());
    listIterator.next();
    assertTrue("When checking if list has last element, did not return true", listIterator.hasPrevious());
  }
  
  /**
   * Tests the previous method of double linked list iterator.
   */
  @Test
  public void testDoubleLinkedListIteratorPrevious(){
    // list is double linked list used to check whether previous() method executes correctly with double linked list iterator of list.
    DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
    // Add from 0 to 2 to front of list (1 number in each iteration)
    for (int number = 0; number < 3; number ++){
      list.addToFront(number);
    }
    // listIterator is the double linked list iterator of list
    DoubleLinkedList<Integer>.DoubleLinkedListIterator listIterator = list.iterator();
    listIterator.next();
    listIterator.next();
    listIterator.next();
    assertEquals("Iterator failed in returning the last element of list", new Integer(0), listIterator.previous());
    assertEquals("Iterator failed in returning the middle element of list", new Integer(1), listIterator.previous());
    assertEquals("Iterator failed in returning the first element of list", new Integer(2), listIterator.previous());
    try{
      listIterator.previous();
      fail("When iteration does not have previous element, did not throw NoSuchElementException exception");
    }
    catch(NoSuchElementException exception){
    }
    catch(Exception exception){
      fail("When iteration does not have previous element, did not throw NoSuchElementException exception");
    }
  }
  
  /**
   * Tests the add method of double linked list iterator.
   */
  @Test
  public void testDoubleLinkedListIteratorAdd(){
    // list is double linked list used to check whether add(T element) method executes correctly with double linked list iterator of list
    DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
    // listIterator is the double linked list iterator of list
    DoubleLinkedList<Integer>.DoubleLinkedListIterator listIterator = list.iterator();
    listIterator.add(1);
    // Add from 2 to 5 to front of list (1 number in each iteration)
    for (int number = 2; number < 6; number ++){
      list.addToFront(number);
    }
    int number = 5;
    // Examine values when iterating through list (examine 1 value in each iteration)
    for (Integer integerOfList : list){
      assertEquals("The iterator failed when adding element to the start of list", new Integer(number --), integerOfList);
    }
    if(number != 0){
      fail("The iterator failed when adding element to the start of list");
    }
    listIterator = list.iterator();
    listIterator.next();
    listIterator.next();
    listIterator.add(10);
    assertEquals("The iterator failed when adding element to the middle of list", new Integer(10), list.getFront().getNext().getNext().getElement());
    listIterator = list.iterator();
    listIterator.next();
    listIterator.next();
    listIterator.next();
    listIterator.next();
    listIterator.next();
    listIterator.next();
    listIterator.add(12);
    assertEquals("The iterator failed when adding element to the end of list", new Integer(12), list.getBack().getElement());
  }
  
  /**
   * Tests the set method of double linked list iterator.
   */
  @Test
  public void testDoubleLinkedListIteratorSet(){
    // list is double linked list used to check whether set(T element) method executes correctly with double linked list iterator of list
    DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
    // listIterator is the double linked list iterator of list
    DoubleLinkedList<Integer>.DoubleLinkedListIterator listIterator = list.iterator();
    try{
      listIterator.set(25);
      fail("When neither next nor previous have been called, did not throw IllegalStateException exception");
    }
    catch(IllegalStateException exception){
    }
    catch(Exception exception){
      fail("When neither next nor previous have been called, did not throw IllegalStateException exception");
    }
    listIterator.add(18);
    try{
      listIterator.set(12);
      fail("When setting immediately after adding, did not throw IllegalStateException exception");
    }
    catch(IllegalStateException exception){
    }
    catch(Exception exception){
      fail("When setting immediately after adding, did not throw IllegalStateException exception");
    }
    // Add from 2 to 5 to front of list (1 number in each iteration)
    for (int number = 2; number < 6; number ++){
      list.addToFront(number);
    }
    listIterator = list.iterator();
    listIterator.next();
    listIterator.next();
    listIterator.next();
    listIterator.set(20);
    assertEquals("The iterator failed when replacing the last element returned by next() with specified element", new Integer(20), list.getFront().getNext().getNext().getElement());
    listIterator.previous();
    listIterator.previous();
    listIterator.set(56);
    assertEquals("The iterator failed when replacing the last element returned by previous() with specified element", new Integer(56), list.getFront().getNext().getElement());
  }
  
  /**
   * Tests the remove method of double linked list iterator.
   */
  @Test
  public void testDoubleLinkedListIteratorRemove(){
    // list is double linked list used to check whether remove() method executes correctly with double linked list iterator of list
    DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
    // listIterator is the double linked list iterator of list
    DoubleLinkedList<Integer>.DoubleLinkedListIterator listIterator = list.iterator();
    try{
      listIterator.remove();
      fail("Did not throw UnsupportedOperationException exception");
    }
    catch(UnsupportedOperationException exception){
    }
    catch(Exception exception){
      fail("Did not throw UnsupportedOperationException exception");
    }
  }
  
  /**
   * Tests the previousIndex method of double linked list iterator.
   */
  @Test
  public void testDoubleLinkedListIteratorPreviousIndex(){
    // list is double linked list used to check whether previousIndex() method executes correctly with double linked list iterator of list
    DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
    // listIterator is the double linked list iterator of list
    DoubleLinkedList<Integer>.DoubleLinkedListIterator listIterator = list.iterator();
    try{
      listIterator.previousIndex();
      fail("Did not throw UnsupportedOperationException exception");
    }
    catch(UnsupportedOperationException exception){
    }
    catch(Exception exception){
      fail("Did not throw UnsupportedOperationException exception");
    }
  }
  
  /**
   * Tests the nextIndex method of double linked list iterator.
   */
  @Test
  public void testDoubleLinkedListIteratorNextIndex(){
    // list is double linked list used to check whether nextIndex() method executes correctly with double linked list iterator of list
    DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
    // listIterator is the double linked list iterator of list
    DoubleLinkedList<Integer>.DoubleLinkedListIterator listIterator = list.iterator();
    try{
      listIterator.nextIndex();
      fail("Did not throw UnsupportedOperationException exception");
    }
    catch(UnsupportedOperationException exception){
    }
    catch(Exception exception){
      fail("Did not throw UnsupportedOperationException exception");
    }
  }
}