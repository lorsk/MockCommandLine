package driver;

import java.util.List;

public class ExtractAuthorName extends AbstractExtractClass{

  public ExtractAuthorName(String AuthorUrlString) throws Exception {
    this.rawHTMLString = RawHTMLContents.getHTML(AuthorUrlString);

  }
  @Override
  public List<String> extract() {
    return extractListOfItems(reForNameExtraction);
    
  }

}
