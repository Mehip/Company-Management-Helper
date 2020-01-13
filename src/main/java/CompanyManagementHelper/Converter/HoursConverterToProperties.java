package CompanyManagementHelper.Converter;

import CompanyManagementHelper.Entity.WorkHoursEntity;
import CompanyManagementHelper.Properties.WorkHoursProperties;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HoursConverterToProperties {
  public static WorkHoursEntity convertToWorkHoursEntity(WorkHoursProperties workHoursProperties) {
    WorkHoursEntity workHoursEntity = new WorkHoursEntity();
    workHoursEntity.setId(workHoursProperties.getId());
    workHoursEntity.setId_worker(workHoursProperties.getWorkerID());
    workHoursEntity.setStartTime(LocalDateTime.parse(workHoursProperties.getStart_time(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    workHoursEntity.setEndTime(LocalDateTime.parse(workHoursProperties.getEnd_time(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

    return workHoursEntity;
  }


  public static WorkHoursProperties convertToWorkHoursProperties(WorkHoursEntity workHoursEntity) {
    WorkHoursProperties workHoursProperties = new WorkHoursProperties();
    workHoursProperties.setId(workHoursEntity.getId());
    workHoursProperties.setWorkerID(workHoursEntity.getId_worker());
    workHoursProperties.setStart_time(workHoursEntity.getStartTime().toString());

    try {
      workHoursProperties.setEnd_time(workHoursEntity.getEndTime().toString());
      Duration duration = Duration.between(workHoursEntity.getStartTime(), workHoursEntity.getEndTime());
      long diff = Math.abs(duration.toHours());
      if(diff == 0){
        diff = Math.abs(duration.toMinutes());
        workHoursProperties.setDifference(String.valueOf(diff)+"min");
      } else {
        workHoursProperties.setDifference(String.valueOf(diff)+"h");
      }
    } catch (NullPointerException e) {
      workHoursProperties.setEnd_time("------------");
      workHoursProperties.setDifference("---------");
    }

    return workHoursProperties;
  }
}
