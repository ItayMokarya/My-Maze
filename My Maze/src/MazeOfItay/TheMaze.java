//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package MazeOfItay;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TheMaze {
    private ArrayList<Player> players = new ArrayList();
    private final Scanner in;
    private Cell[][] maze;
    private int cellSize;
    private int locatinX;
    private int locatinY;
    public ArrayList<Player> getPlayers() { return this.players; }
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String TEXT_RESET = "\u001B[0m";



    public TheMaze() {
        this.in = new Scanner(System.in);
        this.maze = new Cell[4][4];
        this.cellSize = 7;
    }

    public void InitGame(int r) {
        for(int i = 0; i < 4; ++i) {
            for(int j = 0; j < 4; ++j) {
                this.maze[i][j] = new Cell();
            }
        }
        this.CreateMaze(r);
    }
    // Set random players position
    public void set_players_position() {
        Random rnd = new Random();
        int rand_int1,rand_int2;
        for(Player player: this.getPlayers()){
            do {
                rand_int1 = rnd.nextInt(3);
                rand_int2 = rnd.nextInt(3);
                player.setX(rand_int1);
                player.setY(rand_int2);
            } while (this.maze[player.getX()][player.getY()].isEmpty() || this.maze[player.getX()][player.getY()].isInternal() || this.maze[player.getX()][player.getY()].getPrize() != 0);
        }
    }

    public void Move(Player p) {
        if (p.isPlayerCanPlay()) {
            System.out.println(p.getName() + TEXT_RESET+" Please choose option"+TEXT_RESET);
            System.out.println("Press \"U\" for up");
            System.out.println("Press \"D\" for down");
            System.out.println("Press \"L\" for left");
            System.out.println("Press \"R\" for right");
            System.out.println("Press \"S\" to stay");
            System.out.println("Press \"H\" to get distance from the prize. This hint will cost you a move");
            System.out.println("Press \"I\" to get information about near room.");
            // get the decision
            String playerMove = this.in.nextLine();
            // While the select is not good select again
            while (playerMove.equalsIgnoreCase("U") && this.maze[p.getX()][p.getY()].isUp_Wall() ||
                    playerMove.equalsIgnoreCase("D") && this.maze[p.getX()][p.getY()].isDown_Wall() ||
                    playerMove.equalsIgnoreCase("R") && this.maze[p.getX()][p.getY()].isRight_Wall() ||
                    playerMove.equalsIgnoreCase("L") && this.maze[p.getX()][p.getY()].isLeft_Wall() ||
                    !playerMove.equalsIgnoreCase("U") &&
                    !playerMove.equalsIgnoreCase("D") && !playerMove.equalsIgnoreCase("R") &&
                    !playerMove.equalsIgnoreCase("L") && !playerMove.equalsIgnoreCase("S") &&
                    !playerMove.equalsIgnoreCase("H") && !playerMove.equalsIgnoreCase("I")) {
                System.out.println("Invalid move please choose again");
                playerMove = this.in.nextLine();
            }
            // Get down
            if (playerMove.equalsIgnoreCase("D")) {
                if (p.getX() + 1 > 3 && !this.maze[p.getX()][p.getY()].isDown_Wall()) {
                    p.setX(p.getX() + 1);
                    p.setScore(p.getScore() - 1);
                    p.setPlayerCanPlay(false);
                } else if (this.maze[p.getX() + 1][p.getY()].isEmpty()) {
                    p.setX(p.getX() + 1);
                    p.setScore(p.getScore() - 1);
                    p.setPlayerCanPlay(false);
                } else {
                    p.setScore(p.getScore() - 1);
                    p.setX(p.getX() + 1);
                }
            }
            // Get up
            if (playerMove.equalsIgnoreCase("U")) {
                if (p.getX() - 1 < 0 && !this.maze[p.getX()][p.getY()].isUp_Wall()) {
                    p.setX(p.getX() - 1);
                    p.setScore(p.getScore() - 1);
                    p.setPlayerCanPlay(false);
                } else if (this.maze[p.getX() - 1][p.getY()].isEmpty()) {
                    p.setX(p.getX() - 1);
                    p.setScore(p.getScore() - 1);
                    p.setPlayerCanPlay(false);
                } else {
                    p.setScore(p.getScore() - 1);
                    p.setX(p.getX() - 1);
                }
            }
            // Go left
            if (playerMove.equalsIgnoreCase("L")) {
                if (p.getY() - 1 < 0 && !this.maze[p.getX()][p.getY()].isLeft_Wall()) {
                    p.setY(p.getY() - 1);
                    p.setScore(p.getScore() - 1);
                    p.setPlayerCanPlay(false);
                } else if (this.maze[p.getX()][p.getY() - 1].isEmpty()) {
                    p.setY(p.getY() - 1);
                    p.setScore(p.getScore() - 1);
                    p.setPlayerCanPlay(false);
                } else {
                    p.setScore(p.getScore() - 1);
                    p.setY(p.getY() - 1);
                }
            }
            // Go right
            if (playerMove.equalsIgnoreCase("R")) {
                if (p.getY() + 1 > 3 && !this.maze[p.getX()][p.getY()].isRight_Wall()) {
                    p.setY(p.getY() + 1);
                    p.setScore(p.getScore() - 1);
                    p.setPlayerCanPlay(false);
                } else if (this.maze[p.getX()][p.getY() + 1].isEmpty()) {
                    p.setY(p.getY() + 1);
                    p.setScore(p.getScore() - 1);
                    p.setPlayerCanPlay(false);
                } else {
                    p.setScore(p.getScore() - 1);
                    p.setY(p.getY() + 1);
                }
            }
            // Stay in cell
            if (playerMove.equalsIgnoreCase("S")) {
            }
            // Get the location of the prize
            int yPos;
            int xPos;
            if (playerMove.equalsIgnoreCase("H")) {
                int x1 = p.getX();
                yPos = p.getY();
                xPos = this.locatinX;
                int y2 = this.locatinY;
                int locationPrize = (int)Math.sqrt(Math.pow((double)(xPos - x1), 2.0D) + Math.pow((double)(y2 - yPos), 2.0D));
                System.out.println("The air location from prize is : " + locationPrize);
                p.setScore(p.getScore() - 1);
            }
            // Peek into the next room
            if (playerMove.equalsIgnoreCase("I")) {
                System.out.println("Please Choose near Room (\"U\", \"D\", \'L\", \"R\"): ");
                String R = this.in.nextLine();
                yPos = p.getY();
                xPos = p.getX();
                if (R.equalsIgnoreCase("U")) {
                    --xPos;
                } else if (R.equalsIgnoreCase("D")) {
                    ++xPos;
                } else if (R.equalsIgnoreCase("L")) {
                    --yPos;
                } else if (R.equalsIgnoreCase("R")) {
                    ++yPos;
                }

                if (xPos >= 0 && xPos <= 3 && yPos >= 0 && yPos <= 3) {
                    if (this.maze[xPos][yPos].isEmpty()) {
                        System.out.println("The Room Is empty");
                    } else if (this.maze[xPos][yPos].getPrize() != 0) {
                        System.out.println("Room Contain Prize");
                    }else {
                        System.out.println("The'r is noting in this room");
                    }
                } else {
                    System.out.println("This room is out of bounds");
                }

                p.setScore(p.getScore() - 1);
            }
        }
        // After move Validate if player won
        if (p.getX() >= 0 && p.getX() <= 3 && p.getY() >= 0 && p.getY() <= 3 && this.maze[p.getX()][p.getY()].getPrize() != 0) {
            p.setScore(p.getScore() + this.maze[p.getX()][p.getY()].getPrize());
            // Close round - set all players can't play (round ended)
            for(Player player: getPlayers()){
                player.setPlayerCanPlay(false);
            }
        }

    }

    public void CreateMaze(int round) {
        switch(round) {
            case 1:
                this.maze[0][0].setLeft_Wall(true);
                this.maze[0][1].setUp_Wall(true);
                this.maze[0][1].setDown_Wall(true);
                this.maze[0][2].setUp_Wall(true);
                this.maze[0][2].setDown_Wall(true);
                this.maze[1][0].setEmpty(true);
                this.maze[1][0].setDown_Wall(true);
                this.maze[2][1].setRight_Wall(true);
                this.maze[1][1].setUp_Wall(true);
                this.maze[1][2].setUp_Wall(true);
                this.maze[1][2].setDown_Wall(true);
                this.maze[2][3].setEmpty(true);
                this.maze[2][0].setLeft_Wall(true);
                this.maze[2][2].setLeft_Wall(true);
                this.maze[2][2].setUp_Wall(true);
                this.maze[3][0].setRight_Wall(true);
                this.maze[3][1].setLeft_Wall(true);
                this.maze[3][2].setUp_Wall(true);
                this.maze[3][2].setUp_Wall(true);
                this.maze[3][2].setDown_Wall(true);
                this.maze[1][1].setIntrnal(true);
                this.maze[1][2].setIntrnal(true);
                this.maze[2][1].setIntrnal(true);
                this.maze[2][2].setIntrnal(true);
                this.maze[3][3].setPrize(10);
                this.locatinX = 3;
                this.locatinY = 3;
                break;
            case 2:
                this.maze[0][0].setEmpty(true);
                this.maze[0][1].setUp_Wall(true);
                this.maze[0][1].setLeft_Wall(true);
                this.maze[0][2].setDown_Wall(true);
                this.maze[1][3].setLeft_Wall(true);
                this.maze[1][0].setLeft_Wall(true);
                this.maze[1][0].setRight_Wall(true);
                this.maze[1][1].setEmpty(true);
                this.maze[1][2].setRight_Wall(true);
                this.maze[1][2].setUp_Wall(true);
                this.maze[2][3].setDown_Wall(true);
                this.maze[2][0].setLeft_Wall(true);
                this.maze[2][1].setEmpty(true);
                this.maze[3][0].setDown_Wall(true);
                this.maze[3][3].setEmpty(true);
                this.maze[3][1].setUp_Wall(true);
                this.maze[1][1].setIntrnal(true);
                this.maze[1][2].setIntrnal(true);
                this.maze[2][1].setIntrnal(true);
                this.maze[2][2].setIntrnal(true);
                this.maze[1][2].setPrize(10);
                this.locatinX = 1;
                this.locatinY = 2;
            case 3:
                this.maze[0][0].setUp_Wall(true);
                this.maze[0][1].setUp_Wall(true);
                this.maze[0][1].setRight_Wall(true);
                this.maze[0][2].setEmpty(true);
                this.maze[0][3].setUp_Wall(true);
                this.maze[0][3].setRight_Wall(true);
                this.maze[0][3].setLeft_Wall(true);
                this.maze[1][3].setRight_Wall(true);
                this.maze[1][0].setLeft_Wall(true);
                this.maze[1][0].setRight_Wall(true);
                this.maze[1][0].setDown_Wall(true);
                this.maze[1][1].setLeft_Wall(true);
                this.maze[1][1].setDown_Wall(true);
                this.maze[1][2].setDown_Wall(true);
                this.maze[2][3].setRight_Wall(true);
                this.maze[2][0].setDown_Wall(true);
                this.maze[2][1].setDown_Wall(true);
                this.maze[2][1].setUp_Wall(true);
                this.maze[2][2].setUp_Wall(true);
                this.maze[2][2].setDown_Wall(true);
                this.maze[2][0].setUp_Wall(true);
                this.maze[3][0].setUp_Wall(true);
                this.maze[3][0].setEmpty(true);
                this.maze[3][1].setUp_Wall(true);
                this.maze[3][2].setUp_Wall(true);
                this.maze[3][2].setDown_Wall(true);
                this.maze[1][1].setIntrnal(true);
                this.maze[1][2].setIntrnal(true);
                this.maze[2][1].setIntrnal(true);
                this.maze[2][2].setIntrnal(true);
                this.maze[2][0].setPrize(10);
                this.locatinX = 1;
                this.locatinY = 2;
        }
    }
    // Print the maze with players
    public void printMaze(ArrayList<Player> players) {
        for(int row = 0; row < 4; ++row) {
            int hight;
            int col;
            for(hight = 0; hight < 4; ++hight) {
                if (this.maze[row][hight].isEmpty()) {
                    for(col = 0; col < this.cellSize; ++col) {
                        System.out.print(" ");
                    }
                } else if (this.maze[row][hight].isUp_Wall()) {
                    for(col = 0; col < this.cellSize; ++col) {
                        System.out.print(ANSI_RED+"*"+ANSI_RED);
                    }
                } else {
                    for(col = 0; col < this.cellSize; ++col) {
                        System.out.print(ANSI_GREEN+"-"+ANSI_GREEN);
                    }
                }
            }

            System.out.println("");

            for(hight = 0; hight < this.cellSize - 4; ++hight) {
                for(col = 0; col < 4; ++col) {
                    Boolean isPlayerNamePrinted = false;
                    if (this.maze[row][col].isEmpty()) {
                        System.out.print(" ");
                    } else if (this.maze[row][col].isLeft_Wall()) {
                        System.out.print(ANSI_RED+"*"+ANSI_RED);
                    } else {
                        System.out.print(ANSI_GREEN+"]"+ANSI_GREEN);
                    }

                    int playerNumberInThatRoom = 0;
                    for (Player player:this.getPlayers()) {
                        if (player.getX() == row && player.getY() == col) {
                            if (playerNumberInThatRoom == hight) {
                                System.out.print(player.getName());
                                isPlayerNamePrinted = true;
                            }

                            ++playerNumberInThatRoom;
                        }
                    }

                    if (!isPlayerNamePrinted) {
                        for(int i = 0; i < this.cellSize - 2; ++i) {
                            if (i == 2 && hight == this.cellSize - 6 && this.maze[row][col].getPrize() != 0) {
                                System.out.print(ANSI_BLUE+this.maze[row][col].getPrize());
                                if (this.maze[row][col].getPrize() > 9) {
                                    System.out.print(" ");
                                    break;
                                }
                                ++i;
                            }

                            System.out.print(" ");
                        }
                    }

                    if (this.maze[row][col].isEmpty()) {
                        System.out.print(" ");
                    } else if (this.maze[row][col].isRight_Wall()) {
                        System.out.print(ANSI_RED+"*"+ ANSI_RED);
                    } else {
                        System.out.print(ANSI_GREEN+"["+ANSI_GREEN);
                    }
                }
                System.out.println("");
            }

            for(hight = 0; hight < this.maze[0].length; ++hight) {
                if (this.maze[row][hight].isEmpty()) {
                    for(col = 0; col < this.cellSize; ++col) {
                        System.out.print(" ");
                    }
                } else if (this.maze[row][hight].isDown_Wall()) {
                    for(col = 0; col < this.cellSize; ++col) {
                        System.out.print(ANSI_RED+"*"+ ANSI_RED);
                    }
                } else {
                    for(col = 0; col < this.cellSize; ++col) {
                        System.out.print(ANSI_GREEN+"-"+ANSI_GREEN);
                    }
                }
            }
            System.out.println("");
        }
    }
}
