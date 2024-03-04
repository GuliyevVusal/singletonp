public class Singleton {

    private static Singleton singletonObj;

    private static int count = 0;

    private Singleton() {
        System.out.println("I was created..");
    }

    public static Singleton getInstance() {
        if (singletonObj == null) {
            synchronized (Singleton.class) {
                if (singletonObj == null) {
                    singletonObj = new Singleton();
                }
            }
        }
        count++;
        System.out.println(count);
        return singletonObj;
    }
}

