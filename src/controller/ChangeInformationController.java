package controller;

import view.*;
import dataManagement.*;
import entity.*;

import javax.swing.*;

public class ChangeInformationController {
    private ChangeInformationDisplay changeInformationDisplay;
    private ManagementDisplayController managementDisplayController;
    private StudentManagement studentManagement = new StudentManagement();
    private DataEdit dataEdit = new DataEdit();
    private Student studentToDisplay;

    public Student getStudentToDisplay() {
        return studentToDisplay;
    }

    public void setStudentToDisplay(Student studentToDisplay) {
        this.studentToDisplay = studentToDisplay;
    }

    public ChangeInformationController(Student studentToDisplay) {
        changeInformationDisplay = new ChangeInformationDisplay();
        managementDisplayController = new ManagementDisplayController("Main");
        setStudentToDisplay(studentToDisplay);
        takeInforToInputField();
        okButtonFunction();
        cancelButtonFunction();
    }

    public void takeInforToInputField() {
        Student studentToChange = getStudentToDisplay();
        changeInformationDisplay.getIdInputField().setText(String.valueOf(studentToChange.getId()));
        changeInformationDisplay.getFirstNameInputField().setText(studentToChange.getFirstName());
        changeInformationDisplay.getLastNameInputField().setText(studentToChange.getLastName());
        changeInformationDisplay.getGenderInputField().setText(studentToChange.getGender());
        changeInformationDisplay.getGradeInputField().setText(String.valueOf(studentToChange.getGrade()));
        changeInformationDisplay.getDobInputField().setText(studentToChange.getDateOfBirth());
        changeInformationDisplay.getPhoneNoInputField().setText(studentToChange.getPhoneNumber());
    }

    private void cancelButtonFunction() {
        changeInformationDisplay.getCancelButton().addActionListener(evt ->
                changeInformationDisplay.dispose());
    }

    private void okButtonFunction() {
        changeInformationDisplay.getOkButton().addActionListener(evt -> {
            if (studentBuildUseInputField() != null) {
                Student studentAfterChange = studentBuildUseInputField();
                dataEdit.changeInformationStudentInSQL(studentAfterChange);
                reloadDataOfMainTable();
                changeInformationDisplay.dispose();
            }
        });
    }

    private void reloadDataOfMainTable() {
        ManagementDisplayController.defaultTableModel.setRowCount(0);
        loadDataToMainTable();
    }

    private void loadDataToMainTable() {
        managementDisplayController.setDataForLoadToTable(dataEdit.importDataToMainArray(studentManagement.studentList));
        for (Student student : managementDisplayController.getDataForLoadToTable()) {
            ManagementDisplayController.defaultTableModel.addRow(new Object[]{student.getId(), student.getFirstName(),
                    student.getLastName(), student.getGender(), student.getGrade(),
                    student.getDateOfBirth(), student.getPhoneNumber()});
        }
    }
    public Student studentBuildUseInputField() {
        if (isValidInputValueOfGrade()){
            if  (isValidInputValueOfDOB()){
                return new Student(Integer.parseInt(changeInformationDisplay.getIdInputField().getText()),
                        changeInformationDisplay.getFirstNameInputField().getText(),
                        changeInformationDisplay.getLastNameInputField().getText(),
                        changeInformationDisplay.getGenderInputField().getText(),
                        Double.parseDouble(changeInformationDisplay.getGradeInputField().getText()),
                        changeInformationDisplay.getDobInputField().getText(),
                        changeInformationDisplay.getPhoneNoInputField().getText());
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Birthday input Format : Number");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Grade input Format : dd/mm/yyyy");
        }
        return null;
    }

    public boolean isValidInputValueOfGrade(){
        String gradeRegex = "[0-9]*.*[0-9]*";
        return changeInformationDisplay.getGradeInputField().getText().matches(gradeRegex);
    }

    public boolean isValidInputValueOfDOB(){
        String dobRegex = "([0-2][0-9]|[3][0-1])/([0][1-9]|[1][0-2])/[0-9]{4}";
        return changeInformationDisplay.getDobInputField().getText().matches(dobRegex);
    }
}