package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import a3Files.ExtractITenIndex;

public class ExtractITenIndexTest {

  ExtractITenIndex itenIndex;
  String HTMLstring;

  @Before
  public void setUp() throws Exception {
    HTMLstring =
        "i10-index</a></td><td class=\"cit-borderleft cit-data\">12</td>"
        + "<td class=\"cit-borderleft cit-data\">12</td>";
  }

  @Test
  public void extractItenIndextest() {
     itenIndex = new ExtractITenIndex(HTMLstring);
     assertEquals("12", itenIndex.extract().get(0));
  }

}
