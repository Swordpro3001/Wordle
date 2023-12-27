package Wordle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordleController {
    private WordleModel model;
    private WordleView view;

    public WordleController(WordleModel model, WordleView view) {
        this.model = model;
        this.view = view;

        view.addCheckButtonListener(new CheckButtonListener());
        view.addNewButtonListener(new NewButtonListener());
        view.addSolutionButtonListener(new SolutionButtonListener());
    }

    class CheckButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            char[] guessArray = view.getGuessArray();
            int result = model.checkGuess(guessArray);
            view.updateGraphics(result);
            view.updateLabel(result);
            if (result == model.getSolutionArray().length * 10) {
                view.showWinMessage();
                view.disableComponents();
            }
        }
    }

    class NewButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.resetComponents();
        }
    }

    class SolutionButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.showSolution(model.getSolutionWord());
            view.disableComponents();
        }
    }
}
