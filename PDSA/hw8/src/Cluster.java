import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by cavitation on 2016/5/5.
 */
public class Cluster {


    public static void main(String[] args) throws Exception {

        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {

            String temp = br.readLine();
            int total = Integer.parseInt(temp);
//
////            ArrayList<Double> x = new ArrayList<>();
////            ArrayList<Double> y = new ArrayList<>();
//            for (int i = 0; i < total; i++) {
//                String[] temp2 = br.readLine().split(" ");
//                x.add(Double.parseDouble(temp2[0]));
//                y.add(Double.parseDouble(temp2[1]));
//            }


            ArrayList<Clustering> clus = new ArrayList<>();
            for (int i = 0; i < total; i++) {
                String[] temp2 = br.readLine().split(" ");
                point p = new point(Double.parseDouble(temp2[0]), Double.parseDouble(temp2[1]));
                Clustering c = new Clustering(p);
                clus.add(c);

            }



            br.close();


        }
    }


}