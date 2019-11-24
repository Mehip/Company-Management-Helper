package CompanyManagementHelper.Controller;

import CompanyManagementHelper.App;
import CompanyManagementHelper.Entity.UserEntity;
import CompanyManagementHelper.Utils.SecurityUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

import java.io.IOException;

import static CompanyManagementHelper.Controller.MyProfilController.getUserRole;

public class MenuController {

  @FXML
  Button myProfilButton, statisticButton, tasksButton, workerButton, workHoursButton, aboutAplicationButton;

  @FXML
  MenuItem myProfile;

  public static MenuController menuController;
  String userRole;

  @FXML
  void initialize(){
    menuController = this;
    userRole = menuController.userRole;
    getUserRole();
    System.out.println(menuController.userRole);
    System.out.println(userRole);
//    if(SecurityUtils.isAdmin(userRole)){
//      myProfile.setVisible(false);
//    }
  }

  @FXML
  private void logout() throws IOException {
    App.setFXML("login");
  }

  @FXML
  private void myProfil() throws IOException {
    App.setFXML("myProfil");
  }

  @FXML
  private void tasksView() throws IOException {
    App.setFXML("tasks");
  }

  @FXML
  private void workerView() throws IOException {
    App.setFXML("workers");
  }

  @FXML
  private void workHoursView() throws IOException {
    //App.setFXML("workHours");
  }

  @FXML
  private void statisticView() throws IOException {
    App.setFXML("statistic");
  }

  @FXML
  private void aboutAplicationView() throws IOException {
    App.setFXML("aboutAplication");
  }
}
