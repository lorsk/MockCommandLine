package driver;

import java.util.List;

public class ExtractCoAuthors extends AbstractExtractClass{

  public ExtractCoAuthors(String AuthorUrlString) throws Exception {
    this.rawHTMLString = RawHTMLContents.getHTML(AuthorUrlString);

  }
  @Override
  public List<String> extract() {
    return extractListOfItems(reForCoAuthors, 15);
    
  }
}
