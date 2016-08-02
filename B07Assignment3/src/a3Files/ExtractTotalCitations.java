package a3Files;

import java.util.List;

public class ExtractTotalCitations extends AbstractExtractClass {
  
  final String reForCitedNum = "<td id=\"col-citedby\"><a class=\".*?>(.*?)<";

  public ExtractTotalCitations(String rawHTMLString) {
    this.rawHTMLString = rawHTMLString;
    this.extracted = extractListOfItems(reForCitedNum, 5);
  }
  @Override
  public List<String> extract() {
    return this.extracted;
    
  }

}
