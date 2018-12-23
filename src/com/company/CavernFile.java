package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

public class CavernFile {
    private String path;
    private String text;

    //getters
    public String getPath() {
        return path;
    }

    public String getText() {
        return text;
    }

    //setters
    public void setPath(String path) {
        this.path = path;
    }

    public void setText(String text) {
        this.text = text;
    }

    //constructor
    public CavernFile(String path) {
        this.path = path;
    }

    //methods
    public Map parseFile() {
        try(BufferedReader br = new BufferedReader(new FileReader(this.path))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            this.text = sb.toString();

        } catch(java.io.IOException ex) {
            System.out.println("Exception: " + ex);
        }

        String[] fileStringArray = this.getText().split(",");

        int numberOfCaverns = parseInt(fileStringArray[0]);


        // Creates list of nodes
        List<Node> nodes = new ArrayList<>();
        for(int i = 1; i <= numberOfCaverns * 2; i+=2) {
            int x = parseInt(fileStringArray[i]);
            int y = parseInt(fileStringArray[i+1]);
            Node p = new Node(x, y);
            nodes.add(p);
        }

        // Creates 2D array binary matrix of edges
        String[] matrixList = Arrays.copyOfRange(fileStringArray, numberOfCaverns * 2 + 1, fileStringArray.length);
        int[][] matrix = new int[numberOfCaverns][numberOfCaverns];
        int count=0;
        for(int x=0; x < numberOfCaverns; x++) {
            for(int y=0; y < numberOfCaverns; y++) {
                if(count==matrixList.length -1) break;
                matrix[x][y] = parseInt(matrixList[count]);
                count++;
            }
        }

        Map map = new Map(numberOfCaverns, nodes, matrix);

        return map;
    }
}
