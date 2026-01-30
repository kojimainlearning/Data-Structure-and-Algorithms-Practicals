import java.util.ArrayList;
import java.util.Scanner;

public class ScoreApp {
    public ArrayList<Integer> inputScore() {
        int nextScore = -1;

        ArrayList<Integer> score_list = new ArrayList<>();
        
        try (Scanner scanner = new Scanner(System.in);) {
            do { 
                System.out.print("Enter score (0-100) or a negative number to quit: ");
                
                nextScore = scanner.nextInt();
                if (nextScore >= 0 && nextScore <= 100) {
                    score_list.add(nextScore);
                } else if (nextScore < 0) {
                    System.out.println("Exiting score input.");
                    break;
                } else {
                    System.out.println("Invalid score. Please enter a score between 0 and 100.");
                    
                }
            } while (nextScore >= 0);
        } catch (Exception e) {
            System.out.println("An error occurred during input: " + e.getMessage());
        }

        System.out.println("You entered the following scores: " + score_list);
        return score_list;
    }

    public static int highestScore(ArrayList<Integer> scores) {
        int highest = -1;
        for (int score: scores) {
            if (score > highest) {
                highest = score;
            }
        }
        return highest;
    }

    public static int lowestScore(ArrayList<Integer> scores) {
        int lowest = highestScore(scores);

        for (int score: scores) {
            if (score < lowest) {
                lowest = score;
            }
        }
        return lowest;
    }

    public static int averageScore(ArrayList<Integer> scores) {
        int total = 0;
        for (int score: scores) {
            total += score;
        }
        return total / scores.size();
    }


    public static void main(String[] args) {
        ScoreApp app = new ScoreApp();
        ArrayList<Integer> scores = app.inputScore();
        System.out.println("The highest score: " + highestScore(scores));
        System.out.println("The lowest score: " + lowestScore(scores));
        System.out.println("The average score: " + averageScore(scores));
    }
}
