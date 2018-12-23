package com.company;

import java.util.ArrayList;
import java.util.List;

public class Map {
   private int numberOfCaverns;
   private List<Node> nodes = new ArrayList<>();
   private int[][] matrix = new int[numberOfCaverns][numberOfCaverns];

   //getters
   int getNumberOfCaverns() {
       return numberOfCaverns;
   }

   List<Node> getNodes() {
       return nodes;
   }

   int[][] getMatrix() {
       return matrix;
   }

   public int[][] matrix() {
       return matrix;
   }

   //setters
   public void setNumberOfCaverns(int numberOfCaverns) {
       this.numberOfCaverns = numberOfCaverns;
   }

   public void setNodes(List<Node> vertices) {
       this.nodes = vertices;
   }

   public void setMatrix(int[][] matrix) {
       this.matrix = matrix;
   }

   //constructor
   Map(int numberOfCaverns, List<Node> vertices, int[][] matrix) {
       this.numberOfCaverns = numberOfCaverns;
       this.nodes= vertices;
       this.matrix = matrix;
   }
}
