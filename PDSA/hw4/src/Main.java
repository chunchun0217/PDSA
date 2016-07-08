import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by cavitation on 2016/3/26.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<String> arr ;
        arr = new ArrayList<>();
        arr.add("123");
        arr.get(0);


        int[] a = new int[10];
        a[0] = a[-1];
        a[0] = 1;
        System.out.println(a[0]);

        Deque<String> d = new Deque<String>();

//        for(int i = 1; i < 1000; i++){
//            d.addFirst(i+"");
//        }

        d.addFirst("123");

       Iterator<String> r = d.iterator();
        while(r.hasNext()) System.out.println(r.next());


    }
}
