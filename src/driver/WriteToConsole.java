package driver;

import java.util.List;

// import java.util.List;

public class WriteToConsole implements OutputInterface {

  // this is the instance of the Author object that has the info
  // that needs to be printed
  List<Author> allAuthors;
  
  // String that holds the formatted information on all the authors and their 
  // co-authors
  FormatContent formattedContent;

  /*
   * This creates an instance of the WriteToConsole class which extends the
   * OutputInterface interface. It takes in a list of authors as a parameter and
   * then uses the FormatContent class to create a string of all the authors
   * information in the specified format. This string will then be printed to
   * the console by the printAllAuthors() method
   */
  public WriteToConsole(List<Author> authors) {
    this.allAuthors = authors;
    this.formattedContent = new FormatContent(authors);

  }

  @Override
  /*
   * @see driver.OutputInterface#printAllAuthors()
   */
  public void printAllAuthors() {
    System.out.println(this.formattedContent.getFormattedString());

  }

  @Override
  /*
   * @see driver.OutputInterface#printAllCoAuthors()
   */
  public void printAllCoAuthors() {
    FormatContent.addContentToCoAuthors();

    System.out.println(FormatContent.getCoAuthorsString());
  }

  @Override
  /*
   * @see driver.OutputInterface#getAllAuthors()
   */
  public List<Author> getAllAuthors() {
    return allAuthors;
  }

}
