package a3Files;

import java.util.List;

/*
 * This class is in charge of Extracting the top 3 publications
 *  from the given html file
 */
public class ExtractTopPublications extends AbstractExtractClass {

  // regex used to extract the author's top 3 publications
  final String reForPublications = "<td id=\"col-title\"><a href=\".*?>(.*?)<";

  /*
   * Creates an instance and stores the extracted publications
   */
  public ExtractTopPublications(String rawHTMLString) {
    this.rawHTMLString = rawHTMLString;
    this.extracted = extractListOfItems(reForPublications, 4);
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
