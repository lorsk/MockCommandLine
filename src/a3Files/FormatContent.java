package a3Files;

import java.util.List;

public class FormatContent {

  // this is the instance of the Author object that has the info
  // that needs to be printed
  List<Author> authors;
  private String formattedString = "";
  private static String allCoAuthorsString = "";

  /*
   * This class creates the formatted string
   */
  public FormatContent(List<Author> authors) {
    for (Author author : authors) {
      if (author.exists) {
        addToContent("\n------------------------------------------------");
        addToContent("\n1. Name of Author");
        addListToContent(author.authorName);
        addToContent("\n2. Number of All Citations:");
        addListToContent(author.numberOfCitations);
        addToContent("\n3. Number of i10-index after 2009");
        addListToContent(author.i10IndexAfter2009);
        addToContent("\n4. Title of first 3 publications:");

        for (int index = 1; index < author.topPublications.size(); index++) {
          addToContent(
              "\n\t" + index + "- " + author.topPublications.get(index));
        }

        addToContent("\n5. Total paper citation (first 5 papers):");
        addToContent("\n\t" + author.totalCitations);
        addToContent("\n6. Total Co-Authors:");
        addToContent("\n\t" + author.numberOfCoAuthors);
      }
    }
  }

  /*
   * 
   */
  public String getFormattedString() {
    return formattedString;
  }

  /*
   * 
   */
  public static String getCoAuthorsString() {
    return allCoAuthorsString;
  }

  /*
   * 
   */
  private void addToContent(String content) {
    formattedString = formattedString + content;

  }

  /*
   * This defines how the extracted info that contains many different matches
   * (like the names of co-authors or publication titles) is formatted. In this
   * case it just creates a new line, indents and then prints the next item
   * matched.
   */
  private void addListToContent(List<String> list) {
    //
    for (String item : list) {
      formattedString = formattedString + "\n\t" + item;
    }
  }

  /*
   * 
   */
  public static void addContentToCoAuthors() {
    addToCoAuthorsString("\n------------------------------------------------");
    addToCoAuthorsString("\n7. Co-Author list sorted(Total: "
        + Author.numberOfTotalCoAuthors + ")");
    for (String coAuthor : Author.totalCoAuthors) {
      addToCoAuthorsString("\n" + coAuthor);
    }
  }


  /*
   * 
   */
  private static void addToCoAuthorsString(String string) {
    allCoAuthorsString = allCoAuthorsString + string;

  }


}
