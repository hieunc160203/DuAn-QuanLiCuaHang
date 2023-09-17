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
import model.PhieuKiem;

/**
 *
 * @author Administrator
 */
public class PhieuKiemDAO {
    
    /*
     * Hàm thêm phiếu đã cân bằng
     */
    public int themPhieuCanBang(PhieuKiem model) {
        String sql = "INSERT INTO PhieuKiemKe(MaPhieuKiemKe, MaNhanVien, NgayTao, NgayCanBang, "
                + "GiaTriLech, GhiChu, TrangThai) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcHelper.executeUpdate(sql, 
                model.getMaPhieuKiem(),
                model.getMaNhanVien(),
                model.getNgayTao(),
                model.getNgayCanBang(),
                model.getGiaTriLech(),
                model.getGhiChu(),
                1);
    }
    
    /*
     * Hàm thêm phiếu tạm
     */
    public int themPhieuTam(PhieuKiem model) {
        String sql = "INSERT INTO PhieuKiemKe(MaPhieuKiemKe, MaNhanVien, NgayTao, "
                + "GiaTriLech, GhiChu, TrangThai) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcHelper.executeUpdate(sql, 
                model.getMaPhieuKiem(),
                model.getMaNhanVien(),
                model.getNgayTao(),
                model.getGiaTriLech(),
                model.getGhiChu(),
                0);
    }
    
    /*
     * Hàm cập nhật phiếu kiểm
     */
    public int capnhatPhieuKiem(PhieuKiem model) {
        String sql = "{call sp_update_phieukiemke(?, ?, ?, ?)}";
        return jdbcHelper.executeUpdate(sql, 
                model.getGiaTriLech(),
                model.getGhiChu(),
                model.getTrangThai(),
                model.getMaPhieuKiem());
    }
    
    /*
     * Hàm huỷ phiếu kiểm
     */
    public int huyPhieuKiem(PhieuKiem model) {
        String sql = "UPDATE PhieuKiemKe SET TrangThai = 2, GhiChu = ? "
                + "WHERE MaPhieuKiemKe = ?";
        return jdbcHelper.executeUpdate(sql, 
                model.getGhiChu(), 
                model.getMaPhieuKiem());
    }
    
    /*
     * Hàm đếm tổng số phiếu kiểm
     */
    public int demPhieuKiem() throws SQLException {
        int dem = 0;
        String sql = "SELECT COUNT(*) AS 'COUNT' FROM PhieuKiemKe";
        ResultSet rs = jdbcHelper.executeQuery(sql);
        while (rs.next())
            dem = rs.getInt("COUNT");
        return dem;
    }
    
    /*
     * Hàm tìm phiếu kiểm theo trạng thái
     */
    public List<PhieuKiem> timTheoTrangThai(String ChuoiTrangThai) {
        char x[] = ChuoiTrangThai.toCharArray();
        String TrangThai = "";
        for(int i = 0; i < x.length; i++){
            if (i != x.length - 1)
                TrangThai += x[i] + ",";
            else
                TrangThai += x[i];
        }
        String sql = "SELECT * FROM PhieuKiemKe "
                + "WHERE TrangThai IN (" + TrangThai + ") "
                + "ORDER BY CAST(RIGHT(MaPhieuKiemKe,LEN(MaPhieuKiemKe)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm tìm phiếu kiểm theo ngày tuỳ chọn
     */
    public List<PhieuKiem> timTheoKhoangNgay(String ChuoiTrangThai, String TuNgay, String DenNgay) {
        char x[] = ChuoiTrangThai.toCharArray();
        String TrangThai = "";
        for(int i = 0; i < x.length; i++){
            if (i != x.length - 1)
                TrangThai += x[i] + ",";
            else
                TrangThai += x[i];
        }
        String sql = "SELECT * FROM PhieuKiemKe "
                + "WHERE TrangThai IN (" + TrangThai + ") "
                + "AND NgayTao >= '" + TuNgay + "' "
                + "AND NgayTao <= '" + DenNgay + "' "
                + "ORDER BY CAST(RIGHT(MaPhieuKiemKe,LEN(MaPhieuKiemKe)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm tìm phiếu kiểm trong 7 ngày trước (không tính hôm nay)
     */
    public List<PhieuKiem> tim7NgayTruoc(String ChuoiTrangThai) {
        char x[] = ChuoiTrangThai.toCharArray();
        String TrangThai = "";
        for(int i = 0; i < x.length; i++){
            if (i != x.length - 1)
                TrangThai += x[i] + ",";
            else
                TrangThai += x[i];
        }
        String sql = "SELECT * FROM PhieuKiemKe "
                + "WHERE TrangThai IN (" + TrangThai + ") "
                + "AND NgayTao < FORMAT(getdate(),'yyyy-MM-dd') "
                + "AND NgayTao >= FORMAT(getdate()-7,'yyyy-MM-dd')"
                + "ORDER BY CAST(RIGHT(MaPhieuKiemKe,LEN(MaPhieuKiemKe)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm tìm phiếu kiểm tạo hôm qua
     */
    public List<PhieuKiem> timNgayHomQua(String ChuoiTrangThai) {
        char x[] = ChuoiTrangThai.toCharArray();
        String TrangThai = "";
        for(int i = 0; i < x.length; i++){
            if (i != x.length - 1)
                TrangThai += x[i] + ",";
            else
                TrangThai += x[i];
        }
        String sql = "SELECT * FROM PhieuKiemKe "
                + "WHERE TrangThai IN (" + TrangThai + ") "
                    + "AND NgayTao = FORMAT(getdate()-1,'yyyy-MM-dd') "
                + "ORDER BY CAST(RIGHT(MaPhieuKiemKe,LEN(MaPhieuKiemKe)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm tìm phiếu kiểm tạo trong ngày
     */
    public List<PhieuKiem> timTrongNgay(String ChuoiTrangThai) {
        char x[] = ChuoiTrangThai.toCharArray();
        String TrangThai = "";
        for(int i = 0; i < x.length; i++){
            if (i != x.length - 1)
                TrangThai += x[i] + ",";
            else
                TrangThai += x[i];
        }
        String sql = "SELECT * FROM PhieuKiemKe "
                + "WHERE TrangThai IN (" + TrangThai + ") "
                    + "AND NgayTao = FORMAT(getdate(),'yyyy-MM-dd') "
                + "ORDER BY CAST(RIGHT(MaPhieuKiemKe,LEN(MaPhieuKiemKe)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm tìm theo mã sản phẩm hoặc tên sản phẩm
     */
    public List<PhieuKiem> timTheoSanPham(String ChuoiTimKiem) {
        String sql = "SELECT * FROM PhieuKiemKe PK "
                + "WHERE EXISTS "
                    + "(SELECT MaPhieuKiem FROM PhieuKiemChiTiet PKCT "
                        + "WHERE PKCT.MaPhieuKiem = PK.MaPhieuKiemKe "
                        + "AND EXISTS "
                            + "(SELECT MaSanPham FROM SanPham SP "
                            + "WHERE PKCT.MaSanPham = SP.MaSanPham "
                            + "AND (MaSanPham = '" + ChuoiTimKiem +"' OR TenSanPham LIKE N'%" + ChuoiTimKiem + "%'))) "
                + "ORDER BY CAST(RIGHT(MaPhieuKiemKe,LEN(MaPhieuKiemKe)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm tìm theo mã chứng từ
     */
    public PhieuKiem timTheoMa(String MaChungTu){
        String sql = "SELECT * FROM PhieuKiemKe WHERE MaPhieuKiemKe = ?";
        List<PhieuKiem> list = select(sql, MaChungTu);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    /*
     * Hàm tìm tất cả phiếu kiểm
     */
    public List<PhieuKiem> select(){
        String sql = "SELECT * FROM PhieuKiemKe " 
                + "ORDER BY CAST(RIGHT(MaPhieuKiemKe,LEN(MaPhieuKiemKe)-2) AS int)";
        return select(sql);
    }
    
    private List<PhieuKiem> select(String sql, Object... args) {
        List<PhieuKiem> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    PhieuKiem model = readFromResultSet(rs);
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

    private PhieuKiem readFromResultSet(ResultSet rs) throws SQLException {
        PhieuKiem model = new PhieuKiem();
        model.setMaPhieuKiem(rs.getString("MaPhieuKiemKe"));
        model.setMaNhanVien(rs.getString("MaNhanVien"));
        model.setNgayTao(rs.getDate("NgayTao"));
        model.setNgayCanBang(rs.getDate("NgayCanBang"));
        model.setGiaTriLech(rs.getDouble("GiaTriLech"));
        model.setGhiChu(rs.getString("GhiChu"));
        model.setTrangThai(rs.getInt("TrangThai"));
        return model;
    }
    
}