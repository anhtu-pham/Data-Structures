import org.junit.*;
import static org.junit.Assert.*;
/**
 * A class that tests the methods of the DNA class.
 * @author Tu Pham
 */
public class DNATester{
  
  /**
   * Tests the toString method of DNA.
   */
  @Test
  public void testToString(){
    // dna is used to check representation by toString
    DNA dna = new DNA();
    assertEquals("When dna has no bases, did not return true string", "", dna.toString());
    dna.addFirst(DNA.Base.A);
    assertEquals("When dna has only 1 base, did not return true string", "A", dna.toString());
    dna.addFirst(DNA.Base.G);
    dna.addFirst(DNA.Base.T);
    dna.addFirst(DNA.Base.T);
    dna.addFirst(DNA.Base.C);
    assertEquals("When dna has many bases, did not return true string", "CTTGA", dna.toString());
  }
  
  /**
   * Tests the string2DNA method of DNA.
   */
  @Test
  public void testString2DNA(){
    try{
      DNA.string2DNA("");
      fail("Did not throw IllegalArgumentException exception when the string is empty");
    }
    catch(IllegalArgumentException exception){
    }
    catch(Exception exception){
      fail("Did not throw IllegalArgumentException exception when the string is empty");
    }
    assertEquals("When the string has 1 character, did not return exact DNA sequence", "A", DNA.string2DNA("A").toString());
    try{
      DNA.string2DNA("N");
      fail("When the string has 1 character and contains character that is not A, C, G, or T, did not throw IllegalArgumentException exception");
    }
    catch(IllegalArgumentException exception){
    }
    catch(Exception exception){
      fail("When the string has 1 character and contains character that is not A, C, G, or T, did not throw IllegalArgumentException exception");
    }
    assertEquals("When the string has many characters, did not return exact DNA sequence", "CGA", DNA.string2DNA("CGA").toString());
    try{
      DNA.string2DNA("CGNA");
      fail("when the string has many characters and contains character that is not A, C, G, or T, did not throw IllegalArgumentException exception");
    }
    catch(IllegalArgumentException exception){
    }
    catch(Exception exception){
      fail("When the string has many characters and contains character that is not A, C, G, or T, did not throw IllegalArgumentException exception");
    }
  }
  
  /**
   * Tests the splice method of DNA.
   */
  @Test
  public void testSplice(){
    // appendedDna is the DNA that is appended by parameter DNA
    DNA appendedDna = new DNA();
    appendedDna.addFirst(DNA.Base.A);
    // appendingDna is the DNA used to append to appendedDna
    DNA appendingDna = null;
    appendedDna.splice(appendingDna, 1);
    assertEquals("When appendingDna is null, did not have true appendedDna", "A", appendedDna.toString());
    appendingDna = new DNA();
    appendedDna.splice(appendingDna, 1);
    assertEquals("When appendingDna does not have any elements after removing 0 bases from appendingDna, did not have true appendedDna", "A", appendedDna.toString());
    appendingDna = DNA.string2DNA("T");
    appendedDna.splice(appendingDna, 1);
    assertEquals("When appendingDna does not have any elements after removing 1 base from appendingDna, did not have true appendedDna", "A", appendedDna.toString());
    appendingDna = DNA.string2DNA("CCT");
    appendedDna.splice(appendingDna, 2);
    assertEquals("When appendingDna has only 1 base after removing many bases from appendingDna, did not have true appendedDna", "AT", appendedDna.toString());
    appendingDna = DNA.string2DNA("CAAG");
    appendedDna.splice(appendingDna, 2);
    assertEquals("When appendingDna has many bases after removing many bases from appendingDna, did not have true appendedDna", "ATAG", appendedDna.toString());
  }
  
