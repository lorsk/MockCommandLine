package driver;

import java.util.List;

public class WriteToConsole {
  
  //
  Author author;
  
  /*
   * 
   */
  public WriteToConsole(Author author) {
    this.author = author;
    }
  
  /*
   * 
   */
  public void printAuthor() {
    System.out.println("---------------------------------------------------");
    System.out.println("1. Name of Author");
    printList(this.author.authorName);
    System.out.println("2. Number of All Citations:");
    printList(this.author.numberOfCitations);
    System.out.println("3. Number of i10-index after 2009");
    printList(this.author.i10IndexAfter2009);
    System.out.println("4. Title of first 3 publications:");
    
    for (int index=1;index < this.author.topPublications.size();index++)
    {
      System.out.println("\t" + index + "- " + this.author.topPublications.get(index));
    }
    
    System.out.println("5. Total paper citation (first 5 papers):");
    System.out.println("\t" + this.author.totalCitations);
    System.out.println("6. Total Co-Authors:");
    System.out.println("\t" + this.author.numberOfCoAuthors);
    
  }
  

  /*
   * 
   */
  public static void printAllCoAuthors() {
    System.out.println("---------------------------------------------------");
    System.out.println("7. Co-Author list sorted(Total: " 
                                     + Author.numberOfTotalCoAuthors + ")");
    for (String coAuthor : Author.totalCoAuthors) {
      System.out.println("\t" + coAuthor);
    }
  }
  
  /*
   * 
   */
  private static void printList(List<String> list) {
    for (String item : list) {
      System.out.println("\t" + item);    }
  }
}
