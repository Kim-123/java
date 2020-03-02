import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Customer {
	public static void main(String[] args) {
		//getCustomers();
		
	}
	
	public static void update(int row, String name, String text) {
		try {
			Connection conn = getConnection(); //DB연결 conn객체 
			PreparedStatement update = conn.prepareStatement(
					"UPDATE customer SET "+name+"='"+text+"' WHERE customer_id=?");
			update.setInt(1, row+1); //첫번째를 row로
			update.execute();	
			System.out.println("업데이트 되었습니다!");
		} catch (Exception e) {
			e.printStackTrace();
	}
	}
	
	public static void login(String id, String pass) {
		try {
			Connection conn = getConnection(); //DB연결 conn객체 
			PreparedStatement statement = conn.prepareStatement(
					"SELECT * FROM customer where id=? and pass=?");
			statement.setString(1, id);
			statement.setString(2, pass);	
			ResultSet results = statement.executeQuery();
			if(results.next()) { //
				JOptionPane.showMessageDialog(null, "로그인 성공!");
				// 원래있던 창 dispose, 새 프레임
			} else {
				JOptionPane.showMessageDialog(null, "아이디나 패스워드가 틀립니다.");
			}
			
				
		} catch (Exception e) {
			e.printStackTrace();
	}
	}
//		public static void CreateCustomer(String id, String pass, String gender, String phone, String note)
//				try {
//					Connection conn = getConnection(); //DB연결 conn객체
//					PreparedStatement insert = conn.prepareStatement(
//							"INSERT INTO customer(id,pass,gender,phone,note) "
//							+ "VALUES" 
//							
//				}catch (Exception e) {
//					e.printStackTrace();
//				}
//	}
	public static String[][] getCustomers() {
		try {
			Connection conn = getConnection(); //DB연결 conn객체 
			PreparedStatement statement = conn.prepareStatement(
					"SELECT * FROM customer");
			ResultSet results = statement.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(results.next()) {
				list.add(new String[] {
						results.getString("id"),
						results.getString("pass"),
						results.getString("gender"),
						results.getString("phone"),
						results.getString("note")
				});
//				System.out.print(results.getString("id") + " ");
//				System.out.print(results.getString("pass") + " ");
//				System.out.print(results.getString("gender") + " ");
//				System.out.print(results.getString("phone") + " ");
//				System.out.println(results.getString("note"));
			}
			System.out.println("검색되었습니다.");
			String[][] arr = new String[list.size()][5]; //2차원배열 사이즈 지정 무슨소리냐고요? 저도 모르겠습니다
			return list.toArray(arr);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	public static void createCustomer(String id, String pass, String gender, String phone, String note) {
		try {
			Connection conn = getConnection(); //DB연결 conn객체 
			PreparedStatement insert = conn.prepareStatement(
					"INSERT INTO customer(id, pass, gender, phone, note) "
					+ "VALUES ('"+id+"','"+pass+"','"+gender+"','"+phone+"','"+note+"')");
			insert.execute();
			System.out.println("손님이 저장됐습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
					
	public static void createTable() {
		try {
			Connection conn = getConnection(); //DB연결 conn객체
			PreparedStatement insert = conn.prepareStatement(
					
					
					"CREATE TABLE IF NOT EXISTS "
					+ "customer(customer_id int NOT NULL AUTO_INCREMENT,"
					+ "id varChar(255),"
					+ "pass varChar(255),"
					+ "gender varChar(255),"
					+ "phone varChar(255),"
					+ "note varChar(255),"
					+"PRIMARY KEY(customer_id))");
			insert.execute();
			System.out.println("테이블을 만들었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
//	public static void createStudent(String name, String dept, String id) {
//		try {
//			Connection conn = getConnection(); //DB연결 conn객체
//			PreparedStatement insert = conn.prepareStatement(
//					"INSERT INTO student(name, dept,id)" + "VALUES ('" + name + "','" + dept + "','" + id + "')");
//			insert.execute();
//			System.out.println("저장했습니다.");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	public static Connection getConnection() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/sampledb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
		String user = "root";
		String pass = "code1234";
		
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,user,pass);
			System.out.println("DB 연결 완료!");
			return conn;
		
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}

}
}
