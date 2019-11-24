package CompanyManagementHelper.Properties;

import javafx.beans.property.*;

public class TaskProperties {

  private IntegerProperty id = new SimpleIntegerProperty();
  private StringProperty task = new SimpleStringProperty();
  private StringProperty status = new SimpleStringProperty();
  private StringProperty estimatedTime = new SimpleStringProperty();
  private StringProperty endTimeTask = new SimpleStringProperty();
  private StringProperty idUser = new SimpleStringProperty();

  public int getId() {
    return id.get();
  }

  public IntegerProperty idProperty() {
    return id;
  }

  public void setId(int id) {
    this.id.set(id);
  }

  public String getTask() {
    return task.get();
  }

  public StringProperty taskProperty() {
    return task;
  }

  public void setTask(String task) {
    this.task.set(task);
  }

  public String getStatus() {
    return status.get();
  }

  public StringProperty statusProperty() {
    return status;
  }

  public void setStatus(String status) {
    this.status.set(status);
  }

  public String getEstimatedTime() {
    return estimatedTime.get();
  }

  public StringProperty estimatedTimeProperty() {
    return estimatedTime;
  }

  public void setEstimatedTime(String estimatedTime) {
    this.estimatedTime.set(estimatedTime);
  }

  public String getEndTimeTask() {
    return endTimeTask.get();
  }

  public StringProperty endTimeTaskProperty() {
    return endTimeTask;
  }

  public void setEndTimeTask(String endTimeTask) {
    this.endTimeTask.set(endTimeTask);
  }

  public String getIdUser() {
    return idUser.get();
  }

  public StringProperty idUserProperty() {
    return idUser;
  }

  public void setIdUser(String idUser) {
    this.idUser.set(idUser);
  }
}
