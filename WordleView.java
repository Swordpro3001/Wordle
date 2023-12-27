package Wordle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class WordleView extends JFrame {
    private JTextField[] guessFields;
    private JLabel resultLabel;
    private JButton checkButton;
    private JButton newButton;
    private JButton solutionButton;
    private WordleGraphicsPanel graphicsPanel;

    public WordleView() {
        setTitle("Wordle Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1, 5));
        guessFields = new JTextField[5];
        for (int i = 0; i < guessFields.length; i++) {
            guessFields[i] = new JTextField();
            topPanel.add(guessFields[i]);
        }
        add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout());
        graphicsPanel = new WordleGraphicsPanel();
        centerPanel.add(graphicsPanel);
        add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        resultLabel = new JLabel();
        bottomPanel.add(resultLabel);
        checkButton = new JButton("Check");
        bottomPanel.add(checkButton);
        newButton = new JButton("Neu");
        bottomPanel.add(newButton);
        solutionButton = new JButton("Lösung");
        bottomPanel.add(solutionButton);
        add(bottomPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void addCheckButtonListener(ActionListener listener) {
        checkButton.addActionListener(listener);
    }

    public void addNewButtonListener(ActionListener listener) {
        newButton.addActionListener(listener);
    }

    public void addSolutionButtonListener(ActionListener listener) {
        solutionButton.addActionListener(listener);
    }

    public char[] getGuessArray() {
        char[] guessArray = new char[guessFields.length];
        for (int i = 0; i < guessFields.length; i++) {
            guessArray[i] = guessFields[i].getText().toUpperCase().charAt(0);
        }
        return guessArray;
    }

    public void updateGraphics(int result) {
        graphicsPanel.updateGraphics(result);
    }

    public void updateLabel(int result) {
        resultLabel.setText("Result: " + result);
    }

    public void showWinMessage() {
        JOptionPane.showMessageDialog(this, "GEWONNEN!", "Wordle", JOptionPane.PLAIN_MESSAGE);
    }

    public void resetComponents() {
        for (JTextField field : guessFields) {
            field.setText("");
        }
        resultLabel.setText("");
        graphicsPanel.reset();
    }

    public void showSolution(String solutionWord) {
        resultLabel.setText("Lösung: " + solutionWord);
    }

    public void disableComponents() {
        for (JTextField field : guessFields) {
            field.setEnabled(false);
        }
        checkButton.setEnabled(false);
    }
}
