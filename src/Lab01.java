/* this part is as comment similar to comments in Python
Lab01
Name:Eldad Opare (65542027)
Section:B
*/
public class Lab01 {
   public static void main(String[] arguments) {
      // declaring and initializing some variables
      byte x  = 12;
      String y = "WELCOME to O.O.Programming";
      float z = 3.1415f;

      // printing the initialized variables
      System.out.println("x:" + x + "  " + "y:" + y + " " + "z:" + z);

      // an array mimicking the list, nums
      byte nums[] = {5, 16, -8, 2, 11};
      for(byte num: nums){
         System.out.println(num + " ");
      }

      System.out.println();

      // calling the function char_count
      int numFound = char_count(y, 'C');

      System.out.println("Number of C in " + y);

      System.out.println("Found: " + numFound);

      System.out.println();

      // Printing an integer sequence from one to 14

      for(byte i = 1; i < 15; i++){
         System.out.print(i + " ");
      }


   }

   // function counts the given character in the given string


   static int char_count(String s, char c){
      int counter = 0;
      for(char ch : s.toCharArray()){
         if(ch == c){
            counter++;
         }
      }

      return counter;
   }
}
    

