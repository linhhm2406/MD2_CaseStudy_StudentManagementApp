package view;

import javax.swing.*;
import java.awt.*;

public class LoginDisplay extends JFrame {
    private JButton loginButton;
    private JLabel loginTitle;
    private JPasswordField passwordInput;
    private JLabel passwordLabel;
    private JTextField userNameInput;
    private JLabel userNameLabel;
    private JPanel panel;

    public LoginDisplay() {
        init();
        setFrameDisplayCenter();
    }
    private void setFrameDisplayCenter() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int centerOfScreenWidth = dim.width / 2 - this.getSize().width / 2;
        int centerOfSreenHeight = dim.height / 2 - this.getSize().height / 2;
        this.setLocation(centerOfScreenWidth, centerOfSreenHeight);
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JPanel getPanel() {
        return panel;
    }

    public JPasswordField getPasswordInput() {
        return passwordInput;
    }

    public void setPasswordInput(JPasswordField passwordInput) {
        this.passwordInput = passwordInput;
    }

    public JTextField getUserNameInput() {
        return userNameInput;
    }

    public void setUserNameInput(JTextField userNameInput) {
        this.userNameInput = userNameInput;
    }

    public void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        userNameLabel = new JLabel();
        passwordInput = new JPasswordField(13);
        userNameInput = new JTextField(13);
        passwordLabel = new JLabel();
        loginTitle = new JLabel();
        loginButton = new JButton();

        loginTitle.setFont(new Font("Tahoma", 1, 18));
        userNameLabel.setFont(new Font("Tahoma", 1, 13));
        passwordLabel.setFont(new Font("Tahoma", 1, 13));

        userNameLabel.setText("User Name");
        passwordLabel.setText("Password");
        loginTitle.setText("LOGIN");
        loginButton.setText("LOGIN");

        initLayout();
    }

    private void initLayout() {
        SpringLayout layout = new SpringLayout();
        panel = new JPanel();

        panel.setSize(420, 300);
        panel.setLayout(layout);
        panel.add(loginButton);
        panel.add(loginTitle);
        panel.add(passwordLabel);
        panel.add(passwordInput);
        panel.add(userNameInput);
        panel.add(userNameLabel);
        panel.add(loginTitle);

        layout.putConstraint(SpringLayout.WEST, userNameLabel, 70, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, userNameLabel, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, userNameInput, 150, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, userNameInput, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, passwordLabel, 70, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, passwordLabel, 110, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, passwordInput, 150, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, passwordInput, 110, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, loginButton, 150, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, loginButton, 150, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, loginTitle, 150, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, loginTitle, 30, SpringLayout.NORTH, panel);

        this.add(panel);
        this.pack();

        this.setSize(420, 300);
        this.setResizable(false);
    }
}