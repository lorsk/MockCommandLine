package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import a3Files.ExtractAuthorName;

public class ExtractAuthorNameTest {

  ExtractAuthorName authorsName;
  String HTMLstring;
  
  @Before
  /*
   * 
   */
  public void setUp() throws Exception {
    HTMLstring = "<span id=\"cit-name-display\" "
        + "class=\"cit-in-place-nohover\">Lors Kushtov</span>";
  }

  @Test
  /*
   * 
   */
  public void extractAuthorNametest() {
      authorsName = new ExtractAuthorName(HTMLstring);
      assertEquals("Lors Kushtov", authorsName.extract().get(0));
  }

}
