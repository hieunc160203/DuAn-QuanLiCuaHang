/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author Administrator
 */
public class jdbcHelper {
    
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String db_url = "jdbc:sqlserver://localhost:1433;databaseName=DuAn1_QuanLiCuaHang";
    private static String db_user = "sa";
    private static String db_pass = "123456";
    
    /*
     * Nap driver
     */
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException (e);
        }
    }
    
    /**
     * Xay dung PreparedStatement
     */
    public static PreparedStatement prepareStatement(String sql, Object...args) throws SQLException{
        Connection con = DriverManager.getConnection(db_url, db_user, db_pass);
        PreparedStatement pstm = null;
        if(sql.trim().startsWith("|")){
            pstm = con.prepareCall(sql);
        }
        else{
            pstm = con.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            pstm.setObject(i + 1, args[i]);
        }
        return pstm;
    }
    
    /**
     * Thuc hien cac cau lenh SQL thao tac (INSERT, UPDATE, DELETE) 
     * hoac thu tuc luu thao tac du lieu
     * @return int - ket qua tra ve so dong da tac dong tren CSDL
     *               neu tra ve 0 tuc la khong co thay doi CSDL
     *               neu tra ve > 0 tuc la da co thay doi CSDL
     */    
    public static int executeUpdate(String sql, Object... args) {
        int rs = 0;
        try {
            PreparedStatement pstm = prepareStatement(sql, args);
            try {
                rs = pstm.executeUpdate();
                return rs;
            } finally {
                pstm.getConnection().close();
                return rs;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
            
    /**
     * Thuc hien cau lenh SQL truy van SELECT 
     * hoac thu tuc luu truy van du lieu
     */
    public static ResultSet executeQuery(String sql, Object...args){
        try {
            PreparedStatement pstm = prepareStatement(sql, args);
            return pstm.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
    }

    public static ResultSet excuteQuery(String sql, Object[] args) {
        try {
            PreparedStatement pstm = prepareStatement(sql, args);
            return pstm.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
    }
    
    /*
     * Hàm kết nối ireport và in hoá đơn
     */
    public static void inHoaDon(HashMap HoaDon) throws Exception {
        Connection con = DriverManager.getConnection(db_url, db_user, db_pass);
        File path = new File(System.getProperty("user.dir")+"\\src\\ui\\chung\\InHoaDon.jrxml");
        JasperDesign jdesign = JRXmlLoader.load(path.getAbsolutePath());
        // JasperDesign jdesign = JRXmlLoader.load("D:\\FPOLY\\FALL 19\\Du an 1\\quanlysieuthimini\\quanlysieuthimini\\src\\ui\\chung\\InHoaDon.jrxml");
        JasperReport ireport = JasperCompileManager.compileReport(jdesign);
        JasperPrint jprint = JasperFillManager.fillReport(ireport, HoaDon, con);
        // hàm view:
        // JasperViewer.viewReport(jprint);
        // hàm in:
        JasperPrintManager.printReport(jprint, false);
    }
}
