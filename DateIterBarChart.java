import javafx.application.Application;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;




public class DateIterBarChart extends Application implements Runnable {

    // dynamically changeable width and height
    int standartWidth = 1024;
    int standartHeight = 1000;
    int miniWidth = 800;
    int miniHeight= 600;


    @Override
    public void run() {
        launch();
    }

    @Override
    public void start(Stage stage) {
        final int width;
        final  int height;
        stage.setTitle("DateIterChart");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc =
                new BarChart<>(xAxis,yAxis);
        bc.setTitle("Performance");

        xAxis.setLabel("Date");
        yAxis.setLabel("Iters");

        XYChart.Series series = new XYChart.Series();
        series.setName("Iterations");

        for (int i = 0; i < JDBC_MainConn.dateArray.size(); i++) {
        series.getData().add(new XYChart.Data(JDBC_MainConn.dateArray.get(i),
                JDBC_MainConn.iterArray.get(i)));
        }
        if (JDBC_MainConn.size == 1) {
            width = miniWidth;
            height = miniHeight;
        }
        else {
            width = standartWidth;
            height = standartHeight;
        }

        Scene scene  = new Scene(bc,width,height);
        bc.getData().addAll(series);



// /*
        // this magic lines change color
        for(Node n : bc.lookupAll(".default-color0.chart-bar")) {
            n.setStyle("-fx-bar-fill: black;");
        }

// */
        stage.setScene(scene);
        stage.show();
    }


}