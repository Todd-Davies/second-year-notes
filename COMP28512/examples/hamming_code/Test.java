public class Test {
  
  public static void main(String[] args) {

    HammingCode.HammingNumber[] numbers = { 
      new HammingCode.HammingNumber(new boolean[]{false, false, false, false, false, false, false}),
      new HammingCode.HammingNumber(new boolean[]{true,  true,  false, false, false, false, true }),
      new HammingCode.HammingNumber(new boolean[]{true,  false, true,  false, false, true,  false}),
      new HammingCode.HammingNumber(new boolean[]{false, true,  true,  false, false, true,  true }),
      new HammingCode.HammingNumber(new boolean[]{false, true,  true,  false, true,  false, false})
    };

    HammingCode code = new HammingCode(numbers);

    for(int i = 0; i < 10; i++) {
      HammingCode.HammingNumber h = new HammingCode.HammingNumber(new boolean[]{Math.random() < 0.5,
                                    Math.random() < 0.5, Math.random() < 0.5,
                                    Math.random() < 0.5, Math.random() < 0.5,
                                    Math.random() < 0.5, Math.random() < 0.5});
      System.out.println("Input: " + h);
      HammingCode.HammingNumber corrected = code.correct(h);
      if(corrected != null) System.out.println("Output: " + code.correct(h));
      else System.out.println("Unable to correct: " + h);
    }

  }

}