  /**
   * Tests the overlaps method of DNA.
   */
  @Test
  public void testOverlaps(){
    // dna1 is the first DNA sequence for first input of overlaps method
    DNA dna1 = new DNA();
    // dna2 is the second DNA sequence for second input of overlaps method
    DNA dna2 = new DNA();
    assertFalse("When parameter n is lower than 0, did not return false", DNA.overlaps(dna1, dna2, -5));
    assertTrue("When dna1 and dna2 each does not have any bases and parameter n is 0, did not return true", DNA.overlaps(dna1, dna2, 0));
    assertFalse("When dna1 and dna2 each does not have any bases and parameter n is 1, did not return false", DNA.overlaps(dna1, dna2, 1));
    assertFalse("When dna1 and dna2 each does not have any bases and parameter n is higher than 1, did not return false", DNA.overlaps(dna1, dna2, 10));
    dna1.addFirst(DNA.Base.G);
    dna2.addFirst(DNA.Base.G);
    assertTrue("When dna1 and dna2 each have 1 same base and parameter n is 0, did not return true", DNA.overlaps(dna1, dna2, 0));
    assertTrue("When dna1 and dna2 each have 1 same base and parameter n is 1, did not return true", DNA.overlaps(dna1, dna2, 1));
    assertFalse("When dna1 and dna2 each have 1 same base and parameter n is higher than 1 (which is also number of bases of each of dna1 and dna2), did not return false", DNA.overlaps(dna1, dna2, 8));
    dna1 = DNA.string2DNA("AGTCG");
    assertTrue("When dna1 has many bases and dna2 has only one base, which matches the last base of dna1, and parameter n is 1, did not return true", DNA.overlaps(dna1, dna2, 1));
    dna2 = DNA.string2DNA("CGTAG");
    assertTrue("When n is higher than 1 and last n bases of dna1 match exactly with first n bases of dna2, did not return true", DNA.overlaps(dna1, dna2, 2));
  }
  
  /**
   * Tests the compareTo method of DNA.
   */
  @Test
  public void testCompareTo(){
    // dna1 is the DNA used to compare to the parameter DNA
    DNA dna1 = DNA.string2DNA("AT");
    // dna2 is the DNA put in parameter of compareTo method to compare to dna1
    DNA dna2 = DNA.string2DNA("GATC");
    assertTrue("When dna1 is shorter than dna2, did not return negative number", dna1.compareTo(dna2) < 0);
    dna1 = DNA.string2DNA("CGCTG");
    assertTrue("When dna1 is longer than dna2, did not return positive number", dna1.compareTo(dna2) > 0);
    dna2 = DNA.string2DNA("TGCAG");
    assertTrue("When dna1 and dna2 have equal lengths and first character of dna1 is before that of dna2, did not return negative number", dna1.compareTo(dna2) < 0);
    dna2 = DNA.string2DNA("ATGCG");
    assertTrue("When dna1 and dna2 have equal lengths and first character of dna1 is after that of dna2, did not return positive number", dna1.compareTo(dna2) > 0);
    dna2 = DNA.string2DNA("CGGTG");
    assertTrue("When dna1 and dna2 have equal lengths and middle character of dna1 is before that of dna2, did not return negative number", dna1.compareTo(dna2) < 0);
    dna2 = DNA.string2DNA("CGATG");
    assertTrue("When dna1 and dna2 have equal lengths and middle character of dna1 is after that of dna2, did not return positive number", dna1.compareTo(dna2) > 0);
    dna2 = DNA.string2DNA("CGCTT");
    assertTrue("When dna1 and dna2 have equal lengths and last character of dna1 is before that of dna2, did not return negative number", dna1.compareTo(dna2) < 0);
    dna2 = DNA.string2DNA("CGCTC");
    assertTrue("When dna1 and dna2 have equal lengths and last character of dna1 is after that of dna2, did not return positive number", dna1.compareTo(dna2) > 0);
    dna2 = DNA.string2DNA("CGCTG");
    assertTrue("When dna1 and dna2 have equal lengths and same corresponding characters, did not return 0", dna1.compareTo(dna2) == 0);
  }
  
  // The tests of main method of DNA are included in TESTING REPORT FOR PROGRAMMING PROJECT 4
}