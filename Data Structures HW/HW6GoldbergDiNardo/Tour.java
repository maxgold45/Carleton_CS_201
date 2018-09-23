
/**
 * This class creates a Tour of Points using a
 * Linked List implementation.  The points can
 * be inserted into the list using two heuristics.
 *
 * @author Max Goldberg, Zach DiNardo
 * @author Layla Oesper, modified code 09-22-2017
 */
public class Tour {

    /**
     * A helper class that defines a single node for use in a tour. A node consists of a Point,
     * representing the location of that city in the tour, and a pointer to the next Node in the
     * tour.
     */
    private class Node {

        private Point p;
        private Node next;

        /**
         * Constructor creates a new Node at the given Point newP with an intital next value of
         * null.
         *
         * @param newP - the point to associate with the Node.
         */
        public Node(Point newP) {
            p = newP;
            next = null;
        }

        /**
         * Constructor creates a new Node at the given Point newP with the specified next node.
         *
         * @param newP - the point to associate with the Node.
         * @param nextNode - the nextNode this node should point to.
         */
        public Node(Point newP, Node nextNode) {
            p = newP;
            next = nextNode;
        }

        /**
         * Return the Point associated with this Node. (Same value can also be accessed from a Node
         * object node using node.p)
         *
         * @return The Point object associated with this node.
         */
        public Point getPoint() {
            return p;
        }

        /**
         * Return the next Node associated with this Node. (Same value can also be accessed from a
         * Node object node using node.next)
         *
         * @return The next Node object linked from this node..
         */
        public Node getNext() {
            return next;
        }

    } // End Node class

    // Tour class Instance variables
    private Node head;
    private int size; //number of nodes
    //Add other instance variables you think might be useful.

    /**
     * Constructor for the Tour class. By default sets head to null.
     */
    public Tour() {
        head = null;
        size = 0;
    }

    /**
     * @return Returns a description of the tour as a nicely formatted string.
     */
    @Override
    public String toString() {
        String ret = "";
        Node temp = head;
        while (temp.next != null) {
            ret += temp.getPoint() + "\n";
            temp = temp.next;
        }
        ret += temp.getPoint();
        return ret;
    }

    /**
     * Draws the tour.
     */
    public void draw() {
        Node temp = head;
        while (temp.next != null) {
            temp.getPoint().drawTo(temp.next.getPoint());
            temp = temp.next;
        }
        temp.getPoint().drawTo(head.getPoint());
    }

    /**
     * @return the number of points, or stops in the tour.
     */
    public int size() {
        return size;
    }

    /**
     * @return total distance of the tour
     */
    public double distance() {
        double distance = 0;
        Node temp = head;
        while (temp.next != null) {
            distance += temp.getPoint().distanceTo(temp.next.getPoint());
            temp = temp.next;
        }
        distance += temp.getPoint().distanceTo(head.getPoint());
        return distance;
    }

    /**
     * Inserts p into the tour using the nearest neighbor heuristic.
     *
     * @param p the point we are inserting.
     */
    public void insertNearest(Point p) {
        Node iterator = head;
        Node currentNode = head;
        double minDist = Double.MAX_VALUE;
        while (iterator != null) {
            if (iterator.getPoint().distanceTo(p) < minDist) {
                minDist = iterator.getPoint().distanceTo(p);
                currentNode = iterator;
            }
            iterator = iterator.next;
        }

        if (size == 0) {
            head = new Node(p);
        } else {
            Node newNode = new Node(p, currentNode.next);
            currentNode.next = newNode;
        }
        size++;
    }

    /**
     * Inserts p into the tour using the smallest insertion heuristic.
     *
     * @param p the point we are inserting.
     */
    public void insertSmallest(Point p) {
        Point currentPoint;
        Point nextPoint;
        Node iterator = head;
        Node index = head;
        double smallestDist = Double.MAX_VALUE;
        double currentTotalDistance = 0;
        double newDistance = 0;

        while (iterator != null) {
            currentPoint = iterator.getPoint();
            if (iterator.next == null) {
                nextPoint = head.getPoint();
            } else {
                nextPoint = iterator.next.getPoint();
            }
            newDistance = currentTotalDistance - currentPoint.distanceTo(nextPoint)
                    + currentPoint.distanceTo(p) + p.distanceTo(nextPoint);
            if (newDistance < smallestDist) {
                smallestDist = newDistance;
                index = iterator;
            }
            iterator = iterator.next;
        }
        if (size == 0) {
            head = new Node(p);
        } else {
            Node newNode = new Node(p, index.next);
            index.next = newNode;
        }
        size++;
    }

    public static void main(String[] args) {
        /* Use your main() function to test your code as you write it. 
         * This main() will not actually be run once you have the entire
         * Tour class complete, instead you will run the NearestInsertion
         * and SmallestInsertion programs which call the functions in this 
         * class. 
         */

        //One example test could be the follow (uncomment to run):
        Tour tour = new Tour();
        Point p = new Point(0, 0);
        tour.insertSmallest(p);
        p = new Point(0, 100);
        tour.insertSmallest(p);
        p = new Point(100, 100);
        tour.insertSmallest(p);
        System.out.println("Tour distance =  " + tour.distance());
        System.out.println("Number of points = " + tour.size());
        System.out.println(tour);

        // the tour size should be 3 and the distance 341.42 (don't forget to include the trip back
        // to the original point)
        // uncomment the following section to draw the tour, setting w and h to the max x and y 
        // values that occur in your tour points
        int w = 100; //Set this value to the max that x can take on
        int h = 100; //Set this value to the max that y can take on
        StdDraw.setCanvasSize(w, h);
        StdDraw.setXscale(0, w);
        StdDraw.setYscale(0, h);
        StdDraw.setPenRadius(.005);
        tour.draw();

    }

}
