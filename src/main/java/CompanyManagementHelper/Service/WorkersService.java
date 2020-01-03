package CompanyManagementHelper.Service;

import CompanyManagementHelper.App;
import CompanyManagementHelper.Converter.UserConverterToProperties;
import CompanyManagementHelper.Entity.UserEntity;
import CompanyManagementHelper.Properties.UserProperties;
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

public class WorkersService {
  private ObservableList<UserProperties> userPropertiesObservableList = FXCollections.observableArrayList();

  public ObservableList<UserProperties> getUserPropertiesObservableList() {
    return userPropertiesObservableList;
  }

  public void setUserPropertiesObservableList(ObservableList<UserProperties> userPropertiesObservableList) {
    this.userPropertiesObservableList = userPropertiesObservableList;
  }

  public void init() {
    List<UserEntity> users = getItems();

    this.userPropertiesObservableList.clear();
    users.forEach(it ->
    {
      UserProperties userProperties = UserConverterToProperties.convertToUserProperties(it);
      this.userPropertiesObservableList.add(userProperties);
    });
  }

  public List<UserEntity> getItems() {
    return HibernateUtils.findAll("UserEntity");
  }

  public Button moreInfoButton(){
    Button moreInfoBtn = new Button();
    Image image = new Image(this.getClass().getResource("/images/information.png").toString());
    ImageView imageView = new ImageView(image);
    moreInfoBtn.setGraphic(imageView);
    return moreInfoBtn;
  }

  public Parent loadFXML(String fxml) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
    ResourceBundle bundle = ResourceBundle.getBundle("i18n.messages");
    fxmlLoader.setResources(bundle);
    return fxmlLoader.load();
  }
}
