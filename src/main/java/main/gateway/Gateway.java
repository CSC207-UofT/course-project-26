package main.gateway;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public abstract class Gateway implements ReadWriter{

    private String getSerByFileName(String serName){
        String result;
        Path currentWorkingDir = Paths.get("").toAbsolutePath();
        String pathName = currentWorkingDir.normalize().toString();
        result = pathName + "/src/main/java/" + serName;
        return result;
    }

    /**
     * Updates serList to fileName
     * @param serList list of T objects
     * @param fileName the fileName
     * @param <T> Generics type of the Object
     */

    @Override
    public <T> void updateInfo(List<T> serList, String fileName) {
        try {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(fileName);
            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(buffer);
            out.writeObject(serList);
            out.flush();
            out.close();
            file.close();
        }
        catch(IOException ex) {
            System.out.println("IOException is caught");
        }
    }

    /**
     * return list of Object T
     * @param fileName the fileName
     * @param <T> Generics of any types that will be returned
     * @return list of Object T
     */
    public <T> List<T> helperGetInfo(String fileName) {
        List finalList = new ArrayList();
        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(getSerByFileName(fileName));
            ObjectInputStream in = new ObjectInputStream(file);
            finalList = (List) in.readObject();
            in.close();
            file.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return finalList;
    }

    /**
     * Get info from file
     * @param <T> Generics of any types of information that will be returned
     * @return list of the objects T
     */
    public abstract <T> List<T> getInfo();
}
