package controller;

import dataManagement.*;
import entity.Student;
import view.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.*;

public class ManagementDisplayController {
    private ManagementDisplay managementDisplay;
    public static DefaultTableModel defaultTableModel;
    private StudentManagement studentManagement;
    private DataEdit dataEdit = new DataEdit();
    ArrayList<Student> dataForLoadToTable = new ArrayList<>();

    public ManagementDisplayController(String string) {
    }

    public ManagementDisplayController() {
        this.studentManagement = new StudentManagement();
        this.managementDisplay = new ManagementDisplay("Management Sheet");
        this.dataEdit.importDataToMainArray(studentManagement.studentList);
        drawMainTableColumnContent();
        loadDataToMainTable();
        sortFunction();
        searchStudentFunction();
        deleteStudentFunction();
        changeInforStudentFunction();
        addNewStudentFunction();
        gradeInputFieldValidate();
        dobInputFieldValidate();
        idInputFieldValidate();
        refreshButtonFunction();
        showTop3Function();
        logoutButtonFunction();
        managementDisplay.setVisible(true);
    }

    public void setDataForLoadToTable(ArrayList<Student> dataForLoadToTable) {
        this.dataForLoadToTable = dataForLoadToTable;
    }

    public ArrayList<Student> getDataForLoadToTable() {
        return dataForLoadToTable;
    }

    //To Show Top 3 Student follow Grade
    private void showTop3Function() {
        managementDisplay.getShowTop3().addActionListener(evt -> {
            if (managementDisplay.getShowTop3().isSelected()) {
                sortByGrade("Z->A", studentManagement.studentList);
                defaultTableModel.setRowCount(0);
                add3BestStudentIntoMainTable();
            } else {
                defaultTableModel.setRowCount(0);
                loadDataToMainTable();
            }
        });
    }

    private void add3BestStudentIntoMainTable() {
        for (int i = 0; i < 3; i++) {
            defaultTableModel.addRow(new Object[]{studentManagement.studentList.get(i).getId(),
                    studentManagement.studentList.get(i).getFirstName(),
                    studentManagement.studentList.get(i).getLastName(),
                    studentManagement.studentList.get(i).getGender(),
                    studentManagement.studentList.get(i).getGrade(),
                    studentManagement.studentList.get(i).getDateOfBirth(),
                    studentManagement.studentList.get(i).getPhoneNumber()});
        }
    }

    //To sort
    private void sortFunction() {
        managementDisplay.getSortButton().addActionListener(evt -> {
            if (!searchContentInputNotEmpty()) {
                reloadMainData();
                sortAction(studentManagement.studentList);
            } else {
                searchStudentFunction();
                sortAction(studentManagement.searchingList);
            }
        });
    }

    private void sortAction(ArrayList<Student> list) {
        String sortBy = String.valueOf(managementDisplay.getSortBySelectionInput().getSelectedItem());
        String sortCondition = String.valueOf(managementDisplay.getSortConditionInput().getSelectedItem());
        switch (sortBy) {
            case "ID":
                sortByID(sortCondition, list);
                break;
            case "Last Name":
                sortByLastName(sortCondition, list);
                break;
            case "Grade":
                sortByGrade(sortCondition, list);
                break;
        }
        defaultTableModel.setRowCount(0);
        addRowToMainTable(list);
    }

    private void sortByGrade(String sortCondition, ArrayList<Student> list) {
        list.sort((o1, o2) -> {
            if (sortCondition.equals("Z->A")) {
                return o1.getGrade() > o2.getGrade() ? -1 : 1;
            } else {
                return o1.getGrade() > o2.getGrade() ? 1 : -1;
            }
        });
    }

    private void sortByLastName(String sortCondition, ArrayList<Student> list) {
        list.sort((o1, o2) -> {
            if (sortCondition.equals("Z->A")) {
                return o2.getLastName().compareTo(o1.getLastName());
            } else {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
    }

    private void sortByID(String sortCondition, ArrayList<Student> list) {
        list.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (sortCondition.equals("Z->A")) {
                    return o1.getId() < o2.getId() ? 1 : -1;
                } else {
                    return o1.getId() < o2.getId() ? -1 : 1;
                }
            }
        });
    }

