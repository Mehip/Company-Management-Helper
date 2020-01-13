package CompanyManagementHelper.Controller;

import CompanyManagementHelper.Properties.TaskProperties;
import CompanyManagementHelper.Service.TasksService;
import CompanyManagementHelper.Service.WorkersService;
import CompanyManagementHelper.Utils.ProfileRole;
import CompanyManagementHelper.Utils.SecurityUtils;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static CompanyManagementHelper.Controller.TasksController.sendTaskProperties;

public class TaskDialogController {

  static TaskProperties taskProperties;
  static TasksService tasksService;

  @FXML
  TextArea taskTextArea;

  @FXML
  Button deleteButton, editButton;

  @FXML
  TextField workerTextField, estimatedTimeTextField, endTimeTextField, statusTextField;

  public void initialize() {
    if(!(SecurityUtils.isAdmin(ProfileRole.userRole) || SecurityUtils.isBoss(ProfileRole.userRole) || SecurityUtils.isManager(ProfileRole.userRole))){
      deleteButton.setVisible(false);
      editButton.setVisible(false);
    }

    sendTaskProperties();
    setinfo();
  }

  private void setinfo() {
    workerTextField.setText(taskProperties.getIdUser());
    estimatedTimeTextField.setText(taskProperties.getEstimatedTime());
    endTimeTextField.setText(taskProperties.getEndTimeTask());
    statusTextField.setText(taskProperties.getStatus());
    taskTextArea.setText(taskProperties.getTask());
  }

  @FXML
  public void deleteTask() {
    Thread thread = new Thread(() -> {
      Platform.runLater(() -> {
        TasksService.deleteTaskDB(taskProperties);
        tasksService.init();
      });
    });
    thread.start();
    Stage stage = (Stage) deleteButton.getScene().getWindow();
    stage.close();
  }

  @FXML
  public void editTask() throws IOException {
    Stage stage = (Stage) editButton.getScene().getWindow();
    stage.setScene(new Scene(tasksService.loadFXML("tasksCreateEdit")));
  }
}
