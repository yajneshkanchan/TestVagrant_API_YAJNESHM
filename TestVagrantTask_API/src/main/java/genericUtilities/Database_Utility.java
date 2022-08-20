package genericUtilities;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;


public class Database_Utility{
	static Driver driver;
	static Connection connection;
	static ResultSet result;

	/**
	 * this method will perform the mysql database connection
	 * @throws SQLException
	 */
	public void  connectDB() throws SQLException {
		try {
			driver = new Driver() {

				public Connection connect(String url, Properties info) throws SQLException {
					// TODO Auto-generated method stub
					return null;
				}

				public boolean acceptsURL(String url) throws SQLException {
					// TODO Auto-generated method stub
					return false;
				}

				public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
					// TODO Auto-generated method stub
					return null;
				}

				public int getMajorVersion() {
					// TODO Auto-generated method stub
					return 0;
				}

				public int getMinorVersion() {
					// TODO Auto-generated method stub
					return 0;
				}

				public boolean jdbcCompliant() {
					// TODO Auto-generated method stub
					return false;
				}

				public Logger getParentLogger() throws SQLFeatureNotSupportedException {
					// TODO Auto-generated method stub
					return null;
				}
				DriverManager.registerDriver(driver);

			connection=DriverManager.getConnection(IConstant.jdbcUrl, IConstant.jdbcUsername, IConstant.jdbcPassword);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method will close the mysql database
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException{
		try {
			connection.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method will execute the query 
	 * @param query
	 * @return
	 * @throws Throwable
	 */
	public ResultSet executeQuery(String query)throws Throwable{
		result=connection.createStatement().executeQuery(query);
		return result;
	}
	/**
//	 * This method will execute query based on query & it will verify the data
	 * @param query
	 * @param columnName
	 * @param expectedData
	 * @return
	 * @throws Throwable
	 */
	public boolean executeQuerryAndVerify(String querry,int columnIndex,String expectedData)throws Throwable{
		boolean flagfalse;
		result=connection.createStatement().executeQuery(querry);
		boolean flag;
		while(result.next()) {
			if(result.getString(columnIndex).equals(expectedData)) {
				flag=true;
				break;
			}
		}
		if (flag) {
			System.out.println(expectedData+"==>Data is verified in the database table");
			return flag;
		}else {
			System.out.println(expectedData+"==>data is not verified in the database");
			return flag;
		}
	}}}