    //To Search Student
    public void searchStudentFunction() {
        managementDisplay.getSearchContentInputField().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                showOnTableAfterSearch();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                showOnTableAfterSearch();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                showOnTableAfterSearch();
            }
        });
    }

    public void showOnTableAfterSearch() {
        try {
            String searchBy = String.valueOf(managementDisplay.getSearchBySelection().getSelectedItem());
            studentManagement.searchingList.clear();
            switch (searchBy) {
                case "ID": {
                    searchByID();
                    break;
                }
                case "Last Name": {
                    searchByLastName();
                    break;
                }
                case "Gender": {
                    searchByGender();
                    break;
                }
            }
        } catch (NumberFormatException e) {
            e.fillInStackTrace();
        }
    }

    private void searchByID() {
        if (searchContentInputNotEmpty()) {
            String searchInput = managementDisplay.getSearchContentInputField().getText();
            String search = "ID";
            reloadSearchData(search, "=" + String.valueOf(Integer.parseInt(searchInput)));
        } else {
            reloadMainData();
        }
    }

    private void searchByGender() {
        if (searchContentInputNotEmpty()) {
            String searchInput = managementDisplay.getSearchContentInputField().getText();
            String search = "Gender";
            reloadSearchData(search, "='" + searchInput + "'");
        } else {
            reloadMainData();
        }
    }

    private void searchByLastName() {
        if (searchContentInputNotEmpty()) {
            String searchInput = managementDisplay.getSearchContentInputField().getText();
            String search = "[Last Name]";
            reloadSearchData(search, "like N'%" + searchInput + "%'");
        } else {
            reloadMainData();
        }
    }

    private boolean searchContentInputNotEmpty() {
        return managementDisplay.getSearchContentInputField().getText().length() != 0;
    }

    //To delete selected Student
    private void deleteStudentFunction() {
        managementDisplay.getDeleteButton().addActionListener(evt -> {
            if (isSelectedAStudent()) {
                int rowSelected = selectRow();
                int toDeleteStudentId = getIdFromSelectedRow(rowSelected);
                if (confirmToDeleteStudent() == JOptionPane.YES_OPTION) {
                    dataEdit.deleteStudentInSQL(toDeleteStudentId);
                    reloadMainData();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select Student to Delete first!");
            }
        });
    }

    public int confirmToDeleteStudent() {
        return JOptionPane.showConfirmDialog(null, "Delete ?");
    }

    //To change information of Student, when click "change" button, new window will be displayed to Input
    public void changeInforStudentFunction() {
        managementDisplay.getChangeButton().addActionListener(evt -> {
            if (isSelectedAStudent()) {
                new ChangeInformationController(getStudentSelected());
            } else {
                JOptionPane.showMessageDialog(null, "Please select Student to change first!");
            }
        });
    }

    // To get Student that selected by click on table row
    public boolean isSelectedAStudent() {
        return selectRow() != -1;
    }

    public int selectRow() {
        return managementDisplay.getListTable().getSelectedRow();
    }

    public int getIdFromSelectedRow(int row) {
        return Integer.parseInt(String.valueOf(managementDisplay.getListTable().getValueAt(row, 0)));
    }

    public Student getStudentSelected() {
        return studentManagement.getStudentById(getIdFromSelectedRow(selectRow()));
    }

    //To add new student.Student
    private void addNewStudentFunction() {
        managementDisplay.getAddButton().addActionListener(evt -> {
            try {
                if (isValidDOBFormat()) {
                    Student studentToAdd = buildStudentFollowInputField();
                    if (!haveIdInList(studentToAdd.getId(), studentManagement.studentList)) {
                        dataEdit.addStudentToSQL(studentToAdd);
                        reloadMainData();
                    } else {
                        JOptionPane.showMessageDialog(null, "Already existed ID, Please choose other ID Number");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong Birthday Format");
                }
            } catch (NullPointerException ignored) {
            }
        });
    }

    private boolean isValidDOBFormat() {
        return managementDisplay.getValidateDOB().getText().equals("Valid Format");
    }

    public void gradeInputFieldValidate() {
        managementDisplay.getGradeInputField().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                announceValidateGrade();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                announceValidateGrade();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                announceValidateGrade();
            }
        });
    }

    private void announceValidateGrade() {
        String gradeNewStudent = managementDisplay.getGradeInputField().getText();
        if (gradeNotEmpty(gradeNewStudent)) {
            announceValidGrade(gradeNewStudent);
        } else {
            managementDisplay.getValidateGrade().setText("Grade can not be empty!    ");
            managementDisplay.getValidateGrade().setForeground(Color.RED);
        }
    }

    private void announceValidGrade(String gradeNewStudent) {
        try {
            Double.valueOf(gradeNewStudent);
            managementDisplay.getValidateGrade().setText("Valid Format!    ");
            managementDisplay.getValidateGrade().setForeground(Color.BLUE);
        } catch (NumberFormatException e) {
            managementDisplay.getValidateGrade().setText("Wrong Number Format!    ");
            managementDisplay.getValidateGrade().setForeground(Color.RED);
        }
    }

    public void dobInputFieldValidate() {
        managementDisplay.getDobInputField().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                announceValidateDOB();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                announceValidateDOB();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                announceValidateDOB();
            }
        });
    }

    private void announceValidateDOB() {
        String dobRegex = "([0-2][0-9]|[3][0-1])/([0][1-9]|[1][0-2])/[0-9]{4}";
        String dobNewStudent = managementDisplay.getDobInputField().getText();
        if (dobNewStudent.matches(dobRegex)) {
            managementDisplay.getValidateDOB().setText("Valid Format");
            managementDisplay.getValidateDOB().setForeground(Color.BLUE);
        } else {
            managementDisplay.getValidateDOB().setText("Wrong Format Date");
            managementDisplay.getValidateDOB().setForeground(Color.RED);
        }
    }

    public void idInputFieldValidate() {
        managementDisplay.getIdInputField().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                announceValidateID();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                announceValidateID();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                announceValidateID();
            }
        });
    }

    public void announceValidateID() {
        String idNewStudent = managementDisplay.getIdInputField().getText();
        if (idNotEmpty(idNewStudent)) {
            try {
                announceValidID(idNewStudent);
            } catch (NumberFormatException e) {
                managementDisplay.getValidateID().setText("Wrong Number Format");
                managementDisplay.getValidateID().setForeground(Color.RED);
            }
        } else {
            managementDisplay.getValidateID().setText("ID can not be empty!");
            managementDisplay.getValidateID().setForeground(Color.RED);
        }
    }

    private void announceValidID(String idNewStudent) {
        if (haveIdInList(Integer.parseInt(idNewStudent), studentManagement.studentList)) {
            managementDisplay.getValidateID().setText("ID is existed ");
            managementDisplay.getValidateID().setForeground(Color.RED);
        } else {
            managementDisplay.getValidateID().setText("Valid ID ");
            managementDisplay.getValidateID().setForeground(Color.BLUE);
        }
    }

    public Student buildStudentFollowInputField() {
        String idNewStudent = managementDisplay.getIdInputField().getText();
        String firstNameNewStudent = managementDisplay.getFirstNameInputField().getText();
        String lastNameNewStudent = managementDisplay.getLastNameInputField().getText();
        String genderNewStudent = managementDisplay.getGenderInputField().getText();
        String gradeNewStudent = managementDisplay.getGradeInputField().getText();
        String dobNewStudent = managementDisplay.getDobInputField().getText();
        String phoneNumberNewStudent = managementDisplay.getPhoneNoInputField().getText();
        Student newStudent = null;
        try {
            if (idNotEmpty(idNewStudent) && gradeNotEmpty(gradeNewStudent)) {
                newStudent = new Student(Integer.parseInt(idNewStudent), firstNameNewStudent, lastNameNewStudent,
                        genderNewStudent, Double.parseDouble(gradeNewStudent), dobNewStudent, phoneNumberNewStudent);
            } else {
                JOptionPane.showMessageDialog(null, "ID or Grade is empty");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Wrong Number Format for ID or Grade");
        }
        return newStudent;
    }

    private boolean idNotEmpty(String idNewStudent) {
        return !idNewStudent.equals("");
    }

    private boolean gradeNotEmpty(String gradeNewStudent) {
        return !gradeNewStudent.equals("");
    }

    //To refresh Page
    public void refreshButtonFunction() {
        managementDisplay.getRefreshButton().addActionListener(evt -> {
            managementDisplay.getSearchContentInputField().setText("");
            reloadMainData();
        });
    }

    //To Logout
    public void logoutButtonFunction() {
        managementDisplay.getLogoutButton().addActionListener(evt -> {
            managementDisplay.dispose();
            LoginDisplayController loginDisplayController = new LoginDisplayController();
            loginDisplayController.showLoginScreen();
        });
    }

    //Common check and action
    private boolean haveIdInList(int id, ArrayList<Student> list) {
        for (Student st : list) {
            if (id == st.getId()) {
                return true;
            }
        }
        return false;
    }

    public void reloadMainData() {
        defaultTableModel.setRowCount(0);
        dataForLoadToTable.clear();
        loadDataToMainTable();
    }

    public void loadDataToMainTable() {
        dataForLoadToTable = dataEdit.importDataToMainArray(studentManagement.studentList);
        addRowToMainTable(dataForLoadToTable);
    }

    private void loadDataToSearchResultTable(String searchBy, String str) {
        dataForLoadToTable = dataEdit.importDataToSearchArray(searchBy, str, studentManagement.searchingList);
        addRowToMainTable(studentManagement.searchingList);
    }

    private void reloadSearchData(String searchBy, String str) {
        defaultTableModel.setRowCount(0);
        dataForLoadToTable.clear();
        loadDataToSearchResultTable(searchBy, str);
    }

    private void addRowToMainTable(ArrayList<Student> list) {
        for (Student student : list) {
            defaultTableModel.addRow(new Object[]{student.getId(), student.getFirstName(),
                    student.getLastName(), student.getGender(), student.getGrade(),
                    student.getDateOfBirth(), student.getPhoneNumber()});
        }
    }

    private void drawMainTableColumnContent() {
        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        managementDisplay.getListTable().setModel(defaultTableModel);
        defaultTableModel.addColumn("ID");
        defaultTableModel.addColumn("First Name");
        defaultTableModel.addColumn("Last Name");
        defaultTableModel.addColumn("Gender");
        defaultTableModel.addColumn("Grade");
        defaultTableModel.addColumn("DOB");
        defaultTableModel.addColumn("Phone Number");
    }
}
