package driver;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractExtractClass {
  Pattern patternObject;
  Matcher matcherObject;
  String rawHTMLString;
  List<String> extracted;
     
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
