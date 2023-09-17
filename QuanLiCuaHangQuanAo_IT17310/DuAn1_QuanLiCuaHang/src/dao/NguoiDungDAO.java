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
import model.NguoiDung;

/**
 *
 * @author Administrator
 */
public class NguoiDungDAO {
    
    /*
     * Hàm kiểm tra Email tồn tại hay chưa
          true: không tồn tại
          false: tồn tại
     */
    public boolean kiemEmail(String Email) {
        String sql = "SELECT * FROM NguoiDung WHERE Email = ?";
        List<NguoiDung> list = select(sql, Email);
        return list.size() < 1;
    }
    
    /*
     * Hàm kiểm tra SDT tồn tại hay chưa
          true: không tồn tại
          false: tồn tại
     */
    public boolean kiemSDT(String SDT) {
        String sql = "SELECT * FROM NguoiDung WHERE DienThoai = ?";
        List<NguoiDung> list = select(sql, SDT);
        return list.size() < 1;
    }
    
    /*
     * Hàm kiểm tra tên đăng nhập tồn tại hay chưa
          true: không tồn tại
          false: tồn tại
     */
    public boolean kiemTenDangNhap(String TenDangNhap) {
        String sql = "SELECT * FROM NguoiDung WHERE TenDangNhap = ?";
        List<NguoiDung> list = select(sql, TenDangNhap);
        return list.size() < 1;
    }
    
    /*
     * Hàm thêm mới NguoiDung
     */
    public int themNguoiDung(NguoiDung model) {
        String sql = "INSERT INTO NguoiDung(TenDangNhap, MatKhau, HoTen, DienThoai, "
                + "GioiTinh, NgaySinh, Email, DiaChi, VaiTro, TrangThai) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcHelper.executeUpdate(sql,
                model.getTenDangNhap(),
                model.getMatKhau(),
                model.getHoTen(),
                model.getDienThoai(),
                model.getGioiTinh(),
                model.getNgaySinh(),
                model.getEmail(),
                model.getDiaChi(),
                model.getVaiTro(),
                model.getTrangThai());
    }
    
    /*
     * Hàm lọc theo trạng thái
          TrangThai: 0 - ngưng || 1 - hoạt động
     */
    public List<NguoiDung> locTheoTrangThai(int TrangThai) {
        String sql = "SELECT * FROM NguoiDung WHERE TrangThai = ?";
        return select(sql, TrangThai);
    }
    
    /*
     * Hàm tìm kiếm NCC theo mã kh, tên, sdt
     */
    public List<NguoiDung> timTheoMaTenSDT(String ChuoiTimKiem) {
        String sql = "SELECT * FROM NguoiDung WHERE TenDangNhap LIKE N'%" + ChuoiTimKiem + "%' "
                + "OR HoTen LIKE N'%" + ChuoiTimKiem + "%' "
                + "OR DienThoai LIKE '%" + ChuoiTimKiem + "%'";
        return select(sql);
    }
    
    /*
     * Hàm tìm danh sách toàn bộ người dùng
     */
    public List<NguoiDung> select(){
        String sql = "SELECT * FROM NguoiDung";
        return select(sql);
    }
    
    /*
     * Hàm tìm kiếm người dùng theo Tên Đăng Nhập
     */
    public NguoiDung timTenDangNhap(String TenDangNhap){
        String sql = "SELECT * FROM NguoiDung WHERE TenDangNhap = ?";
        List<NguoiDung> list = select(sql, TenDangNhap);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    /*
     * Hàm cập nhật thông tin người dùng
     * @model - Model người dùng để get thông tin cập nhật
     * @check - tham số có đổi mật khẩu hay không: true có false không
     */
    public int capnhatNguoiDung(NguoiDung model, boolean check){
        boolean TuyChon = check; 
        int rs = 0;
        if(TuyChon){
            String sql = "UPDATE NguoiDung SET "
                + "MatKhau = ?, "
                + "HoTen = ?, DienThoai = ?, GioiTinh = ?, NgaySinh = ?, "
                + "Email = ?, DiaChi = ?, VaiTro = ?, TrangThai = ? "
                + "WHERE TenDangNhap = ?";
            return rs = jdbcHelper.executeUpdate(sql, 
                            model.getMatKhau(),
                            model.getHoTen(),
                            model.getDienThoai(),
                            model.getGioiTinh(),
                            model.getNgaySinh(),
                            model.getEmail(),
                            model.getDiaChi(),
                            model.getVaiTro(),
                            model.getTrangThai(),
                            model.getTenDangNhap());
        }
        else {
            String sql = "UPDATE NguoiDung SET "
                + "HoTen = ?, DienThoai = ?, GioiTinh = ?, NgaySinh = ?, "
                + "Email = ?, DiaChi = ?, VaiTro = ?, TrangThai = ? "
                + "WHERE TenDangNhap = ?";
            return rs = jdbcHelper.executeUpdate(sql, 
                            model.getHoTen(),
                            model.getDienThoai(),
                            model.getGioiTinh(),
                            model.getNgaySinh(),
                            model.getEmail(),
                            model.getDiaChi(),
                            model.getVaiTro(),
                            model.getTrangThai(),
                            model.getTenDangNhap());
        }
    }
    
    private List<NguoiDung> select(String sql, Object... args) {
        List<NguoiDung> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    NguoiDung model = readFromResultSet(rs);
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

    private NguoiDung readFromResultSet(ResultSet rs) throws SQLException {
        NguoiDung model = new NguoiDung();
        model.setTenDangNhap(rs.getString("TenDangNhap"));
        model.setMatKhau(rs.getString("MatKhau"));
        model.setHoTen(rs.getString("HoTen"));
        model.setDienThoai(rs.getString("DienThoai"));
        model.setGioiTinh(rs.getBoolean("GioiTinh"));
        model.setNgaySinh(rs.getDate("NgaySinh"));
        model.setEmail(rs.getString("Email"));
        model.setDiaChi(rs.getString("DiaChi"));
        model.setVaiTro(rs.getInt("VaiTro"));
        model.setTrangThai(rs.getBoolean("TrangThai"));
        return model;
    }
}
