package CompanyManagementHelper.Controller;

import CompanyManagementHelper.Entity.UserEntity;
import CompanyManagementHelper.Service.WorkersService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static CompanyManagementHelper.Controller.WorkersController.sendWorkersSerivce;
import static CompanyManagementHelper.Utils.HibernateUtils.insert;

public class UserCreateEditController {

  @FXML
  TextField nameTextField, surnameTextField, cityTextField, dateOfBirthTextField, emailTextField, peselTextField, streetTextField, houseNumberTextField, flatNumberTextField, postalCodeTextField, numberBankAccountTextField, jobTimeTextField;

  @FXML
  PasswordField passwordField;

  @FXML
  Button saveButton;

  private UserEntity userEntity;
  static WorkersService workersService;
  static UserCreateEditController userCreateEditController;

  public void initialize() {
    userEntity = new UserEntity();
    userCreateEditController = this;
    workersService = userCreateEditController.workersService;
    sendWorkersSerivce();
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
    userEntity.setPassword(passwordField.getText());
    userEntity.setHouseNumber(houseNumberTextField.getText());
    userEntity.setFlatNumber(flatNumberTextField.getText());
    userEntity.setJobTime(Double.parseDouble(jobTimeTextField.getText()));
    userEntity.setBankAccountNumber(numberBankAccountTextField.getText());
    userEntity.setPostalCode(postalCodeTextField.getText());
    userEntity.setWorkSince(LocalDate.now());
    insert(userEntity);
    workersService.init();
    Stage stage = (Stage) saveButton.getScene().getWindow();
    stage.close();
  }
}
