package driver;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractExtractClass {
  Pattern patternObject;
  Matcher matcherObject;
  String rawHTMLString;
  
  final String reForNameExtraction = "<span id=\"cit-name-display\" "
                      + "class=\"cit-in-place-nohover\">(.*?)</span>";
  
  final String reForCitationExtraction = "Citations</a.*?<td "
                      + "class=\"cit-borderleft cit-data\">(.*?)</td>.*?";
  
  final String reForPublications = "<td id=\"col-title\"><a href=\".*?>(.*?)<";
  
  final String reForItenExtraction = "i10-index<.*?<td class=\"cit-borderleft"
                      + " cit-data\">.*?</td>.*?"
                      + "<td class=\"cit-borderleft cit-data\">(.*?)</td>";
  
  final String reForCitedNum = "<td id=\"col-citedby\"><a class=\".*?>(.*?)<";
  
  final String reForCoAuthors = "=en\" title=\".*?\">(.*?)</a><br>";    
  
  abstract public List<String> extract();
  
  /*
   * 
   */
  protected List<String> extractListOfItems(String reForExtraction) {
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
  protected List<String> extractListOfItems(String reForExtraction,
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
