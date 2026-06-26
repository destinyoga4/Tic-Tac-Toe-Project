import javax.swing.*;
import java.awt.*;

public class MainMenuFrame extends JFrame {
    private Player currentPlayer;
    private JButton btnStartGame;
    private JButton btnStatistics;
    private JButton btnTopScorers;
    private JButton btnExit;
    public MainMenuFrame(Player player) {
        this.currentPlayer = player;

        // GUI layout is already provided.
        // Pengaturan Jendela Utama
        setTitle("Tic-Tac-Toe - Main Menu");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(30, 39, 46));

        // Panel Atas (Judul & Sambutan)
        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        topPanel.setBackground(new Color(30, 39, 46));
        topPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));

        JLabel lblTitle = new JLabel("MAIN MENU", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Monospaced", Font.BOLD, 36));
        lblTitle.setForeground(new Color(10, 189, 227));
        
        JLabel lblWelcome = new JLabel("Welcome, " + player.getUsername() + "!", SwingConstants.CENTER);
        lblWelcome.setFont(new Font("SansSerif", Font.PLAIN, 16));
        lblWelcome.setForeground(Color.WHITE);

        topPanel.add(lblTitle);
        topPanel.add(lblWelcome);

        // Panel Tengah (Tombol-tombol)
        JPanel centerPanel = new JPanel(new GridLayout(4, 1, 20, 20));
        centerPanel.setBackground(new Color(30, 39, 46));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 50, 40, 50));

        // Inisialisasi tombol dengan desain khusus
        btnStartGame = createStyledButton("Start Game", new Color(46, 204, 113)); // Hijau
        btnStatistics = createStyledButton("My Statistics", new Color(10, 189, 227)); // Biru
        btnTopScorers = createStyledButton("Top 5 Scorers", new Color(155, 89, 182)); // Ungu
        btnExit = createStyledButton("Exit", new Color(231, 76, 60)); // Merah

        centerPanel.add(btnStartGame);
        centerPanel.add(btnStatistics);
        centerPanel.add(btnTopScorers);
        centerPanel.add(btnExit);

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);

        btnStartGame.addActionListener(e -> 
        {GameFrame gameFrame = new GameFrame(currentPlayer);
        gameFrame.setVisible(true);
        this.dispose();
        });
        btnStatistics.addActionListener(e -> 
        {StatisticsFrame statisticsFrame = new StatisticsFrame(currentPlayer);
        statisticsFrame.setVisible(true);
        });
        btnTopScorers.addActionListener(e -> 
        {TopScorersFrame topFrame = new TopScorersFrame();
        topFrame.setVisible(true);
        });
        btnExit.addActionListener(e -> {
        System.exit(0);
        });
    }

    private JButton createStyledButton(String text, Color bgColor) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("SansSerif", Font.BOLD, 16));
        btn.setBackground(bgColor);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return btn;
    }
}

