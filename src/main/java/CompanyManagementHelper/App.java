package CompanyManagementHelper;

import CompanyManagementHelper.Entity.TaskEntity;
import CompanyManagementHelper.Entity.UserEntity;
import CompanyManagementHelper.Entity.WorkHoursEntity;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static CompanyManagementHelper.Utils.HibernateUtils.insert;

//import static CompanyManagementHelper.Utils.HibernateUtil.insert;

/**
 * JavaFX App
 */
public class App extends Application {

  private static Scene scene;

  @Override
  public void start(Stage stage) throws IOException {
    scene = new Scene(loadFXML("login"));
    scene.getStylesheets().add("style.css");
    stage.setResizable(false);
    stage.initStyle(StageStyle.DECORATED);
    stage.setTitle("Company Management Helper");
    stage.setScene(scene);
    stage.show();
  }

  public static void setFXML(String fxml) throws IOException {
    scene.setRoot(loadFXML(fxml));
  }

  private static Parent loadFXML(String fxml) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
    ResourceBundle bundle = ResourceBundle.getBundle("i18n.messages");
    fxmlLoader.setResources(bundle);
    return fxmlLoader.load();
  }

  public static void main(String[] args) {

//    TaskEntity taskEntity1 = new TaskEntity("Zadanie numer 1", "NIEPRZYDZIELONE", 20.0, 0.0,"");
//    TaskEntity taskEntity2 = new TaskEntity("Zadanie numer 2", "W TRAKCIE", 25.0, 0.0,"3");
//    TaskEntity taskEntity3 = new TaskEntity("Zadanie numer 4", "OCZEKIWANIE", 2.0, 0.0,"1");
//    TaskEntity taskEntity4 = new TaskEntity("Zadanie numer 3", "W TRAKCIE", 5.0, 0.0,"4");
//    TaskEntity taskEntity5 = new TaskEntity("Zadanie numer 5", "ZAKONCZONE", 3.0, 4.0,"2");
//    TaskEntity taskEntity6 = new TaskEntity("Zadanie numer 6", "OCZEKIWANIE", 15.0, 0.0,"1");
//    TaskEntity taskEntity7 = new TaskEntity("Zadanie numer 17", "ZAKONCZONE", 10.0, 10.0,"1");
//    TaskEntity taskEntity8 = new TaskEntity("Zadanie numer 9", "W TRAKCIE", 12.0, 0.0,"5");
//    TaskEntity taskEntity9 = new TaskEntity("Zadanie numer 14", "W TRAKCIE", 24.0, 0.0,"2");
//    TaskEntity taskEntity10 = new TaskEntity("Zadanie numer 12", "ZAKONCZONE", 8.0, 6.0,"1");
//
//    insert(taskEntity1);
//    insert(taskEntity2);
//    insert(taskEntity3);
//    insert(taskEntity4);
//    insert(taskEntity5);
//    insert(taskEntity6);
//    insert(taskEntity7);
//    insert(taskEntity8);
//    insert(taskEntity9);
//    insert(taskEntity10);
//
//    UserEntity userEntity = new UserEntity("admin", "", "admin","123", "", null, "", "", "", "", "", "", null, "", null, null);
//    UserEntity userEntity1 = new UserEntity("Grzegorz", "Parapura", "gparapura@cmh.pl","gp", "00000000000", LocalDate.now(), "Warszawa", "Monte Cassino", "1", "38", "01-121", "Senior Java Developer", 14500.35, "34 1234 1234 1234 1234 1234 1234", 1.0, LocalDate.now());
//    UserEntity userEntity2 = new UserEntity("Marcin", "Kozłowski", "mkozlowski@cmh.pl","mk", "11111111111", LocalDate.now(), "Warszawa", "Szybka", "3", "23", "01-143", "Junior Java Developer", 14500.35, "34 1234 1234 1234 1234 1234 1234", 1.0, LocalDate.now());
//    UserEntity userEntity3 = new UserEntity("Mateusz", "Bałazy", "mbalazy@cmh.pl","mb", "22222222222", LocalDate.now(), "Warszawa", "Olbrachta", "67", "12", "01-495", "Analityk", 14500.35, "34 1234 1234 1234 1234 1234 1234", 1.0, LocalDate.now());
//    UserEntity userEntity4 = new UserEntity("Mateusz", "Kotyński", "mkotynski@cmh.pl","mk", "33333333333", LocalDate.now(), "Warszawa", "Kasprzaka", "54", "6", "01-123", "Junior Java Developer", 14500.35, "34 1234 1234 1234 1234 1234 1234", 1.0, LocalDate.now());
//    UserEntity userEntity5 = new UserEntity("Jan", "Kowalski", "jkowalski@cmh.pl","jk", "44444444444", LocalDate.now(), "Warszawa", "Radiowa", "145", "8", "01-189", "Kierownik", 14500.35, "34 1234 1234 1234 1234 1234 1234", 1.0, LocalDate.now());
//    UserEntity userEntity6 = new UserEntity("Łukasz", "Guzek", "lguzek@cmh.pl","lk", "55555555555", LocalDate.now(), "Warszawa", "Powstańców Śląskich", "102", "78", "01-642", "Mid Java Developer", 14500.35, "34 1234 1234 1234 1234 1234 1234", 1.0, LocalDate.now());
//    UserEntity userEntity7 = new UserEntity("Mateusz", "Król", "mkrol@cmh.pl","mk", "66666666666", LocalDate.now(), "Warszawa", "Elekcyjna", "18", "65", "01-765", "Analityk", 14500.35, "34 1234 1234 1234 1234 1234 1234", 1.0, LocalDate.now());
//    UserEntity userEntity8 = new UserEntity("Wojciech", "Kowalczewski", "wkowalczewski@cmh.pl","wk", "77777777777", LocalDate.now(), "Warszawa", "Góralska", "13", "45", "01-444", "Sekretarz", 14500.35, "34 1234 1234 1234 1234 1234 1234", 1.0, LocalDate.now());
//    UserEntity userEntity9 = new UserEntity("Maciej", "Parapura", "mparapura@cmh.pl","mp", "88888888888", LocalDate.now(), "Warszawa", "Monte Cassino", "1", "38", "01-121", "Szef", 14500.35, "34 1234 1234 1234 1234 1234 1234", 1.0, LocalDate.now());
//
//    insert(userEntity);
//    insert(userEntity1);
//    insert(userEntity2);
//    insert(userEntity3);
//    insert(userEntity4);
//    insert(userEntity5);
//    insert(userEntity6);
//    insert(userEntity7);
//    insert(userEntity8);
//    insert(userEntity9);

//WorkHoursEntity workHoursEntity = new WorkHoursEntity(1, LocalDateTime.now());
//    insert(workHoursEntity);

    launch(args);
  }
}