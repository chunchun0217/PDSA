import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/* Create by PG 2016/3/10 Percolation
*
* */

public class Percolation {
    public static void main(String args[]) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            // read file from args[0] in Java 7 style
            String[] data = br.readLine().split(" ");
            int num = Integer.parseInt(data[0]);
            // declare the arrays: row,column, father and the last row of the matrix(bottom)
            ArrayList<Integer> row = new ArrayList<>();
            ArrayList<Integer> column = new ArrayList<>();
            ArrayList<Integer> father = new ArrayList<>();
            ArrayList<Integer> bottom = new ArrayList<>();
            // set the top (0,0) and father to 0 (connect the first row to 0)
            row.add(0, 0);
            column.add(0, 0);
            father.add(0, 0);
            // read the rest content of the file
            while (br.ready()) {
                String[] temp = br.readLine().split(",");
                row.add(Integer.parseInt(temp[0]));
                column.add( Integer.parseInt(temp[1]));
            }
            // close the file
            br.close();

            // if communication is true, it is percolation
            boolean communication = false;

            for (int i = 1; i < row.size(); i++) {
                father.add(i, i);
                if (row.get(i) == 1) father.set(i, 0);
                if (row.get(i) == num) bottom.add(i);
                for (int j = 0; j < i; j++) {
                    if (isConnected(row, column, i, j)) {
                        int root = getRoot(father, j);
                        int root2 = getRoot(father, i);

                        if (row.get(root2) == row.get(root)) {
                            if (root < root2) father.set(root2, root);
                            else father.set(root, root2);
                        } else if (row.get(root) < row.get(root2)) {
                            father.set(root2, root);
                        } else {
                            father.set(root, root2);
                        }
                    }
                }

                if (checkBottom(bottom, father)) {
                    System.out.println(row.get(i) + "," + column.get(i));
                    communication = true;
                    break;
                }
                if (communication) break;
            }
            if (!communication) System.out.println(-1);
        }
    }

    //透過爸爸往上找祖先
    public static int getRoot(ArrayList<Integer> father, int index2) {
        while (index2 != father.get(index2)) index2 = father.get(index2);
        return index2;
    }

    //判斷是否相鄰
    public static boolean isConnected(ArrayList<Integer> row, ArrayList<Integer> column, int index1, int index2) {
        if (row.get(index1) == row.get(index2)) {
            if (column.get(index1) - column.get(index2) == 1 || column.get(index1) - column.get(index2) == -1)
                return true;
        }
        if (column.get(index1) == column.get(index2)) {
            if (row.get(index1) - row.get(index2) == 1 || row.get(index1) - row.get(index2) == -1) return true;
        }
        return false;
    }

    //檢查有沒有bottom

    //檢查bottom祖先跟祖先0是否相等
    public static boolean checkBottom(ArrayList<Integer> bottom, ArrayList<Integer> father) {
        for (int eachBottom : bottom) {
            int bottomRoot = getRoot(father, eachBottom);
            if (bottomRoot == father.get(0)) return true;
        }
        return false;
    }
}