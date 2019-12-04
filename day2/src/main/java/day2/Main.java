package day2;

import lombok.extern.slf4j.Slf4j;

public class Main {
  static Integer[] input = new Integer[]{1, 12, 2, 3, 1, 1, 2, 3, 1, 3, 4, 3, 1, 5, 0, 3, 2, 9, 1, 19, 1, 19, 5, 23, 1, 23, 6, 27, 2, 9, 27, 31, 1, 5, 31, 35, 1, 35, 10, 39, 1, 39, 10, 43, 2, 43, 9, 47, 1, 6, 47, 51, 2, 51, 6, 55, 1, 5, 55, 59, 2, 59, 10, 63, 1, 9, 63, 67, 1, 9, 67, 71, 2, 71, 6, 75, 1, 5, 75, 79, 1, 5, 79, 83, 1, 9, 83, 87, 2, 87, 10, 91, 2, 10, 91, 95, 1, 95, 9, 99, 2, 99, 9, 103, 2, 10, 103, 107, 2, 9, 107, 111, 1, 111, 5, 115, 1, 115, 2, 119, 1, 119, 6, 0, 99, 2, 0, 14, 0};
  
  public static void main(String[] args) {
    System.out.println("One:");
    new One().execute();
    System.out.println("Two:");
    new Two().execute();
  }
}

class One {
  
  public void execute() {
    int index = 0;
    Integer[] clone = Main.input.clone();
    while (processOpCode(clone, index)) {
      index += 4;
    }
    System.out.println(clone[0]);
  }
  
  public boolean processOpCode(Integer[] input, int index) {
    if (input[index] == 99) {
      return false;
    }
    int opcode = input[index];
    int leftIndex = input[index + 1];
    int rightIndex = input[index + 2];
    int resultIndex = input[index + 3];
    int leftValue = input[leftIndex];
    int rightValue = input[rightIndex];
    
    switch (opcode) {
      case 1: //addition
        input[resultIndex] = leftValue + rightValue;
        break;
      case 2: //multiplication
        input[resultIndex] = leftValue * rightValue;
        break;
      default:
        throw new IllegalArgumentException("Something went wrong");
    }
    return true;
  }
}

@Slf4j
class Two {
  private static int target = 19690720;
  
  public void execute() {
    One one = new One();
    for (int noun = 0; noun < 100; noun++) {
      for (int verb = 0; verb < 100; verb++) {
        int index = 0;
        Integer[] clone = Main.input.clone();
        clone[1] = noun;
        clone[2] = verb;
        while (one.processOpCode(clone, index)) {
          index += 4;
        }
        
        if (target == clone[0]) {
          log.info("finished noun {}, verb {}; result {}", noun, verb, 100*noun+verb);
        }
      }
    }
  }
}