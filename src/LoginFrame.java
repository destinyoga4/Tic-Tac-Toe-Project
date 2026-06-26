import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private PlayerService playerService;
    public LoginFrame() {
    playerService = new PlayerService();
    // GUI layout is already provided by the lecturer.
    // Login Window
    setTitle("Tic-Tac-Toe - Login");
    setSize(350, 450);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(new BorderLayout());
    getContentPane().setBackground(new Color(30, 39, 46));

    //Title
    JPanel topPanel = new JPanel();
    topPanel.setBackground(new Color(30, 39, 46));
    topPanel.setBorder(BorderFactory.createEmptyBorder(40, 0, 20, 0)); // Margin atas 40px
    
    JLabel lblTitle = new JLabel("LOGIN");
    lblTitle.setFont(new Font("Monospaced", Font.BOLD, 40));
    lblTitle.setForeground(new Color(10, 189, 227));
    topPanel.add(lblTitle);

    //Form input Username & Password
    JPanel centerPanel = new JPanel();
    centerPanel.setLayout(new GridLayout(4, 1, 10, 10));
    centerPanel.setBackground(new Color(30, 39, 46));
    centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 50, 10, 50));

    JLabel lblUsername = new JLabel("Username");
    lblUsername.setForeground(Color.WHITE);
    lblUsername.setFont(new Font("SansSerif", Font.BOLD, 14));

    txtUsername = new JTextField();
    txtUsername.setFont(new Font("SansSerif", Font.PLAIN, 16));
    txtUsername.setBackground(new Color(45, 52, 54));
    txtUsername.setForeground(Color.WHITE);
    txtUsername.setCaretColor(Color.WHITE);
    txtUsername.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

    JLabel lblPassword = new JLabel("Password");
    lblPassword.setForeground(Color.WHITE);
    lblPassword.setFont(new Font("SansSerif", Font.BOLD, 14));

    txtPassword = new JPasswordField();
    txtPassword.setFont(new Font("SansSerif", Font.PLAIN, 16));
    txtPassword.setBackground(new Color(45, 52, 54));
    txtPassword.setForeground(Color.WHITE);
    txtPassword.setCaretColor(Color.WHITE);
    txtPassword.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

    centerPanel.add(lblUsername);
    centerPanel.add(txtUsername);
    centerPanel.add(lblPassword);
    centerPanel.add(txtPassword);

    //Tombol Login
    JPanel bottomPanel = new JPanel();
    bottomPanel.setLayout(new BorderLayout());
    bottomPanel.setBackground(new Color(30, 39, 46));
    bottomPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 60, 50));

    btnLogin = new JButton("Login to Game");
    btnLogin.setFont(new Font("SansSerif", Font.BOLD, 16));
    btnLogin.setBackground(new Color(46, 204, 113)); // Warna hijau terang
    btnLogin.setForeground(Color.WHITE);
    btnLogin.setFocusPainted(false);
    btnLogin.setBorder(BorderFactory.createEmptyBorder(12, 10, 12, 10));
    btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));

    bottomPanel.add(btnLogin, BorderLayout.CENTER);

    add(topPanel, BorderLayout.NORTH);
    add(centerPanel, BorderLayout.CENTER);
    add(bottomPanel, BorderLayout.SOUTH);

    // Students only need to complete the missing logic.
    btnLogin.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // TODO: Get username from txtUsername
        String username = txtUsername.getText();

        // TODO: Get password from txtPassword
        String password = new String(txtPassword.getPassword());
        
        // TODO: Call playerService.login(username, password)
        Player player = playerService.login(username, password);

        // TODO: If login succeeds, open MainMenuFrame
        if (player != null) {
            JOptionPane.showMessageDialog(LoginFrame.this, "Login successful!");
            MainMenuFrame menuFrame = new MainMenuFrame(player);
            menuFrame.setVisible(true);
            LoginFrame.this.dispose();
        }
        else{
            // TODO: If login fails, show JOptionPane error message
            JOptionPane.showMessageDialog(LoginFrame.this, "Invalid username or password!");
        }
        
        
    }});
    }
}