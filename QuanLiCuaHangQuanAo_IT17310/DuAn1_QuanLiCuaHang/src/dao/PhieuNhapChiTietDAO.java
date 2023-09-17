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
import model.PhieuNhapChiTiet;

/**
 *
 * @author Administrator
 */
public class PhieuNhapChiTietDAO {
    
    /*
     * Insert phiếu nhập chi tiết
     */
    public void themPNCT(PhieuNhapChiTiet model){
        String sql = "INSERT INTO PhieuNhapChiTiet(MaPhieuNhap, MaSanPham, SoLuong, "
                + "GiaNhap, ThanhTien, HSDMoiNhat) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        jdbcHelper.executeUpdate(sql, 
                                    model.getMaPhieuNhap(),
                                    model.getMaSanPham(),
                                    model.getSoLuong(),
                                    model.getGiaNhap(),
                                    model.getThanhTien(),
                                    model.getHSDMoiNhat());
    }
    
    /*
     * Tìm danh sách phiếu nhập chi tiết theo mã phiếu nhập
     */
    public List<PhieuNhapChiTiet> timDanhSachPNCT(String MaPhieuNhap){
        String sql = "SELECT * FROM PhieuNhapChiTiet WHERE MaPhieuNhap = ?";
        return select(sql, MaPhieuNhap);
    }
 
    private List<PhieuNhapChiTiet> select(String sql, Object... args) {
        List<PhieuNhapChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    PhieuNhapChiTiet model = readFromResultSet(rs);
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

    private PhieuNhapChiTiet readFromResultSet(ResultSet rs) throws SQLException {
        PhieuNhapChiTiet model = new PhieuNhapChiTiet();
        model.setMaPNCT(rs.getInt("MaPNCT"));
        model.setMaPhieuNhap(rs.getString("MaPhieuNhap"));
        model.setMaSanPham(rs.getString("MaSanPham"));
        model.setSoLuong(rs.getInt("SoLuong"));
        model.setGiaNhap(rs.getFloat("GiaNhap"));
        model.setThanhTien(rs.getDouble("ThanhTien"));
        model.setHSDMoiNhat(rs.getDate("HSDMoiNhat"));
        return model;
    }
    
}
