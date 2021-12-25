package charts;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import org.mariuszgromada.math.mxparser.Argument;
import org.mariuszgromada.math.mxparser.Expression;

public class MyLineChart {
    private final XYChart.Series series;

    // Build Our Constructor To Take Our Required Param
    public MyLineChart(String equation, float maxVal, float minVal){
        // initialize XLine object (Generate The Points Between The minimum Value Of 'X' And The maximum Value )
        float[] XLine = generateXLine(maxVal, minVal);
        // Call 'generateDataset' Function And Passing The Required Param To generate The Dataset object For Plotting
        this.series = generateDataset(equation, XLine);
    }

    // Function That Generate Every Point Between The Minimum Value Of X and The Maximum Value Of X
    public static float [] generateXLine(float max, float min){
        // calculate The size of the array
        int size = (int)(max - min) + 1;
        float [] xLineValues = new float[size];
        int index = 0;
        // loop on every point between min X and max X
        for (float i = min; i <= max; i++){
            xLineValues[index] = i;
            index++;
        }
        return xLineValues;
    }
    /*
        Generate The Dataset By Giving iT The Generated X Points From (generateXLine Function)
        and The Equation To Calculate Y From X Value
    */
    public static XYChart.Series generateDataset(String equation, float [] xLine){
        XYChart.Series mSeries = new XYChart.Series();
        mSeries.setName("X Values");
        for (float v : xLine) {
            /*
                Argument object called x is the parameter that passed to the equation
                Explain Example
                if the equation is x^2 >... then x is variable that entered by the user, so we pass it to the equation as a value
            */
            Argument x = null;

            // If In Terms of x (lowercase)
            if(equation.contains("x")){
                x = new Argument("x", v);
            }else if (equation.contains("X")){
                // If In Terms of X (uppercase)
                x = new Argument("X", v);
            }

            // Expression Object called 'expression' is To Process The Equation by pass the equation and The parameter ('x')
            Expression expression = new Expression(equation, x);
            // add The Value To The XYChart.Series Object
            mSeries.getData().add(new XYChart.Data(String.valueOf(v), expression.calculate()));
        }
        return mSeries;
    }
    // Display The Chart On A Fiven LineChart Object
    public void showPlot(LineChart lineChart){
        lineChart.getData().clear(); // This Line To Clear The Line Chart If This is Plotted Graph
        // Plot The Graph
        lineChart.getData().add(this.series);
    }

}
