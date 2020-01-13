package CompanyManagementHelper.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_work_hours")
public class WorkHoursEntity {

  @Id
  @GeneratedValue
  @Column(name = "id")
  Integer id;

  @Column(name = "worker_id")
  String worker;

  @Column(name = "start_time")
  LocalDateTime startTime;

  @Column(name = "end_time")
  LocalDateTime endTime;

  public WorkHoursEntity(String worker, LocalDateTime startTime) {
    this.worker = worker;
    this.startTime = startTime;
  }

  public WorkHoursEntity() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getId_worker() {
    return worker;
  }

  public void setId_worker(String worker) {
    this.worker = worker;
  }

  public LocalDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
  }

  public LocalDateTime getEndTime() {
    return endTime;
  }

  public void setEndTime(LocalDateTime endTime) {
    this.endTime = endTime;
  }
}
