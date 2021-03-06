import java.util.Random;

public class SnakeAndLadder {
    final int ENDPOS=100;
    final int STARTPOS=0;
    int userPos;
    int dice;
    int option;

    public SnakeAndLadder(){
        userPos = STARTPOS;
        System.out.println("User ready to Go....");
    }
    static {
        System.out.println("****Welcome to Snakes and Ladders Game****");
    }

    public int rollDice(){
        Random randomRoll = new Random();
        int move;
        //while(userPos<ENDPOS) {
        dice = randomRoll.nextInt(6)+1;
        System.out.println("Dice Rolled value: " + dice);
        move = playGame();
        switch(move){
            case 1:
                if((userPos+dice)<= ENDPOS) {
                    userPos = userPos + dice;
                    System.out.println("User At Position: " + userPos);
                }
                else {
                    System.out.println("Player getting More than : " +ENDPOS);
                }
                break;
            case 2:
                if((userPos-dice)<0) {
                    System.out.println("User back to start");
                    userPos=0;
                    System.out.println("User Position at: " + userPos);
                }
                else {
                    userPos = userPos - dice;
                    System.out.println("User Position at: " + userPos);
                }
                break;
            default:
                System.out.println("Stay in place");
                System.out.println("User Position at: " + userPos);
        }

        //}

        return userPos;

    }

    public int playGame() {
        Random randomOption = new Random();
        option = randomOption.nextInt(3);
        if(option==0) {
            System.out.println("Option : No play");
            return 0;
        }
        else if(option==1) {
            System.out.println("Option: Ladder");
            return 1;
        }
        else {
            System.out.println("Option: Snake");
            return 2;
        }

    }

    public static void main(String[] args) {
        int winnerPos=0;
        int diecounter=0;
        SnakeAndLadder user = new SnakeAndLadder();
        SnakeAndLadder user2 = new SnakeAndLadder();
        while(winnerPos<100) {
            System.out.println("************User1************");
            winnerPos=user.rollDice();
            if(winnerPos==100) {
                System.out.println("Player 1 is winner with Die Count :" +diecounter);
            }
            System.out.println("************User2************");
            winnerPos=user2.rollDice();
            if(winnerPos==100) {
                System.out.println("Player2 is winner with Die Count :" +diecounter);
            }
            System.out.println("*****************************");
            diecounter++;
        }

    }
}