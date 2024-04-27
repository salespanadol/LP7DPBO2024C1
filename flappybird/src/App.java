import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    public static void main(String[] args) {
        JFrame splashFrame = new JFrame("Welcome to Flappy Bird!");
        splashFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        splashFrame.setSize(500, 200);
        splashFrame.setLocationRelativeTo(null);
        splashFrame.setResizable(false);

        // Buat JPanel
        JPanel splashPanel = new JPanel();
        splashPanel.setLayout(new GridBagLayout());
        splashPanel.setBackground(Color.WHITE);

        // Tambahkan label "Welcome to Flappy Bird!"
        JLabel welcomeLabel = new JLabel("Welcome to Flappy Bird!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Ukuran font diperbesar
        GridBagConstraints gbcWelcome = new GridBagConstraints();
        gbcWelcome.gridx = 0;
        gbcWelcome.gridy = 0;
        gbcWelcome.insets = new Insets(0, 0, 20, 0); // Spasi bawah
        splashPanel.add(welcomeLabel, gbcWelcome);

        // Tombol
        JButton startButton = new JButton("Start Game");
        startButton.setFont(new Font("Arial", Font.BOLD, 16)); // Ukuran font diperbesar
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Tutup splash frame dan buka frame game
                splashFrame.dispose();
                JFrame frame = new JFrame("Flappy Bird");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(360, 640);
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);

                // Buat FlappyBird object, masukin ke frame
                FlappyBird flappyBird = new FlappyBird();
                frame.add(flappyBird);
                frame.pack();
                flappyBird.requestFocus();
                frame.setVisible(true);
            }
        });
        // Ubah gridx dan gridy, dan ubah anchor
        GridBagConstraints gbcButton = new GridBagConstraints();
        gbcButton.gridx = 0;
        gbcButton.gridy = 1;
        gbcButton.anchor = GridBagConstraints.CENTER;
        splashPanel.add(startButton, gbcButton);

        splashFrame.add(splashPanel);
        splashFrame.pack();
        splashFrame.setVisible(true);
    }
}
