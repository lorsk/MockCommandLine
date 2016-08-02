package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import a3Files.Author;
import a3Files.WriteToConsole;

public class WriteToConsoleTest {
  Author testAuthor;
  String testOutput;
  Set<Author> authors;
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @Before
  public void setUp() throws Exception {
    System.setOut(new PrintStream(outContent));

    testOutput = "\n------------------------------------------------"
        + "\n1. Name of Author" + "\n\tOla Spjuth"
        + "\n2. Number of All Citations:" + "\n\t437"
        + "\n3. Number of i10-index after 2009" + "\n\t12"
        + "\n4. Title of first 3 publications:"
        + "\n\t1- Bioclipse: an open source workbench for chemo-and "
        + "bioinformatics" + "\n\t2- The LCB data warehouse"
        + "\n\t3- XMPP for cloud computing in bioinformatics supporting"
        + " discovery and invocation of asynchronous web services"
        + "\n5. Total paper citation (first 5 papers):" + "\n\t239"
        + "\n6. Total Co-Authors:" + "\n\t15";

    authors = new HashSet<Author>();
    testAuthor = new Author("sample1.html");
    authors.add(testAuthor);
  }

  @Test
  public void printAllAuthorsTest() {

    WriteToConsole wrc = new WriteToConsole(authors);
    wrc.printAllAuthors();

    assertEquals(testOutput, outContent.toString());
  }

  @Test
  public void printAllCoauthorsTest() {

  }
}
