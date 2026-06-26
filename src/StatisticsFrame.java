import javax.swing.*;
import java.awt.*;

public class StatisticsFrame extends JFrame {

    public StatisticsFrame(Player player) {
        // Pengaturan dasar jendela
        setTitle("My Statistics");
        setSize(300, 350);
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        getContentPane().setBackground(new Color(30, 39, 46));
        
        setLayout(new GridLayout(6, 1, 10, 10));

        // Judul
        JLabel lblTitle = new JLabel("PLAYER STATS", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Monospaced", Font.BOLD, 24));
        lblTitle.setForeground(new Color(10, 189, 227));

        // Label Data
        JLabel lblUser = createStatLabel("Username: " + player.getUsername(), Color.WHITE);
        JLabel lblWins = createStatLabel("Wins: " + player.getWins(), new Color(46, 204, 113));
        JLabel lblLosses = createStatLabel("Losses: " + player.getLosses(), new Color(231, 76, 60));
        JLabel lblDraws = createStatLabel("Draws: " + player.getDraws(), new Color(241, 196, 15));
        
        // Label Skor Total
        JLabel lblScore = createStatLabel("TOTAL SCORE: " + player.getScore(), new Color(155, 89, 182));
        lblScore.setFont(new Font("SansSerif", Font.BOLD, 18));

        // Memasukkan ke frame
        add(lblTitle);
        add(lblUser);
        add(lblWins);
        add(lblLosses);
        add(lblDraws);
        add(lblScore);
    }

    // Metode bantuan untuk desain teks
    private JLabel createStatLabel(String text, Color color) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 16));
        label.setForeground(color);
        return label;
    }
}