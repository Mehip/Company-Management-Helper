package CompanyManagementHelper.Service;

import CompanyManagementHelper.App;
import CompanyManagementHelper.Converter.HoursConverterToProperties;
import CompanyManagementHelper.Converter.TaskConverterToProperties;
import CompanyManagementHelper.Entity.TaskEntity;
import CompanyManagementHelper.Entity.WorkHoursEntity;
import CompanyManagementHelper.Properties.TaskProperties;
import CompanyManagementHelper.Properties.WorkHoursProperties;
import CompanyManagementHelper.Utils.HibernateUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import static CompanyManagementHelper.Converter.TaskConverterToProperties.convertToTaskEntity;
import static CompanyManagementHelper.Utils.HibernateUtils.delete;

public class WorkHoursService {
  private ObservableList<WorkHoursProperties> workHoursObservableList = FXCollections.observableArrayList();


  public ObservableList<WorkHoursProperties> getWorkHoursEntityObservableList() {
    return workHoursObservableList;
  }

  public void setWorkHoursEntityObservableList(ObservableList<WorkHoursProperties> taskEntityObservableList) {
    this.workHoursObservableList = workHoursObservableList;
  }

  public void init() {
    List<WorkHoursEntity> tasks = getItems();

    this.workHoursObservableList.clear();
    tasks.forEach(it ->
    {
      WorkHoursProperties workHoursProperties = HoursConverterToProperties.convertToWorkHoursProperties(it);
      this.workHoursObservableList.add(workHoursProperties);
    });
  }

  public List<WorkHoursEntity> getItems() {
    return HibernateUtils.findAll("WorkHoursEntity");
  }
}
