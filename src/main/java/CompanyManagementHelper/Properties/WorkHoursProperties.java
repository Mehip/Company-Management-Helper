package CompanyManagementHelper.Properties;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class WorkHoursProperties {
  private IntegerProperty id = new SimpleIntegerProperty();
  private StringProperty workerID = new SimpleStringProperty();
  private StringProperty start_time = new SimpleStringProperty();
  private StringProperty end_time = new SimpleStringProperty();
  private StringProperty difference = new SimpleStringProperty();

  public String getDifference() {
    return difference.get();
  }

  public StringProperty differenceProperty() {
    return difference;
  }

  public void setDifference(String difference) {
    this.difference.set(difference);
  }

  public int getId() {
    return id.get();
  }

  public IntegerProperty idProperty() {
    return id;
  }

  public void setId(int id) {
    this.id.set(id);
  }

  public String getWorkerID() {
    return workerID.get();
  }

  public StringProperty workerIDProperty() {
    return workerID;
  }

  public void setWorkerID(String workerID) {
    this.workerID.set(workerID);
  }

  public String getStart_time() {
    return start_time.get();
  }

  public StringProperty start_timeProperty() {
    return start_time;
  }

  public void setStart_time(String start_time) {
    this.start_time.set(start_time);
  }

  public String getEnd_time() {
    return end_time.get();
  }

  public StringProperty end_timeProperty() {
    return end_time;
  }

  public void setEnd_time(String end_time) {
    this.end_time.set(end_time);
  }
}
