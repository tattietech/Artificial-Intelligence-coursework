package com.company;

import java.io.File;
import java.io.FilenameFilter;

class FileFilter {
    File[] finder(){
        File dir = new File(System.getProperty("user.dir"));

        return dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String filename)
            { return filename.endsWith(".cav"); }
        } );

    }
}
