package day2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Day2Test {
  
  @Test
  public void processOpCode(){
    Integer[] input = new Integer[]{1,0,0,0};
    Integer[] input2 = new Integer[]{2,3,0,3};
    Integer[] input3 = new Integer[]{2,4,4,5,99,0};
    
    day2.One one = new day2.One();
    one.processOpCode(input, 0);
    one.processOpCode(input2, 0);
    one.processOpCode(input3, 0);
    
    assertArrayEquals(new Integer[]{2,0,0,0}, input);
    assertArrayEquals(new Integer[]{2,3,0,6}, input2);
    assertArrayEquals(new Integer[]{2,4,4,5,99,9801}, input3);
  }
}
