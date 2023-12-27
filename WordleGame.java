package Wordle;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WordleGame {
    public static void main(String[] args) {
        WordleModel model = new WordleModel();
        WordleView view = new WordleView();
        WordleController controller = new WordleController(model, view);
    }
}
