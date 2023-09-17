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
import model.DonViTinh;

/**
 *
 * @author Administrator
 */
public class DonViTinhDAO {
    
    /*
     * Hàm tìm đơn vị tính theo mã
     */
    public DonViTinh timTheoMa(int MaDVT) {
        String sql = "SELECT * FROM DonViTinh WHERE MaDVT = ?";
        List<DonViTinh> list = select(sql, MaDVT);
        return list.size() > 0 ? list.get(0) : null;
    }    
    
    public List<DonViTinh> select() {
        String sql = "SELECT * FROM DonViTinh";
        return select(sql);
    }    
    
    private List<DonViTinh> select(String sql, Object... args) {
        List<DonViTinh> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    DonViTinh model = readFromResultSet(rs);
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

    private DonViTinh readFromResultSet(ResultSet rs) throws SQLException {
        DonViTinh model = new DonViTinh();
        model.setMaDVT(rs.getInt("MaDVT"));
        model.setMoTa(rs.getString("MoTa"));
        return model;
    }
    
}
