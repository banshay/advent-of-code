import java.util.Arrays;

public class Day1 {
  static Integer[] input = new Integer[]{88062, 147838, 73346, 80732, 89182, 86798, 145656, 53825, 79515, 78250, 143033, 53680, 89366, 123255, 74974, 65373, 107733, 118266, 50726, 87810, 104355, 85331, 109624, 54282, 107472, 119291, 128702, 81132, 94609, 105929, 63918, 113360, 66932, 145080, 132130, 63858, 104334, 140635, 67642, 111552, 93446, 59263, 133164, 119788, 97327, 77379, 144054, 110747, 89394, 123533, 86026, 124422, 108855, 125000, 99270, 55789, 146945, 103156, 141044, 94238, 136833, 54370, 69178, 142349, 72239, 149992, 50901, 112759, 105467, 90841, 55693, 52532, 92343, 134889, 143351, 123359, 134972, 59986, 85415, 136521, 81581, 131078, 131201, 56194, 142135, 69982, 140667, 110013, 67772, 108135, 92591, 87200, 78189, 73407, 145395, 131869, 143480, 82068, 82423, 110819};
  
  public static void main(String[] args) {
    //    new One().execute(input);
    new Two().execute();
  }
  
}

class One {
  
  void execute() {
    System.out.println(main());
  }
  
  double main() {
    return Arrays.stream(Day1.input)
            .map(Integer::doubleValue)
            .map(this::calcFuel)
            .reduce(0d, Double::sum);
  }
  
  private double calcFuel(double i) {
    return Math.floor(i / 3) - 2;
  }
}

class Two {
  void execute() {
    System.out.println(main());
  }
  
  double main() {
    return Arrays.stream(Day1.input)
            .map(Integer::doubleValue)
            .map(this::calcFuel)
            .reduce(0d, Double::sum);
  }
  
  double calcFuel(double i) {
    double fuel = Math.floor(i / 3) - 2;
    return fuel <= 0 ? 0 : Double.sum(fuel, calcFuel(fuel));
  }
}
