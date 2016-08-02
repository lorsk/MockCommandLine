package a3Files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import driver.MyParser;

public class WriteToFile implements OutputInterface {

  // the instance that holds the strings extracted from author,
  // ready to be written on to the file
  FormatContent formattedContent;
  // this is the name of the outFile that the information is being written
  // on to
  String fileName;
  // This is the file instance of the file that will contain all of the
  // needed information
  File outFile;
  // This contains a list of all of the author instances. (Contains as many
  // instances as there were files specified in the argument in MyParser)
  List<Author> allAuthors;
  // object
  FileWriter fw;

  /*
   * This creates an instance of the WriteToConsole class which extends the
   * OutputInterface interface. It takes in a list of authors as a parameter and
   * then uses the FormatContent class to create a string of all the authors
   * information in the specified format. This string will then be written on to
   * a file by the printAllAuthors() method
   */
  public WriteToFile(List<Author> authors) {
    // create object that contains the formatted string
    formattedContent = new FormatContent(authors);
    // create the instance variable that will hold the list of authors
    this.allAuthors = authors;

    // creates a file with the outFile name. This is simply to check
    // whether a file with this name exists already
    outFile = new File(MyParser.outFile);

    // checks whether the outfile already exists, and if it does, deletes it
    if (outFile.exists()) {
      outFile.delete();
    }

    // catches the exceptions raised and outputs the error messages on the
    // console instead of crashing the program
    try {
      // creates an instance of the file ready to be written onto
      // the true will append the new data
      this.fw = new FileWriter(MyParser.outFile, true);
    } catch (IOException ioe) {
      System.err.println("IOException: " + ioe.getMessage());
    }
  }

  @Override
  /*
   * (non-Javadoc)
   * 
   * @see a3Files.OutputInterface#printAllAuthors()
   */
  public void printAllAuthors() {
    // catches the exceptions raised and outputs the error messages on the
    // console instead of crashing the program
    try {
      // appends the string to the file
      this.fw.write(formattedContent.getFormattedString());
    } catch (IOException ioe) {
      System.err.println("IOException: " + ioe.getMessage());
    }
  }

  @Override
  /*
   * (non-Javadoc)
   * 
   * @see a3Files.OutputInterface#printAllCoAuthors()
   */
  public void printAllCoAuthors() {
    // all the co-authors are added to the string and formatted
    FormatContent.addContentToCoAuthors();

    // catches the exceptions raised and outputs the error messages on the
    // console instead of crashing the program
    try {
      // appends the string to the file
      this.fw.write(FormatContent.getCoAuthorsString());
      // closes the file
      this.fw.close();
    } catch (IOException ioe) {
      System.err.println("IOException: " + ioe.getMessage());
    }
  }

  @Override
  /*
   * (non-Javadoc)
   * 
   * @see a3Files.OutputInterface#getAllAuthors()
   */
  public List<Author> getAllAuthors() {
    return allAuthors;
  }
}
