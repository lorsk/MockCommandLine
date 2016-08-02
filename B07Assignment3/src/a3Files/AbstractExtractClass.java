package a3Files;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * This is an abstract class for all of the extract classes
 * It extracts the list of items defined by the inputed regexes
 */
public abstract class AbstractExtractClass {
  Pattern patternObject;
  Matcher matcherObject;
  String rawHTMLString;
  
  // variable that holds the list of extracted items used by the sub-classes
  List<String> extracted;
  List<String> listOfMatchedItems = new ArrayList<String>();

  /*
   * returns a list of the extracted items
   */
  abstract public List<String> extract();


  /*
   * This method returns a list of all of the matched substrings in 
   * rawHTMLString
   */
  protected List<String> extractListOfItems(String reForExtraction) {
    
    try {
      // Creates a patter and matcher that will be used with the given regex
      // that is used for extraction from rawHTMLString
      patternObject = Pattern.compile(reForExtraction);
      matcherObject = patternObject.matcher(rawHTMLString);
      // Keeps looping while a matched string is found
      while (matcherObject.find()) {
        // Adds only the portion of the matched string (1st group) that is 
        // wanted
        listOfMatchedItems.add(matcherObject.group(1));
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    return listOfMatchedItems;
  }


  /*
   * This method extracts only the first numItems matched strings and returns a 
   * list of them
   */
  protected List<String> extractListOfItems(String reForExtraction,
      int numItems) {
    try {
      // Creates a patter and matcher that will be used with the given regex
      // that is used for extraction from rawHTMLString
      patternObject = Pattern.compile(reForExtraction);
      matcherObject = patternObject.matcher(rawHTMLString);
      // Keeps looping while a matched string is found and as long as 
      // the number of strings found does not exceed numItems 
      while (matcherObject.find() && listOfMatchedItems.size() < numItems) {
        // Adds only the portion of the matched string (1st group) that is 
        // wanted
        listOfMatchedItems.add(matcherObject.group(1));
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    return listOfMatchedItems;
  }
}
