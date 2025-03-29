import java.sql.Connection;

import utils.DatabaseConnection;

public class Main{
	public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn != null && !conn.isClosed()) {
                System.out.println(" Kết nối database thành công!");
            } else {
                System.out.println("Kết nối database thất bại!");
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi kết nối database: " + e.getMessage());
            e.printStackTrace();
        }
	}	
}