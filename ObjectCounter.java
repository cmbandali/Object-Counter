import java.io.FileNotFoundException;
import java.util.Set;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;


public class ObjectCounter<X extends Comparable<X>, Y> implements Counter<X, Y> {

      /*Main method*/
      public static void main(String args[]) throws FileNotFoundException {
         Counter<String, String> x = new ObjectCounter<String, String>();
         Utility.run(x);
      }

      /*Field*/
      private TreeMap<X, ArrayList<Y>> map;

      /*Constructor*/
      public ObjectCounter() {
         map = new TreeMap<>();
      }

      /*Methods*/

      /*Returns a String of all the different values found*/
      public String get(X word) {
         //Makes a copy of the keys values
         List<Y> values = new ArrayList<>( map.get(word) );
         StringBuilder ans = new StringBuilder();
         //Calls an aux recursive method
         get(values, ans);
         //returns a nonrepetative list of distinct values
         return ans.toString();
      }

      /*Returns the number of values found for a certain key*/
      public int getCount(X word) {
         return map.get(word).size();
      }

      /*Returns a set of all of the keys*/
      public Set<X> keySet() {
         return map.keySet();
      }

      /*If the keyWord is already present within the map, another value is
       *Assigned to it. Else the keyword is added to the map with its value*/
      public void put(X keyWord, Y word) {
         ArrayList<Y> value;
         //If the keyword is not in the map, create new ArrayList, add Y
         //Put the key into the map
         if(map.get(keyWord) == null){
            value = new ArrayList<>();
            value.add(word);
            map.put(keyWord, value);
            return;
          }
          //If the key is present within the map, add the new value to the keys values
          value = map.get(keyWord);
          value.add(word);
      }


      // declare any required instance variables or helpful auxiliary types and methods here


      /*Auxillary Recursive Method for get(x) method*/
      private void get(List<Y> value, StringBuilder ans) {
        //If the copied list of values is empty, do nothing
        if(value.size()==0) return;
        //create a copy of the value to be removed from the copied List of values
        //Remove the value
        Y pattern = value.get(0);
        List<Y> removable = new ArrayList<>();
        removable.add(pattern);
        value.removeAll(removable);
        //Append the value to the ArrayList
        if( ans.length()==0 ) ans.append(pattern);
        else ans.append( ", "+pattern );
        //recursively call the function for the remainder of the list
        get(value,ans);

      }

}
