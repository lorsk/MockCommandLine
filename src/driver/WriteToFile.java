package driver;

import java.io.File;

public class WriteToFile {

    File outFile;
    public WriteToFile(String fileName) {
      outFile = new File(fileName);
    }
}
