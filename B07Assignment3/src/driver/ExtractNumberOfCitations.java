package driver;

import java.util.List;

public class ExtractNumberOfCitations extends AbstractExtractClass {

  public ExtractNumberOfCitations(String AuthorUrlString) throws Exception {
    this.rawHTMLString = RawHTMLContents.getHTML(AuthorUrlString);

  }
  @Override
  public List<String> extract() {
    return extractListOfItems(reForCitationExtraction);
    
  }
}
