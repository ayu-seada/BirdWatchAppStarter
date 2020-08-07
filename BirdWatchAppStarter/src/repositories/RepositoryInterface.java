package repositories;

import model.Bird;
import model.BirdSpot;

import java.util.List;

public interface RepositoryInterface {

    void add(Bird item);

    Bird getItem(int id);

    List<Bird> getItems();

    void remove(int id);

    void setItems(List<Bird> items);



    void add(BirdSpot birdSpot);



    List<BirdSpot> getBirdSpots();

   // void remove(int id);

    void setBirdSpots(List<BirdSpot> items);







    String toString(char delimiter);

    void store(String filename);

    String toString();
}
