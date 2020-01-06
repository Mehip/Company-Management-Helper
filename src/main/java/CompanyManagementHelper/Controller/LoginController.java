package CompanyManagementHelper.Controller;

import CompanyManagementHelper.App;
import CompanyManagementHelper.Entity.UserEntity;
import CompanyManagementHelper.Service.LoginService;
import CompanyManagementHelper.Utils.ProfileRole;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

import static CompanyManagementHelper.Controller.MyProfilController.myProfilController;

public class LoginController {

  @FXML
  TextField emailTextField;

  @FXML
  PasswordField passwordTextField;

  @FXML
  Button loginButton;

  @FXML
  Label failLoginLabel;

  private static UserEntity userEntity;
  private LoginService loginService;

  @FXML
  void initialize() {
    loginService = new LoginService();
  }

  @FXML
  private void login() throws IOException {

    userEntity = loginService.profilInfo(emailTextField.getText());
    //get userEntity for MyProfilController
    ProfileRole.userRole = userEntity.getRole();
    if (loginService.login(emailTextField.getText(), passwordTextField.getText())) App.setFXML("tasks");
    else
      failLoginLabel.setVisible(true);
  }

  //For MyProfilController data
  static void sendUser() {
    myProfilController.userEntity = userEntity;
  }
}
