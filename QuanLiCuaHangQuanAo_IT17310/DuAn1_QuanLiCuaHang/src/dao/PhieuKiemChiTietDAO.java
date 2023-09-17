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
import model.PhieuKiemChiTiet;

/**
 *
 * @author Administrator
 */
public class PhieuKiemChiTietDAO {
    
    /*
     * Insert phiếu kiểm chi tiết
     */
    public void themPKCT(PhieuKiemChiTiet model){
        String sql = "INSERT INTO PhieuKiemChiTiet(MaPhieuKiem, MaSanPham, DonGia, "
                + "DVT, TonKho, ThucTe, SoLuongLech, GiaTriLech) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcHelper.executeUpdate(sql, 
                                    model.getMaPhieuKiem(),
                                    model.getMaSanPham(),
                                    model.getDonGia(),
                                    model.getDVT(),
                                    model.getTonKho(),
                                    model.getThucTe(),
                                    model.getSoLuongLech(),
                                    model.getGiaTriLech());
    }
    
    /*
     * Cập nhật phiếu kiểm chi tiết
     */
    public void capnhatPKCT(PhieuKiemChiTiet model){
        String sql = "UPDATE PhieuKiemChiTiet SET "
                + "DonGia = ?, TonKho = ?, ThucTe = ?, "
                + "SoLuongLech = ?, GiaTriLech = ? "
                + "WHERE MaPKCT = ?";
        jdbcHelper.executeUpdate(sql, 
                                    model.getDonGia(),
                                    model.getTonKho(),
                                    model.getThucTe(),
                                    model.getSoLuongLech(),
                                    model.getGiaTriLech(),
                                    model.getMaPKCT());
    }
    
    /*
     * Tìm danh sách phiếu kiểm chi tiết theo mã phiếu kiểm
     */
    public List<PhieuKiemChiTiet> timDanhSachPKCT(String MaPhieuKiem){
        String sql = "SELECT * FROM PhieuKiemChiTiet WHERE MaPhieuKiem = ?";
        return select(sql, MaPhieuKiem);
    }
 
    private List<PhieuKiemChiTiet> select(String sql, Object... args) {
        List<PhieuKiemChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    PhieuKiemChiTiet model = readFromResultSet(rs);
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

    private PhieuKiemChiTiet readFromResultSet(ResultSet rs) throws SQLException {
        PhieuKiemChiTiet model = new PhieuKiemChiTiet();
        model.setMaPKCT(rs.getInt("MaPKCT"));
        model.setMaPhieuKiem(rs.getString("MaPhieuKiem"));
        model.setMaSanPham(rs.getString("MaSanPham"));
        model.setDonGia(rs.getFloat("DonGia"));
        model.setDVT(rs.getString("DVT"));
        model.setTonKho(rs.getInt("TonKho"));
        model.setThucTe(rs.getInt("ThucTe"));
        model.setSoLuongLech(rs.getInt("SoLuongLech"));
        model.setGiaTriLech(rs.getDouble("GiaTriLech"));
        return model;
    }
    
}
