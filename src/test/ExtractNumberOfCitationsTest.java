package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import a3Files.ExtractNumberOfCitations;

public class ExtractNumberOfCitationsTest {
  ExtractNumberOfCitations citations;
  String HTMLstring;
  
  @Before
  public void setUp() throws Exception {
    HTMLstring = "Citations</a></td><td class="
        + "\"cit-borderleft cit-data\">437</td>";
  }

  @Test
  public void test() {
    citations = new ExtractNumberOfCitations(HTMLstring);
    assertEquals("437", citations.extract().get(0));
  }

}
