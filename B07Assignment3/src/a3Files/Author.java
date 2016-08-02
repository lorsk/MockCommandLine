// **********************************************************
// Assignment3:
// UTORID user_name:kushtovm
//
// Author:Magomed-Lors Kushtov
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// *********************************************************

package a3Files;

import java.util.ArrayList;
import java.util.List;


/*
 * This program extracts and stores all of the contents of the wanted Author.
 * When creating an instance, the user inputs the HTML file from which to
 * extract the information from. The different methods then parse the data using
 * regular expressions and stores the relevant information into the proper
 * variables
 */
public class Author {   
  
   // String that holds the raw html contents 
  String rawHTMLString;
  String HTMLfileName;
  // Lists of all of the info that have been extracted from rawHTMLString
  List<String> authorName;
  List<String> numberOfCitations;
  List<String> i10IndexAfter2009;
  List<String> topPublications;
  List<String> coAuthorsList;
  
  // These two static variables contain the accumulated Co-authors
  // every time an instance of Author is made, it adds on to their co-authors 
  // to these variables
  static List<String> totalCoAuthors = new ArrayList<String>();
  static int numberOfTotalCoAuthors = 0;

  // Instances of the Extract classes that are used to extract the wanted info
  ExtractAuthorName name;
  ExtractNumberOfCitations citations;
  ExtractTopPublications publications;
  ExtractITenIndex itenIndex;
  ExtractTotalCitations totalPaperCitations;
  ExtractCoAuthors coAuthors;

  int numberOfLocalCoAuthors;
  int totalCitations = 0;

  // a boolean variable that is used to identify whether the html file that 
  // this author instance is tied to, exists or not
  // if False, it does not get outputted 
  boolean exists = true;

  /*
   * Constructor that creates the Author instance
   */
  public Author(String AuthorUrlString) {
    this.HTMLfileName = AuthorUrlString;
    
    // Attempts to get the raw contents of the file and extract all the needed
    // information, if no such file exists, raises and exception and sets
    // exists to false
    try {
      this.rawHTMLString = RawHTMLContents.getHTML(AuthorUrlString);

      name = new ExtractAuthorName(this.rawHTMLString);
      this.authorName = name.extract();

      citations = new ExtractNumberOfCitations(this.rawHTMLString);
      this.numberOfCitations = citations.extract();

      publications = new ExtractTopPublications(this.rawHTMLString);
      this.topPublications = publications.extract();

      itenIndex = new ExtractITenIndex(this.rawHTMLString);
      this.i10IndexAfter2009 = itenIndex.extract();

      totalPaperCitations = new ExtractTotalCitations(this.rawHTMLString);
      // After extraction all of the citations, this loop 
      // adds them together to find the total citations for the top 
      // 5 publications
      for (String cts : totalPaperCitations.extract()) {
        this.totalCitations = (this.totalCitations + Integer.valueOf(cts));
      }

      coAuthors = new ExtractCoAuthors(this.rawHTMLString);
      this.coAuthorsList = coAuthors.extract();
      this.numberOfLocalCoAuthors = coAuthorsList.size();
      
      numberOfTotalCoAuthors = numberOfTotalCoAuthors + numberOfLocalCoAuthors;

      totalCoAuthors.addAll(coAuthorsList);
      java.util.Collections.sort(totalCoAuthors);

    } catch (Exception e) {
      System.out.print(AuthorUrlString + " file not found");
      this.exists = false;
    }
  }
}
