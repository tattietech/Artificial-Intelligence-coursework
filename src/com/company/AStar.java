package com.company;

import java.util.*;

public class AStar {

    private double totalDistance;
    public double getTotalDistance() {
        return totalDistance;
    }

    public List<Node> run(Node start, Node goal, Map map) {
        Set<Node> open = new HashSet<Node>();
        Set<Node> closed = new HashSet<Node>();

        start.setG(0);
        start.setH(start.estimateDistance(goal));
        start.setF(start.getH());

        open.add(start);

        while (true) {
            Node current = null;

            // If all nodes have been checked and we're not at the goal
            if (open.size() == 0) {
                System.out.println("No path found");
            }


            for (Node node : open) {
                if (current == null || node.getF() < current.getF()) {
                    current = node;
                }
            }

            if (current == goal) {
                System.out.println("Achieved goal\n");
                break;
            }

            open.remove(current);
            closed.add(current);

            try {
                current.setNeighbors(current.findNeighbors(map));
            } catch(java.lang.NullPointerException ex) {
                break;
            }

            for (Node neighbor : current.getNeighbors()) {
                if (neighbor == null) {
                    continue;
                }

                double nextG = current.getG() + neighbor.getCost();

                if (nextG < neighbor.getG()) {
                    open.remove(neighbor);
                    closed.remove(neighbor);
                }

                if (!open.contains(neighbor) && !closed.contains(neighbor)) {
                    neighbor.setG(nextG);
                    neighbor.setH(neighbor.estimateDistance(goal));
                    neighbor.setF(neighbor.getG() + neighbor.getH());
                    neighbor.setParent(current);
                    open.add(neighbor);
                }
            }
        }

        List<Node> nodes = new ArrayList<Node>();
        Node current = goal;
        while (current.getParent() != null) {
            Node parent = current.getParent();
            this.totalDistance += Math.sqrt( ( current.getX() - parent.getX() ) * ( current.getX() - parent.getX() ) + ( current.getY() - parent.getY() ) * ( current.getY() - parent.getY() ));
            nodes.add(current);
            current = parent;
        }
        if(nodes.size() > 0) {
            nodes.add(start);
        }

        Collections.reverse(nodes);
        return nodes;
    }

}
