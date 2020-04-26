package view;

import entity.*;

import javax.swing.*;
import java.awt.*;

public class ManagementDisplay extends JFrame {
    private JButton logoutButton;
    private JButton addButton;
    private JLabel addLabel;
    private JPanel addPanel;
    private JButton changeButton;
    private JLabel classTitle;
    private JButton deleteButton;
    private JLabel dobAddLabel;
    private JTextField dobInputField;
    private JLabel firstNameAddLabel;
    private JTextField firstNameInputField;
    private JLabel genderAddLabel;
    private JTextField genderInputField;
    private JLabel gradeAddLabel;
    private JTextField gradeInputField;
    private JTextField idInputField;
    private JLabel idAddLabel;
    private JScrollPane tablePanel;
    private JLabel lastNameAddLabel;
    private JTextField lastNameInputField;
    private JTable listTable;
    private JTextField phoneNoInputField;
    private JLabel phoneNoLabel;
    private JLabel schoolTitle;
    private JLabel searchByLabel;
    private JComboBox<String> searchBySelection;
    private JTextField searchContentInputField;
    private JLabel searchContentLabel;
    private JLabel searchLabel;
    private JPanel searchPanel;
    private JButton sortButton;
    private JComboBox<String> sortBySelectionInput;
    private JLabel sortBySelectionLabel;
    private JLabel sortCondition;
    private JComboBox<String> sortConditionInput;
    private JLabel sortLabel;
    private JPanel sortPanel;
    private JLabel studentListTitle;
    private JLabel userTitle;
    private JButton refreshButton;
    private JLabel validateDOB;
    private JLabel validateID;
    private JLabel validateGrade;
    private JToggleButton showTop3;
    private Student studentSelected = null;


    public JButton getAddButton() {
        return addButton;
    }
    public JPanel getAddPanel() {
        return addPanel;
    }
    public JButton getChangeButton() {
        return changeButton;
    }
    public JButton getDeleteButton() {
        return deleteButton;
    }
    public JTextField getDobInputField() {
        return dobInputField;
    }
    public JTextField getFirstNameInputField() {
        return firstNameInputField;
    }
    public JTextField getGenderInputField() {
        return genderInputField;
    }
    public JTextField getGradeInputField() {
        return gradeInputField;
    }
    public JTextField getIdInputField() {
        return idInputField;
    }
    public JScrollPane getTablePanel() {
        return tablePanel;
    }
    public JTextField getLastNameInputField() {
        return lastNameInputField;
    }
    public JTable getListTable() {
        return listTable;
    }
    public JTextField getPhoneNoInputField() {
        return phoneNoInputField;
    }
    public JComboBox<String> getSearchBySelection() {
        return searchBySelection;
    }
    public JTextField getSearchContentInputField() {
        return searchContentInputField;
    }
    public JButton getSortButton() {
        return sortButton;
    }
    public JComboBox<String> getSortBySelectionInput() {
        return sortBySelectionInput;
    }
    public JComboBox<String> getSortConditionInput() {
        return sortConditionInput;
    }
    public JButton getRefreshButton() {
        return refreshButton;
    }
    public JLabel getValidateDOB() {
        return validateDOB;
    }
    public JLabel getValidateID() {
        return validateID;
    }
    public JLabel getValidateGrade() {
        return validateGrade;
    }
    public JToggleButton getShowTop3() {
        return showTop3;
    }
    public JButton getLogoutButton() {
        return logoutButton;
    }
    public void setStudentSelected(Student studentSelected) {
        this.studentSelected = studentSelected;
    }
    public Student getStudentSelected() {
        return studentSelected;
    }

    public ManagementDisplay(String title) {
        super(title);
        init();
        setupMainFrame();
        setFrameDisplayCenter();
        setVisible(true);
    }

