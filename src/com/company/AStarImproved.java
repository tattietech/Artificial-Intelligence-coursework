package com.company;

import java.util.*;

public class AStarImproved {
    private double totalDistance;
    public double getTotalDistance() {
        return totalDistance;
    }
    public void resetTotalDistance() {this.totalDistance = 0;}

   public List<Node> run (Node start, Node goal, Map map) {
        List<Node> open = new ArrayList<>();
        List<Node> closed = new ArrayList<>();
        List<Node> parentMap = new ArrayList<Node>();
        Node currentNode = new Node();

        start.setG(0);
        start.setH(start.estimateDistance(goal));
        start.setF(start.getH());

        open.add(start);

        while(!open.isEmpty()) {
            currentNode = open.get(0);

            for(Node node : open) {
                if(node.getF() < currentNode.getF()) {
                    currentNode = node;
                }
            }

            currentNode.setG(currentNode.estimateDistance(start));

            if(currentNode == goal) {
                parentMap.add(currentNode);
                while(currentNode.getParent() != null) {
                    Node parent = currentNode.getParent();

                    this.totalDistance += Math.sqrt( ( currentNode.getX() - parent.getX() ) * ( currentNode.getX() - parent.getX() ) + ( currentNode.getY() - parent.getY() ) * ( currentNode.getY() - parent.getY() ));
                    parentMap.add(parent);
                    currentNode = parent;
                }

                System.out.println("Path found");
                break;
            }

            open.remove(currentNode);
            closed.add(currentNode);

            List<Node> neighbors = currentNode.findNeighbors(map);
            for(Node neighbor : neighbors) {
                if(closed.contains(neighbor)) {
                    continue;
                }

                double neighbourScore = currentNode.getG() + currentNode.estimateDistance(neighbor);
                if(!open.contains(neighbor)) {
                    open.add(neighbor);
                } else if (neighbourScore >= neighbor.getG()) {
                    continue;
                }

                neighbor.setG(neighbourScore);
                neighbor.setH(neighbor.estimateDistance(goal));
                neighbor.setF(neighbor.getG() + neighbor.getH());
                neighbor.setParent(currentNode);

            }
        }

    return parentMap;
   }
}
