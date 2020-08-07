package daos;
import model.Bird;
import repositories.Repository;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOTextImpl implements DAOInterface {
    static final char DELIMITER=',';
    @Override
    public Repository load(String filename) {  Repository repository = new Repository();
        try {
            FileInputStream fin = new FileInputStream(filename);
            try (ObjectInputStream ois = new ObjectInputStream(fin)) {
                repository = (Repository) ois.readObject();
            }
        } catch(IOException | ClassNotFoundException ex){
            System.out.println(ex);
            System.exit(0);
        }
        return repository;
    }

    @Override
    public void store(String filename,
                      Repository repository) { ObjectOutputStream output = null;
        try {
            output = new ObjectOutputStream(new FileOutputStream(filename));
            output.writeObject(repository);
            output.close();
        } catch (IOException ex) {
            Logger.getLogger(DAOObjImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        } finally {
            try {
                output.close();
            } catch (IOException ex) {
                Logger.getLogger(DAOObjImpl.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
    }


    @Override
    public String toString() {
        return "DAOTextImpl{}";
    }
}


