package CompanyManagementHelper.Service;

import CompanyManagementHelper.Converter.HoursConverterToProperties;
import CompanyManagementHelper.Entity.WorkHoursEntity;
import CompanyManagementHelper.Properties.WorkHoursProperties;
import CompanyManagementHelper.Utils.HibernateUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class WorkHoursService {
  private ObservableList<WorkHoursProperties> workHoursObservableList = FXCollections.observableArrayList();


  public ObservableList<WorkHoursProperties> getWorkHoursEntityObservableList() {
    return workHoursObservableList;
  }

  public void setWorkHoursEntityObservableList(ObservableList<WorkHoursProperties> taskEntityObservableList) {
    this.workHoursObservableList = workHoursObservableList;
  }

  public void init() {
    List<WorkHoursEntity> tasks = getItems();

    this.workHoursObservableList.clear();
    tasks.forEach(it ->
    {
      WorkHoursProperties workHoursProperties = HoursConverterToProperties.convertToWorkHoursProperties(it);
      this.workHoursObservableList.add(workHoursProperties);
    });
  }

  public List<WorkHoursEntity> getItems() {
    return HibernateUtils.findAll("WorkHoursEntity");
  }
}
