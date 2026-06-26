import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class TopScorersFrame extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private PlayerService playerService;

    public TopScorersFrame() {
        playerService = new PlayerService();

        // 1. Pengaturan Dasar Jendela
        setTitle("Top 5 Scorers");
        setSize(500, 350); // Ukuran sedikit dilebarkan agar tabel rapi
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(30, 39, 46));

        // 2. Panel Judul Atas
        JLabel lblTitle = new JLabel("LEADERBOARD", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Monospaced", Font.BOLD, 28));
        lblTitle.setForeground(new Color(155, 89, 182)); // Warna Ungu
        lblTitle.setBorder(BorderFactory.createEmptyBorder(15,0, 15, 0));
        add(lblTitle, BorderLayout.NORTH);

        String[] columns = {"Username", "Wins","Losses","Draws","Score"};   
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);

        table.setBackground(new Color(30, 39, 46)); // Latar belakang baris gelap
        table.setForeground(Color.WHITE); // Teks warna putih
        table.setFont(new Font("SansSerif", Font.PLAIN, 14));
        table.setRowHeight(30); 
        
        // Desain Kepala Tabel (Header biru)
        table.getTableHeader().setBackground(new Color(10, 189, 227));
        table.getTableHeader().setForeground(Color.BLACK);
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        table.setFillsViewportHeight(true); // Memaksa tabel menutupi area putih di bawahnya
        table.setGridColor(new Color(70, 70, 70));

        // TODO: Get Top 5 players from playerService
        ArrayList<Player> topPlayers = playerService.getTop5Scorers();

        // TODO: Add each player data into the table model
        for (Player p : topPlayers) {
            Object[] rowData = {
                p.getUsername(),
                p.getWins(),
                p.getLosses(),
                p.getDraws(),
                p.getScore()
            };
            tableModel.addRow(rowData);
        }
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBackground(new Color(30, 39, 46));
        scrollPane.getViewport().setBackground(new Color(30, 39, 46)); // Latar belakang area kosong
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20)); // Margin kiri-kanan-bawah
        add(scrollPane, BorderLayout.CENTER);
    }
}



       