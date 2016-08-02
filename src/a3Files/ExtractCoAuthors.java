package a3Files;

import java.util.List;

/*
 * This class is in charge of Extracting the co-authors from the given html
 * file
 */
public class ExtractCoAuthors extends AbstractExtractClass {

  // regex that is used to extract the co-authors
  final String reForCoAuthors = "=en\" title=\".*?\">(.*?)</a><br>";

  /*
   * Creates an instance and stores the extracted co-authors
   */
  public ExtractCoAuthors(String rawHTMLString) {
    this.rawHTMLString = rawHTMLString;
    this.extracted = extractListOfItems(reForCoAuthors, 15);

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
