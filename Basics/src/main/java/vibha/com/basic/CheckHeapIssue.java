package vibha.com.basic;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.opencsv.CSVWriter;

public class CheckHeapIssue {
	static final String DB_URL = "jdbc:mysql://localhost/";

	static final String USER = "root";
	static final String PASS = "root123";
	static Connection conn = null;
	static Statement stmt = null;

	public static void main(String[] args) {
		createConnection();
	}

	private static void createConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL + "?autoReconnect=true&useCursorFetch=true", USER,
					PASS);
//			conn.setAutoCommit(false);
//			Statement st = conn.createStatement(/* ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY */);
//			st.setFetchSize(5000);
			ExecutorService executor = Executors.newFixedThreadPool(2);
			ArrayList<String> list = new ArrayList<String>();
			list.add("tbl_employee");
			for (String string : list) {
				Runnable task0 = () -> {
					try (CSVWriter writer = new CSVWriter(new FileWriter("E:\\heapIssue//" + string + ".csv"));) {

						// insert the data

//						String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date("1981/23/04"));

						String query = ("INSERT INTO test.tbl_employee(std_id,std_name,course,admission_date,dob) "
								+ "VALUES (?,?,?,?,?)");
						PreparedStatement ps = conn.prepareStatement(query);
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); // United States style of format.
						java.util.Date myDate;
						try {
							myDate = format.parse("0000-00-00 00:00:00");
							java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());

							ps.setInt(1, 1);
							ps.setString(2, "vibha");
							ps.setString(3, "saini");
							ps.setDate(4, sqlDate);
							ps.setTime(5, Time.valueOf("24:75:00"));
							ps.execute();
							System.out.println("ok");
						} catch (ParseException e) {
							e.printStackTrace();
						}
						// Notice the ".sql." (not "util")
						// in package name.

						/*
						 * System.out.println("enter" + " time :- " + LocalDateTime.now());
						 * System.out.println(string); ResultSet rs =
						 * st.executeQuery("select count(1) from test.tbl_employee"); rs =
						 * st.executeQuery("select std_id,std_name,course,admission_date from test." +
						 * string + " limit 759" ); ResultSetMetaData metaData = rs.getMetaData(); int
						 * numberOfColumns = metaData.getColumnCount(); List<String> dataTypeList = new
						 * ArrayList<>(); for (int i = 1; i <= numberOfColumns; i++) {
						 * dataTypeList.add(metaData.getColumnTypeName(i).toLowerCase()); } while
						 * (rs.next()) { String line1[] = { (rs.getInt("std_id") + "") }; String line2[]
						 * = { (rs.getString("std_name") + "") }; String line3[] = {
						 * (rs.getString("course") + "") }; String line4[] = {
						 * (rs.getDate("admission_date") + "") }; writer.writeNext(line1);
						 * writer.flush(); }
						 */
					} catch (SQLException | IOException e) {
						e.printStackTrace();
					}
					System.out.println("done :-- time " + LocalDateTime.now());
				};
				Thread th = new Thread(task0, string);
				executor.submit(th);

			}
			executor.shutdown();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void writeDataAtOnce(String filePath) {

	}

}
