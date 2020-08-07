/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.File;
/**
 *
 * @author mga
 */
public class BirdSpot  {
    
    private String spotter;
    private String location;
    private int number;
    
    static final char EOLN='\n';       
    static final String QUOTE="\""; 

    /**
     *
     */
    public BirdSpot() {
        this.spotter = "TBC";
        this.location = "TBC";        
        this.number = 0;
    }

    /**
     *
     * @param spotter
     * @param location
     * @param number
     */
    public BirdSpot(String spotter, String location, int number) {
        this.spotter = spotter;
        this.location = location;        
        this.number = number;
    }

    public String getSpotter() {
        return spotter;
    }

    public void setSpotter(String spotter) {
        this.spotter = spotter;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public static char getEOLN() {
        return EOLN;
    }

    public static String getQUOTE() {
        return QUOTE;
    }


    @Override
    public String toString() {
        return "-{" +
                "spotter='" + spotter + '\'' +
                ", location='" + location + '\'' +
                ", number=" + number +
                "}- ";
    }


}
