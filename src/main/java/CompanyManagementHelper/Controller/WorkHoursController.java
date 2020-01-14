package CompanyManagementHelper.Controller;

import CompanyManagementHelper.Entity.WorkHoursEntity;
import CompanyManagementHelper.Properties.WorkHoursProperties;
import CompanyManagementHelper.Service.WorkHoursService;
import CompanyManagementHelper.Utils.ProfileRole;
import CompanyManagementHelper.Utils.SecurityUtils;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDateTime;
import java.util.List;

import static CompanyManagementHelper.Utils.HibernateUtils.*;


public class WorkHoursController {

  @FXML
  TableView<WorkHoursProperties> workHoursTableView;
  @FXML
  TableColumn<WorkHoursProperties, String> workerTableColumn;
  @FXML
  TableColumn<WorkHoursProperties, String> startTableColumn;
  @FXML
  TableColumn<WorkHoursProperties, String> stopTableColumn;
  @FXML
  TableColumn<WorkHoursProperties, String> differenceTableColumn;
  @FXML
  Button startButton, stopButton;

  private static WorkHoursService workHoursService;

  public void initialize() {
    if (SecurityUtils.isAdmin(ProfileRole.userRole)) {
      startButton.setVisible(false);
      stopButton.setVisible(true);
    }

    workHoursService = new WorkHoursService();
    workHoursService.init();
    this.workHoursTableView.setItems(workHoursService.getWorkHoursEntityObservableList());
    this.workerTableColumn.setCellValueFactory(cellData -> cellData.getValue().workerIDProperty());
    this.startTableColumn.setCellValueFactory(cellData -> cellData.getValue().start_timeProperty());
    this.stopTableColumn.setCellValueFactory(cellData -> cellData.getValue().end_timeProperty());
    this.differenceTableColumn.setCellValueFactory(cellData -> cellData.getValue().differenceProperty());
  }

  @FXML
  public void startTime() {
    WorkHoursEntity workHoursEntity = new WorkHoursEntity(ProfileRole.userName, LocalDateTime.now());
    insert(workHoursEntity);
    workHoursService.init();
  }

  @FXML
  public void stopTime() {
    List<WorkHoursEntity> workHoursEntities = findWorkHoursByNullAndByUser(ProfileRole.userName);

    Thread thread = new Thread(() -> {
      Platform.runLater(() -> {
        workHoursEntities.forEach(c -> {
          c.setEndTime(LocalDateTime.now());
          update(c);
        });
        workHoursService.init();
      });
    });
    thread.start();
  }
}
