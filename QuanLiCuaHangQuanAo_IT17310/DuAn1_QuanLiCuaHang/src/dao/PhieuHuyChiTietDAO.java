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
import model.PhieuHuyChiTiet;

/**
 *
 * @author Administrator
 */
public class PhieuHuyChiTietDAO {
    
    /*
     * Insert phiếu huỷ chi tiết
     */
    public void themPHCT(PhieuHuyChiTiet model){
        String sql = "INSERT INTO PhieuHuyChiTiet(MaPhieuHuy, MaSanPham, "
                + "DVT, SoLuong, GiaVon, ThanhTien) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        jdbcHelper.executeUpdate(sql, 
                                    model.getMaPhieuHuy(),
                                    model.getMaSanPham(),
                                    model.getDVT(),
                                    model.getSoLuong(),
                                    model.getGiaVon(),
                                    model.getThanhTien());
    }
    
    /*
     * Tìm danh sách phiếu huỷ chi tiết theo mã phiếu huỷ
     */
    public List<PhieuHuyChiTiet> timDanhSachPHCT(String MaPhieuHuy){
        String sql = "SELECT * FROM PhieuHuyChiTiet WHERE MaPhieuHuy = ?";
        return select(sql, MaPhieuHuy);
    }
    
    private List<PhieuHuyChiTiet> select(String sql, Object... args) {
        List<PhieuHuyChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    PhieuHuyChiTiet model = readFromResultSet(rs);
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

    private PhieuHuyChiTiet readFromResultSet(ResultSet rs) throws SQLException {
        PhieuHuyChiTiet model = new PhieuHuyChiTiet();
        model.setMaPHCT(rs.getInt("MaPHCT"));
        model.setMaPhieuHuy(rs.getString("MaPhieuHuy"));
        model.setMaSanPham(rs.getString("MaSanPham"));
        model.setDVT(rs.getString("DVT"));
        model.setSoLuong(rs.getInt("SoLuong"));
        model.setGiaVon(rs.getFloat("GiaVon"));
        model.setThanhTien(rs.getFloat("ThanhTien"));
        return model;
    }
    
}
