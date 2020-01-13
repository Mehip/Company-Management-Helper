package CompanyManagementHelper.Controller;

import CompanyManagementHelper.Entity.TaskEntity;
import CompanyManagementHelper.Entity.UserEntity;
import CompanyManagementHelper.Properties.TaskProperties;
import CompanyManagementHelper.Service.TasksService;
import CompanyManagementHelper.Service.WorkersService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.stream.Collectors;

import static CompanyManagementHelper.Controller.TasksController.sendTaskService;
import static CompanyManagementHelper.Utils.HibernateUtils.insert;
import static CompanyManagementHelper.Utils.HibernateUtils.update;
import static java.lang.Thread.currentThread;

public class TasksCreateEditController {

  @FXML
  ComboBox<String> workerComboBox, statusComboBox;

  @FXML
  Button saveButton;

  @FXML
  TextArea taskTextArea;

  @FXML
  TextField estimatedTimeTextField, endTimeTextField;

  private TaskEntity taskEntity;
  static TasksService tasksService;
  static TaskProperties taskProperties;
  static TasksCreateEditController tasksCreateEditController;
  private int workMode = 0;

  public void initialize() {
    tasksCreateEditController = this;
    sendTaskService();

    taskEntity = new TaskEntity();
    WorkersService workersService = new WorkersService();
    workersService.init();

    ObservableList<String> users = FXCollections.observableArrayList(workersService.getItems().stream().map(UserEntity::getEmail).collect(Collectors.toList()));
    this.workerComboBox.setItems(users);

    try {
      System.out.println("TaskID: " + taskProperties.getId());
      setInfo();
    } catch (Exception e) {
      System.out.println("Adding new task");
    }
  }

  private void setInfo() {
    taskTextArea.setText(taskProperties.getTask());
    workerComboBox.setValue(taskProperties.getIdUser());
    statusComboBox.setValue(taskProperties.getStatus());
    estimatedTimeTextField.setText(taskProperties.getEstimatedTime());
    endTimeTextField.setText(taskProperties.getEndTimeTask());
    taskEntity.setId(taskProperties.getId());
    workMode = 1;
  }

  @FXML
  public void saveTask() {
    taskEntity.setStatus(statusComboBox.getValue());
    taskEntity.setTask(taskTextArea.getText());
    taskEntity.setIdUser(workerComboBox.getValue());
    taskEntity.setEndTimeTask(Double.parseDouble(endTimeTextField.getText()));
    taskEntity.setEstimatedTime(Double.parseDouble(estimatedTimeTextField.getText()));

    if (workMode == 0) {
      Thread thread = new Thread(() -> {
        Platform.runLater(() -> {
          insert(taskEntity);
          tasksService.init();
        });
      });
      thread.start();
    } else {
      Thread thread = new Thread(() -> {
        Platform.runLater(() -> {
          update(taskEntity);
          tasksService.init();
        });
      });
      thread.start();
    }

    Stage stage = (Stage) saveButton.getScene().getWindow();
    stage.close();
  }
}
