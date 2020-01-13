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
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import static CompanyManagementHelper.Converter.TaskConverterToProperties.convertToTaskEntity;
import static CompanyManagementHelper.Utils.HibernateUtils.delete;

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

  public Button moreInfoButton(){
    Button moreInfoBtn = new Button();
    Image image = new Image(this.getClass().getResource("/images/information.png").toString());
    ImageView imageView = new ImageView(image);
    moreInfoBtn.setGraphic(imageView);
    return moreInfoBtn;
  }

  public static void deleteTaskDB(TaskProperties taskProperties){
    delete(convertToTaskEntity(taskProperties));
  }
}
