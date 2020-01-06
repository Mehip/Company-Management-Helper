package CompanyManagementHelper.Controller;

import CompanyManagementHelper.Properties.TaskProperties;
import CompanyManagementHelper.Service.TasksService;
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
    TasksService.deleteTaskDB(taskProperties);
    tasksService.init();
    Stage stage = (Stage) deleteButton.getScene().getWindow();
    stage.close();
  }

  @FXML
  public void editTask() throws IOException {
    Stage stage = (Stage) editButton.getScene().getWindow();
    stage.setScene(new Scene(tasksService.loadFXML("tasksCreateEdit")));
  }
}
