/***
 * As a start, we simply expect you to check 
 * whether a given string contains a repeated xyx anywhere. 
 * You must be able to do this for any alphabet size from one to four. 
 * That is, the alphabet can be {x0},{x0, x1}, {x0, x1, x2}, 
 * or {x0, x1, x2, x3}, 
 * where xi ∈ {A, C, G, T} for 0 ≤ i ≤ 3. 
 * The length of the input string is not specified, 
 * but may be really, really long. Your task is to check for repetitions. 
 * If there are no repetitions found, then output ‘None’. 
 * For every possible repetition found, 
 * you should print all the repeating strings on a separate line, 
 * including the starting indices of the repetitions in the input string. 
 * The mode for this phase is 1
 */
public class Checker {

  /**
   * mahlare karabo
  * @param line mahlare karabo
  */
  public void repeats(String line) {

    int u = 0;
    String temp = "";
    boolean repeat = true;
    //here y is the number o chars between X.
    for (int y = 0; y < line.length(); y++) { 
      for (int i = 0; i < line.length(); i++) {
        //index of char just after string y, in string xyx.
        int k = i + y + 1; 
        if (k < line.length()) {
          if (Character.compare(line.charAt(i), line.charAt(k)) == 0) {
            temp = line.substring(i, k + 1);
            for (int j = i + 1; j < line.length(); j++) {
              int l = j + y + 1;
              if (l < line.length()) {
                if (Character.compare(line.charAt(j), line.charAt(l)) == 0) {
                  if (temp.compareTo(line.substring(j, l + 1)) == 0) {
                    repeat = false;
                    System.out.println(temp + " " + i + " " + j);
                    u++;
                  }
                }
              }
            }
          }
        } else {
          break;
        } 
      }
    }
    if (repeat) {
      System.out.print("None");
    }

  }
}
