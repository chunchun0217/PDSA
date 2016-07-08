import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


/**
 * Created by cavitation on 2016/5/26.
 */


public class Main {
//    public static void main(String[] args) {
//        Point2D[] points = new Point2D[5];
//        points[0] = new Point2D(0.4, 0.2);
//        points[1] = new Point2D(0.1, 0.5);
//        points[2] = new Point2D(0.2, 0.3);
//        points[3] = new Point2D(0.78, 0.1);
//        points[4] = new Point2D(0.6, 0.3);
//
//
////        FindNeighbors f = new FindNeighbors();
////            f.init(points);
////        test t = new test();
////        t.init(points);
//
//        Point2D p = new Point2D(0, 0);
////        t.query(p, 1);
//
//
//        double d = points[0].distanceTo(p);
//        double d2;
//        for (int i = 0; i < points.length; i++) {
//            d2 = points[i].distanceTo(p);
//            if (d2 < d) {
//                d = d2;
//            }
//        }
//        System.out.println(d);
//
//
//    }

    public static void main(String[] args) throws Exception {
        ArrayList<Point2D> pointsA = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {

            while (br.ready()) {
                String[] temp = br.readLine().split(" ");
                double x = Double.parseDouble(temp[0]);
                double y = Double.parseDouble(temp[1]);
//                pointsA.add(new Point2D(x, y));

            }


            for (int i = 0; i < 1000; i++) {
                pointsA.add(new Point2D(Math.random(), Math.random()));
            }


            Point2D[] points = new Point2D[pointsA.size()];
            for (int i = 0; i < pointsA.size(); i++) {
                points[i] = pointsA.get(i);
            }

//            test t = new test();
//            t.init(points);
//            Point2D p = new Point2D(0, 0);
//            t.query(p, 1);

            FindNeighbors f = new FindNeighbors();
            f.init(points);
            Point2D p = new Point2D(1, 0.5);
            Point2D[] result = f.query(p,3);

            for (Point2D n :result) {
                System.out.println(n.x() + "," + n.y());
            }


            double d = points[0].distanceTo(p);
            double d2;
            for (int i = 0; i < points.length; i++) {
                d2 = points[i].distanceTo(p);
                if (d2 < d) {
                    d = d2;
                }
            }
//            System.out.println(d);

            Point2D[] sortedArray = sort(points, p);
            System.out.println(String.format("%.3f,%.3f", sortedArray[0].x(), sortedArray[0].y()));


        }
    }

    public static Point2D[] sort(Point2D[] points, Point2D target) {
        points = points.clone();
        Arrays.sort(points, new Comparator<Point2D>() {
            @Override
            public int compare(Point2D o1, Point2D o2) {
                double d1 = o1.distanceTo(target);
                double d2 = o2.distanceTo(target);
                if (d1 > d2) return 1;
                else if (d1 < d2) return -1;
                else return 0;
            }
        });
        return points;

    }


}
