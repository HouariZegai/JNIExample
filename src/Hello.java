import java.nio.file.FileSystems;

public class Hello {

    // Ensure library is only loaded once
    static {
        // Windows based
        try {
            System.load(
                    FileSystems.getDefault().getPath("./src/cpplib/PCGLib.dll")  // Dynamic link
                            .normalize().toAbsolutePath().toString());
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Hello().sayHello();
    }

    public native boolean sayHello();

    public native boolean pcg(long seed, long sequence, long rng1, long rng2);
}