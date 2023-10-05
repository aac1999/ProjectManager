package com.example.lab3.Project.ui;


import com.example.lab3.Project.model.Project;

import java.io.*;
import java.util.ArrayList;
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
        FileOutputStream fout = null;

        try {
            fout = new FileOutputStream(file);
            ObjectOutputStream ous = new ObjectOutputStream(fout);

            ous.writeObject(data);

            System.out.println("Serializing successfully completed");
        }

        catch (Exception e) {
            System.out.println(e);
        }

        finally {
            try {
                if (fout != null) fout.close();
            }
            catch (IOException e) {}
        }
    }

    /**
     * Call this method at startup of the application, to deserialize the users and
     * from file the specified file.
     */
    @SuppressWarnings("unchecked")
    public static List<Project> deSerializeFromFile(File file) throws IOException, ClassNotFoundException {
        FileInputStream fin = null;

        ArrayList<Project> proj = new ArrayList<>();

        try {
            fin = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fin);

            ArrayList<Project> projects = (ArrayList<Project>) ois.readObject();

            System.out.println("Deserializing successfully completed");
            for (Project p: projects) {
                System.out.println(p.toString());
                proj.add(p);
            }
        }

        catch (IOException e) {
            System.out.println(e);
        }

        catch (ClassNotFoundException e) {
            System.out.println("Klassen för objekten på filen är inte känd!");
        }

        finally {
            try {
                if (fin != null) fin.close();
            }
            catch (IOException e) {}
        }

        return proj;
    }

    private ProjectsFileIO() {}
}
