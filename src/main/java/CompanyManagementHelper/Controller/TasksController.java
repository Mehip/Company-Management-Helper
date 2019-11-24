package CompanyManagementHelper.Controller;

import CompanyManagementHelper.Properties.TaskProperties;
import CompanyManagementHelper.Service.TasksService;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

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

  private TasksService tasksService;

  public void initialize(){
    this.tasksService = new TasksService();
    tasksService.init();
    this.taskTableView.setItems(this.tasksService.getTaskEntityObservableList());
    this.workerIdTableColumn.setCellValueFactory(cellData -> cellData.getValue().idUserProperty());
    this.taskTableColumn.setCellValueFactory(cellData -> cellData.getValue().taskProperty());
    this.statusTableColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
    this.estimatedTimeTableColumn.setCellValueFactory(cellData -> cellData.getValue().estimatedTimeProperty());
    this.endTimeTaskTableColumn.setCellValueFactory(cellData -> cellData.getValue().endTimeTaskProperty());
  }
}
