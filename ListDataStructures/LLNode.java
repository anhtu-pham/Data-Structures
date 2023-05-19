public class LLNode{
  
  // element stores the value of the node
  private double element;
  
  // next stores the address of the node's next node
  private LLNode next;
  
  /**
   * Initialize the node with its element being first input value and its next node being second input value
   * Time complexity: O(1)
   */
  public LLNode(double element, LLNode next){
    this.element = element;
    this.next = next;
  }
  
  /**
   * Set the node's element as the input value
   * Time complexity: O(1)
   */
  public void setElement(double element){
    this.element = element;
  }
  
  /**
   * Return the node's element
   * Time complexity: O(1)
   */
  public double getElement(){
    return this.element;
  }
  
  /**
   * Set the node's next node as the input value
   * Time complexity: O(1)
   */
  public void setNext(LLNode next){
    this.next = next;
  }
  
  /**
   * Return the node's next node
   * Time complexity: O(1)
   */
  public LLNode getNext(){
    return this.next;
  }
}