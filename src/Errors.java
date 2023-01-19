/**
 * This class file contains All error that will be teste
 * it include methods Such as, InvalidNumberOfArguments,
 * InvalidMode, InvalidChar, Invalidfile, InvalidArgumentType
 */
public class Errors {
  
  /**
     * 
     * If the incorrect number of arguments is given, 
     * then the followingerror must be displayed:
     * ERROR: invalid number of arguments
     */
  public void invalidNumberOfArguments() {
    System.err.println("ERROR: invalid number of arguments");
    System.exit(0);
  }

  /**
     * 
     * If the mode is not 1, 2, or 3, then this error must be displayed
     * ERROR: invalid mode
     */
  public void invalidMode() {
    System.err.println("ERROR: invalid mode");
    System.exit(0);
  }
  /**
     * 
     * If the alphabet symbol for the root of the decision tree or any character
     * in the input file is not in {A, C, G, T}, 
     * then this error must be displayed:
     * ERROR: invalid alphabet symbol
     */
  public void invalidChar() {
    System.err.println("ERROR: invalid alphabet symbol");
    System.exit(0);
  }
  /**
     * 
     * If the file name is given,
     * but the file cannot be opened or does not exist, 
     * the followingerror must be displayed:
     * ERROR: invalid or missing file
     */
  public void invalidfile() {
    System.err.println("ERROR: invalid or missing file");
    System.exit(0);
  }
  /**
     * 
     * If an argument is of the wrong TYPE
     * (for example, a mode of “abc” is given),
     * then this error must be displayed:
     * ERROR: invalid argument type
     */
  public void invalidArgumentType() {
    System.err.println("ERROR: invalid argument type");
    System.exit(0);
  }
}
