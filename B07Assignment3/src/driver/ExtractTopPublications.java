package driver;

import java.util.List;

public class ExtractTopPublications extends AbstractExtractClass{
  
  public ExtractTopPublications(String AuthorUrlString) throws Exception {
    this.rawHTMLString = RawHTMLContents.getHTML(AuthorUrlString);

  }
  @Override
  public List<String> extract() {
    return extractListOfItems(reForPublications, 4);
    
  }
}
