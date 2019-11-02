package CompanyManagementHelper;

import CompanyManagementHelper.Entity.TaskEntity;
import CompanyManagementHelper.Entity.UserEntity;
import CompanyManagementHelper.Entity.WorkHoursEntity;
import CompanyManagementHelper.Utils.HibernateUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.io.IOException;
import java.time.LocalDateTime;

//import static CompanyManagementHelper.Utils.HibernateUtil.insert;

/**
 * JavaFX App
 */
public class App extends Application {

  private static Scene scene;

  @Override
  public void start(Stage stage) throws IOException {
    scene = new Scene(loadFXML("primary"));
    stage.setScene(scene);
    stage.show();
  }

  public static void setRoot(String fxml) throws IOException {
    scene.setRoot(loadFXML(fxml));
  }

  private static Parent loadFXML(String fxml) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
    return fxmlLoader.load();
  }

  public static void main(String[] args) {

    TaskEntity taskEntity = new TaskEntity("ZADANKO ROBIC SMIECIE JEDNE WY", "ROZPOCZETE", 20.0);
    WorkHoursEntity workHoursEntity = new WorkHoursEntity(1, LocalDateTime.now());
    UserEntity userEntity = new UserEntity("Maciej", "Parapura", "98111709978", "Warszawa", "Monte Cassino", "1", "38", "01-121", "Szef", 14500.35, "34 1234 1234 1234 1234 1234 1234", 1.0);
    insert(taskEntity);
    insert(workHoursEntity);
    insert(userEntity);

    launch(args);
  }

    public static void insert(Object o){
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
    }
}