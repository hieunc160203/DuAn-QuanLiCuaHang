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
import model.PhieuNhap;

/**
 *
 * @author Administrator
 */
public class PhieuNhapDAO {
    
    /*
     * Hàm cập nhật phiếu nhập hàng
         chỉ được cập nhật ghi chú
     */
    public int capnhatPhieuNhap(PhieuNhap model) {
        String sql = "UPDATE PhieuNhapHang SET GhiChu = ? "
                + "WHERE MaPhieuNhap = ?";
        return jdbcHelper.executeUpdate(sql, 
                model.getGhiChu(),
                model.getMaPhieuNhap());
    }
    
    /*
     * Hàm thêm phiếu nhập
     */
    public int themPhieuNhap(PhieuNhap model) {
        String sql = "INSERT INTO PhieuNhapHang(MaPhieuNhap, MaNhanVien, NgayNhap, "
                + "MaNCC, TongSoLuong, ChietKhau, VAT, ThanhTien, GhiChu) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcHelper.executeUpdate(sql, 
                model.getMaPhieuNhap(),
                model.getMaNhanVien(),
                model.getNgayNhap(),
                model.getMaNCC(),
                model.getTongSoLuong(),
                model.getChietKhau(),
                model.getVAT(),
                model.getThanhTien(),
                model.getGhiChu());
    }
    
    /*
     * Hàm đếm tổng số phiếu nhập
     */
    public int demPhieuNhap() throws SQLException {
        int dem = 0;
        String sql = "SELECT COUNT(*) AS 'COUNT' FROM PhieuNhapHang";
        ResultSet rs = jdbcHelper.executeQuery(sql);
        while (rs.next())
            dem = rs.getInt("COUNT");
        return dem;
    }
    
    /*
     * Hàm tìm phiếu nhập theo ngày tuỳ chọn
     */
    public List<PhieuNhap> timTheoKhoangNgay(String TuNgay, String DenNgay) {
        String sql = "SELECT * FROM PhieuNhapHang "
                + "WHERE NgayNhap >= '" + TuNgay + "' "
                + "AND NgayNhap <= '" + DenNgay + "' "
                + "ORDER BY CAST(RIGHT(MaPhieuNhap, LEN(MaPhieuNhap)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm tìm phiếu nhập trong 7 ngày trước (không tính hôm nay)
     */
    public List<PhieuNhap> tim7NgayTruoc() {
        String sql = "SELECT * FROM PhieuNhapHang "
                + "WHERE NgayNhap < FORMAT(getdate(),'yyyy-MM-dd') "
                + "AND NgayNhap >= FORMAT(getdate()-7,'yyyy-MM-dd')"
                + "ORDER BY CAST(RIGHT(MaPhieuNhap, LEN(MaPhieuNhap)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm tìm phiếu nhập tạo hôm qua
     */
    public List<PhieuNhap> timNgayHomQua() {
        String sql = "SELECT * FROM PhieuNhapHang "
                + "WHERE NgayNhap = FORMAT(getdate()-1,'yyyy-MM-dd') "
                + "ORDER BY CAST(RIGHT(MaPhieuNhap, LEN(MaPhieuNhap)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm tìm phiếu nhập tạo trong ngày
     */
    public List<PhieuNhap> timTrongNgay() {
        String sql = "SELECT * FROM PhieuNhapHang "
                + "WHERE NgayNhap = FORMAT(getdate(),'yyyy-MM-dd') "
                + "ORDER BY CAST(RIGHT(MaPhieuNhap, LEN(MaPhieuNhap)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm tìm theo mã sản phẩm hoặc tên sản phẩm
     */
    public List<PhieuNhap> timTheoSanPham(String ChuoiTimKiem) {
        String sql = "SELECT * FROM PhieuNhapHang PN "
                + "WHERE EXISTS "
                    + "(SELECT MaPhieuNhap FROM PhieuNhapChiTiet PNCT "
                        + "WHERE PNCT.MaPhieuNhap = PN.MaPhieuNhap "
                        + "AND EXISTS "
                            + "(SELECT MaSanPham FROM SanPham SP "
                            + "WHERE PNCT.MaSanPham = SP.MaSanPham "
                            + "AND (MaSanPham = '" + ChuoiTimKiem +"' OR TenSanPham LIKE N'%" + ChuoiTimKiem + "%'))) "
                + "ORDER BY CAST(RIGHT(MaPhieuNhap, LEN(MaPhieuNhap)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm tìm theo mã NCC
     */
    public List<PhieuNhap> timTheoMaNCC(String MaNCC){
        String sql = "SELECT * FROM PhieuNhapHang WHERE MaNCC = ?";
        return select(sql, MaNCC);
    }
    
    /*
     * Hàm tìm theo mã chứng từ
     */
    public PhieuNhap timTheoMa(String MaChungTu){
        String sql = "SELECT * FROM PhieuNhapHang WHERE MaPhieuNhap = ?";
        List<PhieuNhap> list = select(sql, MaChungTu);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    /*
     * Hàm tìm tất cả phiếu nhập
     */
    public List<PhieuNhap> select(){
        String sql = "SELECT * FROM PhieuNhapHang " 
                + "ORDER BY CAST(RIGHT(MaPhieuNhap, LEN(MaPhieuNhap)-2) AS int)";
        return select(sql);
    }
    
    private List<PhieuNhap> select(String sql, Object... args) {
        List<PhieuNhap> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    PhieuNhap model = readFromResultSet(rs);
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

    private PhieuNhap readFromResultSet(ResultSet rs) throws SQLException {
        PhieuNhap model = new PhieuNhap();
        model.setMaPhieuNhap(rs.getString("MaPhieuNhap"));
        model.setMaNhanVien(rs.getString("MaNhanVien"));
        model.setNgayNhap(rs.getDate("NgayNhap"));
        model.setMaNCC(rs.getString("MaNCC"));
        model.setTongSoLuong(rs.getInt("TongSoLuong"));
        model.setChietKhau(rs.getFloat("ChietKhau"));
        model.setVAT(rs.getFloat("VAT"));
        model.setThanhTien(rs.getDouble("ThanhTien"));
        model.setGhiChu(rs.getString("GhiChu"));
        return model;
    }
    
}