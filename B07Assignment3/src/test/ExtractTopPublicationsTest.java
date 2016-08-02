package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import a3Files.ExtractTopPublications;

public class ExtractTopPublicationsTest {

  ExtractTopPublications publications;
  String HTMLstring;
  
  @Before
  public void setUp() throws Exception {
    HTMLstring = "<td id=\"col-title\"><a href=\"http://scholar.google.ca"
        + "/citations?sortby=title&hl=en&user=oSJgw2cAAAAJ&view_op=list_works"
        + "\" class=\"cit-dark-link\">PUBLICATION HERE</a>";
    
  }

  @Test
  public void test() {
    publications = new ExtractTopPublications(HTMLstring);
    assertEquals("PUBLICATION HERE", publications.extract().get(0)); 
    }

}
