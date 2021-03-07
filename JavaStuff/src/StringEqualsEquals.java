
public class StringEqualsEquals {

    public static void main(String[] args) {
        String s1 = "James Madison";
        String s2 = "Madison";
        String s3 = s2 = "James" + " " + s2;
        System.out.println(s2);
        System.out.println(s3);

        if (s1 == s3) {
            System.out.println("s1 and s3 are equal");
        } else {
            System.out.println("s1 and s3 are not equal");
        }

        if (s3 == s2) {
            System.out.println("s3 and s2 are equal");
        } else {
            System.out.println("s3 and s2 are not equal");
        }
    }
}
