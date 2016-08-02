package a3Files;

import java.util.Set;

/*
 * This class is in charge of outputting the string formatted by the 
 * FormatContent classand outputting it onto the console
 */
public class WriteToConsole implements OutputInterface {

  // this is the instance of the Author object that has the info
  // that needs to be printed
  Set<Author> allAuthors;

  // String that holds the formatted information on all the authors and their
  // co-authors
  public FormatContent formattedContent;

  /*
   * This creates an instance of the WriteToConsole class which extends the
   * OutputInterface interface. It takes in a list of authors as a parameter and
   * then uses the FormatContent class to create a string of all the authors
   * information in the specified format. This string will then be printed to
   * the console by the printAllAuthors() method
   */
  public WriteToConsole(Set<Author> authors) {
    this.allAuthors = authors;
    this.formattedContent = new FormatContent(authors);

  }

  @Override
  /*
   * (non-Javadoc)
   * 
   * @see a3Files.OutputInterface#printAllAuthors()
   */
  public void printAllAuthors() {
    System.out.print(this.formattedContent.getFormattedString());

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
    // outputs all co-authors to the console
    System.out.println(FormatContent.getCoAuthorsString());
  }

  @Override
  /*
   * @see a3Files.OutputInterface#getAllAuthors()
   */
  public Set<Author> getAllAuthors() {
    return allAuthors;
  }

}
