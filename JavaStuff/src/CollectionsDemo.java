import java.util.*;

public class CollectionsDemo {

    public static void main(String[] args) {
        System.out.println("test");
        int[] arr = {1,2,3,4};
        CollectionsDemo test = new CollectionsDemo();
        System.out.println("is array an array = "+test.isArray(arr));
        List<Integer> hey = new ArrayList<>();
        hey.add(1);
        hey.add(2);
        hey.add(3);
        System.out.println("is list an array = "+test.isArray(hey));
    }

    public boolean isArray(Object a) {
        if(a.getClass().isArray()) {
            return true;
        }
        return false;
    }
}
