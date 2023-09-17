/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import helper.jdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.KhachHang;

/**
 *
 * @author Administrator
 */
public class KhachHangDAO {
    
    /*
     * Hàm thêm mới khách hàng
     */
    public int themKhachHang(KhachHang model) {
        String sql = "INSERT INTO KhachHang(MaKhachHang, HoTen, DiemThuong, DienThoai, "
                + "GioiTinh, NgaySinh, NVQuanLy, Email, DiaChi, GhiChu, TrangThai) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcHelper.executeUpdate(sql,
                model.getMaKhachHang(),
                model.getHoTen(),
                model.getDiemThuong(),
                model.getDienThoai(),
                model.getGioiTinh(),
                model.getNgaySinh(),
                model.getNVQuanLy(),
                model.getEmail(),
                model.getDiaChi(),
                model.getGhiChu(),
                model.getTrangThai());
    }
    
    /*
     * Hàm cập nhật thông tin khách hàng
     */
    public int capnhatKhachHang(KhachHang model) {
        String sql = "UPDATE KhachHang SET "
                + "HoTen = ?, DiemThuong = ?, DienThoai = ?, GioiTinh = ?, "
                + "NgaySinh = ?, Email = ?, DiaChi = ?, GhiChu = ?, TrangThai = ? "
                + "WHERE MaKhachHang = ?";
        return jdbcHelper.executeUpdate(sql,
                model.getHoTen(),
                model.getDiemThuong(),
                model.getDienThoai(),
                model.getGioiTinh(),
                model.getNgaySinh(),
                model.getEmail(),
                model.getDiaChi(),
                model.getGhiChu(),
                model.getTrangThai(),
                model.getMaKhachHang());
    }

    /*
     * Hàm đếm tổng số khách hàng
     */
    public int tongKhachHang() throws SQLException{
        int dem = 0;
        String sql = "SELECT COUNT(*) AS 'COUNT' FROM KhachHang";
        ResultSet rs = jdbcHelper.executeQuery(sql);
        while(rs.next()){
            dem = rs.getInt(1);
        }
        return dem;
    }
    
    /*
     * Hàm tìm kiếm khách hàng theo mã kh, tên, sdt
     */
    public List<KhachHang> timTheoMaTenSDT(String ChuoiTimKiem) {
        String sql = "SELECT * FROM KhachHang WHERE HoTen LIKE N'%" + ChuoiTimKiem + "%' "
                + "OR MaKhachHang LIKE N'%" + ChuoiTimKiem + "%' "
                + "OR DienThoai LIKE '%" + ChuoiTimKiem + "%' "
                + "ORDER BY CAST(RIGHT(MaKhachHang,LEN(MaKhachHang)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm tìm khách hàng theo SDT
           - false nếu tồn tại
           - true nếu không tồn tại
     */
    public boolean kiemSDT(String SDT){
        String sql = "SELECT * FROM KhachHang WHERE DienThoai = ?";
        List<KhachHang> list = select(sql, SDT);
        return list.size() < 1;
    }
    
    /*
     * Hàm tìm khách hàng theo Email
           - false nếu tồn tại
           - true nếu không tồn tại
     */
    public boolean kiemEmail(String Email){
        String ChuoiDaXuLy = Email.substring(0, Email.indexOf("@"));
        String sql = "SELECT * FROM KhachHang WHERE Email LIKE ?";
        List<KhachHang> list = select(sql, ChuoiDaXuLy + "%");
        if(list.size() < 1)
            return true;
        else
            return false;
    }
    
    /*
     * Hàm tìm khách hàng theo mã (tìm tuyệt đối)
     */
    public KhachHang timTheoMa(String MaKhachHang) {
        String sql = "SELECT * FROM KhachHang WHERE MaKhachHang = ?";
        List<KhachHang> list = select(sql, MaKhachHang);
        return list.size() > 0 ? list.get(0) : null;
    }

    /*
     * Hàm tìm khách hàng có sinh nhật trong tháng
     */
    public List<KhachHang> timTheoSinhNhat() {
        LocalDate now = LocalDate.now();
        int Thang = now.getMonthValue();
        String sql = "SELECT * FROM KhachHang WHERE MONTH(NgaySinh) = ? "
                    + "ORDER BY CAST(RIGHT(MaKhachHang,LEN(MaKhachHang)-2) AS int)";
        return select(sql, Thang);
    }
    
    /*
     * Hàm tìm khách hàng theo giao dịch cuối
           lọc các khách hàng có giao dịch cuối cùng vào ngày đã chọn hoặc trước đó
           mục đích lọc các khách hàng quá lâu không có giao dịch nào để chuyển trạng thái
     */
    public List<KhachHang> timTheoGDCuoi(String Ngay) {
        String sql = "SELECT * FROM KhachHang WHERE NOT EXISTS "
                + "(SELECT * FROM HoaDon WHERE NgayBan > ? "
                + "AND KhachHang.MaKhachHang = HoaDon.MaKhachHang) "
                + "ORDER BY CAST(RIGHT(KhachHang.MaKhachHang,LEN(KhachHang.MaKhachHang)-2) AS int)";
        return select(sql, Ngay);
    }
    
    /*
     * Hàm tìm khách hàng có trạng thái 'ngưng giao dịch' - TrangThai: 0 (false)
     */
    public List<KhachHang> timKHNgungHoatDong() {
        String sql = "SELECT * FROM KhachHang WHERE TrangThai = 0 "
                    + "ORDER BY CAST(RIGHT(MaKhachHang,LEN(MaKhachHang)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm cập nhật trạng thái ngưng giao dịch cho khách hàng theo mã
     */
    public int ngungGiaoDich(String MaKH) {
        String sql = "UPDATE KhachHang SET TrangThai = 0 WHERE MaKhachHang = ?";
        return jdbcHelper.executeUpdate(sql, MaKH);
    }
    
    public List<KhachHang> select() {
        String sql = "SELECT * FROM KhachHang " 
                + "ORDER BY CAST(RIGHT(MaKhachHang,LEN(MaKhachHang)-2) AS int)";
        return select(sql);
    }
    
    public List<KhachHang> timKhachHang(String ChuoiTimKiem) {
        String sql = "SELECT * FROM KhachHang WHERE HoTen LIKE N'%" + ChuoiTimKiem + "%' "
                + "OR DienThoai LIKE N'%" + ChuoiTimKiem + "%' "
                + "ORDER BY CAST(RIGHT(MaKhachHang,LEN(MaKhachHang)-2) AS int)";
        return select(sql);
    }
    
    public KhachHang timKhachHangTheoMa(String MaKhachHang) {
        String sql = "SELECT * FROM KhachHang WHERE MaKhachHang = ?";
        List<KhachHang> listKH = select(sql, MaKhachHang);
        return listKH.get(0);
    }
    
    /*
     * Hàm cập nhật điểm thưởng khách hàng sau khi áp dụng chiết khấu
     */
    public void capnhatDiemThuong(KhachHang model){
        String sql = "UPDATE KhachHang SET DiemThuong = ? WHERE MaKhachHang = ?";
        jdbcHelper.executeUpdate(sql, model.getDiemThuong(), model.getMaKhachHang());
    }

    private List<KhachHang> select(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    KhachHang model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    private KhachHang readFromResultSet(ResultSet rs) throws SQLException {
        KhachHang model = new KhachHang();
        model.setMaKhachHang(rs.getString("MaKhachHang"));
        model.setHoTen(rs.getString("HoTen"));
        model.setDiemThuong(rs.getInt("DiemThuong"));
        model.setDienThoai(rs.getString("DienThoai"));
        model.setGioiTinh(rs.getBoolean("GioiTinh"));
        model.setNgaySinh(rs.getDate("NgaySinh"));
        model.setNVQuanLy(rs.getString("NVQuanLy"));
        model.setEmail(rs.getString("Email"));
        model.setDiaChi(rs.getString("DiaChi"));
        model.setGhiChu(rs.getString("GhiChu"));
        model.setTrangThai(rs.getBoolean("TrangThai"));
        return model;
    }
}
