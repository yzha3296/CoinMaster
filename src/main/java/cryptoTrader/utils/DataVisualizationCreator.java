package cryptoTrader.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import cryptoTrader.entity.ClientTradingRecord;
import cryptoTrader.entity.TransactionRecord;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.LogAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.Range;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import cryptoTrader.gui.MainUI;
/**
 * This class is used to visualize the data by generating 
 * @author CS2212 Group 11
 *
 */
public class DataVisualizationCreator {

//	public void createCharts(String[][] data) {
//		createTableOutput(data);
//		createBar();
//	}
	
	/**
	 * create a table to visualize the trader information
	 * @param transaction Given the transaction parameter to fetch the transaction information
	 */
	public void createTableOutput(String[][] transaction) {
		// Dummy dates for demo purposes. These should come from selection menu
		Object[] columnNames = {"Trader","Strategy","CryptoCoin","Action","Quantity","Price","Date"};


		// Dummy data for demo purposes. These should come from actual fetcher
		Object[][] data = (Object[][]) transaction;
	
		for (Object obj : data) {
			System.out.println(obj);
		}
		/**
		 * make a new Jtable with data and columnNames which are previously defined 
		 */
		JTable table = new JTable(data, columnNames);
		//table.setPreferredSize(new Dimension(600, 300));
		/**
		 * Modify the table 
		 */
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder (BorderFactory.createTitledBorder (BorderFactory.createEtchedBorder (),
                "Trader Actions",
                TitledBorder.CENTER,
                TitledBorder.TOP));
		scrollPane.setPreferredSize(new Dimension(800, 300));
		table.setFillsViewportHeight(true);;
		
		MainUI.getInstance().updateStats(scrollPane);
	}
	
	public void createBar(List<ClientTradingRecord> list) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//		Those are hard-coded values!!!! 
//		You will have to come up with a proper data structure to populate the BarChart with live data!
//		dataset.setValue(6, "Trader-1", "Strategy-A");
//		dataset.setValue(5, "Trader-2", "Strategy-B");
//		dataset.setValue(0, "Trader-3", "Strategy-E");
//		dataset.setValue(1, "Trader-4", "Strategy-C");
//		dataset.setValue(10, "Trader-5", "Strategy-D");

		List<ClientTradingRecord> clients = list;
//
		for (int i = 0; i < clients.size();i++) {
			dataset.addValue(clients.get(i).getStrategyACount(), list.get(i).getClientName(),"Strategy-A" );
			dataset.addValue(clients.get(i).getStrategyBCount(), list.get(i).getClientName(),"Strategy-B" );
			dataset.addValue(clients.get(i).getStrategyCCount(), list.get(i).getClientName(),"Strategy-C" );
			dataset.addValue(clients.get(i).getStrategyDCount(), list.get(i).getClientName(),"Strategy-D" );
			dataset.addValue(clients.get(i).getStrategyECount(), list.get(i).getClientName(),"Strategy-E" );
		}

		CategoryPlot plot = new CategoryPlot();
		BarRenderer barrenderer1 = new BarRenderer();

		plot.setDataset(0, dataset);
		plot.setRenderer(0, barrenderer1);
		CategoryAxis domainAxis = new CategoryAxis("Strategy");
		plot.setDomainAxis(domainAxis);
		NumberAxis rangeAxis = new NumberAxis ("Actions(Buys or Sells)");
		rangeAxis.setRange(new Range(0.0, 20.0));
		plot.setRangeAxis(rangeAxis);

		//plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis
		//plot.mapDatasetToRangeAxis(1, 1); // 2nd dataset to 2nd y-axis

		JFreeChart barChart = new JFreeChart("Actions Performed By Traders So Far", new Font("Serif", java.awt.Font.BOLD, 18), plot,
				true);

		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new Dimension(600, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		chartPanel.setBackground(Color.white);
		MainUI.getInstance().updateStats(chartPanel);
	}

}
