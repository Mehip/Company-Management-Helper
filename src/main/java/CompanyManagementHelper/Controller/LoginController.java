package CompanyManagementHelper.Controller;

import CompanyManagementHelper.App;
import CompanyManagementHelper.Entity.UserEntity;
import CompanyManagementHelper.Service.LoginService;
import CompanyManagementHelper.Utils.ProfileRole;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.persistence.NoResultException;
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
  Label failLoginLabel, failLoginLabel1;

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
      loadingView.initStyle(StageStyle.UNDECORATED);
      loadingView.setAlwaysOnTop(true);
      loadingView.setX(600);
      loadingView.setY(200);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @FXML
  private void login() throws IOException {
    loadingView.show();

    Thread thread = new Thread(() -> {
      Platform.runLater(() -> {
        try {
          userEntity = loginService.profilInfo(emailTextField.getText());
          //get userEntity for MyProfilController
          if (loginService.login(emailTextField.getText(), passwordTextField.getText())) {
            ProfileRole.userRole = userEntity.getRole();
            ProfileRole.userName = userEntity.getEmail();
            loadingView.close();
            App.setFXML("tasks");
          } else {
            loadingView.close();
            failLoginLabel.setVisible(true);
            failLoginLabel1.setVisible(true);
          }
        } catch (NoResultException | IOException e) {
          loadingView.close();
          failLoginLabel.setVisible(true);
          failLoginLabel1.setVisible(true);
        }
      });
    });
    thread.start();
  }

  //For MyProfilController data
  static void sendUser() {
    myProfilController.userEntity = userEntity;
  }
}
