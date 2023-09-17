/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import helper.jdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.NhaCungCap;

/**
 *
 * @author Administrator
 */
public class NhaCungCapDAO {
    
    /*
     * Hàm tìm NCC theo mã (tìm tuyệt đối)
     */
    public NhaCungCap timTheoMa(String MaNCC) {
        String sql = "SELECT * FROM NhaCungCap WHERE MaNCC = ?";
        List<NhaCungCap> list = select(sql, MaNCC);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    /*
     * Hàm tìm NCC theo SDT
           - false nếu tồn tại
           - true nếu không tồn tại
     */
    public boolean kiemSDT(String SDT){
        String sql = "SELECT * FROM NhaCungCap WHERE DienThoai = ?";
        List<NhaCungCap> list = select(sql, SDT);
        return list.size() < 1;
    }
    
    /*
     * Hàm tìm NhaCungCap theo Email
           - false nếu tồn tại
           - true nếu không tồn tại
     */
    public boolean kiemEmail(String Email){
        String ChuoiDaXuLy = Email.substring(0, Email.indexOf("@"));
        String sql = "SELECT * FROM NhaCungCap WHERE Email LIKE ?";
        List<NhaCungCap> list = select(sql, ChuoiDaXuLy + "%");
        if(list.size() < 1)
            return true;
        else
            return false;
    }
    
    /*
     * Hàm thêm mới NCC
     */
    public int themNCC(NhaCungCap model) {
        String sql = "INSERT INTO NhaCungCap(MaNCC, TenNCC, DienThoai, "
                + "Email, DiaChi, GhiChu, TrangThai) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcHelper.executeUpdate(sql,
                model.getMaNCC(),
                model.getTenNCC(),
                model.getDienThoai(),
                model.getEmail(),
                model.getDiaChi(),
                model.getGhiChu(),
                model.getTrangThai());
    }
    
    /*
     * Hàm cập nhật thông tin NCC
     */
    public int capnhatNCC(NhaCungCap model) {
        String sql = "UPDATE NhaCungCap SET "
                + "TenNCC = ?,DienThoai = ?, Email = ?, "
                + "DiaChi = ?, GhiChu = ?, TrangThai = ? "
                + "WHERE MaNCC = ?";
        return jdbcHelper.executeUpdate(sql,
                model.getTenNCC(),
                model.getDienThoai(),
                model.getEmail(),
                model.getDiaChi(),
                model.getGhiChu(),
                model.getTrangThai(),
                model.getMaNCC());
    }

    /*
     * Hàm đếm tổng số NCC
     */
    public int tongNCC() throws SQLException{
        int dem = 0;
        String sql = "SELECT COUNT(*) AS 'COUNT' FROM NhaCungCap";
        ResultSet rs = jdbcHelper.executeQuery(sql);
        while(rs.next()){
            dem = rs.getInt(1);
        }
        return dem;
    }
    
    /*
     * Hàm cập nhật trạng thái ngưng giao dịch theo mã ncc
     */
    public int ngungGiaoDich(String MaNCC) {
        String sql = "UPDATE NhaCungCap SET TrangThai = 0 WHERE MaNCC = ?";
        return jdbcHelper.executeUpdate(sql, MaNCC);
    }
    
    /*
     * Hàm lọc NCC theo trạng thái
          TrangThai: 0 - ngưng || 1 - hoạt động
     */
    public List<NhaCungCap> locTheoTrangThai(int TrangThai) {
        String sql = "SELECT * FROM NhaCungCap WHERE TrangThai = ? "
                    + "ORDER BY CAST(RIGHT(MaNCC,LEN(MaNCC)-3) AS int)";
        return select(sql, TrangThai);
    }
    
    /*
     * Hàm tìm kiếm NCC theo mã kh, tên, sdt
     */
    public List<NhaCungCap> timTheoMaTenSDT(String ChuoiTimKiem) {
        String sql = "SELECT * FROM NhaCungCap WHERE MaNCC LIKE N'%" + ChuoiTimKiem + "%' "
                + "OR TenNCC LIKE N'%" + ChuoiTimKiem + "%' "
                + "OR DienThoai LIKE '%" + ChuoiTimKiem + "%' "
                + "ORDER BY CAST(RIGHT(MaNCC,LEN(MaNCC)-3) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm tính tổng tiền nhập hàng theo Mã NCC
     */
    public double tongTienNhap(String MaNCC) throws SQLException {
        double TongNhap = 0;
        String sql = "SELECT SUM(ThanhTien) AS 'TongTien' FROM PhieuNhapHang "
                + "WHERE MaNCC = ? "
                + "GROUP BY MaNCC";
        ResultSet rs = jdbcHelper.executeQuery(sql, MaNCC);
        while(rs.next()){
            TongNhap = rs.getDouble("TongTien");
        }
        return TongNhap;
    }
    
    /*
     * Hàm tính tổng tiền trả hàng theo Mã NCC
     */
    public double tongTienTra(String MaNCC) throws SQLException {
        double TongTra = 0;
        String sql = "SELECT SUM(ThanhTien) AS 'TongTien' FROM PhieuTraHang "
                + "WHERE MaNCC = ? "
                + "GROUP BY MaNCC";
        ResultSet rs = jdbcHelper.executeQuery(sql, MaNCC);
        while(rs.next()){
            TongTra = rs.getDouble("TongTien");
        }
        return TongTra;
    }
    
    public List<NhaCungCap> select() {
        String sql = "SELECT * FROM NhaCungCap " 
                + "ORDER BY CAST(RIGHT(MaNCC,LEN(MaNCC)-3) AS int)";
        return select(sql);
    }
    
    private List<NhaCungCap> select(String sql, Object... args) {
        List<NhaCungCap> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    NhaCungCap model = readFromResultSet(rs);
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

    private NhaCungCap readFromResultSet(ResultSet rs) throws SQLException {
        NhaCungCap model = new NhaCungCap();
        model.setMaNCC(rs.getString("MaNCC"));
        model.setTenNCC(rs.getString("TenNCC"));
        model.setDienThoai(rs.getString("DienThoai"));
        model.setEmail(rs.getString("Email"));
        model.setDiaChi(rs.getString("DiaChi"));
        model.setGhiChu(rs.getString("GhiChu"));
        model.setTrangThai(rs.getBoolean("TrangThai"));
        return model;
    }
}
