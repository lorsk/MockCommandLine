package a3Files;

import java.util.List;

/*
 * This class is in charge of Extracting the i10 index from the given html
 * file
 */
public class ExtractITenIndex extends AbstractExtractClass {

  // regex used to extract the i10 index of the author past 2009
  final String reForItenExtraction =
      "i10-index<.*?<td class=\"cit-borderleft" + " cit-data\">.*?</td>.*?"
          + "<td class=\"cit-borderleft cit-data\">(.*?)</td>";

  /*
   * Creates an instance and stores the extracted i10 index
   */
  public ExtractITenIndex(String rawHTMLString) {
    this.rawHTMLString = rawHTMLString;
    this.extracted = extractListOfItems(reForItenExtraction);
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
