package CompanyManagementHelper.Controller;

import CompanyManagementHelper.Entity.UserEntity;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import static CompanyManagementHelper.Controller.LoginController.sendUser;
import static CompanyManagementHelper.Controller.MenuController.menuController;

public class MyProfilController {

  @FXML
  Label nameLabel, surnameLabel, emailLabel, roleLabel, dateOfBirthLabel, adressLabel;

  UserEntity userEntity;
  public static MyProfilController myProfilController;
  private static String userRole;

  @FXML
  void initialize() {
    myProfilController = this;
    userEntity = myProfilController.userEntity;
    sendUser();
    setProfil();
    userRole = userEntity.getRole();
//    System.out.println(userRole);
  }

  private void setProfil() {
    nameLabel.setText(userEntity.getName());
    surnameLabel.setText(userEntity.getSurname());
    emailLabel.setText(userEntity.getEmail());
    roleLabel.setText(userEntity.getRole());
    dateOfBirthLabel.setText(userEntity.getDateOfBirth().toString());
    adressLabel.setText(userEntity.getCity() + " " + userEntity.getStreet() + " " + userEntity.getHouseNumber() + "/" + userEntity.getFlatNumber());
  }

  public static void getUserRole(){
    menuController.userRole = userRole;
  }
}