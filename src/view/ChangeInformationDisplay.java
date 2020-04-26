package view;

import javax.swing.*;
import java.awt.*;

public class ChangeInformationDisplay extends JFrame {

    private JButton cancelButton;
    private JLabel changeLabel;
    private JLabel dobChangeLabel;
    private JTextField dobInputField;
    private JLabel firstNameChangeLabel;
    private JTextField firstNameInputField;
    private JLabel genderChangeLabel;
    private JTextField genderInputField;
    private JLabel gradeChangeLabel;
    private JTextField gradeInputField;
    private JLabel idChangeLabel;
    private JTextField idInputField;
    private JLabel lastNameChangeLabel;
    private JTextField lastNameInputField;
    private JButton okButton;
    private JLabel phoneNoChangeLabel;
    private JTextField phoneNoInputField;

    public ChangeInformationDisplay() {
        setLocationRelativeTo(null);
        UIManager.getSystemLookAndFeelClassName();
        init();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void init() {
        declareComponent();
        initMainFrame();
        setFrameDisplayCenter();
    }

    private void setFrameDisplayCenter() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int centerOfScreenWidth = dim.width / 2 - this.getSize().width / 2;
        int centerOfSreenHeight = dim.height / 2 - this.getSize().height / 2;
        this.setLocation(centerOfScreenWidth, centerOfSreenHeight);
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(JButton cancelButton) {
        this.cancelButton = cancelButton;
    }

    public JTextField getDobInputField() {
        return dobInputField;
    }

    public void setDobInputField(JTextField dobInputField) {
        this.dobInputField = dobInputField;
    }

    public JTextField getFirstNameInputField() {
        return firstNameInputField;
    }

    public void setFirstNameInputField(JTextField firstNameInputField) {
        this.firstNameInputField = firstNameInputField;
    }

    public JTextField getGenderInputField() {
        return genderInputField;
    }

    public void setGenderInputField(JTextField genderInputField) {
        this.genderInputField = genderInputField;
    }

    public JTextField getGradeInputField() {
        return gradeInputField;
    }

    public void setGradeInputField(JTextField gradeInputField) {
        this.gradeInputField = gradeInputField;
    }

    public JTextField getIdInputField() {
        return idInputField;
    }

    public void setIdInputField(JTextField idInputField) {
        this.idInputField = idInputField;
    }

    public JTextField getLastNameInputField() {
        return lastNameInputField;
    }

    public void setLastNameInputField(JTextField lastNameInputField) {
        this.lastNameInputField = lastNameInputField;
    }

    public JButton getOkButton() {
        return okButton;
    }

    public void setOkButton(JButton okButton) {
        this.okButton = okButton;
    }

    public JTextField getPhoneNoInputField() {
        return phoneNoInputField;
    }

    public void setPhoneNoInputField(JTextField phoneNoInputField) {
        this.phoneNoInputField = phoneNoInputField;
    }

    public JLabel getFirstNameChangeLabel() {
        return firstNameChangeLabel;
    }

    private void declareComponent() {
        genderInputField = new JTextField();
        genderChangeLabel = new JLabel();
        idInputField = new JTextField();
        idChangeLabel = new JLabel();
        gradeInputField = new JTextField();
        gradeChangeLabel = new JLabel();
        firstNameInputField = new JTextField();
        firstNameChangeLabel = new JLabel();
        phoneNoInputField = new JTextField();
        phoneNoChangeLabel = new JLabel();
        lastNameInputField = new JTextField();
        dobInputField = new JTextField();
        lastNameChangeLabel = new JLabel();
        dobChangeLabel = new JLabel();
        okButton = new JButton();
        cancelButton = new JButton();
        changeLabel = new JLabel();
        initGroupLayout();
    }

    private void initGroupLayout() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(dobChangeLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                                                .addComponent(dobInputField, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(lastNameChangeLabel)
                                                .addGap(18, 18, 18)
                                                .addComponent(lastNameInputField))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(firstNameChangeLabel)
                                                .addGap(18, 18, 18)
                                                .addComponent(firstNameInputField))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(idChangeLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(idInputField, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(35, 35, 35)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(gradeChangeLabel)
                                                                        .addComponent(genderChangeLabel))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(phoneNoChangeLabel)
                                                                .addGap(18, 18, 18)))
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(phoneNoInputField, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(gradeInputField, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(genderInputField, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(okButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
                                .addGap(38, 38, 38))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addComponent(changeLabel)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(changeLabel)
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(genderInputField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(genderChangeLabel)
                                        .addComponent(idInputField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(idChangeLabel))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(gradeInputField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(gradeChangeLabel)
                                        .addComponent(firstNameInputField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(firstNameChangeLabel))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(phoneNoInputField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(phoneNoChangeLabel)
                                        .addComponent(lastNameInputField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lastNameChangeLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(dobInputField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dobChangeLabel)
                                        .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(okButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21))
        );
        pack();
    }

    private void initMainFrame() {
        genderChangeLabel.setText("Gender");
        idInputField.setEnabled(false);
        idChangeLabel.setText("ID");
        gradeChangeLabel.setText("Grade");
        firstNameChangeLabel.setText("First Name");
        phoneNoChangeLabel.setText("Phone No.");
        lastNameChangeLabel.setText("Last Name");
        dobChangeLabel.setText("DOB");
        okButton.setText("OK");
        cancelButton.setText("Cancel");
        changeLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        changeLabel.setText("CHANGE INFORMATION OF STUDENT");
    }
}
