import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by cavitation on 2016/5/11.
 */
public class ClusterA {

    public static void main(String[] args) throws Exception{
        try(BufferedReader br = new BufferedReader(new FileReader(args[0]))){

            String temp = br.readLine();
            int total = Integer.parseInt(temp);

            double[] x = new double[total];
            double[] y = new double[total];
            for (int i = 0; i < total; i++) {
                String[] temp2 = br.readLine().split(" ");
                x[i] = Double.parseDouble(temp2[0]);
                y[i] = Double.parseDouble(temp2[1]);
            }


            int[] root = new int[total];
            for (int i = 0; i < total; i++) {
                root[i] = i;
            }


            int mergeP1, mergeP2;
//            double nearDis = getDistance(x[0], x[1], y[0], y[1]);
            for (int i = 1; i < x.length; i++) {
                for (int j = i + 1 ; j < x.length; j++) {

                    if (x[i].ea null )



                    double tempDis = getDistance(x[i], y[i], x[j], y[j]);
                    if (nearDis != null && tempDis < nearDis) {
                        nearDis = tempDis;
                        mergeP1 = i;
                        mergeP2 = j;
                    }

                }
            }



        }

    }







    public static double getDistance(double x1, double y1, double x2, double y2) {
        double distance = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
        return distance;
    }




}
