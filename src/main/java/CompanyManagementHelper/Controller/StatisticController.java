package CompanyManagementHelper.Controller;

import CompanyManagementHelper.Service.StatisticService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;

public class StatisticController {

  @FXML
  PieChart pieChart;

  @FXML
  BarChart barChart;

  private StatisticService statisticService;
  private ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();


  public void initialize() {
    statisticService = new StatisticService();
    initPieChart();
    initBarChart();
  }

  private void initPieChart() {
    pieChartData.addAll(
        new PieChart.Data("W TRAKCIE", statisticService.count().get(0)),
        new PieChart.Data("OCZEKIWANIE", statisticService.count().get(1)),
        new PieChart.Data("ZAKONCZONE", statisticService.count().get(2)));
    pieChart.setData(pieChartData);
  }

  private void initBarChart() {
    barChart.getData().addAll(statisticService.barCharData());
  }
}
