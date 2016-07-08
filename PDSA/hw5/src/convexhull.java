import java.awt.geom.*;
import java.util.*;

/**
 * Created by cavitation on 2016/4/14.
 */

public class convexhull {

    public static void main(String[] args) {
        int num = 10;
        Point2D[] point2Ds = new Point2D[num];
        for (int i = 0; i < num; i++) {
            double x = Math.random();
            double y = Math.random();
            point2Ds[i] = new Point2D(x, y);
            System.out.println(i + ":" + String.format("(%.3f,%.3f)", x, y));
        }

        ArrayList<Point2D> PG = new ArrayList<>();
        for(int i = 0; i < point2Ds.length; i++) {
            PG.add(point2Ds[i]);
        }


        int minIndex = getMin(point2Ds);
        Point2D min = point2Ds[minIndex];

        Comparator<Point2D> comparator = min.ATAN2_ORDER;
        sort(point2Ds, comparator);

        Stack<Point2D> data = new Stack<Point2D>();
        data.push(point2Ds[0]);
        data.push(point2Ds[1]);

        for (int i = 2; i < point2Ds.length; i++) {
            Point2D b = data.pop();
            Point2D c = data.pop();
            Point2D a = point2Ds[i];

            while (Point2D.ccw(c, b, a) != 1) {
                b = c;
                c = data.pop();
            }
            data.push(c);
            data.push(b);
            data.push(a);
        }


        int[] index = new int[data.size()];
        int count = 0;
        while (!data.isEmpty()) {
            Point2D p = data.pop();
            int i = PG.indexOf(p);
            index[count++] = i;
        }


        int[] index2 = new int[index.length];
        for(int i = 0; i < index.length; i++) {
            index2[i] = index[index.length-1-i];
        }


        for(int i:index2){
            System.out.println(i);
        }




        StdDraw.setCanvasSize(800, 800);
        StdDraw.setXscale(-0.1, 1.1);
        StdDraw.setYscale(-0.1, 1.1);
        StdDraw.setPenRadius(0.015);
        int counter = 0;
        for (Point2D p : point2Ds) {
            p.draw();
            StdDraw.text(p.x() + 0.03, p.y(), counter++ + "(" + PG.indexOf(p) + ")");
        }


        StdDraw.setPenColor(StdDraw.MAGENTA);
        min.draw();

        for(int i : index) {
            PG.get(i).draw();
        }


    }


    public static int getMin(Point2D[] a) {
        double min = a[0].y();
        int minIndex = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i].y() < min) {
                min = a[i].y();
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void sort(Point2D[] array, Comparator<Point2D> c) {
        sort2(array, 0, array.length - 1, c);
    }

    public static void sort2(Point2D[] array, int start, int end, Comparator<Point2D> c) {

        boolean goOn = true;
        int i = start + 1;
        int n = end;

        if (start >= end) return;

        while (goOn) {
            while (c.compare(array[start], array[i]) != -1) {
                if (i == end) break;
                i++;
            }

            while (c.compare(array[start], array[n]) != 1) {
                if (n == start) break;
                n--;
            }


            if (i < n) {
                Point2D temp = array[i];
                array[i] = array[n];
                array[n] = temp;
                goOn = true;
            } else {
                Point2D temp = array[n];
                array[n] = array[start];
                array[start] = temp;
                goOn = false;
            }

        }
        sort2(array, start, n - 1, c);
        sort2(array, n + 1, end, c);
    }


//
}
