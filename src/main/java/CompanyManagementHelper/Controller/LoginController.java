package CompanyManagementHelper.Controller;

import CompanyManagementHelper.App;
import CompanyManagementHelper.Entity.UserEntity;
import CompanyManagementHelper.Service.LoginService;
import CompanyManagementHelper.Utils.ProfileRole;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.ResourceBundle;

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
  private Stage loadingView;

  @FXML
  void initialize() {
    loginService = new LoginService();
    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("loading.fxml"));
    ResourceBundle bundle = ResourceBundle.getBundle("i18n.messages");
    fxmlLoader.setResources(bundle);

    loadingView = new Stage();
    try {
      Scene loadScene = new Scene(fxmlLoader.load());
      loadingView.setScene(loadScene);
      loadingView.setAlwaysOnTop(true);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @FXML
  private void login() throws IOException {
    loadingView.show();
    userEntity = loginService.profilInfo(emailTextField.getText());

    //get userEntity for MyProfilController
    if (loginService.login(emailTextField.getText(), passwordTextField.getText())) {
      ProfileRole.userRole = userEntity.getRole();
      ProfileRole.userName = userEntity.getEmail();
      App.setFXML("tasks");
    }
    else
      failLoginLabel.setVisible(true);

    loadingView.close();
  }

  //For MyProfilController data
  static void sendUser() {
    myProfilController.userEntity = userEntity;
  }
}
