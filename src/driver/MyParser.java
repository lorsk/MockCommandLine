// **********************************************************
// Assignment3:
// UTORID user_name:kushtovm
//
// Author:Lors Kushtov
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// *********************************************************
package driver;

import java.util.HashSet;
import java.util.Set;

import a3Files.Author;
import a3Files.OutputInterface;
import a3Files.WriteToConsole;
import a3Files.WriteToFile;

/*
 * this is the driver of the program that takes in 1 mandatory argument and 
 * 1 optional argument. The first argument is all of the html files that
 * correspond to the authors and the second is the name of the file that 
 * will be written to. If the second argument is not given, the information
 * will be outputted to the console
 */
public class MyParser {
  public static String outFile;
  private static OutputInterface OI;
  public static Set<Author> allAuthors;

  /**
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    DEBUGStarterCode(args);
  }

  /*
   * This is a debug/helper method to help you get started. Once you understand
   * how this method is being used, you are free to refactor it, modify it, or
   * change it, or remove it entirely in any way you like.
   */
  private static void DEBUGStarterCode(String[] args) {

    String inputFiles[] = args[0].split(",");

    allAuthors = new HashSet<Author>();
    int counter = 0;
    for (String fileName : inputFiles) {
      allAuthors.add(new Author(fileName));
      counter = counter + 1;
    }


    if (args.length > 1) {
      outFile = args[1];
      OI = new WriteToFile(allAuthors);
    } else {
      OI = new WriteToConsole(allAuthors);
    }

    OI.printAllAuthors();
    OI.printAllCoAuthors();

  }

}
