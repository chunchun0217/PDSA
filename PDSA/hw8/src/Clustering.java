import java.util.ArrayList;

/**
 * Created by cavitation on 2016/5/11.
 */
public class Clustering {

    double x;
    double y;

    ArrayList<point> points;

    Clustering(point p) {


        x = p.getX();
        y = p.getY();
        points.add(p);

    }

    public double getX() {
        return x;
    }

    public double getY() { return y; }

    public double distanceTo(Clustering that) {

        double x1 = this.x;
        double y1 = this.y;
        double x2 = that.y;
        double y2 = that.y;

        double distance = Math.


    }


}
