package TP2.trees;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Mateus Fernandes, adapted from: https://github.com/kostyaev/2D-Tree
 */

public class KdTree<T> {
    /**
     * Method that comparates the X coordenates of 2 points
     */
    private final Comparator<Node<T>> cmpX = new Comparator<Node<T>>() {
        @Override
        public int compare(Node<T> p1, Node<T> p2) {
            return Double.compare(p1.getX(), p2.getY());
        }
    };
    /**
     * Method that comparates the Y coordenates of 2 points
     */
    private final Comparator<Node<T>> cmpY = new Comparator<Node<T>>() {
        @Override
        public int compare(Node<T> p1, Node<T> p2) {
            return Double.compare(p1.getY(), p2.getY());
        }
    };

    private Node<T> root;
    private int size;
    /**
     * Constructor method
     */
    public KdTree(){
        //Empty
    }
    /**
     * Method to balance the tree
     */
    public void balanceTree(){
        if (root != null){
            List<Node<T>> list = new ArrayList<>();
            balanceTreeRec(root, list);
            balancedKdTree(list);
        }
    }
    /**
     * Recursive method to create a List with all elements of the KdTree
     *
     * @param node Root of the tree
     * @param list List with the elements
     */
    private void balanceTreeRec(Node<T> node, List<Node<T>> list){
        if (node == null)
            return;
        balanceTreeRec(node.left, list);
        list.add(node);
        balanceTreeRec(node.right, list);
    }
    /**
     * Recursive method that balances the tree
     *
     * @param nodesList List with all the nodes in the tree
     */
    private void balancedKdTree(List<Node<T>> nodesList) {
        root = new Object() {
            Node<T> buildTree(List<Node<T>> nodesList, boolean divX) {
                if (nodesList == null || nodesList.isEmpty())
                    return null;
                nodesList.sort(divX ? cmpX : cmpY);
                int mid = nodesList.size() >> 1;
                Node<T> node = new Node<>(nodesList.get(mid).getInfo(),nodesList.get(mid).coords.getX(), nodesList.get(mid).coords.getY());
                node.left = buildTree(nodesList.subList(0, mid), !divX);
                if (mid + 1 < nodesList.size() - 1)
                    node.right = buildTree(nodesList.subList(mid+1, nodesList.size()), !divX);
                return node;
            }
        }.buildTree(nodesList, true);
    }
    /**
     * Method that checks if the tree is empty
     *
     * @return returns boolean that shows if it's empty or not
     */
    public boolean isEmpty(){
        return root == null;
    }
    /**
     * Method to find the nearest node of a given node
     *
     * @param x X coordenate of the node
     * @param y Y coordenate of the node
     * @return returns info of nearest node
     */
    public T findNearestNeighbour(double x, double y) {
        return findNearestNeighbour(root, x, y,true).getInfo();
    }
    /**
     * Recursive method to find the nearest node of a given node
     *
     * @param x X coordenate of the node
     * @param y Y coordenate of the node
     * @param fromNode Root of the tree
     * @param divX Boolean to know which coordenate needs to be used
     * @return returns nearest node
     */
    private Node<T> findNearestNeighbour(Node<T> fromNode, final double x, final double y, boolean divX) {
        return new Object() {
            double closestDist = Double.POSITIVE_INFINITY;

            Node<T> closestNode = null;

            Node<T> findNearestNeighbour(Node<T> node, boolean divX) {
                if (node == null)
                    return null;
                double d = Point2D.distanceSq(node.coords.x, node.coords.y, x, y);
                if (closestDist > d) {
                    closestDist = d;
                    closestNode = node;
                }
                double delta = divX ? x - node.coords.x : y - node.coords.y;
                double delta2 = delta * delta;
                Node<T> node1 = delta < 0 ? node.left : node.right;
                Node<T> node2 = delta < 0 ? node.right : node.left;
                findNearestNeighbour(node1, !divX);
                if (delta2 < closestDist) {
                    findNearestNeighbour(node2, !divX);
                }
                return closestNode;
            }
        }.findNearestNeighbour(fromNode, divX);
    }
    /**
     * Method to insert a node in the tree
     *
     * @param object Info of the object in the node
     * @param x X coordenate of the node
     * @param y Y coordenate of the node
     */
    public void insert(T object, double x, double y) {
        Node<T> node = new Node<>(object, x, y);
        if (isEmpty()){
            root = node;
            size++;
        }else{
            insert(node, root, true);
        }
    }
    /**
     * Recursive method to insert a node in the tree
     *
     * @param node Node that will be inserted
     * @param currentNode Root of the tree
     * @param divX Boolean to know which coordenate needs to be used
     */
    private void insert(Node<T> node, Node<T> currentNode, boolean divX) {
        if (node.getCoords().equals(currentNode.getCoords())){
            return;
        }

        int cmpResult = (divX ? cmpX : cmpY).compare(node, currentNode);

        if (cmpResult == -1){
            if(currentNode.left == null){
                currentNode.left = node;
                size++;
            }else {
                insert(node, currentNode.left, !divX);
            }
        }else {
            if(currentNode.right == null){
                currentNode.right = node;
                size++;
            }else {
                insert(node, currentNode.right, !divX);
            }
        }
    }

    /**
     * Method that returns all nodes in order
     *
     */
    public Iterable<T> inOrder() {
        List<T> snapshot = new ArrayList<>();
        if (root != null)
            inOrder(root, snapshot);
        return snapshot;
    }
    /**
     * Recursive method that returns all nodes in ordert
     *
     * @param node Root of the tree
     * @param snapshot List with nodes in order
     */
    private void inOrder(Node<T> node, List<T> snapshot) {
        if (node == null)
            return;
        inOrder(node.left, snapshot);
        snapshot.add(node.getInfo());
        inOrder(node.right, snapshot);
    }
    /**
     * Method that returns the size of the tree
     *
     */
    public int size() {
        return size;
    }

    protected static class Node<T> {
        protected Point2D.Double coords;
        protected T info;
        protected Node<T> left;
        protected Node<T> right;
        /**
         * Constructor method of node class
         *
         * @param info Data in node
         * @param x X coordenate of node
         * @param y Y coordenate of node
         */
        public Node(T info, double x, double y) {
            this.coords = new Point2D.Double(x,y);
            this.info = info;
        }
        /**
         * Method that returns data in node
         *
         * @return returns info of the node
         */
        public T getInfo() {
            return info;
        }
        /**
         * Method that returns the coordenates of the node
         *
         * @return returns coordenates of the node
         */
        public Point2D.Double getCoords() {
            return coords;
        }
        /**
         * Method that returns X coordenate of node
         *
         * @return returns x coordenate of the node
         */
        public Double getX() {
            return coords.x;
        }
        /**
         * Method that returns Y coordenate of node
         *
         * @return returns y coordenate of the node
         */
        public Double getY() {
            return coords.y;
        }
    }
}