package CompanyManagementHelper.Converter;

import CompanyManagementHelper.Entity.TaskEntity;
import CompanyManagementHelper.Properties.TaskProperties;

public class TaskConverterToProperties {

  public static TaskEntity convertToTaskEntity(TaskProperties taskProperties){
    TaskEntity taskEntity = new TaskEntity();
    taskEntity.setId(taskProperties.getId());
    taskEntity.setTask(taskProperties.getTask());
    taskEntity.setStatus(taskProperties.getStatus());
    taskEntity.setEstimatedTime(Double.parseDouble(taskProperties.getEstimatedTime()));
    taskEntity.setEndTimeTask(Double.parseDouble(taskProperties.getEndTimeTask()));
    taskEntity.setIdUser(taskProperties.getIdUser());

    return taskEntity;
  }


  public static TaskProperties convertToTaskProperties(TaskEntity taskEntity){
    TaskProperties taskProperties = new TaskProperties();
    taskProperties.setId(taskEntity.getId());
    taskProperties.setTask(taskEntity.getTask());
    taskProperties.setStatus(taskEntity.getStatus());
    taskProperties.setEstimatedTime(String.valueOf(taskEntity.getEstimatedTime()));
    taskProperties.setEndTimeTask(String.valueOf(taskEntity.getEndTimeTask()));
    taskProperties.setIdUser(taskEntity.getIdUser());

    return taskProperties;
  }

}
