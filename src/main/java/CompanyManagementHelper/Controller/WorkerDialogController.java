package CompanyManagementHelper.Controller;

import CompanyManagementHelper.Properties.UserProperties;
import CompanyManagementHelper.Service.WorkersService;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

import static CompanyManagementHelper.Controller.WorkersController.sendUserProperties;

public class WorkerDialogController {

  @FXML
  Label nameLabel, surnameLabel, emailLabel, jobTimeLabel, workSinceLabel, dateOfBirthLabel, roleLabel, adressLabel, salaryLabel, bankAccountNumberLabel, peselNipLabel;

  @FXML
  Button editButton, deleteButton;

  UserProperties userProperties;
  static WorkerDialogController workerDialogController;
  static WorkersService workersService;

  @FXML
  public void initialize() {
    workerDialogController = this;
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

    if (userProperties.getEmail().equals("admin")) {
      editButton.setVisible(true);
      deleteButton.setVisible(false);
    }
  }

  @FXML
  public void editUser() throws IOException {
    Stage stage = (Stage) editButton.getScene().getWindow();
    stage.setScene(new Scene(workersService.loadFXML("userCreateEdit")));
  }

  @FXML
  public void deleteUser() {
    try {
      WorkersService.deleteUserDB(this.userProperties);
      workersService.init();
      Stage stage = (Stage) deleteButton.getScene().getWindow();
      stage.close();
    } catch (NullPointerException e) {
      e.getStackTrace();
    }
  }
}
