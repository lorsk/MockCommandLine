package a3Files;

import java.util.List;

/*
 * This class is in charge of Extracting the number of citations
 *  from the given html file
 */
public class ExtractNumberOfCitations extends AbstractExtractClass {

  // regex used to extract the number of citations
  final String reForCitationExtraction =
      "Citations</a.*?<td class=\"cit-borderleft cit-data\">(.*?)</td>.*?";

  /*
   * Creates an instance and stores the extracted number of citations
   */
  public ExtractNumberOfCitations(String rawHTMLString) {
    this.rawHTMLString = rawHTMLString;
    this.extracted = extractListOfItems(reForCitationExtraction);

  }

  @Override
  /*
   * (non-Javadoc)
   * 
   * @see a3Files.AbstractExtractClass#extract()
   */
  public List<String> extract() {
    return this.extracted;

  }
}
