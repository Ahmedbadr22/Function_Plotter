package com.badr.functionplotterapp;

import charts.MyLineChart;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.TextField;
import validate.InputValidator;

public class FunctionPlotterController {
    @FXML
    private TextField equationTextField;

    @FXML
    private TextField maxXValueTextField;

    @FXML
    private TextField minXValueTextField;

    @FXML
    private LineChart lineChartView;

    // on click on Plot Button This Function Run
    @FXML
    protected void onPlotButtonClicked() {
        // Take Data From The GUI
        String equation = equationTextField.getText();
        String xMax = maxXValueTextField.getText();
        String xMin = minXValueTextField.getText();

        // Validate The Input Data
        // if all Valid The Run if Not , The Non-Valid Point Will Show Warning Message To The User
        if (InputValidator.isAllInputValid(equation, xMax, xMin)){
            // Declare And initialize MyLineChart Object
            MyLineChart myLineChart = new MyLineChart(equation, Float.parseFloat(xMax), Float.parseFloat(xMin));
            // Plot The Graph
            myLineChart.showPlot(lineChartView);
        }

    }


}