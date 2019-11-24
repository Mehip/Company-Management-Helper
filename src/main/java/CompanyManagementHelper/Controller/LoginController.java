package CompanyManagementHelper.Controller;

import CompanyManagementHelper.App;
import CompanyManagementHelper.Entity.UserEntity;
import CompanyManagementHelper.Service.LoginService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

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
  void initialize() throws IOException {
    loginService = new LoginService();

  }

  @FXML
  void enter(KeyEvent event) throws IOException {
    if (event.getCode().equals(KeyCode.ENTER)) {
      loginButton.fire();
    }
  }

  @FXML
  private void login() throws IOException {
    //get userEntity for MyProfilController
    userEntity = loginService.profilInfo(emailTextField.getText());

    //TODO Hashowanie hasła
    if (loginService.login(emailTextField.getText(), passwordTextField.getText())) {
      App.setFXML("tasks");
    } else
      failLoginLabel.setVisible(true);
  }

  //For MyProfilController data
  public static void sendUser() {
    myProfilController.userEntity = userEntity;
  }
}
