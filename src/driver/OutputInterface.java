package driver;

import java.util.List;

public interface OutputInterface {
  
  public void printAllAuthors();
  
  public void printAllCoAuthors();
  
  public List<Author> getAllAuthors();
}
