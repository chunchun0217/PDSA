/**
 * Created by cavitation on 2016/4/14.
 */
public class Main {
    public static void main(String[] args) {
        double b,c;

        Point2D[] a = new Point2D[10];

        StdDraw.setCanvasSize(800, 800);
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);
        StdDraw.setPenRadius(.03);
        int yMin = 0;

        for (int i = 0; i < 10; i++) {
            b = StdRandom.uniform();
            c = StdRandom.uniform();
            a[i] = new Point2D(b,c);
            System.out.println(a[i].x() +" / "+ a[i].y());
            a[i].draw();
            StdDraw.text(b,c+0.03, (int)(b*1000)/1000.0+" / "+ (int)(c*1000)/1000.0 + "(" + i + ")");
            int yOrder = Point2D.Y_ORDER.compare(a[yMin],a[i]);
            if (yOrder == 1)
                yMin = i;
        }
        StdDraw.setPenColor(StdDraw.RED);
        a[yMin].draw();

        for(int i = 1; i < 10; i ++) {
            int angleYa = a[yMin].ATAN2_ORDER.compare(a[i - 1],a[i]);




//            System.out.println(angleYa);
        }





    }
}
