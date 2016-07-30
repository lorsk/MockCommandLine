package driver;

import java.util.List;

//import java.util.List;

public class WriteToConsole implements OutputInterface{
  
  // this is the instance of the Author object that has the info
  // that needs to be printed
  List<Author> allAuthors;
  FormatContent formattedContent;
  
  /*
   * 
   */
  public WriteToConsole(List<Author> authors) {
    this.allAuthors= authors;
    this.formattedContent = new FormatContent(authors);

    }
  
  /*
   * 
   */
  
  public void printAllAuthors() {
    System.out.println(this.formattedContent.getFormattedString());
 
  }
  
  /*
   * 
   */
  public void printAllCoAuthors() {
    FormatContent.addContentToCoAuthors();
    System.out.println(FormatContent.getCoAuthorsString());

  }

  @Override
  public List<Author> getAllAuthors() {
    return allAuthors;
  }
  
}
