package easyfit.easyfit.graphique;

import android.os.Bundle;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import easyfit.easyfit.BaseDrawerActivity;
import easyfit.easyfit.R;


public class Graph extends BaseDrawerActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        String months[] = new String[] {"Ja", "Fe", "Ma", "Av", "Ma", "Ju", "Ju", "Se", "Oc", "No","De"};
        String weights[] = new String[] {"10", "20", "30", "40", "50", "60", "70", "80", "90", "100",};
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_graphics, frame);
        GraphView graph = (GraphView) findViewById(R.id.graph);
        assert (graph != null);
        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);
        assert (staticLabelsFormatter != null);
        staticLabelsFormatter.setHorizontalLabels(months);
        staticLabelsFormatter.setVerticalLabels(weights);
        graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
        graph.getGridLabelRenderer().setVerticalAxisTitle("Kg");
        graph.getGridLabelRenderer().setHorizontalAxisTitle("Time");
        graph.setTitle("Progression");

        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 2),
                new DataPoint(2, 2),
                new DataPoint(3, 3),
                new DataPoint(4, 4),
                new DataPoint(5, 3)
        });

        graph.addSeries(series);
    }
}
