package CompanyManagementHelper.Service;

import CompanyManagementHelper.Converter.HoursConverterToProperties;
import CompanyManagementHelper.Entity.TaskEntity;
import CompanyManagementHelper.Entity.WorkHoursEntity;
import CompanyManagementHelper.Properties.WorkHoursProperties;
import javafx.scene.chart.XYChart;
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

  public XYChart.Series barCharData(){
    List<WorkHoursProperties> workHoursPropertiesList = workHours();
    WorkHoursProperties[] finalList = workHoursPropertiesList.toArray(new WorkHoursProperties[0]);
    List<WorkHoursProperties> showList = new ArrayList<>();

    for (WorkHoursProperties workHours : finalList) {
      if (workHours.getDifference().contains("min")) {
        workHours.setDifference("0." + workHours.getDifference().substring(0, workHours.getDifference().length() - 3));
      } else {
        workHours.setDifference(workHours.getDifference().substring(0, workHours.getDifference().length() - 1));
      }
    }

    for(int i=0; i < workHoursPropertiesList.size()-1; i++){
      for(int j=i+1; j < workHoursPropertiesList.size(); j++){
        if(finalList[i].getWorkerID().equals(finalList[j].getWorkerID())){
          finalList[i].setDifference(String.valueOf(Float.parseFloat(finalList[i].getDifference())+Float.parseFloat(finalList[j].getDifference())));
          finalList[j].setWorkerID("xd");
        }
      }
    }

    for(int i=0; i < workHoursPropertiesList.size(); i++){
      if(!finalList[i].getWorkerID().equals("xd")){
        showList.add(finalList[i]);
      }
    }

    XYChart.Series series = new XYChart.Series();
    for (WorkHoursProperties work : showList) {
      series.getData().add(new XYChart.Data(work.getWorkerID(), Float.parseFloat(work.getDifference())));
    }

    return series;
  }
}
