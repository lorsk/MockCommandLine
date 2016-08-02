package a3Files;

import java.util.List;

/*
 * This class is in charge of Extracting the total number of citations in 
 * the author's top 5 publications from the given html file
 */
public class ExtractTotalCitations extends AbstractExtractClass {

  // regex used to extract the author's total citations
  final String reForCitedNum = "<td id=\"col-citedby\"><a class=\".*?>(.*?)<";

  /*
   * Creates an instance and stores the extracted number of total citations
   */
  public ExtractTotalCitations(String rawHTMLString) {
    this.rawHTMLString = rawHTMLString;
    this.extracted = extractListOfItems(reForCitedNum, 5);
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
