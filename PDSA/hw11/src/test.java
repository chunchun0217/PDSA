import java.util.ArrayList;

/**
 * Created by user on 2016/6/7.
 */
public class test {

    public static void main(String[] args) {
        ArrayList<Integer> pp = new ArrayList<>();
        pp.add(1);
        pp.add(2);
        pp.add(3);
        pp.add(4);


        pp.remove(2);
        System.out.println(pp.indexOf(4));
        System.out.println(pp.get(2));

    }
}
