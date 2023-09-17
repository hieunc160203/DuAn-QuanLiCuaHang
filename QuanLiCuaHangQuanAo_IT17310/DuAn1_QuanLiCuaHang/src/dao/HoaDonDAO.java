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
import model.HoaDon;

/**
 *
 * @author Administrator
 */
public class HoaDonDAO {
    
    /*
     * Hàm lọc số hoá đơn bán ra trong năm
     */
    public List<HoaDon> locHoaDonTrongNam() {
        String sql = "SELECT * FROM HoaDon "
                + "WHERE YEAR(NgayBan) = YEAR(getdate()) "
                + "ORDER BY CAST(RIGHT(MaHoaDon,LEN(MaHoaDon)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm lọc số hoá đơn bán ra trong quý
     */
    public List<HoaDon> locHoaDonTrongQuy() {
        int Quy = DateHelper.tinhSoQuyTrongNam();
        String sql = "SELECT * FROM HoaDon "
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
        sql += " ORDER BY CAST(RIGHT(MaHoaDon,LEN(MaHoaDon)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm lọc số hoá đơn bán ra trong tháng
     */
    public List<HoaDon> locHoaDonTrongThang() {
        String sql = "SELECT * FROM HoaDon "
                + "WHERE MONTH(NgayBan) = MONTH(getdate()) "
                + "AND YEAR(NgayBan) = YEAR(getdate()) "
                + "ORDER BY CAST(RIGHT(MaHoaDon,LEN(MaHoaDon)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm lọc số hoá đơn bán ra trong tuần
     */
    public List<HoaDon> locHoaDonTrongTuan() {
        String DauTuan = DateHelper.tinhNgayDauTuan(1);
        String sql = "SELECT * FROM HoaDon "
                + "WHERE NgayBan <= FORMAT(getdate(), 'yyyy-MM-dd') "
                + "AND NgayBan >= '" + DauTuan + "' "
                + "ORDER BY CAST(RIGHT(MaHoaDon,LEN(MaHoaDon)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm tính thành tiền hoá đơn (chưa gồm VAT và chiết khấu)
     */
    public float tinhThanhTien(String MaHD) throws SQLException {
        float ThanhTien = 0;
        String sql = "SELECT SUM(ThanhTien) AS 'ThanhTien' FROM HoaDonChiTiet "
                + "WHERE MaHoaDon = ? "
                + "GROUP BY MaHoaDon";
        ResultSet rs = jdbcHelper.executeQuery(sql, MaHD);
        while (rs.next()) {
            ThanhTien = rs.getFloat("ThanhTien");
        }
        return ThanhTien;
    }
        
    /*
     * Hàm tìm hoá đơn theo khoảng ngày
     */
    public List<HoaDon> timTheoKhoangNgay(String TuNgay, String DenNgay) {
        String sql = "SELECT * FROM HoaDon "
                + "WHERE NgayBan >= '" + TuNgay + "' "
                + "AND NgayBan <= '" + DenNgay + "' "
                + "ORDER BY CAST(RIGHT(MaHoaDon,LEN(MaHoaDon)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm tìm hoá đơn tạo trong 7 ngày trước (không tính hôm nay)
     */
    public List<HoaDon> timTrong7NgayTruoc() {
        String sql = "SELECT * FROM HoaDon "
                + "WHERE NgayBan >= FORMAT(getdate()-7,'yyyy-MM-dd') "
                + "AND NgayBan < FORMAT(getdate(),'yyyy-MM-dd') "
                + "ORDER BY CAST(RIGHT(MaHoaDon,LEN(MaHoaDon)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm tìm hoá đơn tạo trong hôm qua
     */
    public List<HoaDon> timTrongHomQua() {
        String sql = "SELECT * FROM HoaDon "
                + "WHERE NgayBan = FORMAT(getdate()-1,'yyyy-MM-dd') "
                + "ORDER BY CAST(RIGHT(MaHoaDon,LEN(MaHoaDon)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm tìm hoá đơn tạo trong ngày
     */
    public List<HoaDon> timTrongNgay() {
        String sql = "SELECT * FROM HoaDon "
                + "WHERE NgayBan = FORMAT(getdate(),'yyyy-MM-dd') "
                + "ORDER BY CAST(RIGHT(MaHoaDon,LEN(MaHoaDon)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm gọi tất cả các hoá đơn
     */
    public List<HoaDon> select() {
        String sql = "SELECT * FROM HoaDon " 
                + "ORDER BY CAST(RIGHT(MaHoaDon,LEN(MaHoaDon)-2) AS int)";
        return select(sql);
    }

    /*
     * Insert Hoá đơn bằng Store Procedure
     */
    public int themHoaDon(HoaDon model) {
        int rs = 0;
        String sql = "{call sp_insert_hoadon(?, ?, ?, ?, ?, ?, ?, ?)}";
        try {
            rs = jdbcHelper.executeUpdate(sql, 
                                        model.getMaKhachHang(),
                                        model.getMaNhanVien(),
                                        DateHelper.toString(model.getNgayBan(), "yyyy-MM-dd"),
                                        model.getTongSoLuong(),
                                        model.getChietKhau(),
                                        model.getVAT(),
                                        model.getThanhTien(),
                                        model.getTienKhachTra());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
    /*
     * Hàm đếm tổng số hoá đơn
     */
    public int demHoaDon() throws SQLException{
        int dem = 0;
        String sql = "SELECT COUNT(*) AS 'COUNT' FROM HoaDon";
        ResultSet rs = jdbcHelper.executeQuery(sql);
        while (rs.next()) {
            dem = rs.getInt("COUNT");
        }
        return dem;
    }
    
    /*
     * Hàm đếm số hoá đơn đã xuất của nhân viên trong ngày
     */
    public int demHoaDonTrongNgay(String MaNhanVien) throws SQLException{
        int dem = 0;
        String NgayBan = DateHelper.toString(DateHelper.now(), "yyyy-MM-dd");
        String sql = "SELECT COUNT(*) AS 'COUNT' FROM HoaDon "
                + "WHERE MaNhanVien = ? AND NgayBan = ?";
        ResultSet rs = jdbcHelper.executeQuery(sql, MaNhanVien, NgayBan);
        while (rs.next()) {
            dem = rs.getInt("COUNT");
        }
        return dem;
    }
    
    /*
     * Hàm thống kê doanh thu trong ngày của nhân viên
     */
    public float tinhDoanhThuTrongNgay(String MaNhanVien) throws SQLException{
        float DoanhThu = 0;
        String NgayBan = DateHelper.toString(DateHelper.now(), "yyyy-MM-dd");
        String sql = "SELECT SUM(ThanhTien) AS 'DoanhThu' FROM HoaDon "
                + "WHERE MaNhanVien = ? AND NgayBan = ? "
                + "GROUP BY MaNhanVien";
        ResultSet rs = jdbcHelper.executeQuery(sql, MaNhanVien, NgayBan);
        while (rs.next()) {
            DoanhThu = rs.getFloat("DoanhThu");
        }
        return DoanhThu;
    }
        
    /*
     * Hàm lọc danh sách các đơn hàng nhân viên đã bán trong ngày
     */
    public List<HoaDon> timDonHangTrongNgay(String MaNhanVien){
        String sql = "SELECT * FROM HoaDon WHERE MaNhanVien = ? AND NgayBan = ? "
                + "ORDER BY CAST(RIGHT(MaHoaDon,LEN(MaHoaDon)-2) AS int)";
        String NgayBan = DateHelper.toString(DateHelper.now(), "yyyy-MM-dd");
        return select(sql, MaNhanVien, NgayBan);
    }
    
    /*
     * Hàm tìm hoá đơn theo mã người bán
     */
    public List<HoaDon> timHoaDonTheoMaNguoiBan(String MaNguoiBan){
        String sql = "SELECT * FROM HoaDon WHERE MaNhanVien = ?";
        return select(sql, MaNguoiBan);
    }
    
    /*
     * Hàm tìm hoá đơn theo tên khách hàng
     */
    public List<HoaDon> timHoaDonTheoTenKH(String TenKhachHang){
        String sql = "SELECT * FROM HoaDon WHERE EXISTS "
                + "(SELECT * FROM KhachHang WHERE HoTen LIKE N'%" + TenKhachHang + "%' "
                    + "AND HoaDon.MaKhachHang = KhachHang.MaKhachHang) "
                + "ORDER BY CAST(RIGHT(MaHoaDon,LEN(MaHoaDon)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm tìm hoá đơn theo mã
     */
    public HoaDon timHoaDonTheoMa(String MaHoaDon){
        String sql = "SELECT * FROM HoaDon WHERE MaHoaDon = ?";
        List<HoaDon> list = select(sql, MaHoaDon);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    private List<HoaDon> select(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    HoaDon model = readFromResultSet(rs);
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

    private HoaDon readFromResultSet(ResultSet rs) throws SQLException {
        HoaDon model = new HoaDon();
        model.setMaHoaDon(rs.getString("MaHoaDon"));
        model.setMaKhachHang(rs.getString("MaKhachHang"));
        model.setMaNhanVien(rs.getString("MaNhanVien"));
        model.setNgayBan(rs.getDate("NgayBan"));
        model.setTongSoLuong(rs.getInt("TongSoLuong"));
        model.setChietKhau(rs.getFloat("ChietKhau"));
        model.setVAT(rs.getFloat("VAT"));
        model.setThanhTien(rs.getFloat("ThanhTien"));
        model.setTienKhachTra(rs.getFloat("TienKhachTra"));
        return model;
    }
}
