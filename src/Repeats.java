import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * Main file class
 */
public class Repeats {

  /**
   * main method
   * 
   * @param args mahlare karabo
   * @throws FileNotFoundException mahlare karabo
   */
  public static void main(String[] args) throws FileNotFoundException {

    Errors error = new Errors();
    if (args.length == 0) {
      error.invalidNumberOfArguments();
    } else {
      int arg1 = Integer.parseInt(args[0]);
      if (arg1 == 1) {
        if (args.length != 2) {
          error.invalidNumberOfArguments();
        } else {
          File f = new File(args[1]);
          if (f.exists()) {
            if (f.canRead() && f.exists()) {
              Scanner file = new Scanner(f);
              Checker mode = new Checker();

              String line = "";
              String name = f.getName();
              String outputName = "../out/"
                  + name.substring(0, name.lastIndexOf("."))
                  + "_chk.txt";
              PrintStream o = new PrintStream(new File(outputName));
              // Assign o to output stream
              System.setOut(o);

              while (file.hasNextLine()) {
                line = file.next();
              }
              mode.repeats(line);
            } else {
              error.invalidArgumentType();
            }
          } else {
            error.invalidfile();
          }
        }
      } else if (arg1 == 2) {
        int alphabetSize;
        alphabetSize = Integer.parseInt(args[1]);
        String startSymbol = args[2];
        char symbol = startSymbol.charAt(0);
        int depth = Integer.parseInt(args[3]);
        int count = 1;

        // String name = f.getName();
        String outputName = "../out/" + "gen" + count + "_bf.txt";
        File file = new File(outputName);
        // if(file.exists()){
        while (file.exists()) {
          // System.out.println("YES");
          count++;
          // String name = f.getName();
          outputName = "../out/" + "gen" + count + "_bf.txt";
          // File file = new File(outputName);
          file = new File(outputName);
        }
        // }
        PrintStream o = new PrintStream(file);
        // Assign o to output stream
        System.setOut(o);

        BruteForce mode = new BruteForce();
        mode.mode2(alphabetSize, symbol, depth);
        mode.printGeneratedStrings();
      } else if (arg1 == 3) {
        int alphabetSize = Integer.parseInt(args[1]);
        String startSymbol = args[2];
        char symbol = startSymbol.charAt(0);
        double timer = Double.parseDouble(args[3]);
        int count = 1;

        // String name = f.getName();
        String outputName = "../out/" + "out" + count + "_opt.txt";
        File file = new File(outputName);
        // if(file.exists()){
        while (file.exists()) {
          // System.out.println("YES");
          count++;
          // String name = f.getName();
          outputName = "../out/" + "out" + count + "_opt.txt";
          // File file = new File(outputName);
          file = new File(outputName);
        }
        // }
        PrintStream o = new PrintStream(file);
        // Assign o to output stream
        System.setOut(o);

        Optimiser mode = new Optimiser();
        mode.optimiser(alphabetSize, symbol, timer);
      } else {
        error.invalidMode();
      }

    }
  }
}
