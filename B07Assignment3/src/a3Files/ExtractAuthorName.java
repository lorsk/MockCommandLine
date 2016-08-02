package a3Files;

import java.util.List;

public class ExtractAuthorName extends AbstractExtractClass {
  private List<String> extracted;
  final String reForNameExtraction = "<span id=\"cit-name-display\" "
      + "class=\"cit-in-place-nohover\">(.*?)</span>";

  public ExtractAuthorName(String rawHTMLString) {
    this.rawHTMLString = rawHTMLString;
    this.extracted = extractListOfItems(reForNameExtraction);

  }

  @Override
  public List<String> extract() {
    return this.extracted;

  }

}
