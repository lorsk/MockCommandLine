package a3Files;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;

/*
 * This program takes in the html file name (example: sample1.html) and then
 * returns the string that contains the raw HTML code
 */
public class RawHTMLContents {
  
  public static String getHTML(String urlString) throws Exception {
    // create object to store html source text as it is being collected
    StringBuilder html = new StringBuilder();
    // open connection to given url
    URL url = new File(urlString).toURI().toURL();
    // create BufferedReader to buffer the given url's HTML source
    BufferedReader htmlbr =
        new BufferedReader(new InputStreamReader(url.openStream()));
    String line;
    // read each line of HTML code and store in StringBuilder
    while ((line = htmlbr.readLine()) != null) {
      html.append(line);
    }
    htmlbr.close();
    // convert StringBuilder into a String and return it
    return html.toString();
  }

}
