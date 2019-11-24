package CompanyManagementHelper.Controller;

import CompanyManagementHelper.Properties.UserProperties;
import CompanyManagementHelper.Service.WorkersService;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import static CompanyManagementHelper.Controller.MyProfilController.myProfilController;
import static CompanyManagementHelper.Controller.WorkerDialogController.workerDialogController;


public class WorkersController {

  @FXML
  TableView<UserProperties> workerTableView;

  @FXML
  TableColumn<UserProperties, String> roleTableColumn;

  @FXML
  TableColumn<UserProperties, String> nameTableColumn;

  @FXML
  TableColumn<UserProperties, String> surnameTableColumn;

  @FXML
  TableColumn<UserProperties, String> emailTableColumn;

  @FXML
  TableColumn<UserProperties, String> ageTableColumn;

  @FXML
  TableColumn<UserProperties, String> jobTimeTableColumn;

  @FXML
  TableColumn<UserProperties, UserProperties> moreTableColumn;

  WorkersService workersService;
  private static UserProperties userProperties;

  public void initialize() {
    this.workersService = new WorkersService();
    workersService.init();
    this.workerTableView.setItems(this.workersService.getUserPropertiesObservableList());
    this.nameTableColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
    this.surnameTableColumn.setCellValueFactory(cellData -> cellData.getValue().surnameProperty());
    this.emailTableColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
    this.roleTableColumn.setCellValueFactory(cellData -> cellData.getValue().roleProperty());
    this.ageTableColumn.setCellValueFactory(cellData -> cellData.getValue().dateOfBirthProperty());
    this.jobTimeTableColumn.setCellValueFactory(cellData -> cellData.getValue().jobTimeProperty());
    this.moreTableColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue()));

    this.moreTableColumn.setCellFactory(param -> new TableCell<>() {
      Button moreInfoBtn = workersService.moreInfoButton();

      @Override
      protected void updateItem(UserProperties item, boolean empty) {
        super.updateItem(item, empty);

        if (!empty) {
          setGraphic(moreInfoBtn);
          moreInfoBtn.setOnAction(event -> {
            userProperties = item;
            final Stage dialogWorker = new Stage();

            try {
              Scene scene = new Scene(workersService.loadFXML("workerDialog", item));
              dialogWorker.setResizable(false);
              dialogWorker.setTitle("Pracownik");
              dialogWorker.initStyle(StageStyle.DECORATED);
              dialogWorker.setScene(scene);
              dialogWorker.show();
            } catch (IOException e) {
              e.printStackTrace();
            }
          });
        }
      }
    });
  }

  //For MyProfilController data
  public static void sendUserProperties() {
    workerDialogController.userProperties = userProperties;
  }
}
