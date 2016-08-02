package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import a3Files.Author;
import a3Files.FormatContent;

public class FormatContentTest {
  String testAuthorOutput;
  String testCoAuthorOutput;
  List<Author> testAuthor;
  FormatContent format;
  @Before
  public void setUp() throws Exception {
      testAuthorOutput =
        "\n------------------------------------------------" 
      + "\n1. Name of Author"
      + "\n\tOla Spjuth"
      + "\n2. Number of All Citations:"
      + "\n\t437"
      + "\n3. Number of i10-index after 2009"
      + "\n\t12"
      + "\n4. Title of first 3 publications:"
      + "\n\t1- Bioclipse: an open source workbench for chemo-and bioinformatics"
      + "\n\t2- The LCB data warehouse"
      + "\n\t3- XMPP for cloud computing in bioinformatics supporting discovery and invocation of asynchronous web services"
      + "\n5. Total paper citation (first 5 papers):"
      + "\n\t239"
      + "\n6. Total Co-Authors:"
      + "\n\t15";
      
      testCoAuthorOutput = 
          "\n------------------------------------------------"
        + "\n7. Co-Author list sorted(Total: 15)"
        + "\nAdam Ameur"
        + "\nAntony John Williams"
        + "\nChristoph Steinbeck"
        + "\nEgon Willighagen"
        + "\nJanna Hastings"
        + "\nJonathan Alvarsson"
        + "\nKomorowski Jan"
        + "\nNina Jeliazkova"
        + "\nNoel M. O'Boyle"
        + "\nRajarshi Guha"
        + "\nSam Adams"
        + "\nSamuel Lampa"
        + "\nSean Ekins"
        + "\nValentin Georgiev"
        + "\ngilleain torrance";
      
      testAuthor = new ArrayList<Author>();
      testAuthor.add(new Author("sample1.html"));
      System.out.println(testAuthor.toString());
      format = new FormatContent(testAuthor);

  }

  @Test
  public void formattedStringTest() {
    assertEquals(testAuthorOutput, format.getFormattedString());
  }
  
  @Test
  public void formattedCoAuthorStringTest() {
    FormatContent.addContentToCoAuthors();
    assertEquals(testCoAuthorOutput, FormatContent.getCoAuthorsString());
    
  }

}
