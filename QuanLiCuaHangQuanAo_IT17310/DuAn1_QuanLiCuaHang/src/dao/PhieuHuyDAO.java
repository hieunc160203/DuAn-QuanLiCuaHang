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
import model.PhieuHuyHang;

/**
 *
 * @author Administrator
 */
public class PhieuHuyDAO {
    
    /*
     * Hàm thêm phiếu huỷ
     */
    public int themPhieuHuy(PhieuHuyHang model) {
        String sql = "INSERT INTO PhieuHuyHang(MaPhieuHuy, LoaiPhieuHuy, MaNhanVien, "
                + "NgayHuy, SoLuongHuy, GiaTriHuy, GhiChu) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcHelper.executeUpdate(sql, 
                model.getMaPhieuHuy(),
                model.getLoaiPhieuHuy(),
                model.getMaNhanVien(),
                model.getNgayHuy(),
                model.getSoLuongHuy(),
                model.getGiaTriHuy(),
                model.getGhiChu()
                );
    }
    
    /*
     * Hàm tìm phiếu theo loại phiếu
     */
    public List<PhieuHuyHang> timTheoLoaiPhieu(String LoaiPhieuHuy) {
        char x[] = LoaiPhieuHuy.toCharArray();
        String LoaiPhieu = "";
        for(int i = 0; i < x.length; i++){
            if (i != x.length - 1)
                LoaiPhieu += x[i] + ",";
            else
                LoaiPhieu += x[i];
        }
        String sql = "SELECT * FROM PhieuHuyHang "
                + "WHERE LoaiPhieuHuy IN (" + LoaiPhieu + ") "
                + "ORDER BY CAST(RIGHT(MaPhieuHuy,LEN(MaPhieuHuy)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm tìm phiếu huỷ theo ngày tuỳ chọn
     */
    public List<PhieuHuyHang> timTheoKhoangNgay(String LoaiPhieuKiem, String TuNgay, String DenNgay) {
        char x[] = LoaiPhieuKiem.toCharArray();
        String LoaiPhieu = "";
        for(int i = 0; i < x.length; i++){
            if (i != x.length - 1)
                LoaiPhieu += x[i] + ",";
            else
                LoaiPhieu += x[i];
        }
        String sql = "SELECT * FROM PhieuHuyHang "
                + "WHERE LoaiPhieuHuy IN (" + LoaiPhieu + ") "
                + "AND NgayHuy >= '" + TuNgay + "' "
                + "AND NgayHuy <= '" + DenNgay + "' "
                + "ORDER BY CAST(RIGHT(MaPhieuHuy,LEN(MaPhieuHuy)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm tìm phiếu tạo trong 7 ngày trước (không tính hôm nay)
     */
    public List<PhieuHuyHang> tim7NgayTruoc(String LoaiPhieuHuy) {
        char x[] = LoaiPhieuHuy.toCharArray();
        String LoaiPhieu = "";
        for(int i = 0; i < x.length; i++){
            if (i != x.length - 1)
                LoaiPhieu += x[i] + ",";
            else
                LoaiPhieu += x[i];
        }
        String sql = "SELECT * FROM PhieuHuyHang "
                + "WHERE LoaiPhieuHuy IN (" + LoaiPhieu + ") "
                + "AND NgayHuy < FORMAT(getdate(),'yyyy-MM-dd') "
                + "AND NgayHuy >= FORMAT(getdate()-7,'yyyy-MM-dd')"
                + "ORDER BY CAST(RIGHT(MaPhieuHuy,LEN(MaPhieuHuy)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm tìm phiếu tạo hôm qua
     */
    public List<PhieuHuyHang> timNgayHomQua(String LoaiPhieuHuy) {
        char x[] = LoaiPhieuHuy.toCharArray();
        String LoaiPhieu = "";
        for(int i = 0; i < x.length; i++){
            if (i != x.length - 1)
                LoaiPhieu += x[i] + ",";
            else
                LoaiPhieu += x[i];
        }
        String sql = "SELECT * FROM PhieuHuyHang "
                + "WHERE LoaiPhieuHuy IN (" + LoaiPhieu + ") "
                    + "AND NgayHuy = FORMAT(getdate()-1,'yyyy-MM-dd') "
                + "ORDER BY CAST(RIGHT(MaPhieuHuy,LEN(MaPhieuHuy)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm tìm phiếu tạo trong ngày
     */
    public List<PhieuHuyHang> timTrongNgay(String LoaiPhieuHuy) {
        char x[] = LoaiPhieuHuy.toCharArray();
        String LoaiPhieu = "";
        for(int i = 0; i < x.length; i++){
            if (i != x.length - 1)
                LoaiPhieu += x[i] + ",";
            else
                LoaiPhieu += x[i];
        }
        String sql = "SELECT * FROM PhieuHuyHang "
                + "WHERE LoaiPhieuHuy IN (" + LoaiPhieu + ") "
                    + "AND NgayHuy = FORMAT(getdate(),'yyyy-MM-dd') "
                + "ORDER BY CAST(RIGHT(MaPhieuHuy,LEN(MaPhieuHuy)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm tìm theo mã sản phẩm hoặc tên sản phẩm
     */
    public List<PhieuHuyHang> timTheoSanPham(String ChuoiTimKiem) {
        String sql = "SELECT * FROM PhieuHuyHang PH "
                + "WHERE EXISTS "
                    + "(SELECT MaPhieuHuy FROM PhieuHuyChiTiet PHCT "
                        + "WHERE PHCT.MaPhieuHuy = PH.MaPhieuHuy "
                        + "AND EXISTS "
                            + "(SELECT MaSanPham FROM SanPham SP "
                            + "WHERE PHCT.MaSanPham = SP.MaSanPham "
                            + "AND (MaSanPham = '" + ChuoiTimKiem +"' OR TenSanPham LIKE N'%" + ChuoiTimKiem + "%'))) "
                + "ORDER BY CAST(RIGHT(MaPhieuHuy,LEN(MaPhieuHuy)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm tìm theo mã chứng từ
     */
    public PhieuHuyHang timTheoMa(String MaChungTu){
        String sql = "SELECT * FROM PhieuHuyHang WHERE MaPhieuHuy = ?";
        List<PhieuHuyHang> list = select(sql, MaChungTu);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    /*
     * Hàm đếm tổng số phiếu huỷ
     */
    public int demTongPhieu() throws SQLException {
        int dem = 0;
        String sql = "SELECT COUNT(*) AS 'COUNT' FROM PhieuHuyHang";
        ResultSet rs = jdbcHelper.executeQuery(sql);
        while(rs.next())
            dem = rs.getInt("COUNT");
        return dem;
    }
    
    /*
     * Hàm tìm tất cả phiếu huỷ
     */
    public List<PhieuHuyHang> select(){
        String sql = "SELECT * FROM PhieuHuyHang " 
                + "ORDER BY CAST(RIGHT(MaPhieuHuy,LEN(MaPhieuHuy)-2) AS int)";
        return select(sql);
    }
    
    private List<PhieuHuyHang> select(String sql, Object... args) {
        List<PhieuHuyHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    PhieuHuyHang model = readFromResultSet(rs);
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

    private PhieuHuyHang readFromResultSet(ResultSet rs) throws SQLException {
        PhieuHuyHang model = new PhieuHuyHang();
        model.setMaPhieuHuy(rs.getString("MaPhieuHuy"));
        model.setLoaiPhieuHuy(rs.getInt("LoaiPhieuHuy"));
        model.setMaNhanVien(rs.getString("MaNhanVien"));
        model.setNgayHuy(rs.getDate("NgayHuy"));
        model.setSoLuongHuy(rs.getInt("SoLuongHuy"));
        model.setGiaTriHuy(rs.getFloat("GiaTriHuy"));
        model.setGhiChu(rs.getString("GhiChu"));
        return model;
    }
    
}
