package CompanyManagementHelper.Controller;

import CompanyManagementHelper.Entity.WorkHoursEntity;
import CompanyManagementHelper.Properties.WorkHoursProperties;
import CompanyManagementHelper.Service.StatisticService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ListView;

import java.util.List;

public class StatisticController {

  @FXML
  PieChart pieChart;

  @FXML
  BarChart barChart;

  @FXML
  LineChart lineChart;

  @FXML
  ListView listViewStatistcs;

  private StatisticService statisticService;
  private ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();


  public void initialize() {
    statisticService = new StatisticService();
    initPieChart();
    initBarChart();
    initLineChart();
  }

  private void initPieChart() {
    pieChartData.addAll(
        new PieChart.Data("W TRAKCIE", statisticService.count().get(0)),
        new PieChart.Data("OCZEKIWANIE", statisticService.count().get(1)),
        new PieChart.Data("ZAKONCZONE", statisticService.count().get(2)));
    pieChart.setData(pieChartData);
  }

  private void initBarChart() {
    List<WorkHoursProperties> workHoursPropertiesList = statisticService.workHours();

    XYChart.Series series = new XYChart.Series();
    workHoursPropertiesList.forEach(c -> {
      if(c.getDifference().contains("min")){
        c.setDifference(c.getDifference().substring(0,c.getDifference().length()-3));
      } else {
        c.setDifference(c.getDifference().substring(0,c.getDifference().length()-1));
      }
      series.getData().add(new XYChart.Data(c.getWorkerID(),5));
    });

    barChart.getData().addAll(series);
  }

  private void initLineChart() {
    //pieChart.setData(pieChartList);
  }
}
