import java.io.BufferedReader;
import java.io.FileReader;
import java.text.Format;

/**
 * Created by cavitation on 2016/6/26.
 */
public class FindHub {

//    public static void main(String[] args) {
//        EdgeWeightedGraph g = new EdgeWeightedGraph(20);
//
//        Edge e = new Edge(0,1,0.1);
//
//        g.addEdge(e);
//
//        KruskalMST k = new KruskalMST(g);
//
//        EdgeWeightedDigraph g2 = new EdgeWeightedDigraph(20);
//
//        for (Edge edge : k.edges()){
//            int v = edge.either();
//            int w = edge.other(v);
//            double m = edge.weight();
//            DirectedEdge e2 = new DirectedEdge(v,w,m);
//            DirectedEdge e3 = new DirectedEdge(w,v,m);
//            g2.addEdge(e2);
//            g2.addEdge(e3);
//        }
//
//
//        DijkstraSP dijkstraSP = new DijkstraSP(g2,0);
//        double d =0;
//        d += dijkstraSP.distTo(1);
//
//
//    }




        public static void main(String[] args) throws Exception {
            try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
                int num = Integer.parseInt(br.readLine());

                Point2D[] points = new Point2D[num];
                for (int i = 0; i < num; i++) {
                    String temp[] = br.readLine().split("\\s");
                    double x = Double.parseDouble(temp[0]);
                    double y = Double.parseDouble(temp[1]);
                    points[i] = new Point2D(x, y);
                }

                EdgeWeightedGraph edgeWG = new EdgeWeightedGraph(num);

                for (int i = 0; i < num; i++) {
                    for (int j = 0; j < num; j++) {
                        double w = points[i].distanceTo(points[j]);
                        Edge e = new Edge(i, j, w);
                        edgeWG.addEdge(e);
                    }
                }

                KruskalMST kruskalMST = new KruskalMST(edgeWG);

                EdgeWeightedDigraph edgeDWG = new EdgeWeightedDigraph(num);
                for (Edge edge : kruskalMST.edges()) {
                    int v = edge.either();
                    int w = edge.other(v);
                    Double m = edge.weight();
                    DirectedEdge e = new DirectedEdge(v, w, m);
                    DirectedEdge e2 = new DirectedEdge(w, v, m);
                    edgeDWG.addEdge(e);
                    edgeDWG.addEdge(e2);
                }


                double[] dis = new double[num];
                for (int i = 0; i < num; i++) {
                    DijkstraSP dijkstraSP = new DijkstraSP(edgeDWG, i);
                    double d = 0;
                    for (int j = 0; j < num; j++) {
                        d += dijkstraSP.distTo(j);
                    }
                    dis[i] = d;
                }

                double sp = dis[0];
                for (int i = 1; i < num; i++) {
                    if (dis[i] < sp) {
                        sp = dis[i];
                    }
                }

                System.out.println(String.format("%5.5f\n",sp));


            }


        }

    }


