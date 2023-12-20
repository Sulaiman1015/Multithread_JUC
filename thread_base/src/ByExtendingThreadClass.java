public class ByExtendingThreadClass {
    public static void main(String[] args) {
        /*
         * 1. Define a class 'MythreadByExtends' to heritage Thread class
         * 2. Override run methods in the class 'MythreadByExtends'
         * 3. Create an object of a subclass in main class to run the thread
         * But no return value
         */

        MythreadByExtends mt1 = new MythreadByExtends();
        MythreadByExtends mt2 = new MythreadByExtends();
        mt1.setName("T1");
        mt2.setName("T2");
        mt1.start();
        mt2.start();

    }
}
