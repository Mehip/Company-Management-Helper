package CompanyManagementHelper.Controller;

import CompanyManagementHelper.Entity.UserEntity;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import static CompanyManagementHelper.Controller.LoginController.sendUser;

public class MyProfilController {

  @FXML
  Label nameLabel, surnameLabel, emailLabel, roleLabel, dateOfBirthLabel, adressLabel;

  UserEntity userEntity;
  static MyProfilController myProfilController;

  @FXML
  void initialize() {
    myProfilController = this;
    sendUser();
    setProfil();
  }

  private void setProfil() {
    nameLabel.setText(userEntity.getName());
    surnameLabel.setText(userEntity.getSurname());
    emailLabel.setText(userEntity.getEmail());
    roleLabel.setText(userEntity.getRole());
    dateOfBirthLabel.setText(userEntity.getDateOfBirth().toString());
    adressLabel.setText(userEntity.getCity() + " " + userEntity.getStreet() + " " + userEntity.getHouseNumber() + "/" + userEntity.getFlatNumber());
  }
}
