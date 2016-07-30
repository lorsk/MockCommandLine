package driver;

import java.util.List;

public class ExtractITenIndex extends AbstractExtractClass{
  
  final String reForItenExtraction = "i10-index<.*?<td class=\"cit-borderleft"
      + " cit-data\">.*?</td>.*?"
      + "<td class=\"cit-borderleft cit-data\">(.*?)</td>";
  
  public ExtractITenIndex(String rawHTMLString) {
    this.rawHTMLString = rawHTMLString;
    this.extracted = extractListOfItems(reForItenExtraction);

  }
  @Override
  public List<String> extract() {
    return this.extracted;
    
  }
}
