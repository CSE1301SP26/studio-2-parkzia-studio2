import java.util.Scanner;
public class Ruin {
public static void main(String[] args){

    Scanner in = new Scanner(System.in);

    System.out.println("How much money to start?");
    double startAmount = in.nextDouble();
    System.out.println("What is our win chance");
    double winChance = in.nextDouble();
    System.out.println("What is our win limit");
    double winLimit = in.nextDouble();
    double currentMoney = startAmount;
    int plays = 0;
    int day = 1;
    boolean success = true;
    double alpha = (1-winChance)/winChance;
   double expectedRuin;
    if(winChance == 0.5){
        expectedRuin = 1- (startAmount / winLimit);
    }
    else{
expectedRuin = (Math.pow(alpha,startAmount)-Math.pow(alpha,winLimit))/(1-Math.pow(alpha,winLimit));
    }  
    System.out.println(expectedRuin);




    while (0 < currentMoney && currentMoney < winLimit){
            double play = Math.random();
            plays++;
        if (play <= winChance){
            currentMoney++;
        }
        else {
            currentMoney--;
        }
        }
    if (currentMoney <= 0) {
        success = false;
    }
    if (currentMoney >= winLimit) {
       success = true;
    }
    System.out.println("Day " + day + ", " + plays + " plays, win? " + success);
} 

}