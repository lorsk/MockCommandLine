package a3Files;

import java.util.List;

/*
 * This class is in charge of Extracting the author's name from the given html
 * file
 */
public class ExtractAuthorName extends AbstractExtractClass {

  // the regex that is used to extract the author's name
  final String reForNameExtraction = "<span id=\"cit-name-display\" "
      + "class=\"cit-in-place-nohover\">(.*?)</span>";

  /*
   * Creates an instance and stores the extracted name
   */
  public ExtractAuthorName(String rawHTMLString) {
    this.rawHTMLString = rawHTMLString;
    this.extracted = extractListOfItems(reForNameExtraction);

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
