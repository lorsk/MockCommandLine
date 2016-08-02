package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import a3Files.ExtractCoAuthors;

public class ExtractCoAuthorsTest {

  ExtractCoAuthors coAuthors;
  String HTMLstring;

  @Before
  public void setUp() throws Exception {
    HTMLstring =
        "<a class=\"cit-dark-link\" href=\"http://scholar.google.ca/citations?"
        + "user=u8SjMZ0AAAAJ&hl=en\" title=\"Egon Willighagen\">"
        + "Egon Willighagen</a><br><a class=\"cit-dark-link\" href="
        + "\"http://scholar.google.ca/citations?user=S-7-BNAAAAAJ&hl=en\" "
        + "title=\"Jonathan Alvarsson\">Jonathan Alvarsson</a><br><a class="
        + "\"cit-dark-link\" href=\"http://scholar.google.ca/citations?user="
        + "PwIiNu0AAAAJ&hl=en\" title=\"Christoph Steinbeck\">Christoph "
        + "Steinbeck</a><br><a class=\"cit-dark-link\" href=\"http://scholar."
        + "google.ca/citations?user=2eBL2WMAAAAJ&hl=en\" title=\""
        + "Nina Jeliazkova\">Nina Jeliazkova</a>";
  }

  @Test
  public void extractCoAuthorstest() {
    coAuthors = new ExtractCoAuthors(HTMLstring);
    assertEquals("[Egon Willighagen, Jonathan Alvarsson, Christoph Steinbeck]",
        coAuthors.extract().toString());
  }

}
