package CompanyManagementHelper.Controller;

import CompanyManagementHelper.Entity.UserEntity;
import CompanyManagementHelper.Properties.UserProperties;
import CompanyManagementHelper.Service.WorkersService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static CompanyManagementHelper.Controller.WorkersController.sendWorkersSerivce;
import static CompanyManagementHelper.Utils.HibernateUtils.insert;
import static CompanyManagementHelper.Utils.HibernateUtils.update;

public class UserCreateEditController {

  @FXML
  TextField nameTextField, surnameTextField, cityTextField, dateOfBirthTextField, emailTextField, peselTextField, streetTextField, houseNumberTextField, flatNumberTextField, postalCodeTextField, numberBankAccountTextField, jobTimeTextField, roleTextField, salaryTextField;

  @FXML
  PasswordField passwordField;

  @FXML
  Button saveButton;

  private UserEntity userEntity;
  UserProperties userProperties;
  static WorkersService workersService;
  static UserCreateEditController userCreateEditController;
  private int workMode = 0;

  public void initialize() {
    userEntity = new UserEntity();
    userCreateEditController = this;
    sendWorkersSerivce();
    try {
      System.out.println("UserID: " + userProperties.getId());
      setUserInfo();
    } catch (Exception e) {
      workMode = 1;
      System.out.println("Adding new worker");
    }
  }

  private void setUserInfo() {
    nameTextField.setText(userProperties.getName());
    surnameTextField.setText(userProperties.getSurname());
    cityTextField.setText(userProperties.getCity());
    dateOfBirthTextField.setText(userProperties.getDateOfBirth());
    emailTextField.setText(userProperties.getEmail());
    peselTextField.setText(userProperties.getPesel());
    streetTextField.setText(userProperties.getStreet());
    passwordField.setText(userProperties.getPassword());
    houseNumberTextField.setText(userProperties.getHouseNumber());
    flatNumberTextField.setText(userProperties.getFlatNumber());
    jobTimeTextField.setText(userProperties.getJobTime());
    numberBankAccountTextField.setText(userProperties.getBankAccountNumber());
    roleTextField.setText(userProperties.getRole());
    postalCodeTextField.setText(userProperties.getPostalCode());
    roleTextField.setText(userProperties.getRole());
    salaryTextField.setText(userProperties.getSalary());
    userEntity.setId(userProperties.getId());
  }

  @FXML
  public void saveUser() {
    userEntity.setName(nameTextField.getText());
    userEntity.setSurname(surnameTextField.getText());
    userEntity.setCity(cityTextField.getText());
    userEntity.setDateOfBirth(LocalDate.parse(dateOfBirthTextField.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    userEntity.setEmail(emailTextField.getText());
    userEntity.setPesel(peselTextField.getText());
    userEntity.setStreet(streetTextField.getText());
    userEntity.setPassword(String.valueOf(passwordField.getText().hashCode()));
    userEntity.setHouseNumber(houseNumberTextField.getText());
    userEntity.setFlatNumber(flatNumberTextField.getText());
    userEntity.setJobTime(Double.parseDouble(jobTimeTextField.getText()));
    userEntity.setBankAccountNumber(numberBankAccountTextField.getText());
    userEntity.setPostalCode(postalCodeTextField.getText());
    userEntity.setWorkSince(LocalDate.now());
    userEntity.setRole(roleTextField.getText());
    userEntity.setSalary(Double.parseDouble(salaryTextField.getText()));

    if (workMode == 1) {
      Thread thread = new Thread(() -> {
        Platform.runLater(() -> {
          insert(userEntity);
          workersService.init();
        });
      });
      thread.start();
    } else {
      Thread thread = new Thread(() -> {
        Platform.runLater(() -> {
          update(userEntity);
          workersService.init();
        });
      });
      thread.start();
    }

    Stage stage = (Stage) saveButton.getScene().getWindow();
    stage.close();
  }
}
