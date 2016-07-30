//**********************************************************
//Assignment3:
//UTORID user_name:kushtovm 
//
//Author:Magomed-Lors Kushtov
//
//
//Honor Code: I pledge that this program represents my own
//program code and that I have coded on my own. I received
//help from no one in designing and debugging my program.
//*********************************************************

package driver;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * This program extracts and stores all of the contents of the wanted Author.
 * When creating an instance, the user inputs the HTML file from which 
 * to extract the information from. The different methods then parse the data
 * using regular expressions and stores the relevant information into the 
 * proper variables
 */
public class Author {
  WriteToConsole printObject;
  Pattern patternObject;
  Matcher matcherObject;
  String rawHTMLString;
  
  final String  reForNameExtraction = "<span id=\"cit-name-display\" "
                              + "class=\"cit-in-place-nohover\">(.*?)</span>";
  final String reForCitationExtraction = "Citations</a.*?<td "
      + "class=\"cit-borderleft cit-data\">(.*?)</td>.*?";
  
  final String reForItenExtraction = "i10-index<.*?<td class=\"cit-borderleft"
      + " cit-data\">.*?</td>.*?"
      + "<td class=\"cit-borderleft cit-data\">(.*?)</td>";
  
  final String reForPublications = "<td id=\"col-title\"><a href=\".*?>(.*?)<";
  
  final String reForCitedNum = "<td id=\"col-citedby\"><a class=\".*?>(.*?)<";
  
  final String reForCoAuthors = "=en\" title=\".*?\">(.*?)</a><br>";
  
  List<String> authorName;
  List<String> numberOfCitations;
  List<String> i10IndexAfter2009;
  List<String> topPublications;
  List<String> coAuthorsList;
  static List<String> totalCoAuthors = new ArrayList<String>();
  static int numberOfTotalCoAuthors = 0;
  
  int numberOfCoAuthors;
  int totalCitations = 0;
  /*
   * Constructor that creates the author instance
   */
  public Author(String AuthorUrlString) throws Exception {
    
    
    this.rawHTMLString = RawHTMLContents.getHTML(AuthorUrlString);
    
    this.authorName = extractListOfItems(reForNameExtraction);
    this.numberOfCitations = extractListOfItems(reForCitationExtraction);
    
    this.topPublications = extractListOfItems(reForPublications, 4);
    this.i10IndexAfter2009 = extractListOfItems(reForItenExtraction);
    for(String cts : extractListOfItems(reForCitedNum, 5)) {
      this.totalCitations = (this.totalCitations + Integer.valueOf(cts));
    }
    this.coAuthorsList = extractListOfItems(reForCoAuthors, 15);
    this.numberOfCoAuthors = coAuthorsList.size();
    numberOfTotalCoAuthors = numberOfTotalCoAuthors + numberOfCoAuthors;
    
    totalCoAuthors.addAll(coAuthorsList);
    java.util.Collections.sort(totalCoAuthors);
    
    this.printObject = new WriteToConsole(this);
  }
  
  /*
   * 
   */
  private List<String> extractListOfItems(String reForExtraction) {
    List<String> listOfMatchedItems = new ArrayList<String>();
    try {
      patternObject = Pattern.compile(reForExtraction);
      matcherObject = patternObject.matcher(rawHTMLString);
      while (matcherObject.find()) {
        listOfMatchedItems.add(matcherObject.group(1));
        
      }

    } catch (Exception e) {
      System.out.println(e);
    }
    return listOfMatchedItems;
  }
  
  
  /*
   * 
   */
  private List<String> extractListOfItems(String reForExtraction, 
                                          int numItems) {
    List<String> listOfMatchedItems = new ArrayList<String>();
    try {
      patternObject = Pattern.compile(reForExtraction);
      matcherObject = patternObject.matcher(rawHTMLString);
      while (matcherObject.find() && listOfMatchedItems.size() < numItems) {
        listOfMatchedItems.add(matcherObject.group(1));
        
      }

    } catch (Exception e) {
      System.out.println(e);
    }
    return listOfMatchedItems;
  }
  
}
