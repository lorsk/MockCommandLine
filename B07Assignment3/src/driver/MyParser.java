//**********************************************************
//Assignment3:
//UTORID user_name:kushtovm 
//
//Author:Lors Kushtov
//
//
//Honor Code: I pledge that this program represents my own
//program code and that I have coded on my own. I received
//help from no one in designing and debugging my program.
//*********************************************************
package driver;

public class MyParser {

/**
* @param args
 * @throws Exception 
*/
public static void main(String[] args) throws Exception {
 DEBUGStarterCode(args);
}

/*
* This is a debug/helper method to help you get started. Once you understand
* how this method is being used, you are free to refactor it, modify it, or
* change it, or remove it entirely in any way you like.
*/
private static void DEBUGStarterCode(String[] args) throws Exception {
 try {
   System.out.println("DEBUG: URLS are " + args[0]);
   System.out.println("DEBUG: FileName is " + args[1]);
 } catch (Exception e) {
   System.out.println("Did you change the run configuration in"
       + "Eclipse for argument0 and argument 1?");
 }


 // TODO Auto-generated method stub
 String inputFiles[] = args[0].split(",");

 
 Author sampleOne = new Author(inputFiles[0]);
 Author sampleTwo = new Author(inputFiles[1]);
 Author sampleThree = new Author(inputFiles[2]);

 sampleOne.printObject.printAuthor();
 sampleTwo.printObject.printAuthor();
 sampleThree.printObject.printAuthor();

 WriteToConsole.printAllCoAuthors();
}

}
