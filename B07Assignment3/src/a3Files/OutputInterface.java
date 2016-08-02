package a3Files;

import java.util.List;

public interface OutputInterface {
  
  /*
   * This is steps 1-6 from the information that is needed to be outputted
   * This method will output the string that contains all of the
   * authors in the proper format. The type of output (to File or Console)
   * will be determined by the type of instance. 
   */
  public void printAllAuthors();
  
  /*
   * This is step 7. from the information that is needed to be outputted
   * This method will output the string that contains all of the
   * co-authors in the proper format. The type of output (to File or Console)
   * will be determined by the type of instance. 
   */
  public void printAllCoAuthors();
  
  /*
   * This method returns a list of all the author objects
   */
  public List<Author> getAllAuthors();
}
