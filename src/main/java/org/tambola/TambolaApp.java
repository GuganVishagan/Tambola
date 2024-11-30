package org.tambola;

import org.tambola.Factory.GamePatternFactory;
import org.tambola.Model.Game;
import org.tambola.Model.Round;
import org.tambola.Model.Ticket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TambolaApp {
    public static void main(String[] args) {
        // Initialize the round
        Round round = new Round(1);

        // Create the game using the GamePatternFactory
        GamePatternFactory gamePatternFactory = new GamePatternFactory();
        Game game = new Game(1, gamePatternFactory);

        // Associate the game with the round
        round.setGame(game);

        // Create and initialize a ticket with numbers
        List<String> ticketNumbers = new ArrayList<>();
        Ticket ticket = new Ticket(1, 3, 9);
        Collections.addAll(ticketNumbers, "4", "16", "_", "_", "48", "_", "63", "76",
                "_", "7", "_", "23", "38", "_", "52", "_", "_", "80", "9", "_", "25",
                "_", "_", "56", "64", "_", "83");
        ticket.setTicket(ticketNumbers);

        // Display the created ticket
        String[][] formattedTicket = ticket.getTicket();
        System.out.println("Created Ticket:");
        for (String[] row : formattedTicket) {
            for (String value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        // Check the Top-Row winning claim for the first announced numbers list.
        List<Integer> announcedNumbers1 = new ArrayList<>();
        Collections.addAll(announcedNumbers1, 4, 16, 9, 48, 777, 63, 699, 76);
        String firstClaimResponse = game.isGameWinner(ticket, announcedNumbers1, "Top Row");
        System.out.println(firstClaimResponse + " for announced numbers: " + announcedNumbers1 + " Top Row");

        // Check the Top-Row winning claim for the second announced numbers list.
        List<Integer> announcedNumbers2 = new ArrayList<>();
        Collections.addAll(announcedNumbers2, 4, 16, 9, 48, 777, 63, 699, 76, 12);
        String secondClaimResponse = game.isGameWinner(ticket, announcedNumbers2, "Top Row");
        System.out.println(secondClaimResponse + " for announced numbers: " + announcedNumbers2 + " Top Row");

        // Check the Middle-Row winning claim for the third announced numbers list.
        List<Integer> announcedNumbers3 = new ArrayList<>();
        Collections.addAll(announcedNumbers3, 7,23,38,52,991,992,80);
        String thirdClaimResponse = game.isGameWinner(ticket, announcedNumbers3, "Middle Row");
        System.out.println(thirdClaimResponse + " for announced numbers: " + announcedNumbers3 + " Middle Row");

        // Check the Middle-Row winning claim for the fourth announced numbers list.
        List<Integer> announcedNumbers4 = new ArrayList<>();
        Collections.addAll(announcedNumbers4, 7,23,38,52,991,992,80,83);
        String fourthClaimResponse = game.isGameWinner(ticket, announcedNumbers4, "Middle Row");
        System.out.println(fourthClaimResponse + " for announced numbers: " + announcedNumbers4 + " Middle Row");

        // Check the Bottom-Row winning claim for the fifth announced numbers list.
        List<Integer> announcedNumbers5 = new ArrayList<>();
        Collections.addAll(announcedNumbers5, 9,25,56,64,83);
        String fifthClaimResponse = game.isGameWinner(ticket, announcedNumbers5, "Bottom Row");
        System.out.println(fifthClaimResponse + " for announced numbers: " + announcedNumbers5 + " Bottom Row");

        // Check the Bottom-Row winning claim for the sixth announced numbers list.
        List<Integer> announcedNumbers6 = new ArrayList<>();
        Collections.addAll(announcedNumbers6, 9,25,56,64,83,800);
        String sixthClaimResponse = game.isGameWinner(ticket, announcedNumbers6, "Bottom Row");
        System.out.println(sixthClaimResponse + " for announced numbers: " + announcedNumbers6 + " Bottom Row");

        // Check the Early-Five winning claim for the seventh announced numbers list.
        List<Integer> announcedNumbers7 = new ArrayList<>();
        Collections.addAll(announcedNumbers7, 4,7,23,52,64);
        String seventhClaimResponse = game.isGameWinner(ticket, announcedNumbers7, "Early Five");
        System.out.println(seventhClaimResponse + " for announced numbers: " + announcedNumbers7 + " Early Five");

        // Check the Early-Five winning claim for the eighth announced numbers list.
        List<Integer> announcedNumbers8 = new ArrayList<>();
        Collections.addAll(announcedNumbers8, 4,7,23,52,64,800);
        String eighthClaimResponse = game.isGameWinner(ticket, announcedNumbers8, "Early Five");
        System.out.println(eighthClaimResponse + " for announced numbers: " + announcedNumbers8 + " Early Five");

        // Check the Full-House winning claim for the ninth announced numbers list.
        List<Integer> announcedNumbers9 = new ArrayList<>();
        Collections.addAll(announcedNumbers9, 4,16,48,63,76,7,233,23,388,38,52,80,9,99,999,25,56,64,83);
        String ninthClaimResponse = game.isGameWinner(ticket, announcedNumbers9, "Full House");
        System.out.println(ninthClaimResponse + " for announced numbers: " + announcedNumbers9 + " Full House");

        // Check the Full-House winning claim for the tenth announced numbers list.
        List<Integer> announcedNumbers10 = new ArrayList<>();
        Collections.addAll(announcedNumbers10, 4,16,48,63,76,7,233,23,388,38,52,80,9,99,999,25,56,64,83,100);
        String tenthClaimResponse = game.isGameWinner(ticket, announcedNumbers10, "Full house");
        System.out.println(tenthClaimResponse + " for announced numbers: " + announcedNumbers10 + " Full house" );

    }
}