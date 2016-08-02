package test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import a3Files.Author;
import a3Files.WriteToFile;
import driver.MyParser;

public class WriteToFileTest {
  String fileContent = "";
  WriteToFile writeToFile;
  Set<Author> authors = new HashSet<Author>();
  String testOutput;
  WriteToFile wtf;
  File file;
  Scanner inputFile ;
  @Before
  public void setUp() throws Exception {

    authors.add(new Author("sample1.html"));
    MyParser.outFile = "outfile.txt";
    writeToFile = new WriteToFile(authors);
    wtf = new WriteToFile(authors);
    
    testOutput = "\n------------------------------------------------"
        + "\n1. Name of Author" + "\n\tOla Spjuth"
        + "\n2. Number of All Citations:" + "\n\t437"
        + "\n3. Number of i10-index after 2009" + "\n\t12"
        + "\n4. Title of first 3 publications:"
        + "\n\t1- Bioclipse: an open source workbench for chemo-and"
        + " bioinformatics" + "\n\t2- The LCB data warehouse"
        + "\n\t3- XMPP for cloud computing in bioinformatics supporting "
        + "discovery and invocation of asynchronous web services"
        + "\n5. Total paper citation (first 5 papers):" + "\n\t239"
        + "\n6. Total Co-Authors:" + "\n\t15";
    
    file = new File("outfile.txt");
    inputFile = new Scanner(file);

    while (inputFile.hasNextLine()) {
      fileContent = fileContent + inputFile.nextLine();
    }
    System.out.println(fileContent);
    inputFile.close();
  }
  

  @Test
  public void printAllAuthorsTest() {
    //TODO

    assertEquals(fileContent, testOutput);

  }

}
