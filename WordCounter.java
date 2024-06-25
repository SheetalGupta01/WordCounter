import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class WordCounter extends JFrame implements ActionListener {

    private JTextArea textArea;
    private JLabel wordCountLabel, charCountLabel, paraCountLabel;

    public WordCounter() {
        // Set up the frame
        setTitle("Word Counter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a text area
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        // Add a scroll pane to the text area
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Create a panel for the buttons and labels
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        // Create the labels
        wordCountLabel = new JLabel("Words: 0");
        charCountLabel = new JLabel("Characters: 0");
        paraCountLabel = new JLabel("Paragraphs: 0");

        // Add labels to the panel
        panel.add(wordCountLabel);
        panel.add(charCountLabel);
        panel.add(paraCountLabel);

        // Create a button to count words
        JButton countButton = new JButton("Count");
        countButton.addActionListener(this);

        // Add button to the panel
        panel.add(countButton);

        // Add components to the frame
        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = textArea.getText();

        // Count characters
        int charCount = text.length();

        // Count words
        String[] words = text.trim().split("\\s+");
        int wordCount = text.trim().isEmpty() ? 0 : words.length;

        // Count paragraphs
        String[] paragraphs = text.split("\\n+");
        int paraCount = text.trim().isEmpty() ? 0 : paragraphs.length;

        // Update the labels
        wordCountLabel.setText("Words: " + wordCount);
        charCountLabel.setText("Characters: " + charCount);
        paraCountLabel.setText("Paragraphs: " + paraCount);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WordCounter wc = new WordCounter();
            wc.setVisible(true);
        });
    }
}
