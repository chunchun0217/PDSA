import java.util.Comparator;

public class FindNeighbors {

    public Node root;

    public void init(Point2D[] points) {
        root = new Node(null, null, points[0]);
        root.setisVertical(true);
//        System.out.println(root.getValue().y());

        for (int i = 1; i < points.length; i++) {
            Node arrow = root;
            Node now = new Node(null, null, points[i]);


            while (true) {
                if (arrow.isVertical) {
                    if (arrow.getValue().x() > now.getValue().x()) {
                        if (arrow.getLeft() == null) {
                            arrow.setLeft(now);
                            now.setisVertical(false);
                            break;
                        } else {
                            arrow = arrow.getLeft();

                        }
                    } else {
                        if (arrow.getRight() == null) {
                            arrow.setRight(now);
                            now.setisVertical(false);
                            break;
                        } else {
                            arrow = arrow.getRight();

                        }
                    }
                } else {
                    if (arrow.getValue().y() > now.getValue().y()) {
                        if (arrow.getLeft() == null) {
                            arrow.setLeft(now);
                            now.setisVertical(false);
                            break;
                        } else {
                            arrow = arrow.getLeft();
                        }
                    } else {
                        if (arrow.getRight() == null) {
                            arrow.setRight(now);
                            now.setisVertical(false);
                            break;
                        } else {
                            arrow = arrow.getRight();
                        }
                    }
                }
            }
        }
    }


    MaxPQ<Point2D> pq;

    public Point2D[] query(Point2D point, int k) {
        pq = new MaxPQ<>(new Comparator<Point2D>() {
            @Override
            public int compare(Point2D o1, Point2D o2) {
                double d1 = o1.distanceTo(point);
                double d2 = o2.distanceTo(point);

                if (d1 > d2) return 1;
                else if (d1 < d2) return -1;
                return 0;
            }
        });
        queryHelper(root, point, k);


        Point2D[] result = new Point2D[k];
        for (int i = k-1; i >= 0 ; i--) {
            result[i] = pq.delMax();
        }


        return result;
        // the points should be sorted accordingly to their distances to the query, from small to large
    }

    private void queryHelper(Node root, Point2D point, int k) {
        double disTemp;
        double disDeci;

        if (root == null) {
            return;
        }

        if (root.getLeft() == null && root.getRight() == null) {
            pq.insert(root.getValue());
            if (pq.size() > k) {
                pq.delMax();
            }
            return;
        }

        pq.insert(root.getValue());
        if (pq.size() > k) {
            pq.delMax();
        }


        if (root.isVertical()) {
            if (point.x() < root.getValue().x()) {
                queryHelper(root.getLeft(), point, k);

                disDeci = Math.abs(root.getValue().x() - point.x());
                Point2D temp = pq.delMax();
                disTemp = temp.distanceTo(point);
                pq.insert(temp);
                if (disDeci < disTemp) {
                    queryHelper(root.getRight(), point, k);
                }


            } else {
                queryHelper(root.getRight(), point, k);

                disDeci = Math.abs(root.getValue().x() - point.x());
                Point2D temp = pq.delMax();
                disTemp = temp.distanceTo(point);
                pq.insert(temp);
                if (disDeci < disTemp) {
                    queryHelper(root.getLeft(), point, k);
                }

            }


        } else {
            if (point.y() < root.getValue().y()) {
                queryHelper(root.getLeft(), point, k);

                disDeci = Math.abs(root.getValue().y() - point.y());
                Point2D temp = pq.delMax();
                disTemp = temp.distanceTo(point);
                pq.insert(temp);
                if (disDeci < disTemp) {
                    queryHelper(root.getRight(), point, k);
                }

            } else {
                queryHelper(root.getRight(), point, k);

                disDeci = Math.abs(root.getValue().y() - point.y());
                Point2D temp = pq.delMax();
                disTemp = temp.distanceTo(point);
                pq.insert(temp);
                if (disDeci < disTemp) {
                    queryHelper(root.getLeft(), point, k);
                }


            }
        }

    }



    public static class Node {
        private Node left;
        private Node right;
        private Point2D value;
        private boolean isVertical;

        public Node(Node left, Node right, Point2D value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public Node getLeft() {
            return (this.left);
        }

        public Node getRight() {
            return (this.right);
        }

        public Point2D getValue() {
            return (this.value);
        }

        public boolean isVertical() {
            return (this.isVertical);
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public void setValue(Point2D value) {
            this.value = value;
        }

        public void setisVertical(boolean isVertical) {
            this.isVertical = isVertical;
        }
    }

}



