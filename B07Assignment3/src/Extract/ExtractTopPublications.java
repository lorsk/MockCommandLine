package Extract;

import java.util.List;

public class ExtractTopPublications extends AbstractExtractClass {

  final String reForPublications = "<td id=\"col-title\"><a href=\".*?>(.*?)<";

  public ExtractTopPublications(String rawHTMLString) {
    this.rawHTMLString = rawHTMLString;
    this.extracted = extractListOfItems(reForPublications, 4);
  }

  @Override
  public List<String> extract() {
    return this.extracted;

  }
}
