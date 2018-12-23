package com.company;

import java.io.File;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        File file = null;
        String filePath = "";
        if (0 < args.length) {
            file = new File(args[0]);
            filePath = file.getPath();
            if(!filePath.endsWith(".cav")) {
                filePath = filePath + ".cav";
            }
        } else {
            System.err.println("Invalid arguments count:" + args.length);
            System.exit(0);
        }

        AStarImproved aStar = new AStarImproved();

        DecimalFormat df2 = new DecimalFormat(".##");
        CavernFile cf = new CavernFile(filePath);

        Map map = cf.parseFile();

        List<Node> path = aStar.run(map.getNodes().get(0), map.getNodes().get(map.getNodes().size()-1), map);
        Collections.reverse(path);

        try {
            String FileName = file.getName().split("\\.")[0];
            PrintWriter writer = new PrintWriter(FileName + ".csn", "UTF-8");
            if(path.size() == 0) {
                writer.println(0);
            } else {
                for(Node node : path) {
                    int index = map.getNodes().indexOf(node);
                    writer.print(index+1 + " ");
                }

                //writer.print("Length: "  + df2.format(aStar.getTotalDistance()));
               // aStar.resetTotalDistance();

            }
            writer.close();
        } catch(java.io.IOException ex) {
            System.out.println("Exception: " + ex);
        }

    }
}