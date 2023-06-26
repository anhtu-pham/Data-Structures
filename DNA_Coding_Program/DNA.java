import java.util.LinkedList;
import java.util.Iterator;
/**
 * DNA is a sequence of bases including A, C, G, T.
 * @author Tu Pham
 */
public class DNA extends LinkedList<DNA.Base> implements Comparable<DNA>{
  
  /**
   * Base includes 4 bases of DNA.
   */
  enum Base{
    A, C, G, T;
  }
  
  /**
   * Returns a String representation of this DNA.
   * @return a String representation of this DNA
   */
  public String toString(){
    // builder is used to store the String representation of this DNA
    StringBuilder builder = new StringBuilder();
    /**
     * Append all bases of this DNA to the builer
     * Subgoal: each base of this DNA is appended to the builder
     */
    for(Base base : this){
      builder.append(base);
    }
    return builder.toString();
  }
  
  /**
   * Removes numbases bases from start of dna, appends remaining bases of dna to the end of this DNA if dna has more than or exactly numbases bases.
   * @param dna the DNA sequence that is used to remove numbases bases from its start and append its remaining bases to the end of this DNA
   * @param numbases the number of bases removed from dna
   */
  public void splice(DNA dna, int numbases){
    // If dna is not null, execute statements right after this condition
    if(dna != null){
      // If the size of dna is higher than or equal to numbases, remove numbases bases from the start of dna
      if(dna.size() >= numbases){
        /**
         * The first numbases bases of dna are removed from dna
         * Subgoal: in each iteration, the first base of dna is removed from dna
         */
        for(int number = 0; number < numbases; number = number + 1){
          dna.removeFirst();
        }
        this.addAll(dna);
      }
    }
  }
  
  /**
   * Compares this DNA with the parameter dna for order.
   * @param dna the DNA used for comparison with this DNA sequence
   * @return a negative number if this DNA is shorter than dna or is before dna alphabetically,
   * a positive number if this DNA is longer than dna or is after dna alphabetically,
   * zero if all characters of this DNA are the same as all characters of dna
   */
  @Override
  public int compareTo(DNA dna){
    // If size of this DNA is different from size of dna, return the result of subtraction of the size of dna from the size of this DNA
    if(this.size() != dna.size()){
      return this.size() - dna.size();
    }
    // thisDNAString stores the string representation of this DNA
    String thisDNAString = this.toString();
    // dnaString stores the string representation of dna
    String dnaString = dna.toString();
    /**
     * Compare characters of thisDNAString and characters of dnaString and return appropriate number based on alphabetical order
     * Subgoal: in each iteration, if character with index theIndex of thisDNAString is different from character with index theIndex of dnaString,
     * return the result of subtraction of the examined character of dnaString from the examined character of thisDNAString
     */
    for(int theIndex = 0; theIndex < dnaString.length(); theIndex = theIndex + 1){
      /**
       * If the character with index theIndex of thisDNAString is different from the character with index theIndex of dnaString, 
       * return the result of subtraction of the examined character of dnaString from the examined character of thisDNAString
       */
      if(thisDNAString.charAt(theIndex) != dnaString.charAt(theIndex)){
        return thisDNAString.charAt(theIndex) - dnaString.charAt(theIndex);
      }
    }
    return 0;
  }
  
  /**
   * Returns the DNA that is represented by the string in the input parameter.
   * @param s the string that is used to create and return the DNA that the string represents
   * @return the DNA represented by the string in the input parameter
   * @throws IllegalArgumentException when parameter s is empty or has a character that is not A, C, G, or T
   */
  public static DNA string2DNA(String s){
    // if parameter s is empty, throw IllegalArgumentException exception
    if(s.length() == 0)
      throw new IllegalArgumentException();
    else{
      // dna is used to store the DNA represented by the string in the input parameter
      DNA dna = new DNA();
      /**
       * From the end to the beginning of parameter s, examine all characters and add all bases corresponding to the examined character to dna
       * Subgoal: add each base that corresponds to the examined character to the front of dna
       */
      for(int theIndex = s.length() - 1; theIndex >= 0; theIndex = theIndex - 1){
        // If character with index theIndex is 'A', add base A to the front of dna
        if(s.charAt(theIndex) == 'A'){
          dna.addFirst(Base.A);
        }
        // If character with index theIndex is 'C', add base C to the front of dna
        else if(s.charAt(theIndex) == 'C'){
          dna.addFirst(Base.C);
        }
        // If character with index theIndex is 'G', add base G to the front of dna
        else if(s.charAt(theIndex) == 'G'){
          dna.addFirst(Base.G);
        }
        // If character with index theIndex is 'T', add base T to the front of dna
        else if(s.charAt(theIndex) == 'T'){
          dna.addFirst(Base.T);
        }
        // If character with index theIndex is not 'A', 'C', 'G', or 'T', throw IllegalArgumentException exception
        else{
          throw new IllegalArgumentException();
        }
      }
      return dna;
    }
  }
  