    private void setFrameDisplayCenter() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int centerOfScreenWidth = dim.width / 2 - this.getSize().width / 2;
        int centerOfSreenHeight = dim.height / 2 - this.getSize().height / 2;
        this.setLocation(centerOfScreenWidth, centerOfSreenHeight);
    }

    private void setupMainFrame() {
        setSize(870, 660);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void init() {
        declareComponent();
        initMainTable();
        initPageTitle();
        initSchoolClassUserName();
        initAddChangeDeletePanel();
        initSearchPanel();
        initSortPanel();
        initMainGroupLayout();
        pack();
    }

    //init/declare and draw main GUI
    private void declareComponent() {
        logoutButton = new JButton("Logout");
        studentListTitle = new JLabel();
        schoolTitle = new JLabel();
        classTitle = new JLabel();
        addPanel = new JPanel();
        addLabel = new JLabel();
        idAddLabel = new JLabel();
        genderAddLabel = new JLabel();
        firstNameAddLabel = new JLabel();
        lastNameAddLabel = new JLabel();
        dobAddLabel = new JLabel();
        gradeAddLabel = new JLabel();
        idInputField = new JTextField();
        phoneNoLabel = new JLabel();
        addButton = new JButton();
        firstNameInputField = new JTextField();
        lastNameInputField = new JTextField();
        gradeInputField = new JTextField();
        phoneNoInputField = new JTextField();
        dobInputField = new JTextField();
        genderInputField = new JTextField();
        changeButton = new JButton();
        deleteButton = new JButton();
        searchPanel = new JPanel();
        searchLabel = new JLabel();
        searchByLabel = new JLabel();
        searchBySelection = new JComboBox<>();
        searchContentLabel = new JLabel();
        searchContentInputField = new JTextField();
        userTitle = new JLabel();
        sortPanel = new JPanel();
        sortLabel = new JLabel();
        sortBySelectionLabel = new JLabel();
        sortBySelectionInput = new JComboBox<>();
        sortCondition = new JLabel();
        sortConditionInput = new JComboBox<>();
        sortButton = new JButton();
        showTop3 = new JToggleButton();
        refreshButton = new JButton();
        validateID = new JLabel();
        validateDOB = new JLabel();
        validateGrade = new JLabel();
    }

    private void initAddChangeDeletePanel() {
        initAddChangeDeleteGUI();
        addButton.setText("Add");
        deleteButton.setText("Del");
        changeButton.setText("Change");
        showTop3.setText("Show Top 3");
        refreshButton.setText("Refresh");
        addChangeDeleteGroupLayout();
    }

    private void addChangeDeleteGroupLayout() {
        GroupLayout addPanelLayout = new GroupLayout(addPanel);
        addPanel.setLayout(addPanelLayout);
        addPanelLayout.setHorizontalGroup(
                addPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, addPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(addPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(addPanelLayout.createSequentialGroup()
                                                .addComponent(addLabel)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, addPanelLayout.createSequentialGroup()
                                                .addGroup(addPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(addPanelLayout.createSequentialGroup()
                                                                .addComponent(lastNameAddLabel)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(lastNameInputField, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(phoneNoLabel))
                                                        .addGroup(addPanelLayout.createSequentialGroup()
                                                                .addComponent(dobAddLabel)
                                                                .addGap(48, 48, 48)
                                                                .addGroup(addPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(validateDOB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addGroup(addPanelLayout.createSequentialGroup()
                                                                                .addComponent(dobInputField, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                                .addGap(15, 15, 15)
                                                                .addComponent(changeButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGap(3, 3, 3))
                                                        .addGroup(GroupLayout.Alignment.LEADING, addPanelLayout.createSequentialGroup()
                                                                .addGroup(addPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(firstNameAddLabel)
                                                                        .addComponent(idAddLabel))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(addPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(validateID)
                                                                        .addGroup(GroupLayout.Alignment.TRAILING, addPanelLayout.createSequentialGroup()
                                                                                .addGroup(addPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(idInputField, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(firstNameInputField, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addGroup(addPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(gradeAddLabel)
                                                                                        .addComponent(genderAddLabel))
                                                                                .addGap(17, 17, 17)))))
                                                .addGroup(addPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(addPanelLayout.createSequentialGroup()
                                                                .addGap(9, 9, 9)
                                                                .addGroup(addPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(addPanelLayout.createSequentialGroup()
                                                                                .addComponent(addButton, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(genderInputField, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, addPanelLayout.createSequentialGroup()
                                                                .addGap(12, 12, 12)
                                                                .addGroup(addPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(gradeInputField, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(phoneNoInputField, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))))
                                                .addGap(217, 217, 217))))
                        .addGroup(GroupLayout.Alignment.TRAILING, addPanelLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(validateGrade)
                                .addGap(207, 207, 207))
        );
        addPanelLayout.setVerticalGroup(
                addPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(addPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(addLabel)
                                .addGap(24, 24, 24)
                                .addGroup(addPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(idAddLabel)
                                        .addComponent(idInputField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(genderAddLabel)
                                        .addComponent(genderInputField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4)
                                .addComponent(validateID)
                                .addGap(18, 18, 18)
                                .addGroup(addPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(firstNameAddLabel)
                                        .addComponent(firstNameInputField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(gradeAddLabel)
                                        .addComponent(gradeInputField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addComponent(validateGrade)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(addPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(phoneNoInputField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(phoneNoLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lastNameInputField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lastNameAddLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                .addGroup(addPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, addPanelLayout.createSequentialGroup()
                                                .addComponent(dobAddLabel)
                                                .addGap(27, 27, 27))
                                        .addGroup(GroupLayout.Alignment.TRAILING, addPanelLayout.createSequentialGroup()
                                                .addComponent(dobInputField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(validateDOB)
                                                .addContainerGap())
                                        .addGroup(addPanelLayout.createSequentialGroup()
                                                .addGroup(addPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(deleteButton)
                                                        .addComponent(addButton)
                                                        .addComponent(changeButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap())))
        );
    }

    private void initAddChangeDeleteGUI() {
        addPanel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        addLabel.setFont(new Font("Tahoma", 0, 14));
        addLabel.setText("INPUT FOR ADDING NEW STUDENT : \n[Mark (*) can not be empty]");

        idAddLabel.setText("ID(*)");
        genderAddLabel.setText("Gender");
        firstNameAddLabel.setText("First Name");
        lastNameAddLabel.setText("Last Name");
        dobAddLabel.setText("DOB");
        gradeAddLabel.setText("Grade(*)");
        phoneNoLabel.setText("Phone No.");

        validateID.setFont(new java.awt.Font("Tahoma", 2, 13));
        validateID.setForeground(new java.awt.Color(153, 153, 153));
        validateID.setText("Can't duplicate with existed!");

        validateDOB.setFont(new java.awt.Font("Tahoma", 2, 13));
        validateDOB.setForeground(new java.awt.Color(153, 153, 153));
        validateDOB.setText("Format : dd/mm/yyyy");

        validateGrade.setFont(new java.awt.Font("Tahoma", 2, 13));
        validateGrade.setForeground(new java.awt.Color(153, 153, 153));
        validateGrade.setText(" ");
    }

    private void initSearchPanel() {
        searchPanel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        searchLabel.setFont(new Font("Tahoma", 0, 14));
        searchLabel.setText("INPUT INFOR FOR SEARCHING :");
        searchByLabel.setText("Search by : ");
        searchBySelection.setModel(new DefaultComboBoxModel<>(new String[]{"ID", "Last Name", "Gender"}));
        searchContentLabel.setText("with Content : ");
        initSearchGroupLayout();
    }

    private void initSortPanel() {
        initSortPanelGUI();
        initSortGroupPanel();
    }

    private void initSearchGroupLayout() {
        GroupLayout searchPanelLayout = new GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
                searchPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(searchPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(searchPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(searchPanelLayout.createSequentialGroup()
                                                .addComponent(searchLabel)
                                                .addGap(0, 117, Short.MAX_VALUE))
                                        .addGroup(searchPanelLayout.createSequentialGroup()
                                                .addGroup(searchPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(searchByLabel)
                                                        .addComponent(searchContentLabel))
                                                .addGap(18, 18, 18)
                                                .addGroup(searchPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(searchBySelection, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(searchContentInputField))))
                                .addContainerGap())
        );
        searchPanelLayout.setVerticalGroup(
                searchPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(searchPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(searchLabel)
                                .addGap(18, 18, 18)
                                .addGroup(searchPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(searchBySelection, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchByLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(searchPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(searchContentInputField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchContentLabel))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    private void initMainGroupLayout() {
        GroupLayout mainGroupLayout = new GroupLayout(getContentPane());
        getContentPane().setLayout(mainGroupLayout);
        mainGroupLayout.setHorizontalGroup(
                mainGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainGroupLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(mainGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(studentListTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(mainGroupLayout.createSequentialGroup()
                                                .addComponent(schoolTitle)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(userTitle)
                                                .addContainerGap())
                                        .addGroup(mainGroupLayout.createSequentialGroup()
                                                .addGroup(mainGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(addPanel, GroupLayout.PREFERRED_SIZE, 477, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(classTitle))
                                                .addGroup(mainGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(mainGroupLayout.createSequentialGroup()
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(mainGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(searchPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(sortPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                .addGap(4, 13, Short.MAX_VALUE))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, mainGroupLayout.createSequentialGroup()
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(showTop3)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(refreshButton)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(logoutButton)
                                                                .addContainerGap())))
                                        .addGroup(mainGroupLayout.createSequentialGroup()
                                                .addComponent(tablePanel, GroupLayout.PREFERRED_SIZE, 824, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))))
        );
        mainGroupLayout.setVerticalGroup(
                mainGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, mainGroupLayout.createSequentialGroup()
                                .addComponent(studentListTitle, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addGroup(mainGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(schoolTitle)
                                        .addComponent(userTitle))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(classTitle)
                                        .addComponent(logoutButton)
                                        .addComponent(refreshButton)
                                        .addComponent(showTop3))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(mainGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(mainGroupLayout.createSequentialGroup()
                                                .addComponent(searchPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(sortPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(addPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tablePanel, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    private void initSortGroupPanel() {
        GroupLayout sortPanelLayout = new GroupLayout(sortPanel);
        sortPanel.setLayout(sortPanelLayout);
        sortPanelLayout.setHorizontalGroup(
                sortPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(sortPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(sortPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(sortPanelLayout.createSequentialGroup()
                                                .addComponent(sortBySelectionLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                                                .addComponent(sortBySelectionInput, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(sortPanelLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(sortConditionInput, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(sortPanelLayout.createSequentialGroup()
                                                .addComponent(sortCondition)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(sortPanelLayout.createSequentialGroup()
                                                .addComponent(sortLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(sortButton, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        sortPanelLayout.setVerticalGroup(
                sortPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(sortPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(sortPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(sortLabel)
                                        .addComponent(sortButton))
                                .addGap(19, 19, 19)
                                .addGroup(sortPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(sortBySelectionLabel)
                                        .addComponent(sortBySelectionInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(sortPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(sortCondition)
                                        .addComponent(sortConditionInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(21, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(studentListTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(schoolTitle)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(tablePanel, GroupLayout.PREFERRED_SIZE, 824, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(classTitle)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(userTitle))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(addPanel, GroupLayout.PREFERRED_SIZE, 477, GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addComponent(sortPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addComponent(searchPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                        .addGap(0, 0, Short.MAX_VALUE))))))
                                                .addGap(0, 12, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(studentListTitle, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(schoolTitle)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(classTitle)
                                        .addComponent(userTitle))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(searchPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(sortPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(addPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tablePanel, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    private void initSortPanelGUI() {
        sortButton.setText("Sort");
        sortPanel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        sortLabel.setFont(new Font("Tahoma", 0, 14));
        sortLabel.setText("INPUT INFOR FOR SORTING :");
        sortBySelectionLabel.setText("Sort by : ");
        sortCondition.setText("Condition : ");
        sortBySelectionInput.setModel(new DefaultComboBoxModel<>(new String[]{"ID", "Last Name", "Grade"}));
        sortConditionInput.setModel(new DefaultComboBoxModel<>(new String[]{"A->Z", "Z->A"}));
    }

    private void initSchoolClassUserName() {
        schoolTitle.setFont(new Font("Tahoma", 0, 15));
        schoolTitle.setText("School : CodeGym");

        classTitle.setFont(new Font("Tahoma", 0, 15));
        classTitle.setText("Class   : C0220H1");

        userTitle.setFont(new Font("Tahoma", 2, 15));
        userTitle.setText("User: admin  ");
    }

    private void initPageTitle() {
        studentListTitle.setFont(new Font("Tahoma", 1, 24));
        studentListTitle.setHorizontalAlignment(SwingConstants.CENTER);
        studentListTitle.setText("STUDENT LIST");
    }

    private void initMainTable() {
        tablePanel = new JScrollPane();
        listTable = new JTable();
        listTable.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        listTable.setFont(new Font("Tahoma", 0, 14));
        listTable.setRowHeight(20);
        tablePanel.setViewportView(listTable);
    }
}
