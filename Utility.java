import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

class Utility {
   public static void run(Counter<String, String> words) throws FileNotFoundException{
      Scanner terminal = new Scanner(System.in);
      System.out.println("Give the name of a file for analysis:");
      String fileName = terminal.next();
      Scanner input = new Scanner(new File(fileName));
      input.useDelimiter("\\W+");

      while (input.hasNext()) {
         String word = input.next();
         String keyWord = Utility.dropS(word);
         words.put(keyWord, word);
         /*Puts words into the map we create from a file. The keyword is a lower case
         *version of the word with no s at the end.*/
      }
      for (String word : words.keySet()){
        if (words.getCount(word) > 2)
           System.out.println(word +":\t" +"Total count"+":\t"+words.getCount(word)+ "\t"+words.get(word));
      }

      input.close();
      terminal.close();
   }

   static String dropS(String word) {
      String ans = word.toLowerCase();
      if (ans.endsWith("s"))
         return ans.substring(0, ans.length() - 1);
      return ans;
   }
}
