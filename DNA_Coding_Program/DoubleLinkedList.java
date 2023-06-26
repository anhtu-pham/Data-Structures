import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ListIterator;
/**
 * A doubly linked linked list.
 * @author Tu Pham
 */
public class DoubleLinkedList<T> implements Iterable<T>{
  
  /**
   * front is a reference to the first node of the double linked list.
   */
  private DLNode<T> front = null;
  
  /**
   * back is a reference to the last node of the double linked list.
   */
  private DLNode<T> back = null;
  
  /**
   * Creates an empty double linked list.
   */
  public DoubleLinkedList(){
    front = null;
    back = null;
  }
  
  /** 
   * Returns true if the double linked list is empty.
   * @return true if the double linked list has no nodes; otherwise returns false
   */
  public boolean isEmpty(){
    return (getFront() == null);
  }
  
  /**
   * Returns the reference to the first node of the double linked list.
   * @return the first node of the double linked list
   */
  protected DLNode<T> getFront(){
    return front;
  }
  
  /**
   * Sets the first node of the double linked list.
   * @param node the node that will be the head of the double linked list
   */
  protected void setFront(DLNode<T> node){
    front = node;
  }
  
  /**
   * Returns the reference to the last node of the double linked list.
   * @return the last node of the double linked list
   */
  protected DLNode<T> getBack(){
    return back;
  }
  
  /**
   * Sets the last node of the double linked list.
   * @param node the node that will be the last node of the double linked list
   */
  protected void setBack(DLNode<T> node){
    back = node;
  }
  
  /**
   * Adds an element to the head of the double linked list.
   * @param element the element to add to the front of the double linked list
   */
  public void addToFront(T element){
    /**
     * If this double linked list is empty, set front of this double linked list to be the node having the parameter element and having null next and null previous;
     * set back of this double linked list to be front of this double linked list
     */
    if(isEmpty()){
      this.setFront(new DLNode<T>(element, null, null));
      this.setBack(this.getFront());
    }
    /**
     * If this double linked list is not empty, 
     * set front of this double linked list to be the node having the parameter element and having null previous and next that is the current front of this double linked list
     */
    else{
      this.setFront(new DLNode<T>(element, null, this.getFront()));
    }
  }
  
  /**
   * Adds an element to the tail of the double linked list.
   * @param element the element to add to the tail of the double linked list
   */
  public void addToBack(T element){
    /**
     * If this double linked list is empty, 
     * set back of this double linked list to be the node having the parameter element and having null next and null previous;
     * set front of this double linked list to be back of this double linked list
     */
    if(isEmpty()){
      this.setBack(new DLNode<T>(element, null, null));
      this.setFront(this.getBack());
    }
    /**
     * If this double linked list is not empty, 
     * set back of this double linked list to be the node having the parameter element and having previous that is the current back of this double linked list and null next
     */
    else{
      this.setBack(new DLNode<T>(element, this.getBack(), null));
    }
  }
  
  /**
   * 
   * @param object
   * @return
   */
  @Override
  public boolean equals(Object object){
    // If the parameter object is the instance of DoubleLinkedList, execute statements in curly brackets right after this condition
    if(object instanceof DoubleLinkedList){
      // parameterList is used to store the DoubleLinkedList value of the parameter object
      DoubleLinkedList parameterList = (DoubleLinkedList) object;
      // thisNodePointer is used to store the node of this double linked list
      DLNode<T> thisNodePointer = this.getFront();
      // parameterListNodePointer is used to store the node of parameterList
      DLNode parameterListNodePointer = parameterList.getFront();
      /**
       * 
       * Subgoal:
       */
      while(thisNodePointer != null && parameterListNodePointer != null){
        // If the element of thisNodePointer does not equal to the element of parameterListNodePointer, return false
        if(!thisNodePointer.getElement().equals(parameterListNodePointer.getElement())){
          return false;
        }
        thisNodePointer = thisNodePointer.getNext();
        parameterListNodePointer = parameterListNodePointer.getNext();
      }
      // If the pointer of 1 double linked list reached the end of its double linked list while another pointer did not (1 double linked list is longer than another), return false
      if(thisNodePointer != null || parameterListNodePointer != null){
        return false;
      }
      return true;
    }
    return false;
  }
  
  /**
   * Append the parameter double linked list to this double linked list.
   * @param list the double linked list that is appended to this double linked list
   */
  public void append(DoubleLinkedList<T> list){
    // If the parameter is neither null nor empty, execute statements in curly brackets right after this condition
    if((list != null) && (!list.isEmpty())){
      /**
       * If this double linked list is not empty, 
       * set the next of this double linked list's back to be the front of the parameter and set the previous of the parameter's front to be this double linked list's back
       */
      if(!this.isEmpty()){
        this.getBack().setNext(list.getFront());
        list.getFront().setPrevious(this.getBack());
      }
      // If this double linked list is empty, set this double linked list's front to be the parameter's front
      else{
        this.setFront(list.getFront());
      }
      this.setBack(list.getBack());
    }
  }
  
  /**
   * Removes and returns the element at the front of the double linked list.
   * @return the element that was at the front of the double linked list
   * @throws NoSuchElementException if attempting to remove from an empty double linked list
   */
  public T removeFromFront() throws NoSuchElementException{
    // deletedNode is used to store the element at the front of the double linked list before removing
    DLNode<T> deletedNode = this.getFront();
    this.setFront(this.getFront().getNext());
    return deletedNode.getElement();
  }
  
