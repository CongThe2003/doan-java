package doan_java;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Connect {

    /**
     * @return the conn
     */
    public Connection getConn() {
        return conn;
    }

    /**
     * @param conn the conn to set
     */
    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
    private Connection conn = null;
    
    public Connect() throws SQLException{
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionURL = "jdbc:sqlserver://LAPTOP-M652I7NI\\SQLEXPRESS:1433;databaseName=QuanLySach1;"
                    +"encrypt=true;trustServerCertificate=true";
            conn = DriverManager.getConnection(connectionURL,"sa","123456");
	} catch (ClassNotFoundException e) {
            System.out.println(e.getMessage()+"\n"+e.getClass()+"\n"+e.getCause());
	}
    }
    
    public ResultSet getData(String stringSQL){
        ResultSet rs = null;
        try {
            Statement state = getConn().createStatement();
            rs = state.executeQuery(stringSQL);
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public int ExcuteSQLInsertSach(String[] stringSQL){
        int rowsInserted = 0;
        String sql = "INSERT INTO Sach(MaSach, TenSach, MaTacGia, MaTheLoai, MaNXB, NamXB) VALUES(?,?,?,?,?,?)";
        PreparedStatement statement;
        try {
            statement = getConn().prepareStatement(sql);
            statement.setString(1, stringSQL[0]);
            statement.setString(2, stringSQL[1]);
            statement.setString(3, stringSQL[2]);
            statement.setString(4, stringSQL[3]);
            statement.setString(5, stringSQL[4]);
            statement.setString(6, stringSQL[5]);
            
            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowsInserted;
    }
    
    public int ExcuteSQLInsertNXB(String[] stringSQL){
        int rowsInserted = 0;
        String sql = "INSERT INTO NhaXuatBan(MaNXB, TenNXB, DiaChi, NamSinh) VALUES(?,?,?,?)";
        PreparedStatement statement;
        try {
            statement = getConn().prepareStatement(sql);
            statement.setString(1, stringSQL[0]);
            statement.setString(2, stringSQL[1]);
            statement.setString(3, stringSQL[2]);
            statement.setString(4, stringSQL[3]);
            
            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowsInserted;
    }
    
    public int ExcuteSQLInsertTacGia(String[] stringSQL){
        int rowsInserted = 0;
        String sql = "INSERT INTO TacGia(MaTacGia, TenTacGia) VALUES(?,?)";
        PreparedStatement statement;
        try {
            statement = getConn().prepareStatement(sql);
            statement.setString(1, stringSQL[0]);
            statement.setString(2, stringSQL[1]);
            
            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowsInserted;
    }
    
    public int ExcuteSQLInsertTheLoai(String[] stringSQL){
        int rowsInserted = 0;
        String sql = "INSERT INTO TheLoai(MaTheLoai, TenTheLoai) VALUES(?,?)";
        PreparedStatement statement;
        try {
            statement = getConn().prepareStatement(sql);
            statement.setString(1, stringSQL[0]);
            statement.setString(2, stringSQL[1]);
            
            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowsInserted;
    }
    
    public int ExcuteSQLUpdateSach(String []stringSQL){
        int rowsInserted = 0;
        String sql = "UPDATE Sach SET TenSach=?, MaTacGia=?, MaTheLoai=?, MaNXB=?, NamXB=? WHERE MaSach=?";
        PreparedStatement statement;
        try {
            statement = getConn().prepareStatement(sql);
            statement.setString(1, stringSQL[0]);
            statement.setString(2, stringSQL[1]);
            statement.setString(3, stringSQL[2]);
            statement.setString(4, stringSQL[3]);
            statement.setString(5, stringSQL[4]);
            statement.setString(6, stringSQL[5]);
            
            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowsInserted;
    }
    
    public int ExcuteSQLUpdateNhaXB(String []stringSQL){
        int rowsInserted = 0;
        String sql = "UPDATE NhaXuatBan SET TenNXB=?, DiaChi=?, NamSinh=? WHERE MaNXB=?";
        PreparedStatement statement;
        try {
            statement = getConn().prepareStatement(sql);
            statement.setString(1, stringSQL[0]);
            statement.setString(2, stringSQL[1]);
            statement.setString(3, stringSQL[2]);
            statement.setString(4, stringSQL[3]);
            
            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowsInserted;
    }
    
    public int ExcuteSQLUpdateTacGia(String []stringSQL){
        int rowsInserted = 0;
        String sql = "UPDATE TacGia SET TenTacGia=? WHERE MaTacGia=?";
        PreparedStatement statement;
        try {
            statement = getConn().prepareStatement(sql);
            statement.setString(1, stringSQL[0]);
            statement.setString(2, stringSQL[1]);
            
            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowsInserted;
    }
    
    public int ExcuteSQLUpdateTheLoai(String []stringSQL){
        int rowsInserted = 0;
        String sql = "UPDATE TheLoai SET TenTheLoai=? WHERE MaTheLoai=?";
        PreparedStatement statement;
        try {
            statement = getConn().prepareStatement(sql);
            statement.setString(1, stringSQL[0]);
            statement.setString(2, stringSQL[1]);
            
            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowsInserted;
    }
    
    public int ExcuteSQLDeleteSach(String[] stringSQL){
        int rowsInserted = 0;
        String sql = "DELETE FROM Sach WHERE MaSach=?";
        PreparedStatement statement;
        try {
            statement = getConn().prepareStatement(sql);
            statement.setString(1, stringSQL[0]);
            
            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowsInserted;
    }
    
    public int ExcuteSQLDeleteNhaXB(String[] stringSQL){
        int rowsInserted = 0;
        String sql = "DELETE FROM NhaXuatBan WHERE MaNXB=?";
        PreparedStatement statement;
        try {
            statement = getConn().prepareStatement(sql);
            statement.setString(1, stringSQL[0]);
            
            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowsInserted;
    }
    
    public int ExcuteSQLDeleteTacGia(String[] stringSQL){
        int rowsInserted = 0;
        String sql = "DELETE FROM TacGia WHERE MaTacGia=?";
        PreparedStatement statement;
        try {
            statement = getConn().prepareStatement(sql);
            statement.setString(1, stringSQL[0]);
            
            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowsInserted;
    }
    
    public int ExcuteSQLDeleteTheLoai(String[] stringSQL){
        int rowsInserted = 0;
        String sql = "DELETE FROM TheLoai WHERE MaTheLoai=?";
        PreparedStatement statement;
        try {
            statement = getConn().prepareStatement(sql);
            statement.setString(1, stringSQL[0]);
            
            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowsInserted;
    }
    
    public int ExcuteSQLSearchSach(String[] stringSQL,String MaSach){
        int rowsInserted = 0;
        String sql = "SELECT * FROM Sach WHERE MaSach LIKE'"+MaSach+"'";
        PreparedStatement statement;
        try {
            statement = getConn().prepareStatement(sql);
            statement.setString(1, stringSQL[0]);
            statement.setString(2, stringSQL[1]);
            statement.setString(3, stringSQL[2]);
            statement.setString(4, stringSQL[3]);
            statement.setString(5, stringSQL[4]);
            statement.setString(6, stringSQL[5]);
            
            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowsInserted;
    }
    
}
