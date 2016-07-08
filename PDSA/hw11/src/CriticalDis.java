import java.awt.geom.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by user on 2016/6/7.
 */
public class CriticalDis {


    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {

            int num = Integer.parseInt(br.readLine());
            ArrayList<Point2D> points = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                String[] temp = br.readLine().split("\\s");
                double x = Double.parseDouble(temp[0]);
                double y = Double.parseDouble(temp[1]);
                points.add(new Point2D(x, y));
            }


            int source = 0;
            int target = 0;

            double sTemp = points.get(0).x() + points.get(0).y();
            double tTemp = points.get(0).x() + points.get(0).y();
            for (int i = 1; i < num; i++) {
                double sum = points.get(i).x() + points.get(i).y();
                if (sum < sTemp) {
                    sTemp = sum;
                    source = i;
                } else if (sum > tTemp) {
                    tTemp = sum;
                    target = i;
                }
            }

            double d = 0;
            ArrayList<Double> distance = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num; j++) {
                    if (points.get(i).x() < points.get(j).x() && points.get(i).y() < points.get(j).y()) {
                        d = points.get(i).distanceTo(points.get(j));
                        distance.add(new distanceEvent(d, i, j));
                    }
                }
            }

//
//            ArrayList<Double> distance = new ArrayList<>();
//            ArrayList<Integer> indexV = new ArrayList<>();
//            ArrayList<Integer> indexW = new ArrayList<>();
//
//            for (int i = 0; i < num; i++) {
//                for (int j = 0; j < num; j++) {
//                    if (points.get(i).x() < points.get(j).x() &&
//                            points.get(i).y() < points.get(j).y()) {
//                        distance.add(points.get(i).distanceTo(points.get(j)));
//                        indexV.add(i);
//                        indexW.add(j);
//                    }
//                }
//            }
//

//            Digraph digraph = new Digraph(num);


//            while (!distance.isEmpty()) {
//                double d = distance.get(0);
//                int index = 0;
//                for (int i = 1; i < distance.size(); i++) {
//                    if (distance.get(i) < d) {
//                        d = distance.get(i);
//                        index = i;
//                    }
//
//                }
//
//
//                int v = indexV.get(index);
//                int w = indexW.get(index);
//
//                digraph.addEdge(v, w);
//                DirectedDFS dfs = new DirectedDFS(digraph, source);
//
//                if (!dfs.marked(target)) {
//                    distance.remove(d);
//                    indexV.remove(index);
//                    indexW.remove(index);
//                } else {
//                    System.out.println(String.format("%1.3f", d));
//                    break;
//                }
//
//
//            }


        }


    }

}

class distanceEvent implements Comparable<distanceEvent> {
    double d;
    int i;
    int j;

    public distanceEvent(double d, int i, int j) {
        this.d = d;
        this.i = i;
        this.j = j;
    }

    @Override
    public int compareTo(distanceEvent o) {
        if (d > o.d) return 1;
        else if (d < o.d) return -1;
        else return 0;
    }
}