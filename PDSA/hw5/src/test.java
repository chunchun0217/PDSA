/**
 * Created by cavitation on 2016/4/14.
 */
public class test {
    public static void main(String[] args) {
    double[] array = {0.123, 0.5, 0.6, 0.1, 0.32, 0.58, 0.89, 0.11, 0.13};
//        double[] array = {7};

        sort(array);

        for (int j = 0; j < array.length; j++) System.out.print(array[j] + " ");


//        Point2D p0 = new Point2D(0,0);
//        Point2D p1 = new Point2D(0.2,0.3);
//        Point2D p2 = new Point2D(0.5,0.7);
//
//        System.out.println(Point2D.X_ORDER.compare(p1,p2));
//        System.out.println( p0.ATAN2_ORDER.compare(p1,p2) );
    }

    public static void sort(double[] array){
        sort(array , 0 , array.length-1);
    }

    public static void sort(double[] array, int start, int end) {
        boolean goOn = true;
        int i = start + 1;
        int n = end;

        if(start >= end) return;

        while (goOn) {
            while (array[start] >= array[i]) {
                if (i == end) break;
                i++;
            }

            while (array[start] <= array[n]) {
                if (n == start) break;
                n--;
            }


            if (i < n) {
                double temp = array[i];
                array[i] = array[n];
                array[n] = temp;
                goOn = true;
            } else {
                double temp = array[n];
                array[n] = array[start];
                array[start] = temp;
                goOn = false;
            }

        }
        sort(array,start,n - 1);
        sort(array,n + 1,end);
    }

}
