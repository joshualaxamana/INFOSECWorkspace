package dls.csb.srdbms.model;

import java.sql.*;

import dls.csb.srdbms.utility.Security;

public class StudentBean {

	//make sure that all instance variables are protected
	//from direct access to achieve encapsulation
	private String studentId;
	private String lastName;
	private String firstName;
	private int yearLevel;
	private String course;
	
	//create equivalent setter and getter methods here
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getYearLevel() {
		return yearLevel;
	}
	public void setYearLevel(int yearLevel) {
		this.yearLevel = yearLevel;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
	//this section is reserved for JDBC database table manipulation
	private Connection getConnectionDB() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/laxamana-tc001-infosec",
					"root", "");
		} catch (ClassNotFoundException cfne) {
			cfne.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return connection;
	}
	
	public void insertRecord() {
		String sql = "insert into student(studentId, lastName, "
			+ "firstName, yearLevel, course) values (?,?,?,?,?)";
		
		try {
			Connection connection = getConnectionDB();
			
			if (connection != null) { //if true, we have the session on database
				PreparedStatement prep = connection.prepareStatement(sql);
				prep.setString(1, Security.encrypt(this.studentId));
				prep.setString(2, Security.encrypt(this.lastName));
				prep.setString(3, Security.encrypt(this.firstName));
				prep.setInt(4, this.yearLevel);
				prep.setString(5, this.course);
				
				//now commit this to the database
				prep.executeUpdate();
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	public ResultSet getRecords() {
		ResultSet records = null;
		
		String sql = "select * from student";
		
		try {
			Connection connection = getConnectionDB();
			
			if (connection != null) { //if true, we have the session on database
				PreparedStatement prep = connection.prepareStatement(sql);
				
				//now commit this to the database
				records = prep.executeQuery(); //retrieve records from student table
			} else {
				System.err.println("connection is null.");
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return records;
	}
}
