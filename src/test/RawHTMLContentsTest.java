package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import a3Files.RawHTMLContents;

public class RawHTMLContentsTest {
  FileWriter tempFile;
  String HTMLContents;

  @Before
  public void setUp() throws Exception {


  }

  @After
  public void tearDown() throws IOException {
   // creates an abstract file
   File tempFileDelete = new File("temporaryHTMLFile.html");
   // deletes the temporary file
   if (tempFileDelete.exists()) {
     tempFileDelete.delete();
    }
  }

  @Test
  /*
   * Tests whether the getHTML() method outputs the proper content
   */
  public void getHTMLTest() throws Exception {
    tempFile = new FileWriter("temporaryHTMLFile.html", true);
    HTMLContents = "<html>" + "<head>" + "<title>"
        + "A Simple HTML Document" + "</title>" + "</head>" + "<body>"
        + "<p>This is a very simple HTML document</p>"
        + "<p>It only has two paragraphs</p>" + "</body>" + "</html>";
    tempFile.write(HTMLContents);
    tempFile.close();

    assertEquals(HTMLContents, RawHTMLContents.getHTML("temporaryHTMLFile.html"));
  }
  
  @Test
  /*
   * Tests whether an exception is raised when the file specified is not found
   */
  public void fileDoesNotExistTest() {
    boolean exists = true;
    
    try {
      RawHTMLContents.getHTML("temporaryHTMLFile.html");
    }
    catch (Exception e) {
      exists = false;
    }
    assertFalse(exists);
  }

}
