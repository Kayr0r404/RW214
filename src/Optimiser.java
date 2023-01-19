// import java.util.concurrent.TimeUnit;
/***
 * The third and final phase of the project requires you
 * to optimise your data structures and algorithms,
 * to find the longest possible 
 * repetition-free word in the shortest possible time. 
 * Your input will be the mode (3), 
 * the alphabet size, 
 * the start symbol, and the allowable time (in seconds). 
 * Your output will be a length and the corresponding longest string. 
 * This requires you to internally keep track of the longest
 * string you have reached up to now. 
 * If two strings are of equal length, you can decide which string to
 * save as the current longest string. 
 * When your stopwatch expires, you should print the length and an
 * example of a valid repetition free string of that length, and exit
 */

public class Optimiser { 
    
    long startTime = System.currentTimeMillis();
    /**
     * Output longest String in smallest time possible
     * @param alphabetSize number of alphabets to be used
     * @param startSymbol first character of the string to be generated
     * @param timer time required to find the longest string 
     */
    void optimiser(int alphabetSize, char startSymbol, double timer) {
        BruteForce tester = new BruteForce();
        tester.mode2(alphabetSize, startSymbol, 0);
        int i = 0;
        String currString = "";

        while (tester.vector.size() > i) {
            if (System.currentTimeMillis() - startTime <= timer * 1000) {
                if (currString.length() < tester.vector.get(i).length()) {
                    currString = tester.vector.get(i);
                    //mu
                }
              } else {
                System.out.print(currString.length() + " - " + currString);
                System.exit(0);
              }
            i++;
        }
        System.out.print(currString.length() + " - " + currString);
        
    }
}
