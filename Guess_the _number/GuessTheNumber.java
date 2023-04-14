import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuessTheNumber extends JFrame implements ActionListener {
    private int randomNumber;
    private int attemptsLeft;
    private int score;
    private JLabel messageLabel, attemptsLabel, scoreLabel;
    private JTextField guessField;
    private JButton guessButton;

    public GuessTheNumber() {
        randomNumber = (int) (Math.random() * 100) + 1;
        attemptsLeft = 10;
        score = 0;
        setTitle("Guessing Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 250);
        setLayout(new GridLayout(4, 2));
        messageLabel = new JLabel("Guess a number between 1 and 100:");
        add(messageLabel);
        guessField = new JTextField(10);
        add(guessField);
        guessButton = new JButton("Guess");
        guessButton.addActionListener(this);
        add(guessButton);
        attemptsLabel = new JLabel("Attempts left: " + attemptsLeft);
        add(attemptsLabel);
        scoreLabel = new JLabel("Score: " + score);
        add(scoreLabel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int guess = Integer.parseInt(guessField.getText());
        attemptsLeft--;
        attemptsLabel.setText("Attempts left: " + attemptsLeft);
        if (guess == randomNumber) {
            JOptionPane.showMessageDialog(this, "You win! The number was " + randomNumber + ".", "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
            score += attemptsLeft;
            scoreLabel.setText("Score: " + score);
            guessButton.setEnabled(false);
        } else if (guess < randomNumber) {
            JOptionPane.showMessageDialog(this, "Your guess is too small.", "Try again!", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Your guess is too big.", "Try again!", JOptionPane.WARNING_MESSAGE);
        }
        if (attemptsLeft == 0) {
            JOptionPane.showMessageDialog(this, "You lose! The number was " + randomNumber + ".", "Sorry!", JOptionPane.ERROR_MESSAGE);
            guessButton.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        new GuessTheNumber();
    }
}

