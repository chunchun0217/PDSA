/**
 * Created by cavitation on 2016/6/1.
 */
public class test {
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


    double minDis;
    Point2D nearestP;
    public Point2D[] query(Point2D point, int k) {

        minDis = root.getValue().distanceTo(point);
        queryHelper(root, point);

        System.out.println(minDis);
        System.out.println(nearestP.x());
        System.out.println(nearestP.y());
        Point2D[] result = new Point2D[k];
        return result;
        // the points should be sorted accordingly to their distances to the query, from small to large
    }

    private void queryHelper(Node root, Point2D point) {
        double disTemp;
        double disDeci;
        if (root == null) {
            return ;
        }

        if (root.getLeft() == null && root.getRight() == null) {
            disTemp = root.getValue().distanceTo(point);
            if (disTemp < minDis) {
                minDis = disTemp;
                nearestP = root.getValue();
            }
            return;
        }

        disTemp = root.getValue().distanceTo(point);
        if (disTemp < minDis) {
            minDis = disTemp;
            nearestP = root.getValue();
        }

        if (root.isVertical()) {
            if (point.x() < root.getValue().x()) {
                queryHelper(root.getLeft(), point);

                disDeci = Math.abs(root.getValue().x() - point.x());
                if (disDeci < minDis) {
                     queryHelper(root.getRight(), point);
                }


            } else {
                queryHelper(root.getRight(), point);

                disDeci = Math.abs(root.getValue().x() - point.x());
                if (disDeci < minDis) {
                    queryHelper(root.getLeft(), point);
                }


            }


        } else {
            if (point.y() < root.getValue().y()) {
                queryHelper(root.getLeft(), point);

                disDeci = Math.abs(root.getValue().y() - point.y());
                if (disDeci < minDis) {
                    queryHelper(root.getRight(), point);
                }

            } else {
                queryHelper(root.getRight(), point);

                disDeci = Math.abs(root.getValue().y() - point.y());
                if (disDeci < minDis) {
                    queryHelper(root.getLeft(), point);
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
