package CompanyManagementHelper.Service;

import CompanyManagementHelper.App;
import CompanyManagementHelper.Entity.TaskEntity;
import CompanyManagementHelper.Properties.TaskProperties;
import CompanyManagementHelper.Utils.HibernateUtils;
import CompanyManagementHelper.Converter.TaskConverterToProperties;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

public class TasksService {

  private ObservableList<TaskProperties> taskEntityObservableList = FXCollections.observableArrayList();


  public ObservableList<TaskProperties> getTaskEntityObservableList() {
    return taskEntityObservableList;
  }

  public void setTaskEntityObservableList(ObservableList<TaskProperties> taskEntityObservableList) {
    this.taskEntityObservableList = taskEntityObservableList;
  }

  public void init() {
    List<TaskEntity> tasks = getItems();

    this.taskEntityObservableList.clear();
    tasks.forEach(it ->
    {
      TaskProperties taskProperties = TaskConverterToProperties.convertToTaskProperties(it);
      this.taskEntityObservableList.add(taskProperties);
    });
  }

  public List<TaskEntity> getItems() {
    return HibernateUtils.findAll("TaskEntity");
  }

  public Parent loadFXML(String fxml) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
    ResourceBundle bundle = ResourceBundle.getBundle("i18n.messages");
    fxmlLoader.setResources(bundle);
    return fxmlLoader.load();
  }
}
