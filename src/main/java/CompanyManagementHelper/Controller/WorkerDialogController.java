package CompanyManagementHelper.Controller;

import CompanyManagementHelper.Properties.UserProperties;
import CompanyManagementHelper.Service.WorkerDialogService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static CompanyManagementHelper.Controller.WorkersController.sendUserProperties;

public class WorkerDialogController {

  @FXML
  Label nameLabel, surnameLabel, emailLabel, jobTimeLabel, workSinceLabel, dateOfBirthLabel, roleLabel, adressLabel, salaryLabel, bankAccountNumberLabel, peselNipLabel;

  @FXML
  Button editButton, deleteButton;

  UserProperties userProperties;
  public static WorkerDialogController workerDialogController;
  WorkerDialogService workerDialogService;

  @FXML
  public void initialize() {
    workerDialogController = this;
    userProperties = workerDialogController.userProperties;
    sendUserProperties();
    setUserInfo();
  }

  private void setUserInfo() {
    nameLabel.setText(userProperties.getName());
    surnameLabel.setText(userProperties.getSurname());
    roleLabel.setText(userProperties.getRole());
    emailLabel.setText("Email: " + userProperties.getEmail());
    workSinceLabel.setText("Pracuje od: " + userProperties.getWorkSince());
    jobTimeLabel.setText("Etat: " + userProperties.getJobTime());
    dateOfBirthLabel.setText("Data urodzenia: " + userProperties.getDateOfBirth());
    peselNipLabel.setText("Pesel/NIP: " + userProperties.getPesel());
    bankAccountNumberLabel.setText("Nr konta bankowego: " + userProperties.getBankAccountNumber());
    adressLabel.setText(userProperties.getCity() + " " + userProperties.getStreet() + " " + userProperties.getHouseNumber() + " " + userProperties.getFlatNumber() + " " + userProperties.getPostalCode());
    salaryLabel.setText("Pensja: " + userProperties.getSalary());
  }

  @FXML
  public void editUser() {
  }

  @FXML
  public void deleteUser() {
    try {
      workerDialogService.deleteUser(this.userProperties);
      Stage stage = (Stage) Stage.getWindows();
      stage.close();
    }catch (NullPointerException e){
      e.getStackTrace();
    }
  }
}
