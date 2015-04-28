public class HammingCode {

  private final HammingNumber[] numbers;
  int correctionDistance = Integer.MAX_VALUE;

  public HammingCode(HammingNumber[] numbers) {
    this.numbers = numbers;
    for(int i = 0; i < numbers.length - 1; i++) {
      for(int j = i + 1; j < numbers.length; j++) {
        int distance = numbers[i].hammingDistance(numbers[j]);
        if(distance < correctionDistance) {
          correctionDistance = distance;
        }
      }
    }
  }

  public HammingNumber correct(HammingNumber input) {
    for(HammingNumber number : numbers) {
      int distance = input.hammingDistance(number);
      if(distance == 0 || distance < correctionDistance) {
        return number;
      }
    }
    return null;
  }

  public static class HammingNumber {

    private final boolean[] number;

    public HammingNumber(boolean[] number) {
      this.number = number;
    }

    public int hammingDistance(HammingNumber other) {
      int distance = 0;
      for(int i = 0; i < number.length; i++) {
        if(number[i] != other.number[i]) distance++;
      }
      return distance;
    }

    public String toString() {
      StringBuilder sb = new StringBuilder();
      for(boolean b : number) sb.append(b ? "1" : "0");
      return sb.toString();
    }
  }
}