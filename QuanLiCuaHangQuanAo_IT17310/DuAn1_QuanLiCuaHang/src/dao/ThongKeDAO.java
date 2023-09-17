/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import helper.DateHelper;
import helper.jdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class ThongKeDAO {
    
    /*
     * Hàm lập bảng doanh thu 7 ngày gần nhất 
     */
    public List<Object[]> bangDoanhThu7Ngay() throws SQLException {
        List<Object[]> list = new ArrayList<>();
        String sql = "{call sp_bc_doanhthu7ngay}";
        ResultSet rs = jdbcHelper.executeQuery(sql);
        while (rs.next()) {
            Object[] model = {rs.getDouble(1), rs.getDouble(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7)};
            list.add(model);
        }
        return list;
    }
    
    /*
     * Hàm thống kê số sản phẩm sắp hết HSD trong 7 ngày tới
     */
    public int demSanPhamHetHSD() throws SQLException {
        int dem = 0;
        String sql = "SELECT COUNT(*) AS 'DEM' FROM SanPham "
                + "WHERE HSDTruoc <= (getdate()+7) "
                + "AND HSDTruoc >= getdate()";
        ResultSet rs = jdbcHelper.executeQuery(sql);
        while (rs.next()) {
            dem = rs.getInt("DEM");
        }
        return dem;
    }
    
    /*
     * Hàm tính giá vốn hàng bán theo khoảng thời gian
     */
    public double tinhGiaVonHangBan(String TuNgay, String DenNgay) {
        double GiaVon = 0;
        try {
            ResultSet rs = null;
            try{
                String sql = "{call sp_giavonhangban(?, ?)}";
                rs = jdbcHelper.executeQuery(sql, DateHelper.toDate(TuNgay, "yyyy-MM-dd"), DateHelper.toDate(DenNgay, "yyyy-MM-dd"));
                while(rs.next()){
                    GiaVon = rs.getDouble(1);
                }
            }
            finally{
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return GiaVon;
    }
    
    
    /*
     * Hàm tính tổng số lượng hàng nhập theo thời gian
     */
    public int tinhTongSLHangNhap(String TuNgay, String DenNgay) throws SQLException {
        int Tong = 0;
        String sql = "SELECT SUM(TongSoLuong) AS 'Tong' FROM PhieuNhapHang "
                + "WHERE NgayNhap >= '" + TuNgay + "' AND NgayNhap <= '" + DenNgay + "'";
        ResultSet rs = jdbcHelper.executeQuery(sql);
        while (rs.next()) {
            Tong = rs.getInt("Tong");
        }
        return Tong;
    }
    
    /*
     * Hàm tính tổng số lượng hàng nhập toàn thời gian
     */
    public int tinhTongSLHangNhap() throws SQLException {
        int Tong = 0;
        String sql = "SELECT SUM(TongSoLuong) AS 'Tong' FROM PhieuNhapHang";
        ResultSet rs = jdbcHelper.executeQuery(sql);
        while (rs.next()) {
            Tong = rs.getInt("Tong");
        }
        return Tong;
    }
    
    /*
     * Hàm tính tổng giá trị hàng nhập theo thời gian
     */
    public double tinhTongGiaTriHangNhap(String TuNgay, String DenNgay) throws SQLException {
        double Tong = 0;
        String sql = "SELECT SUM(ThanhTien) AS 'Tong' FROM PhieuNhapHang "
                + "WHERE NgayNhap >= '" + TuNgay + "' AND NgayNhap <= '" + DenNgay + "'";
        ResultSet rs = jdbcHelper.executeQuery(sql);
        while (rs.next()) {
            Tong = rs.getDouble("Tong");
        }
        return Tong;
    }
    
    /*
     * Hàm tính tổng giá trị hàng nhập toàn thời gian
     */
    public double tinhTongGiaTriHangNhap() throws SQLException {
        double Tong = 0;
        String sql = "SELECT SUM(ThanhTien) AS 'Tong' FROM PhieuNhapHang";
        ResultSet rs = jdbcHelper.executeQuery(sql);
        while (rs.next()) {
            Tong = rs.getDouble("Tong");
        }
        return Tong;
    }
    
    /*
     * Hàm thống kê tổng hợp hàng nhập theo thời gian tuỳ chọn
     */
    public List<Object[]> thongkeHangNhap(String TuNgay, String DenNgay) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try{
                String sql = "{call sp_tk_tonghophangnhap_theotg(?, ?)}";
                rs = jdbcHelper.executeQuery(sql, DateHelper.toDate(TuNgay, "yyyy-MM-dd"), DateHelper.toDate(DenNgay, "yyyy-MM-dd"));
                while(rs.next()){
                    Object[] model = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5)};
                    list.add(model);
                }
            }
            finally{
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    /*
     * Hàm thống kê tổng hợp hàng nhập toàn thời gian
     */
    public List<Object[]> thongkeHangNhapToanTG() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try{
                String sql = "{call sp_tk_tonghophangnhap()}";
                rs = jdbcHelper.executeQuery(sql);
                while(rs.next()){
                    Object[] model = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5)};
                    list.add(model);
                }
            }
            finally{
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    /*
     * Hàm thống kê hàng bán chạy theo thời gian tuỳ chọn
     */
    public List<Object[]> locSPBanChay(String TuNgay, String DenNgay) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try{
                String sql = "{call sp_tk_hangbanchay(?, ?)}";
                rs = jdbcHelper.executeQuery(sql, DateHelper.toDate(TuNgay, "yyyy-MM-dd"), DateHelper.toDate(DenNgay, "yyyy-MM-dd"));
                while(rs.next()){
                    Object[] model = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
                    list.add(model);
                }
            }
            finally{
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    /*
     * Hàm thống kê hàng bán chạy toàn thời gian
     */
    public List<Object[]> locSPBanChayToanThoiGian() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try{
                String sql = "{call sp_tk_hangbanchay_toantg()}";
                rs = jdbcHelper.executeQuery(sql);
                while(rs.next()){
                    Object[] model = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
                    list.add(model);
                }
            }
            finally{
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    /*
     * Hàm thống kê tổng giá trị kho hàng
     */
    public double tongGiaTriKho() throws SQLException {
        double Tong = 0;
        String sql = "SELECT SUM(TonKho*GiaVon) AS 'Tong' FROM SanPham";
        ResultSet rs = jdbcHelper.executeQuery(sql);
        while (rs.next()) {
            Tong = rs.getInt("Tong");
        }
        return Tong;
    }
    
    /*
     * Hàm thống kê tổng số lượng sản phẩm trong kho hàng
     */
    public int demTongSanPham() throws SQLException {
        int dem = 0;
        String sql = "SELECT SUM(TonKho) AS 'Tong' FROM SanPham";
        ResultSet rs = jdbcHelper.executeQuery(sql);
        while (rs.next()) {
            dem = rs.getInt("Tong");
        }
        return dem;
    }
    
    /*
     * Hàm liệt kê thông tin kho hàng
     */
    public List<Object[]> thongkeKhoHang() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try{
                String sql = "SELECT MaNhomHang, MaSanPham, TenSanPham, DVT.MoTa, "
                        + "TonKho, GiaVon, (GiaVon*TonKho) AS 'GiaTri' "
                        + "FROM SanPham LEFT JOIN DonViTinh DVT "
                        + "ON SanPham.MaDVT = DVT.MaDVT "
                        + "WHERE TonKho > 0 "
                        + "ORDER BY CAST(RIGHT(MaNhomHang, LEN(MaNhomHang)-2) AS int), "
                        + "CAST(RIGHT(MaSanPham, LEN(MaSanPham)-2) AS int)";
                rs = jdbcHelper.executeQuery(sql);
                while(rs.next()){
                    Object[] model = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getFloat(6), rs.getFloat(7)};
                    list.add(model);
                }
            }
            finally{
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    /*
     * Hàm tính số hoá đơn bán được trong năm
     */
    public int demSoDonTrongNam() throws SQLException {
        int SoHD = 0;
        String sql = "SELECT COUNT(*) AS 'Tong' FROM HoaDon "
                + "WHERE YEAR(NgayBan) = YEAR(getdate())";
        ResultSet rs = jdbcHelper.executeQuery(sql);
        while (rs.next()) {
            SoHD = rs.getInt("Tong");
        }
        return SoHD;
    }
    
    /*
     * Hàm tính doanh thu trong năm
     */
    public double tinhDoanhThuTrongNam() throws SQLException {
        double DoanhThu = 0;
        String sql = "SELECT SUM(ThanhTien) AS 'Tong' FROM HoaDon "
                + "WHERE YEAR(NgayBan) = YEAR(getdate())";
        ResultSet rs = jdbcHelper.executeQuery(sql);
        while (rs.next()) {
            DoanhThu = rs.getDouble("Tong");
        }
        return DoanhThu;
    }
    
    /*
     * Hàm tính số hoá đơn bán được trong quý
     */
    public int demSoDonTrongQuy() throws SQLException {
        int Quy = DateHelper.tinhSoQuyTrongNam();
        int SoHD = 0;
        String sql = "SELECT COUNT(*) AS 'Tong' FROM HoaDon "
                + "WHERE YEAR(NgayBan) = YEAR(getdate()) ";
        switch (Quy) {
            case 1:
                sql+= "AND MONTH(NgayBan) >= 1 AND MONTH(NgayBan) <= 3";
                break;
            case 2:
                sql+= "AND MONTH(NgayBan) >= 4 AND MONTH(NgayBan) <= 6";
                break;
            case 3:
                sql+= "AND MONTH(NgayBan) >= 7 AND MONTH(NgayBan) <= 9";
                break;
            case 4:
                sql+= "AND MONTH(NgayBan) >= 10 AND MONTH(NgayBan) <= 12";
                break;
        }
        ResultSet rs = jdbcHelper.executeQuery(sql);
        while (rs.next()) {
            SoHD = rs.getInt("Tong");
        }
        return SoHD;
    }
    
    /*
     * Hàm tính doanh thu trong quý
     */
    public double tinhDoanhThuTrongQuy() throws SQLException {
        int Quy = DateHelper.tinhSoQuyTrongNam();
        double DoanhThu = 0;
        String sql = "SELECT SUM(ThanhTien) AS 'Tong' FROM HoaDon "
                + "WHERE YEAR(NgayBan) = YEAR(getdate()) ";
        switch (Quy) {
            case 1:
                sql+= "AND MONTH(NgayBan) >= 1 AND MONTH(NgayBan) <= 3";
                break;
            case 2:
                sql+= "AND MONTH(NgayBan) >= 4 AND MONTH(NgayBan) <= 6";
                break;
            case 3:
                sql+= "AND MONTH(NgayBan) >= 7 AND MONTH(NgayBan) <= 9";
                break;
            case 4:
                sql+= "AND MONTH(NgayBan) >= 10 AND MONTH(NgayBan) <= 12";
                break;
        }
        ResultSet rs = jdbcHelper.executeQuery(sql);
        while (rs.next()) {
            DoanhThu = rs.getDouble("Tong");
        }
        return DoanhThu;
    }
    
    /*
     * Hàm tính doanh thu trong tháng
     */
    public double tinhDoanhThuTrongThang() throws SQLException {
        double DoanhThu = 0;
        String sql = "SELECT SUM(ThanhTien) AS 'Tong' FROM HoaDon "
                + "WHERE MONTH(NgayBan) = MONTH(getdate()) "
                + "AND YEAR(NgayBan) = YEAR(getdate())";
        ResultSet rs = jdbcHelper.executeQuery(sql);
        while (rs.next()) {
            DoanhThu = rs.getDouble("Tong");
        }
        return DoanhThu;
    }
    
    /*
     * Hàm tính số hoá đơn bán được trong tháng
     */
    public int demSoDonTrongThang() throws SQLException {
        int SoHD = 0;
        String sql = "SELECT COUNT(*) AS 'Tong' FROM HoaDon "
                + "WHERE MONTH(NgayBan) = MONTH(getdate()) "
                + "AND YEAR(NgayBan) = YEAR(getdate())";
        ResultSet rs = jdbcHelper.executeQuery(sql);
        while (rs.next()) {
            SoHD = rs.getInt("Tong");
        }
        return SoHD;
    }
    
    /*
     * Hàm tính số hoá đơn bán được trong ngày
     */
    public int demSoDonTrongNgay() throws SQLException {
        int SoHD = 0;
        String sql = "SELECT COUNT(*) AS 'Tong' FROM HoaDon "
                + "WHERE NgayBan = FORMAT(getdate(), 'yyyy-MM-dd')";
        ResultSet rs = jdbcHelper.executeQuery(sql);
        while (rs.next()) {
            SoHD = rs.getInt("Tong");
        }
        return SoHD;
    }
    
    /*
     * Hàm tính số hoá đơn bán được trong tuần
     */
    public int demSoDonTrongTuan() throws SQLException {
        String DauTuan = DateHelper.tinhNgayDauTuan(1);
        int SoHD = 0;
        String sql = "SELECT COUNT(*) AS 'Tong' FROM HoaDon "
                + "WHERE NgayBan <= FORMAT(getdate(), 'yyyy-MM-dd') "
                + "AND NgayBan >= '" + DauTuan + "'";
        ResultSet rs = jdbcHelper.executeQuery(sql);
        while (rs.next()) {
            SoHD = rs.getInt("Tong");
        }
        return SoHD;
    }
    
    /*
     * Hàm tính doanh thu trong tuần đến ngày hiện tại
     */
    public double tinhDoanhThuTrongTuan() throws SQLException {
        String DauTuan = DateHelper.tinhNgayDauTuan(1);
        double DoanhThu = 0;
        String sql = "SELECT SUM(ThanhTien) AS 'Tong' FROM HoaDon "
                + "WHERE NgayBan <= FORMAT(getdate(), 'yyyy-MM-dd') "
                + "AND NgayBan >= '" + DauTuan + "'";
        ResultSet rs = jdbcHelper.executeQuery(sql);
        while (rs.next()) {
            DoanhThu = rs.getDouble("Tong");
        }
        return DoanhThu;
    }
    
    /*
     * Hàm tính doanh thu trong ngày
     */
    public double tinhDoanhThuTrongNgay() throws SQLException {
        double DoanhThu = 0;
        String sql = "SELECT SUM(ThanhTien) AS 'Tong' FROM HoaDon "
                + "WHERE NgayBan = FORMAT(getdate(), 'yyyy-MM-dd')";
        ResultSet rs = jdbcHelper.executeQuery(sql);
        while (rs.next()) {
            DoanhThu = rs.getDouble("Tong");
        }
        return DoanhThu;
    }
    
    /*
     * Hàm tính tổng doanh thu của cửa hàng theo toàn thời gian
     */
    public double tinhTongDoanhThu() throws SQLException {
        double TongDoanhThu = 0;
        String sql = "SELECT SUM(ThanhTien) AS 'Tong' FROM HoaDon";
        ResultSet rs = jdbcHelper.executeQuery(sql);
        while (rs.next()) {
            TongDoanhThu = rs.getDouble("Tong");
        }
        return TongDoanhThu;
    }
        
    /*
     * Hàm tính doanh thu của nhân viên theo mã nhân viên
     */
    public double tinhDoanhThuNV(String MaNV) throws SQLException {
        double DoanhThu = 0;
        String sql = "SELECT SUM(ThanhTien) AS 'DoanhThu' FROM HoaDon "
                + "WHERE MaNhanVien = ? "
                + "GROUP BY MaNhanVien";
        ResultSet rs = jdbcHelper.executeQuery(sql, MaNV);
        while(rs.next()) {
            DoanhThu = rs.getDouble("DoanhThu");
        }
        return DoanhThu;
    }
    
    /*
     * Hàm thống kê tổng tiền nhập và tổng tiền trả của nhà cung cấp
     */
    public List<Object[]> tongGiaoDichNCC(String MaNCC) throws SQLException{
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try{
                String sql = "{call sp_tonggiaodich_ncc(?)}";
                rs = jdbcHelper.executeQuery(sql, MaNCC);
                while(rs.next()){
                    Object[] model = {rs.getString(1), rs.getFloat(2), rs.getFloat(3)};
                    list.add(model);
                }
            }
            finally{
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    /*
     * Hàm thống kê tổng giao dịch của khách hàng theo mã khách hàng
     */
    public float tongGiaoDichKH(String MaKhachHang) throws SQLException{
        float TongGiaoDich = 0;
        String sql = "SELECT SUM(ThanhTien) FROM HoaDon HD "
                + "JOIN KhachHang KH ON HD.MaKhachHang = KH.MaKhachHang " 
                + "WHERE HD.MaKhachHang = ?";
        ResultSet rs = null;
        rs = jdbcHelper.executeQuery(sql, MaKhachHang);
        while(rs.next()){
            TongGiaoDich = rs.getFloat(1);
        }
        return TongGiaoDich;
    }
    
    /*
     * Tổng kết cuối ngày: danh sách sản phẩm bán ra, số lượng và giá trị
           Thống kê theo nhân viên
     */
    public List<Object[]> ThongKeCuoiNgay(String MaNhanVien){
        List<Object[]> list = new ArrayList<>();
        String NgayBan = DateHelper.toString(DateHelper.now(), "yyyy-MM-dd");
        try {
            ResultSet rs = null;
            try{
                String sql = "{call sp_tongketcuoingay(?, ?)}";
                rs = jdbcHelper.executeQuery(sql, MaNhanVien, NgayBan);
                while(rs.next()){
                    Object[] model = {rs.getString(1), rs.getInt(2), rs.getFloat(3)};
                    list.add(model);
                }
            }
            finally{
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
