package repositories;

import java.util.*;
import java.util.function.Predicate;

import daos.DAOInterface;
import daos.DAOObjImpl;
import daos.DAOTextImpl;
import model.Bird;
import model.BirdSpot;


public class Repository implements RepositoryInterface {
    private List<Bird> items;
    private List<BirdSpot> birdSpots;
    static char DELIMITER=',';

//    public Repository() {
//        this.items = new ArrayList<>();
//        //this.items = new LinkedList<>();
//    }
//
//    public Repository(List<Bird> items) {
//        this.items = items;
//    }
    public Repository() {
        this.items = new ArrayList<>();
        this.birdSpots = new ArrayList<>();
        //this.items = new LinkedList<>();
    }

    public Repository(List<Bird> items, List<BirdSpot> birdSpots) {
        this.items = items;
        this.birdSpots = birdSpots;
    }


    public Repository(String filename) {
        this();
        DAOTextImpl dao = new DAOTextImpl();
        this.items = dao.load(filename).getItems();
    }

    @Override
    public List<Bird> getItems() {
        return this.items;
    }
    public List<BirdSpot> getBirdSpots() {
        return this.birdSpots;
    }

    @Override
    public void setItems(List<Bird> items) {
        this.items = items;
    }

    public void setBirdSpots(List<BirdSpot> birdSpots) {
        this.birdSpots = birdSpots;
    }

    @Override
    public void add(Bird item) {
        this.items.add(item);
    }

    public void add(BirdSpot birdSpot) { this.birdSpots.add(birdSpot); }





    @Override
    public void remove(int id) {
        Predicate<Bird> birdPredicate = c-> Boolean.parseBoolean(c.getName());
        this.items.removeIf(birdPredicate);
    }

    @Override
    public Bird getItem(int id) {
        for (Bird item:this.items) {
            if (item.getId() == id)
                return item;
        }
        return null;
    }

    @Override
    public String toString() {
        return  "BirdsData{" + "Birds=" + items+"}"+"\n"+"==================="+"\n";
    }

   @Override
    public String toString(char delimiter) {
        String output = "";
        for (Bird item: this.items) {
            output += item.toString();
        }
        return output;
    }

    @Override
    public void store(String filename) {
        DAOTextImpl dao = new DAOTextImpl();
        dao.store(filename, this);
    }




}
