package com.example.lab3.Project.ui;


import com.example.lab3.Project.model.Project;

import java.io.*;
import java.util.List;

/**
 * Hints on how to implement serialization and deserialization
 * of lists of projects and users.
 */
public class ProjectsFileIO {

    /**
     * Call this method before the application exits, to store the users and projects,
     * in serialized form.
     */
    public static void serializeToFile(File file, List<Project> data) throws IOException {
        // ...
        // and then, make sure the file always get closed
        ObjectOutputStream out = null; //objekten blir binär??

        // Serialize to file
        try {
            out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(data);

            System.out.println("Serializing successfully completed");
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * Call this method at startup of the application, to deserialize the users and
     * from file the specified file.
     */
    @SuppressWarnings("unchecked")
    public static List<Project> deSerializeFromFile(File file) throws IOException, ClassNotFoundException {
        // ...
        // and then, make sure the file always get closed
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(file));
            List<Project> data = (List<Project>) in.readObject();
            return data;
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    private ProjectsFileIO() {
    }

}
