package a3Files;

import java.util.List;

public class ExtractNumberOfCitations extends AbstractExtractClass {

  final String reForCitationExtraction =
      "Citations</a.*?<td class=\"cit-borderleft cit-data\">(.*?)</td>.*?";


  public ExtractNumberOfCitations(String rawHTMLString) {
    this.rawHTMLString = rawHTMLString;
    this.extracted = extractListOfItems(reForCitationExtraction);

  }

  @Override
  public List<String> extract() {
    return this.extracted;

  }
}
