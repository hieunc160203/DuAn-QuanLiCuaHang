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
import model.NhomHang;

/**
 *
 * @author Administrator
 */
public class NhomHangDAO {
    
    public List<NhomHang> select() {
        String sql = "SELECT * FROM NhomHang";
        return select(sql);
    }
    
    /*
     * Tìm nhóm hàng theo mã nhóm hàng
     */
    public NhomHang timTheoMa(String MaNH){
        String sql = "SELECT * FROM NhomHang WHERE MaNhomHang = ?";
        List<NhomHang> list =  select(sql, MaNH);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    /*
     * Tìm mã nhóm hàng theo tên nhóm hàng
     */
    public NhomHang timMaNhom(String TenNhom){
        String sql = "SELECT * FROM NhomHang WHERE TenNhomHang = N'" + TenNhom + "'";
        List<NhomHang> list =  select(sql);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    private List<NhomHang> select(String sql, Object... args) {
        List<NhomHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    NhomHang model = readFromResultSet(rs);
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

    private NhomHang readFromResultSet(ResultSet rs) throws SQLException {
        NhomHang model = new NhomHang();
        model.setMaNhomHang(rs.getString("MaNhomHang"));
        model.setTenNhomHang(rs.getString("TenNhomHang"));
        model.setGhiChu(rs.getString("GhiChu"));
        return model;
    }
    
}
