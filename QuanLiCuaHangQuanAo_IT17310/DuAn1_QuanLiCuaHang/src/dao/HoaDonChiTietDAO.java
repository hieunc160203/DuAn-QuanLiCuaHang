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
import model.HoaDonChiTiet;

/**
 *
 * @author Administrator
 */
public class HoaDonChiTietDAO {

    /*
     * Insert Hoá đơn chi tiết
     */
    public void themHDCT(HoaDonChiTiet model){
        String sql = "INSERT INTO HoaDonChiTiet(MaHoaDon, MaSanPham, DonGia, "
                + "SoLuong, ThanhTien) "
                + "VALUES (?, ?, ?, ?, ?)";
        jdbcHelper.executeUpdate(sql, 
                                    model.getMaHoaDon(),
                                    model.getMaSanPham(),
                                    model.getDonGia(),
                                    model.getSoLuong(),
                                    model.getThanhTien());
    }
    
    /*
     * Tìm danh sách hoá đơn chi tiết theo mã hoá đơn
     */
    public List<HoaDonChiTiet> timDanhSachHDCT(String MaHoaDon){
        String sql = "SELECT * FROM HoaDonChiTiet WHERE MaHoaDon = ?";
        return select(sql, MaHoaDon);
    }
    
    private List<HoaDonChiTiet> select(String sql, Object... args) {
        List<HoaDonChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    HoaDonChiTiet model = readFromResultSet(rs);
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

    private HoaDonChiTiet readFromResultSet(ResultSet rs) throws SQLException {
        HoaDonChiTiet model = new HoaDonChiTiet();
        model.setMaHDCT(rs.getInt("MaHDCT"));
        model.setMaHoaDon(rs.getString("MaHoaDon"));
        model.setMaSanPham(rs.getString("MaSanPham"));
        model.setDonGia(rs.getFloat("DonGia"));
        model.setSoLuong(rs.getInt("SoLuong"));
        model.setThanhTien(rs.getFloat("ThanhTien"));
        return model;
    }
}
