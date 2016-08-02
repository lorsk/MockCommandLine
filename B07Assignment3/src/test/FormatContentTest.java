package test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import a3Files.Author;
import a3Files.FormatContent;

public class FormatContentTest {
  String testAuthorOutput;
  String testCoAuthorOutput;
  Set<Author> testAuthor;
  FormatContent format;

  @Before
  public void setUp() throws Exception {
    testAuthorOutput = "\n------------------------------------------------"
        + "\n1. Name of Author" + "\n\tOla Spjuth"
        + "\n2. Number of All Citations:" + "\n\t437"
        + "\n3. Number of i10-index after 2009" + "\n\t12"
        + "\n4. Title of first 3 publications:"
        + "\n\t1- Bioclipse: an open source workbench for chemo-and "
        + "bioinformatics" + "\n\t2- The LCB data warehouse"
        + "\n\t3- XMPP for cloud computing in bioinformatics supporting "
        + "discovery and invocation of asynchronous web services"
        + "\n5. Total paper citation (first 5 papers):" + "\n\t239"
        + "\n6. Total Co-Authors:" + "\n\t15";

    testCoAuthorOutput = "\n------------------------------------------------"
        + "\n7. Co-Author list sorted(Total: 15)" + "\nAdam Ameur"
        + "\nAntony John Williams" + "\nChristoph Steinbeck"
        + "\nEgon Willighagen" + "\nJanna Hastings" + "\nJonathan Alvarsson"
        + "\nKomorowski Jan" + "\nNina Jeliazkova" + "\nNoel M. O'Boyle"
        + "\nRajarshi Guha" + "\nSam Adams" + "\nSamuel Lampa" + "\nSean Ekins"
        + "\nValentin Georgiev" + "\ngilleain torrance";

    testAuthor = new HashSet<Author>();
    testAuthor.add(new Author("sample1.html"));
    format = new FormatContent(testAuthor);

  }

  @After
  public void tearDown() {
    FormatContent.resetCoAuthors();
  }


  @Test
  public void formattedStringTest() {
    assertEquals(testAuthorOutput, format.getFormattedString());

    FormatContent.addContentToCoAuthors();
    assertEquals(testCoAuthorOutput, FormatContent.getCoAuthorsString());

  }

}
