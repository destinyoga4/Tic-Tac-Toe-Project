import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private Player currentPlayer;
    private PlayerService playerService;
    private GameLogic gameLogic;
    private JButton[] buttons;
    private JLabel lblStatus;

    public GameFrame(Player player) {
        this.currentPlayer = player;
        this.playerService = new PlayerService();
        this.gameLogic = new GameLogic();
        this.buttons = new JButton[9];

        // GUI layout is already provided.
        setTitle("Tic-Tac-Toe");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(30, 39, 46));

        // Panel Status
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(30, 39, 46));
        topPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        
        lblStatus = new JLabel("Your Turn! (X)");
        lblStatus.setFont(new Font("SansSerif", Font.BOLD, 20));
        lblStatus.setForeground(new Color(46, 204, 113));
        topPanel.add(lblStatus);

        // Panel Board
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(3, 3, 5, 5));
        boardPanel.setBackground(new Color(30, 39, 46));
        boardPanel.setBorder(BorderFactory.createEmptyBorder(0, 30, 30, 30));

        // Assume buttons[0] until buttons[8] represent the board cells.
        for (int i = 0; i < buttons.length; i++) {

            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Monospaced", Font.BOLD, 60));
            buttons[i].setBackground(new Color(45, 52, 54));
            buttons[i].setForeground(Color.WHITE);
            buttons[i].setFocusPainted(false);

            final int index = i;
            buttons[i].addActionListener(e -> handlePlayerMove(index));

            boardPanel.add(buttons[i]);
        }

        add(topPanel, BorderLayout.NORTH);
        add(boardPanel, BorderLayout.CENTER);
        
    }

    private void handlePlayerMove(int index) {
    // TODO: Make player move using gameLogic.makeMove(index, ’X’)
        if (gameLogic.makeMove(index, 'X')) {
            
    // TODO: Update button text to X
            buttons[index].setText("X");
            buttons[index].setForeground(new Color(10, 189, 227));

    // TODO: Check whether player wins
            if (gameLogic.checkWinner('X')) {
                finishGame("WIN");
                return;
            }
    // TODO: Check draw
            if (gameLogic.isDraw()) {
                finishGame("DRAW");
                return;
            }

    // TODO: Generate computer move
            int compMove = gameLogic.computerMove();
    // TODO: Update computer button text to O
            if (compMove != -1 && gameLogic.makeMove(compMove, 'O')) {
                // Update teks tombol di GUI untuk komputer
                buttons[compMove].setText("O");
                buttons[compMove].setForeground(new Color(231, 76, 60));

    // TODO: Check whether computer wins
                if (gameLogic.checkWinner('O')) {
                    finishGame("LOSE");
                    return;
                }

                if (gameLogic.isDraw()) {
                    finishGame("DRAW");
                    return;
                }
            }
        }
    }
    // TODO: Update database statistics after game ends
    private void finishGame(String result) {
        lblStatus.setText("Result: " + result);
        playerService.updateStatistics(currentPlayer, result);

        int updatedWins = currentPlayer.getWins();
        int updatedLosses = currentPlayer.getLosses();
        int updatedDraws = currentPlayer.getDraws();
        int updatedScore = currentPlayer.getScore();

        if (result.equals("WIN")) {
            updatedWins++;
            updatedScore += 10;
        } else if (result.equals("LOSE")) {
            updatedLosses++;
        } else if (result.equals("DRAW")) {
            updatedDraws++;
            updatedScore += 3;
        }

        currentPlayer = new Player(
            currentPlayer.getId(), 
            currentPlayer.getUsername(), 
            updatedWins, 
            updatedLosses, 
            updatedDraws, 
            updatedScore
        );
        
        JOptionPane.showMessageDialog(this, "Game result: " + result);
        MainMenuFrame menuFrame = new MainMenuFrame(currentPlayer);
        menuFrame.setVisible(true);
        this.dispose();
    }
}

