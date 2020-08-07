/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;



/**
 *
 * @author mga
 */
public class Bird {
    private final int id;
    private String name;
    private List<BirdSpot> birdSpotsCollection;
    
    private static int lastIdAllocated = 0;
    
    static final char EOLN='\n';       
    static final String QUOTE="\""; 

    /**
     *
     */
    public Bird() {
        this.id = ++lastIdAllocated;
        this.name = "TBC";
        this.birdSpotsCollection = new ArrayList<>();
    }

    /**
     *
     * @param name
     */
    public Bird(String name) {
        this.id = ++lastIdAllocated;
        this.name = name;
        this.birdSpotsCollection = new ArrayList<>();
    }

    /**
     *
     * @param name
     * @param birdSpotsCollection
     */
    public Bird(String name, List<BirdSpot> birdSpotsCollection) {
        this.id = ++lastIdAllocated;        
        this.name = name;
        this.birdSpotsCollection = birdSpotsCollection;
    }

    /**
     *
     * @param id
     * @param name
     * @param birdSpotsCollection
     */
    public Bird(int id, String name, List<BirdSpot> birdSpotsCollection) {
        this.id = id;
        this.name = name;
        this.birdSpotsCollection = birdSpotsCollection;
        if (id > Bird.lastIdAllocated)
            Bird.lastIdAllocated = id;
    }


    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BirdSpot> getBirdSpotsCollection() {
        return this.birdSpotsCollection;
    }

    public void setBirdSpotsCollection(List<BirdSpot> birdSpotsCollection) {
        this.birdSpotsCollection = birdSpotsCollection;
    }

    public static int getLastIdAllocated() {
        return lastIdAllocated;
    }

    public static void setLastIdAllocated(int lastIdAllocated) {
        Bird.lastIdAllocated = lastIdAllocated;
    }

    public static char getEOLN() {
        return EOLN;
    }

    public static String getQUOTE() {
        return QUOTE;
    }

    public void addBirdSpot(BirdSpot birdSpot) { this.birdSpotsCollection.add(birdSpot); }
//    public void add(BirdSpot birdSpot) { this.birdSpots.add(birdSpot); }





        @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bird)) return false;
        Bird bird = (Bird) o;
        return getId() == bird.getId() &&
                getName().equals(bird.getName()) &&
                getBirdSpotsCollection().equals(bird.getBirdSpotsCollection());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getBirdSpotsCollection());
    }

    public static Comparator<Bird> BirdNameComparator
            = new Comparator<Bird>() {

        @Override
        public int compare(Bird b1, Bird b2) {

            String BirdName1 = b1.getName();
            String BirdName2 = b1.getName();
            return BirdName1.compareTo(BirdName2);
        }
    };


    public int compareTo(Bird compareBird) {
        return this.name.compareTo(compareBird.name);}


    @Override
    public String toString() {

        return "Bird ID= " + id +
                ", Bird Name='" + name + '\'' +
                 getBirdSpotsCollection();
    }


}

