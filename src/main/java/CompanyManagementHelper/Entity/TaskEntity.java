package CompanyManagementHelper.Entity;

import javax.persistence.*;

@Entity
@Table(name = "zadania")
public class TaskEntity {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Integer id;

  @Column(name = "zadanie")
  private String task;

  @Column(name = "status")
  private String status;

  @Column(name = "przewidywany_czas_wykonania", nullable = true)
  private Double estimatedTime;

  @Column(name = "wykonane_w_czasie", nullable = true)
  private Double endTimeTask;

  @Column(name = "wykonawca", nullable = true)
  private String idUser;

  public TaskEntity(String task, String status, Double estimatedTime) {
    this.task = task;
    this.status = status;
    this.estimatedTime = estimatedTime;
  }

  public TaskEntity() {
  }

  public String getTask() {
    return task;
  }

  public void setTask(String task) {
    this.task = task;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Double getEstimatedTime() {
    return estimatedTime;
  }

  public void setEstimatedTime(Double estimatedTime) {
    this.estimatedTime = estimatedTime;
  }

  public Double getEndTimeTask() {
    return endTimeTask;
  }

  public void setEndTimeTask(Double endTimeTask) {
    this.endTimeTask = endTimeTask;
  }

  public String getIdUser() {
    return idUser;
  }

  public void setIdUser(String idUser) {
    this.idUser = idUser;
  }
}
