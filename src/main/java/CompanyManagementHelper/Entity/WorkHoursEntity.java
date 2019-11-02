package CompanyManagementHelper.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "godziny_pracy")
public class WorkHoursEntity {

  @Id
  @GeneratedValue
  @Column(name = "id")
  Integer id;

  @Column(name = "id_pracownika")
  Integer id_worker;

  @Column(name = "godzina_startu")
  LocalDateTime startTime;

  @Column(name = "godzina_zakonczenia")
  LocalDateTime endTime;

  public WorkHoursEntity(Integer id_worker, LocalDateTime startTime) {
    this.id_worker = id_worker;
    this.startTime = startTime;
  }

  public WorkHoursEntity() {
  }

  public Integer getId_worker() {
    return id_worker;
  }

  public void setId_worker(Integer id_worker) {
    this.id_worker = id_worker;
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
