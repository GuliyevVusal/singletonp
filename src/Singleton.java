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
/*
/
 Then if we are working in a multi-threaded environment and the getInstance method
 is called simultaneously both instances could be null and both could create separate objects
 In that case we can make this method thread-safe by using the synchronized keyword However
 using the synchronized keyword slows down the method's execution The solution is to use the
 synchronized keyword only when needed, which is during the initial creation of the object So
 our only concern is when the object is being created By adding just a null check we can
 eliminate the problem. This way synchronized will only work when the singleton is null
 and it will only run once In subsequent calls as the object is already created synchronized
 won't be needed thus not slowing down the program and it will just return the existing object
 */
