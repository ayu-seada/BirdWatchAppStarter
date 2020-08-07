/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import helpers.InputHelper;
import model.Bird;
import model.BirdSpot;
import repositories.Repository;

import java.sql.ClientInfoStatus;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 *
 * @author mga
 */
public class BirdWatchController {
    // private final Repository repository;
    Repository repository = new Repository();




    /**
     *
     */

    public BirdWatchController() {
        InputHelper inputHelper = new InputHelper();
        char c = inputHelper.readCharacter("Load an already existing Bird File (Y/N)?");


        if (c == 'Y' || c == 'y') {
            String fileName = inputHelper.readString("Enter filename");
            this.repository = new Repository(fileName);



        } else if (c == 'N' || c == 'n') {
                         this.repository = new Repository();
               char o = inputHelper.readCharacter("To add  a new bird press (T) to load presaved bird data press (R) to display menu press(M)");
               if (o == 'T' || o == 't') {
                addBird();
            }
               else if (o == 'R' || o == 'r') {

                boolean check = false;
                {

                    if (!check) {
                        Bird b1 = new Bird("Crow");
                        repository.add(b1);
                        Bird b2 = new Bird("Peacock");
                        repository.add(b2);
                        Bird b3 = new Bird("Dove");
                        repository.add(b3);
                        Bird b4 = new Bird("Sparrow");
                        repository.add(b4);
                        Bird b5 = new Bird("Turkey");
                        repository.add(b5);
          Bird requiredBird=null;

              requiredBird = repository.getItem(1);

         BirdSpot bs1 = new BirdSpot("Jack","Malaga",12);
               requiredBird.addBirdSpot(bs1);

         BirdSpot bs2 = new BirdSpot("James","Ness",1);
         requiredBird.addBirdSpot(bs2);
                        requiredBird = repository.getItem(2);

         BirdSpot bs3 = new BirdSpot("Anna","California",2);
          requiredBird.addBirdSpot(bs3);
                        requiredBird = repository.getItem(3);

          BirdSpot bs4 = new BirdSpot("John","Glasgow",4);
         requiredBird.addBirdSpot(bs4);

          BirdSpot bs5 = new BirdSpot("Micael","Berlin",8);
            requiredBird.addBirdSpot(bs5);

                    }
                    check = true;
                }
            }
               else if (o == 'm' || o == 'm') {

                displayMenu();
            }

         else {
            System.out.println("Not a valid answer");
            new BirdWatchController();
        }
    }

        else {System.out.println("Not a valid answer");
            new BirdWatchController();}
}


    /**
     *
     */
    public void run() {
        boolean finished = false;

        do {
            char choice = displayMenu();
            switch (choice) {
                case 'A':
                    addBird();
                    break;
                case 'B':
                    addBirdSpot();
                    break;
                case 'C':
                    listBirdWatchDataInReverse();
                    break;
                case 'D':
                    listBirdStats();
                    break;
                case 'Q':
                    finished = true;
            }
        } while (!finished);
    }

    private char displayMenu() {
        listBirdWatchDataInIdOrder();
        InputHelper inputHelper = new InputHelper();
        System.out.print("\nA. Add Bird");
        System.out.print("\tB. Add Bird Spot");
        System.out.print("\tC. List Bird Watch Data In Reverse");
        System.out.print("\tD. List Bird Stats");
        System.out.print("\tQ. Quit\n");
        return inputHelper.readCharacter("Enter choice", "ABCDQ");
    }

    private void addBird() {
        System.out.format("\033[31m%s\033[0m%n", "Add Bird");
        System.out.format("\033[31m%s\033[0m%n", "========");

        InputHelper inputHelper = new InputHelper();
        String bird_name =
                inputHelper.readString("Enter Bird Name");
        Bird newBird= new Bird(bird_name);
        repository.add(newBird);

    }

    private void addBirdSpot() {
        InputHelper inputHelper = new InputHelper();
        boolean validBirdId = false;
        Bird requiredBird=null;
        do {
            int birdId = inputHelper.readInt("Enter Bird Id");
            requiredBird = repository.getItem(birdId);
            System.out.println(requiredBird);
            if (requiredBird != null) {
                validBirdId = true;

            }
        } while (!validBirdId);
        System.out.format("\033[31m%s\033[0m%n", "Add Bird Spot");
        System.out.format("\033[31m%s\033[0m%n", "=============");


        String bird_spotter =
               inputHelper.readString("Enter Bird Spotter");
       String bird_spot =                inputHelper.readString("Enter Bird Spot");
       int Number_of_bird_spot =
               Integer.parseInt(inputHelper.readString("Enter Number of Bird Spotted"));
      BirdSpot newBirdSpot= new BirdSpot(bird_spotter,bird_spot,Number_of_bird_spot);
      requiredBird.addBirdSpot(newBirdSpot);

    }

    private void listBirdWatchDataInReverse() {
        System.out.format("\033[31m%s\033[0m%n", "Reverse");
        System.out.format("\033[31m%s\033[0m%n", "==========");

        ListIterator it = repository.getItems().listIterator(repository.getItems().size());
        while (it.hasPrevious()) {
            Bird e = (Bird) it.previous();
            System.out.println(e);



        }

        }



    private void listBirdStats() {
        System.out.format("\033[31m%s\033[0m%n", "Bird Stats");
        System.out.format("\033[31m%s\033[0m%n", "==========");
        //List, for each bird the number of bird spots, and the overall total number of bird spots
        System.out.println("Sorry but this functionality is not implemented yet");

    }

    private void listBirdWatchDataInIdOrder() {
        System.out.format("\033[31m%s\033[0m%n", "Bird Id Order");
        System.out.format("\033[31m%s\033[0m%n", "=============");
        Iterator it = repository.getItems().listIterator();
        while (it.hasNext()) {
            Bird e = (Bird) it.next();
            System.out.println(e);



        }

    }
}
