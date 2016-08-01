package Extract;

import java.util.List;

public class ExtractAuthorName extends AbstractExtractClass {

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
