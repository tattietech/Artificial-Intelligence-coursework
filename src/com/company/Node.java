package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Node {
    private Node parent;
    private List<Node> neighbors = new ArrayList<Node>();
    private int x;
    private int y;
    private double g; // The cost to move from start point to given node
    private double h; // Estimated movement cost to move from that given square on the grid to the final destination
    private double f; // F is the final cost. F = G + H
    private int cost;

    // Getters
    Node getParent() {
        return parent;
    }

    List<Node> getNeighbors() {
        return neighbors;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    double getG() {
        return g;
    }

    double getH() {
        return h;
    }

    double getF() {
        return f;
    }

    int getCost() {
        return cost;
    }

    // Setters
    void setParent(Node parent) {
        this.parent = parent;
    }

    void setNeighbors(List<Node> neighbors) {
        this.neighbors = neighbors;
    }

    void setG(double g) {
        this.g = g;
    }

    void setH(double h) {
        this.h = h;
    }

    void setF(double f) {
        this.f = f;
    }

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Node() {
        this.x = 0;
        this.y = 0;
    }

    // Methods
    double estimateDistance(Node goal) {
       // return Math.abs(this.getX() - goal.getX()) + Math.abs(this.getY() - goal.getY());
        return Math.sqrt( ( this.getX() - goal.getX() ) * ( this.getX() - goal.getX() ) + ( this.getY() - goal.getY() ) * ( this.getY() - goal.getY() ));
    }

    List<Node> findNeighbors(Map map ) {
        // Gets the matrix and nodes for use later
        int[][] matrix = map.getMatrix();
        List<Node> nodes = map.getNodes();

        // Empty list for neighbor nodes
        List<Node> neighbors = new ArrayList<>();

        // Gets the column the current node is in
        int columnIndex = nodes.indexOf(this);

        // Loops down just that column as that's where our current node is
        for(int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            int value = matrix[rowIndex][columnIndex];
            if (value == 1) {
                // Gets the index in the full matrix
                int neighborIndex = rowIndex * map.getNumberOfCaverns() + columnIndex;

                // Converts it to the index of the nodes list
                neighborIndex /= map.getNumberOfCaverns();

                // Gets the node and adds it to the list
                Node neighbor = nodes.get(neighborIndex);
                neighbors.add(neighbor);
            }
        }
        return neighbors;
    }

    // finds lowest scoring node in open
    static Node findLowestNode(List<Node> open) {
        int lowestScore = 0;
        Node lowestNode = new Node();
        if(open.size() == 1) {
            lowestNode = open.get(0);
        } else {
            for(Node node : open) {
                if(node.getF() < lowestScore) {
                    lowestNode = node;
                }
            }
        }
        return lowestNode;
    }


}
