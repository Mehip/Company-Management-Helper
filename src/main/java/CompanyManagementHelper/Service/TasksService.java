package CompanyManagementHelper.Service;

import CompanyManagementHelper.Entity.TaskEntity;
import CompanyManagementHelper.Properties.TaskProperties;
import CompanyManagementHelper.Utils.HibernateUtils;
import CompanyManagementHelper.Converter.TaskConverterToProperties;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

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
}
