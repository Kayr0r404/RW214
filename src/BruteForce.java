import java.util.Vector;
/**
 * For the second phase of the project,
 * you are expected to generate all possible strings (and their lengths)over the
 * given alphabet,
 * for which the strings do not contain any xyx repetitions, starting from a
 * given symbol.
 * In essence, you should generate a decision tree over the given alphabet,
 * and expand the branches one symbol at a time,
 * up to a provided maximum tree depth (that is, string length).
 * Each symbol used in the expansion can potentially cause a repetition.
 * Therefore, before you add the symbol,
 * you must check if that branch would contain a repetition if you add the
 * symbol.
 * If it would, you terminate that branch,
 * and print the length and the branch from the root to the last node before the
 * expansion.
 * If the addition of a symbol would not cause a repetition,
 * the branch can be expanded further. This phase is known as the brute force
 * generator (mode 2).
 * The alphabet size, start symbol and maximum depth are given as parameters.
 */
class BruteForce {
  protected final Vector<String> vector = new Vector<>();
  
  /***
   * Function to generate permutations of 
   * at most depth elements from array arr[]
   * @param alphabetSize number of character to be used in string generation
   * @param startSymbol  first charater of the String
   * @param depth max  String length
   */
  void mode2(int alphabetSize, char startSymbol, int depth) {
    String[] condons = {
        "A",
        "C",
        "G",
        "T"
    };
    String[] temp = new String[alphabetSize];
    for (int i = 0; i < temp.length; i++) {
      temp[i] = condons[i];
    }
    permutations(depth, temp, startSymbol);
  }
  /**
   * generate all the Strings with the given alphabets
   * 
   * @param depth  max String length
   * @param arr contains alphabets needed to generate
   * all Strings
   * @param startSymbol Sysbol/character that all generated Strings
   * should start with
   */
  void permutations(int depth, String[] arr, char startSymbol) {
    String[] list = arr;
    Repeat line = new Repeat();
    Vector<String> tmp = new Vector<String>();
    vector.add(Character.toString(startSymbol));
    int count = list.length;

    if (depth == 0) {
      depth = 10;
      
      for (int z = 0; z < depth - 1; z++) {
        // while (System.currentTimeMillis()-starttime/1000 < 20) {
        // Stores all combinations of length z
        // Traverse all possible lengths
        tmp = new Vector<String>();
        // Traverse the array
        outerloop: 
        for (int i = 0; i < arr.length; i++) {
          for (int k = 0; k < list.length; k++) {
            // Generate all
            // combinations of length z
            String temp = list[k] + arr[i];
            if (line.repeats(temp)) {
              // nothing happens here
              System.out.print("");
            } else if (temp.charAt(0) == startSymbol) {
              tmp.add(temp);
              int size = vector.size();
              vector.add(temp);
              count += 1;
            }
          }
        }
        // Replace all combinations of length z - 1
        // with all combinations of length z
        String[] newArray = new String[tmp.size()];
        list = tmp.toArray(newArray);
      }
    } else {
      for (int z = 0; z < depth - 1; z++) {
        // Stores all combinations of length z
        // Traverse all possible lengths
        tmp = new Vector<String>();
        // Traverse the array
        outerloop: 
        for (int i = 0; i < arr.length; i++) {
          for (int k = 0; k < list.length; k++) {
            // Generate all
            // combinations of length z
            String temp = list[k] + arr[i];
            if (line.repeats(temp)) {
              // nothing happens here
              System.out.print("");
            } else if (temp.charAt(0) == startSymbol) {
              tmp.add(temp);
              vector.add(temp);
              count += 1;
            }
          }
        }
        // Replace all combinations of length z - 1
        // with all combinations of length z
        String[] newArray = new String[tmp.size()];
        list = tmp.toArray(newArray);
      }
    }
  }
/****
 * prints all the strings in the array.
 */
  void printGeneratedStrings() {
    for (int i = 0; i < vector.size(); i++) {
            int len = vector.get(i).length();
            String val = vector.get(i);
            System.out.println(len + " - " + val);
        }
    }
  /***
   * Searches for the longest String in the array
   */
  void search() {
    String currString = "";
    for (int i = 0; i < vector.size(); i++) {
      if (currString.length() < vector.get(i).length()) {
        currString = vector.get(i);
      }
    }
    System.out.println(currString.length() + " - " + currString);
   
  }

  /*****************************************************************************
    *  main driver
    ***************************************************************************/
  /***
   * main
   * @param args array
   */

  public static void main(String[] args) {
    BruteForce s = new BruteForce();
    s.mode2(3, 'C', 0);
    s.search();
    s.mode2(4, 'A', 0);
    s.printGeneratedStrings();
  }
}
