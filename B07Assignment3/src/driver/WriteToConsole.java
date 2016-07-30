package driver;


//import java.util.List;

public class WriteToConsole {
  
  // this is the instance of the Author object that has the info
  // that needs to be printed
  Author author;
  FormatContent formattedContent;
  
  /*
   * 
   */
  public WriteToConsole(Author author) {
    this.author = author;
    this.formattedContent = new FormatContent(author);

    }
  
  /*
   * 
   */
  public void printAuthor() {
    System.out.println(this.formattedContent.getFormattedString());
 
  }
  
  /*
   * 
   */
  public static void printAllCoAuthors() {
    FormatContent.addContentToCoAuthors();
    System.out.println(FormatContent.getCoAuthorsString());

  }
  
}
