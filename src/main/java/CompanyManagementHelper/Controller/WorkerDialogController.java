package CompanyManagementHelper.Controller;

import CompanyManagementHelper.Properties.UserProperties;
import CompanyManagementHelper.Service.WorkerDialogService;
import CompanyManagementHelper.Service.WorkersService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

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
    workersService = workerDialogController.workersService;
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

  //TODO EDYCJA PRACOWNIKA
  @FXML
  public void editUser() {
  }

  @FXML
  public void deleteUser() {
    try {
      WorkerDialogService.deleteUserDB(this.userProperties);
      workersService.init();
      Stage stage = (Stage) deleteButton.getScene().getWindow();
      stage.close();
    }catch (NullPointerException e){
      e.getStackTrace();
    }
  }
}
