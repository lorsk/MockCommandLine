package driver;

import java.util.List;

public class ExtractITenIndex extends AbstractExtractClass{
  public ExtractITenIndex(String AuthorUrlString) throws Exception {
    this.rawHTMLString = RawHTMLContents.getHTML(AuthorUrlString);

  }
  @Override
  public List<String> extract() {
    return extractListOfItems(reForItenExtraction);
    
  }
}
