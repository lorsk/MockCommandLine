package driver;

import java.io.File;

public class WriteContentsToFile {

    File outFile;
    public WriteContentsToFile(String fileName) {
      outFile = new File(fileName);
    }
}