  /**
   * Returns true if last n bases of dna1 and first n bases of dna2 match exactly; otherwise returns false.
   * @param dna1 the DNA sequence used to check if its last n bases and first n bases of dna2 match exactly
   * @param dna2 the DNA sequence used to check if its first n bases and last n bases of dna1 match exactly
   * @param n the number of bases checked for matching between dna1 and dna2
   * @return true if last n bases of dna1 and first n bases of dna2 match exactly; otherwise returns false
   */
  public static boolean overlaps(DNA dna1, DNA dna2, int n){
    // If n is positive or equal to 0 and both dna1 and dna2 are not null, execute statements in brackets right after this condition; if n is negative, return false
    if(n >= 0 && dna1 != null && dna2 != null){
      // If the size of dna1 or the size of dna2 is lower than n, return false
      if(dna1.size() < n || dna2.size() < n){
        return false;
      }
      // dna1String stores the string representation of dna1
      String dna1String = dna1.toString();
      // dna2String stores the string representation of dna2
      String dna2String = dna2.toString();
      /**
       * Check if n last characters of dna1String are the same as n first characters of dna2String
       * Subgoal: in each iteration, if examined character of dna1String is different from examined character of dna2String, return false
       */
      for(int theIndex = 0; theIndex < n; theIndex = theIndex + 1){
        // If the examined character of dna1String is different from the examined character of dna2String, return false
        if(dna1String.charAt(dna1String.length() - n + theIndex) != dna2String.charAt(theIndex)){
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  /**
   * Splices 2 DNA sequences represented by 2 strings in array in input parameter to create minimum DNA sequence or prints an appropriate message when bad data is typed in.
   * @param args array that should have two strings used for splicing 2 DNA sequences represented by these strings to create minimum DNA sequence
   */
  public static void main(String[] args){
    // If there are two strings in input parameter, execute statements in brackets right after this condition
    if(args.length == 2){
      try{
        // dna1 stores the DNA sequence represented by the first string in array in input parameter
        DNA dna1 = DNA.string2DNA(args[0]);
        // dna2 stores the DNA sequence represented by the second string in array in input parameter
        DNA dna2 = DNA.string2DNA(args[1]);
        // maxOverlaps stores the maximum number of overlaps between dna1 and dna2, which is the shorter size between size of dna1 and size of dna2
        int maxOverlaps = dna1.size() > dna2.size() ? dna2.size() : dna1.size();
        // hasSpliced is used to check whether splicing has been done
        boolean hasSpliced = false;
        /**
         * Find the highest overlapNumber that the last overlapNumber bases of 1 DNA sequence overlaps with first overlapNumber bases of another DNA sequence,
         * splice to create minimum DNA sequence, print string representation of that DNA sequence and go to next line
         * Subgoal: if last overlapNumber bases of 1 DNA sequence overlaps with first overlapNumber bases of another DNA sequence,
         * splice to create minimum DNA sequence, print string representation of that DNA sequence and go to next line
         */
        for(int overlapNumber = maxOverlaps; overlapNumber >= 0 && !hasSpliced; overlapNumber = overlapNumber - 1){
          /**
           * If last overlapNumber bases of dna1 and first overlapNumber bases of dna2 match exactly,
           * splice to create minimum DNA sequence (dna1 in this case), print string representation of dna1 and go to next line, and set hasSpliced to true
           */
          if(DNA.overlaps(dna1, dna2, overlapNumber)){
            dna1.splice(dna2, overlapNumber);
            System.out.println(dna1.toString());
            hasSpliced = true;
          }
          /**
           * If last overlapNumber bases of dna2 and first overlapNumber bases of dna1 match exactly,
           * splice to create minimum DNA sequence (dna2 in this case), print string representation of dna2 and go to next line, and set hasSpliced to true
           */
          if(DNA.overlaps(dna2, dna1, overlapNumber) && !hasSpliced){
            dna2.splice(dna1, overlapNumber);
            System.out.println(dna2.toString());
            hasSpliced = true;
          }
        }
      }
      /**
       * When there is at least 1 string typed in having character that is not 'A', 'C', 'G', or 'T', 
       * print a message to notify that DNA representations with 'A', 'C', 'G', or 'T' characters should be typed in
       */
      catch(IllegalArgumentException exception){
        System.out.println("You should type in DNA representations with 'A', 'C', 'G', or 'T'");
      }
    }
    // If there are not two strings in input parameter, print a message to notify that two DNA representations should be typed in
    else{
      System.out.println("You should type in two DNA representations");
    }
  }
}