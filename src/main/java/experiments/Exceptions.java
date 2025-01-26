package experiments;

public class Exceptions {
    public static void main(String[] args) {

        String[] strArray = {"str1","str2","str3"};
        uncheckedExceptions(strArray);

        try {
            pause();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void uncheckedExceptions(String []strArray){
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(strArray[i]);
            }
        }catch (ArrayIndexOutOfBoundsException e){
        e.printStackTrace();
            System.out.println("created exception");
        }
        System.out.println("program is working");
    }
   //======================================================
   private static void pause() throws InterruptedException {
        checkedException();
       System.out.println("pause 3 sec");
   }

   private static void checkedException() throws InterruptedException {
        Thread.sleep(3000);
   }

}
