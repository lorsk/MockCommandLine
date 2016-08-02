package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import a3Files.ExtractTotalCitations;

public class ExtractTotalCitationsTest {
  ExtractTotalCitations citations;
  String HTMLstring;
  @Before
  public void setUp() throws Exception {
    HTMLstring = "<td id=\"col-citedby\"><a class=\"cit-dark-link"
        + "\" href=\"http://scholar.google.ca/scholar?oi=bibs&hl=en&cites="
        + "6912391300348162186\">88</a></td><td id=\"col-asterisk\"></td>"
        + "<td id=\"col-year\">2007</td></tr> <tr class=\"cit-table item\">"
        + "<td id=\"col-title\"><a href=\"http://scholar.google.ca/citations?"
        + "view_op=view_citation&hl=en&user=oSJgw2cAAAAJ&citation_for_"
        + "view=oSJgw2cAAAAJ:u-x6o8ySG0sC\" class=\"cit-dark-large-link\">"
        + "The LCB data warehouse</a><br><span class=\"cit-gray\">A Ameur, V "
        + "Yankovski, S Enroth, O Spjuth, J Komorowski</span><br><span class="
        + "\"cit-gray\">Bioinformatics 22 (8), 1024-1026</span></td><td "
        + "id=\"col-citedby\"><a class=\"cit-dark-link\" href="
        + "\"http://scholar.google.ca/scholar?oi=bibs&hl"
        + "=en&cites=18217435431424551679\">41<";
  }

  @Test
  public void test() {
      citations = new ExtractTotalCitations(HTMLstring);
      assertEquals("[88, 41]", citations.extract().toString());
  }

}
