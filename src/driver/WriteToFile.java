package driver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteToFile implements OutputInterface {
    // this is the instance of the Author object that has the info
    // that needs to be written on to the file
    // the instance that holds the strings extracted from author,
    // ready to be written on to the file
    FormatContent formattedContent;
    String fileName;
    File outFile;
    List<Author> allAuthors;
    /*
     * 
     */
    public WriteToFile(List<Author> authors) {
      formattedContent = new FormatContent(authors);
      this.allAuthors= authors;
      
      outFile = new File(MyParser.outFile);
      if (outFile.exists()) {
        outFile.delete();
      }
      this.fileName = MyParser.outFile;

    }
    
    /*
     * 
     */
    public void printAllAuthors() {
      try
      {   
          FileWriter fw = new FileWriter(this.fileName,true); //the true will append the new data
          fw.write(formattedContent.getFormattedString());//appends the string to the file
          fw.close();
      }
      catch(IOException ioe)
      {
          System.err.println("IOException: " + ioe.getMessage());
      }
    }
    
    /*
     * 
     */
    public void printAllCoAuthors() {
      FormatContent.addContentToCoAuthors();
      try
      {
          FileWriter fw = new FileWriter(MyParser.outFile,true); //the true will append the new data
          fw.write(FormatContent.getCoAuthorsString());//appends the string to the file
          fw.close();
      }
      catch(IOException ioe)
      {
          System.err.println("IOException: " + ioe.getMessage());
      }
      

    }

    @Override
    public List<Author> getAllAuthors() {
      return allAuthors;
    }



 

}
