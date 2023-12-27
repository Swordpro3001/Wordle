package Wordle;
import java.util.Random;

public class WordleModel {
    private String solutionWord;
    private char[] solutionArray;

    public WordleModel() {
        String[] wordList = {"APPLE", "BANAN", "CARDS", "DOORS", "ELBOW", "FLUTE", "GRAPE", "HORSE", "IGLOO", "JUMPS"};
        Random random = new Random();
        int index = random.nextInt(wordList.length);
        solutionWord = wordList[index];
        solutionArray = solutionWord.toCharArray();
    }

    public String getSolutionWord() {
        return solutionWord;
    }

    public char[] getSolutionArray() {
        return solutionArray;
    }

    public int checkGuess(char[] guessArray) {
        int correctPositionCount = 0;
        int correctValueCount = 0;
        for (int i = 0; i < solutionArray.length; i++) {
            if (solutionArray[i] == guessArray[i]) {
                correctPositionCount++;
            } else if (solutionWord.indexOf(guessArray[i]) != -1) {
                correctValueCount++;
            }
        }
        return correctPositionCount * 10 + correctValueCount;
    }
}
