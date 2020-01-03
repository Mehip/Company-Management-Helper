package CompanyManagementHelper.Controller;

import CompanyManagementHelper.Entity.TaskEntity;
import CompanyManagementHelper.Entity.UserEntity;
import CompanyManagementHelper.Service.TasksService;
import CompanyManagementHelper.Service.WorkersService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.stream.Collectors;

import static CompanyManagementHelper.Controller.TasksController.sendTaskService;
import static CompanyManagementHelper.Utils.HibernateUtils.insert;

public class TasksCreateEditController {

  @FXML
  ComboBox<String> workerComboBox;

  @FXML
  Button saveButton;

  @FXML
  TextArea taskTextArea;

  @FXML
  TextField estimatedTimeTextField;

  WorkersService workersService;
  TaskEntity taskEntity;
  static TasksService tasksService;
  static TasksCreateEditController tasksCreateEditController;

  public void initialize(){
    tasksCreateEditController = this;
    sendTaskService();

    taskEntity = new TaskEntity();
    this.workersService = new WorkersService();
    workersService.init();

    ObservableList<String> users = FXCollections.observableArrayList(workersService.getItems().stream().map(UserEntity::getEmail).collect(Collectors.toList()));
    this.workerComboBox.setItems(users);
  }

  @FXML
  public void saveTask() {
    taskEntity.setEstimatedTime(Double.parseDouble(estimatedTimeTextField.getText()));
    taskEntity.setStatus("OCZEKIWANIE");
    taskEntity.setTask(taskTextArea.getText());
    taskEntity.setIdUser(workerComboBox.getValue());
    taskEntity.setEndTimeTask(0.0);
    insert(taskEntity);
    tasksService.init();

    Stage stage = (Stage) saveButton.getScene().getWindow();
    stage.close();
  }
}
