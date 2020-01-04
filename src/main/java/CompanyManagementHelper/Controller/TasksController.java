package CompanyManagementHelper.Controller;

import CompanyManagementHelper.Properties.TaskProperties;
import CompanyManagementHelper.Properties.UserProperties;
import CompanyManagementHelper.Service.TasksService;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import static CompanyManagementHelper.Controller.TaskDialogController.taskDialogController;
import static CompanyManagementHelper.Controller.UserCreateEditController.userCreateEditController;

public class TasksController {

  @FXML
  private TableView<TaskProperties> taskTableView;

  @FXML
  private TableColumn<TaskProperties, String> workerIdTableColumn;

  @FXML
  private TableColumn<TaskProperties, String> taskTableColumn;

  @FXML
  private TableColumn<TaskProperties, String> statusTableColumn;

  @FXML
  private TableColumn<TaskProperties, String> estimatedTimeTableColumn;

  @FXML
  private TableColumn<TaskProperties, String> endTimeTaskTableColumn;

  @FXML
  private TableColumn<TaskProperties, TaskProperties> moreTableColumn;

  @FXML
  Button newTaskButton;

  private static  TasksService tasksService;
  private static TaskProperties taskProperties;

  public void initialize(){
    this.tasksService = new TasksService();
    tasksService.init();
    this.taskTableView.setItems(this.tasksService.getTaskEntityObservableList());
    this.workerIdTableColumn.setCellValueFactory(cellData -> cellData.getValue().idUserProperty());
    this.taskTableColumn.setCellValueFactory(cellData -> cellData.getValue().taskProperty());
    this.statusTableColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
    this.estimatedTimeTableColumn.setCellValueFactory(cellData -> cellData.getValue().estimatedTimeProperty());
    this.endTimeTaskTableColumn.setCellValueFactory(cellData -> cellData.getValue().endTimeTaskProperty());
    this.moreTableColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue()));

    this.moreTableColumn.setCellFactory(param -> new TableCell<>() {
      Button moreInfoBtn = tasksService.moreInfoButton();

      @Override
      protected void updateItem(TaskProperties item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
          setGraphic(null);
          return;
        }

        setGraphic(moreInfoBtn);
        moreInfoBtn.setOnAction(event -> {
          taskProperties = item;
          final Stage dialog = new Stage();

          try {
            Scene scene = new Scene(tasksService.loadFXML("taskDialog"));
            dialog.setResizable(false);
            dialog.setTitle("Zadanie");
            dialog.initStyle(StageStyle.DECORATED);
            dialog.setScene(scene);
            dialog.show();
          } catch (IOException e) {
            e.printStackTrace();
          }
        });

      }
    });
  }

  @FXML
  public void newTask(){
    final Stage dialogWorker = new Stage();

    try {
      Scene scene = new Scene(tasksService.loadFXML("tasksCreateEdit"));
      dialogWorker.setResizable(false);
      dialogWorker.setTitle("Nowe zadanie");
      dialogWorker.initStyle(StageStyle.DECORATED);
      dialogWorker.setScene(scene);
      dialogWorker.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void sendTaskService() {
    TasksCreateEditController.tasksService = tasksService;
  }

  public static void sendTaskProperties() {
    taskDialogController.taskProperties = taskProperties;
    TaskDialogController.tasksService = tasksService;
  }
}