  /**
   * Removes and returns the element at the back of the double linked list.
   * @return the element that was at the back of the double linked list
   * @throws NoSuchElementException if attempting to remove from an empty double linked list
   */
  public T removeFromBack() throws NoSuchElementException{
    // deletedNode is used to store the element at the back of the double linked list before removing
    DLNode<T> deletedNode = this.getBack();
    this.setBack(this.getBack().getPrevious());
    return deletedNode.getElement();
  }
     
  /**
   * Returns an interator for the double linked list.
   * @return the iterator that runs through the double linked list from the head to the tail
   */
  @Override
  public DoubleLinkedListIterator iterator(){
    return new DoubleLinkedListIterator();
  }
  
  public class DoubleLinkedListIterator implements ListIterator<T>{
    
    /**
     * nextPointer marks the next node of cursor position when iterating.
     */
    private DLNode<T> nextPointer = null;
    
    /**
     * previousPointer marks the previous node of cursor position when iterating.
     */
    private DLNode<T> previousPointer = null;
    
    /**
     * lastPointer marks the node returned by next() or previous().
     */
    private DLNode<T> lastPointer = null;
    
    /**
     * hasAddedOrRemoved is used to check if add() or remove() has been used after last call to next or previous.
     */
    private boolean hasAddedOrRemoved = false;
    
    /**
     * Creates a list iterator for the double linked list.
     */
    public DoubleLinkedListIterator(){
      nextPointer = DoubleLinkedList.this.getFront();
    }
    
    /**
     * Adds parameter element to the place before the element that would be returned by next(), if it exists, and after the element that would be returned by previous(), if it exists, of the list.
     * @param element the element that is added to the list
     * @throws IllegalArgumentException if parameter element has some aspect that prevents that element to be added to this list
     */
    public void add(T element){
      // If the list is empty, set the list's front to be the node having element, null previous, null next, set the list's back to be the list's front, and set hasAddedOrRemoved to true
      if(DoubleLinkedList.this.isEmpty()){
        DoubleLinkedList.this.setFront(new DLNode<T>(element, null, null));
        DoubleLinkedList.this.setBack(DoubleLinkedList.this.getFront());
        nextPointer = DoubleLinkedList.this.getFront();
        hasAddedOrRemoved = true;
      }
      // If the list is not empty, execute statements in brackets right after else
      else{
        // addedNode stores the node that is added to the list
        DLNode<T> addedNode = new DLNode<T>(element, previousPointer, nextPointer);
        // If previousPointer is null, set the list's front to be addedNode
        if(previousPointer == null){
          DoubleLinkedList.this.setFront(addedNode);
        }
        // If previousPointer is not null, moves previousPointer to the next node
        else{
          previousPointer = previousPointer.getNext();
        }
        // If nextPointer is null, set the list's back to be addedNode
        if(nextPointer == null){
          DoubleLinkedList.this.setBack(addedNode);
        }
      }
      hasAddedOrRemoved = true;
    }
    
    /**
     * Returns true if there are more elements in the iteration that is in forward direction; otherwise returns false.
     * @return true if there are more elements in the iteration that is in forward direction; otherwise false
     */
    public boolean hasNext(){
      return (nextPointer != null);
    }
    
    /**
     * Returns true if there are more elements in the iteration that is in reverse direction; otherwise returns false.
     * @return true if there are more elements in the iteration that is in reverse direction; otherwise false
     */
    public boolean hasPrevious(){
      return (previousPointer != null);
    }
    
    /**
     * Returns the next element of the iteration that is in forward direction and advances cursor position.
     * @return the next element of the iteration
     * @throws NoSuchElementException if the iteration does not have next element
     */
    public T next(){
      // If hasNext returns true, execute statements in brackets right after this condition
      if(hasNext()){
        previousPointer = nextPointer;
        nextPointer = nextPointer.getNext();
        lastPointer = previousPointer;
        hasAddedOrRemoved = false;
        return previousPointer.getElement();
      }
      // If hasNext returns false, throw NoSuchElementException exception
      throw new NoSuchElementException();
    }
    
    /**
     * Returns the previous element of the iteration that is in reverse direction and moves cursor position backwards.
     * @return the previous element of the iteration that is in reverse direction
     * @throws NoSuchElementException if the iteration does not have previous element
     */
    public T previous(){
      // If hasPrevious returns true, execute statements in brackets right after this condition
      if(hasPrevious()){
        nextPointer = previousPointer;
        previousPointer = previousPointer.getPrevious();
        lastPointer = nextPointer;
        hasAddedOrRemoved = false;
        return nextPointer.getElement();
      }
      // If hasPrevious returns false, throw NoSuchElementException exception
      throw new NoSuchElementException();
    }
    
    /**
     * Replaces the last element returned by next() or previous() with parameter element.
     * @param element the element that replaces the last element returned by next() or previous().
     * @throws IllegalArgumentException if parameter element has some aspect that prevents that element to be added to this list
     * @throws IllegalStateException if neither next() nor previous have been called, or add() has been called after the last call to next() or previous()
     */
    public void set(T element){
      // If hasAddedOrRemoved is true or lastPointer is null, throw IllegalStateException exception
      if(hasAddedOrRemoved || lastPointer == null){
        throw new IllegalStateException();
      }
      lastPointer.setElement(element);
    }
    
    /**
     * Throws UnsupportedOperationException exception when being called.
     * @throws UnsupportedOperationException when this method is called
     */
    public void remove(){
      throw new UnsupportedOperationException();
    }
    
    /**
     * Throws UnsupportedOperationException exception when being called.
     * @throws UnsupportedOperationException when this method is called
     */
    public int previousIndex(){
      throw new UnsupportedOperationException();
    }
    
    /**
     * Throws UnsupportedOperationException exception when being called.
     * @throws UnsupportedOperationException when this method is called
     */
    public int nextIndex(){
      throw new UnsupportedOperationException();
    }
  }
}