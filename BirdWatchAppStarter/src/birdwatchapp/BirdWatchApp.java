/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package birdwatchapp;

import controllers.BirdWatchController;

/**
 *
 * @author mga
 */
public class BirdWatchApp {

    /**
     *
     */
    public static void run() {    
        System.out.println("Birdwatch App\n=============\n\n");
        
        BirdWatchController birdWatchController = new BirdWatchController();  
        
        birdWatchController.run();
        
        System.out.println("Thank you for using Birdwatch App. Good bye.\n");        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BirdWatchApp birdWatchApp = new BirdWatchApp();
        birdWatchApp.run();
    }
    
}
