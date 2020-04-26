package controller;

import view.LoginDisplay;

import javax.swing.*;

public class LoginDisplayController {
    private LoginDisplay loginDisplay;

    public LoginDisplayController() {
        this.loginDisplay = new LoginDisplay();
        loginAction();
    }

    public void showLoginScreen() {
        loginDisplay.setVisible(true);
    }

    private void loginAction() {
        loginDisplay.getLoginButton().addActionListener(evt ->
                loginButtonActionPerformed());
    }

    public void loginButtonActionPerformed() {
        if (loginDisplay.getUserNameInput().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please input Username & Password");
        } else if (loginDisplay.getUserNameInput().getText().equals("admin")
                && String.valueOf(loginDisplay.getPasswordInput().getPassword()).equals("admin")) {
            JOptionPane.showMessageDialog(null, "Login successfully as admin!");
            loginDisplay.dispose();
            new ManagementDisplayController();
        } else {
            JOptionPane.showMessageDialog(null, "Wrong Password or Username!");
        }
    }
}
