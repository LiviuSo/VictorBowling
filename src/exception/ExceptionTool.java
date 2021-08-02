package exception;

public class ExceptionTool {

   public static void checkIndex(int index, int bound) {
       if(index < 0 || index >= bound) {
           throw new ArrayIndexOutOfBoundsException();
       }
   }
}
