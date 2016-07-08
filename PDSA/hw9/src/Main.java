/**
 * Created by cavitation on 2016/5/20.
 */
public class Main {
    public static void main(String[] args) {
        String infix = "(4+(((4*2)/2)/3))";
//        String infix = "(4+(2+3))";
        Expression exp = new Expression();
        Node root = exp.Infix2BT(infix);
//        System.out.println(root.getValue());
//        System.out.println(root.getLeft().getValue());
//        System.out.println(root.getRight().getValue());
//        System.out.println(root.getRight().getLeft().getValue());

//
        Node[] prefix = exp.PrintPrefix();
//        for (Node p: prefix) {
//            System.out.print(p.getValue() + " ");
//        }
//
        exp.PrintPostfix();
        Node[] postfix = exp.PrintPostfix();
//        for (Node p: postfix) {
//            System.out.print(p.getValue() + " ");
//        }
        exp.EvalutionRec();
        double answer = exp.Evaluation();
//        System.out.println(answer);

    }

}

