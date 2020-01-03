package CompanyManagementHelper.Entity;

import javax.persistence.*;

@Entity
@Table(name = "t_tasks")
public class TaskEntity {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Integer id;

  @Column(name = "task")
  private String task;

  @Column(name = "status")
  private String status;

  @Column(name = "estimated_time", nullable = true)
  private Double estimatedTime;

  @Column(name = "end_in_time", nullable = true)
  private Double endTimeTask;

  @Column(name = "worker_id", nullable = true)
  private String idUser;

  public TaskEntity(String task, String status, Double estimatedTime, Double endTimeTask, String idUser) {
    this.task = task;
    this.status = status;
    this.estimatedTime = estimatedTime;
    this.endTimeTask = endTimeTask;
    this.idUser = idUser;
  }

  public TaskEntity() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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
