import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Day1Test {
  
  @Test
  void TwoCalcFuel(){
    Two two = new Two();
    assertEquals(2, two.calcFuel(14));
    assertEquals(966, two.calcFuel(1969));
    assertEquals(50346, two.calcFuel(100756));
  }
}
