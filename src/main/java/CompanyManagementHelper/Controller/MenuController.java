package CompanyManagementHelper.Controller;

import CompanyManagementHelper.App;
import CompanyManagementHelper.Utils.ProfileRole;
import CompanyManagementHelper.Utils.SecurityUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

import java.io.IOException;

public class MenuController {

  @FXML
  Button statisticButton, tasksButton, workerButton, workHoursButton, aboutAplicationButton;
  @FXML
  MenuItem myProfile;

  @FXML
  void initialize() {
    if (SecurityUtils.isAdmin(ProfileRole.userRole)) {
      myProfile.setVisible(false);
    }
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
    App.setFXML("workHours");
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
