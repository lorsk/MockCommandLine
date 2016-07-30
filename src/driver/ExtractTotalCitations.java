package driver;

import java.util.List;

public class ExtractTotalCitations extends AbstractExtractClass {
  
  public ExtractTotalCitations(String AuthorUrlString) throws Exception {
    this.rawHTMLString = RawHTMLContents.getHTML(AuthorUrlString);

  }
  @Override
  public List<String> extract() {
    return extractListOfItems(reForCitedNum, 5);
    
  }

}
