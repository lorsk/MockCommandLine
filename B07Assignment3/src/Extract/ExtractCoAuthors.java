package Extract;

import java.util.List;

public class ExtractCoAuthors extends AbstractExtractClass {

  final String reForCoAuthors = "=en\" title=\".*?\">(.*?)</a><br>";

  public ExtractCoAuthors(String rawHTMLString) {
    this.rawHTMLString = rawHTMLString;
    this.extracted = extractListOfItems(reForCoAuthors, 15);

  }

  @Override
  public List<String> extract() {
    return this.extracted;

  }
}
