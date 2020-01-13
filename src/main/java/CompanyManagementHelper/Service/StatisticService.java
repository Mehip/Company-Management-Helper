package CompanyManagementHelper.Service;

import CompanyManagementHelper.Converter.HoursConverterToProperties;
import CompanyManagementHelper.Entity.TaskEntity;
import CompanyManagementHelper.Entity.WorkHoursEntity;
import CompanyManagementHelper.Properties.WorkHoursProperties;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static CompanyManagementHelper.Utils.HibernateUtils.findAllWorkHoursWithoutNull;
import static CompanyManagementHelper.Utils.HibernateUtils.findTasksByStatus;

public class StatisticService {

  public List<Integer> count(){
    List<TaskEntity> inProgress = findTasksByStatus("W TRAKCIE");
    List<TaskEntity> waiting = findTasksByStatus("OCZEKIWANIE");
    List<TaskEntity> finished = findTasksByStatus("ZAKONCZONE");

    List<Integer> counter = new ArrayList<>();
    counter.add(inProgress.size());
    counter.add(waiting.size());
    counter.add(finished.size());

    return counter;
  }

  public List<WorkHoursProperties> workHours(){
    List<WorkHoursEntity> workHoursEntityList =  findAllWorkHoursWithoutNull();

    return workHoursEntityList.stream().map(HoursConverterToProperties::convertToWorkHoursProperties).collect(Collectors.toList());
  }
}
