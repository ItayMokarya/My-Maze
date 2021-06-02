//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package MazeOfItay;

import java.util.Scanner;

public class Game {
    private TheMaze m = new TheMaze();
    private final Scanner in;
    private boolean printMazeAfterEveryMove;

    public Game() {
        this.in = new Scanner(System.in);
        this.printMazeAfterEveryMove = true;
    }

    // start the game
    public void start_game() {
        //Select number of players and create them
        this.createPlayers();


        for(int round = 3; round <= 3; ++round) {
            System.out.println("Round " + round);
            //Preparing the maze for round
            this.m.InitGame(round);
            // Set the players in random place
            this.m.set_players_position();
            // Start play the round
            this.playRound(round);
            // Print players score
            this.printPlayerScores();
        }
        // Print the winner of the game
        this.printEndGame();
    }

    //Do move for all player that can
    private void playRound(int round) {
        boolean gameOver = false;
        // While game is not over
        while(!gameOver) {
            gameOver = true;
            if (this.printMazeAfterEveryMove) {
                // print the maze with the players
                this.m.printMaze(this.m.getPlayers());
            }
            // DO move only if you can
            for(Player player: m.getPlayers()){
                // if player can play
                if (player.isPlayerCanPlay()) {
                    // Print the move that player can do and do the move
                    this.m.Move(player);
                    // if none players can't play game over
                    if (player.isPlayerCanPlay()) {
                        gameOver = false;
                    }
                }
            }
        }

        System.out.println("Round number " + round + " ended");
    }

    // print the players score
    private void printPlayerScores() {
        System.out.println("Player Scores: ");
        for (Player player : this.m.getPlayers()) {
            System.out.println(player.getName() + " with score: " + player.getScore());
            player.setPlayerCanPlay(true);

        }
    }
    // print the best player whit his score
    private void printEndGame() {
        Player bestplayer = this.m.getPlayers().get(0);
        for (Player player : this.m.getPlayers()) {
            if (bestplayer.getScore() < player.getScore()){
                bestplayer = player;
            }
        }
        System.out.println("All the round over and the winner is: " + bestplayer.getName());
        System.out.println("With score: " + bestplayer.getScore());
    }

    // create players
    private void createPlayers() {
        try{
            int numberOfPlayers;
            System.out.println("Insert number Of players: ");
            numberOfPlayers = Integer.parseInt(this.in.nextLine());
            if(numberOfPlayers<1){
                throw new Exception("");
            }
        for(int i = 1; i <= numberOfPlayers; ++i) {
            System.out.println("Insert Player " + i + " name: ");
            String name = this.in.next();
            Player p = new Player(name +"       ");
            this.m.getPlayers().add(p);
        }
        } catch (Exception e){
            System.out.println("You need to insert valid number");
            createPlayers();
        }
    }
}
