/**
 * Created by cavitation on 2016/3/22.
 */
public class Main {
    public static void main(String[] args) {
        Calculator cct = new Calculator();
        Double d = cct.ans("( ( ( 1 + ( 12 * 5 ) ) - ( 3 * 4 ) ) + ( 4 / 5 ) )");
        System.out.println(d);
    }
}
