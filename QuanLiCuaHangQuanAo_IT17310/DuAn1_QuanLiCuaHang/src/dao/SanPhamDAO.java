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
import java.util.Date;
import java.util.List;
import model.SanPham;

/**
 *
 * @author Administrator
 */
public class SanPhamDAO {
    
    /*
     * Hàm lọc sản phẩm để bán
           - trạng thái: đang kinh doanh
           - tồn kho: > 0
     */
    public List<SanPham> locSanPhamDangBan() {
        String sql = "SELECT * FROM SanPham WHERE TrangThai = 1 AND TonKho > 0";
        return select(sql);
    }
    
    
    /*
     * Hàm lọc sp đã hết HSD
     */
    public List<SanPham> locHetHSD(String MaNH, boolean TrangThai) {
        String sql = "SELECT * FROM SanPham WHERE HSDTruoc < getdate()";
        if (!MaNH.equalsIgnoreCase("0"))
            sql += " AND MaNhomHang = '" + MaNH + "'";
        if (!TrangThai)
            sql += " AND TrangThai = 0";
        sql += " ORDER BY CAST(RIGHT(MaSanPham,LEN(MaSanPham)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm lọc HSD 3 ngày tới
     */
    public List<SanPham> locHSD3NgayToi(String MaNH, boolean TrangThai) {
        String sql = "SELECT * FROM SanPham WHERE HSDTruoc <= (getdate()+3) "
                + "AND HSDTruoc >= getdate()";
        if (!MaNH.equalsIgnoreCase("0"))
            sql += " AND MaNhomHang = '" + MaNH + "'";
        if (!TrangThai)
            sql += " AND TrangThai = 0";
        sql += " ORDER BY CAST(RIGHT(MaSanPham,LEN(MaSanPham)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm lọc HSD 7 ngày tới
     */
    public List<SanPham> locHSD7NgayToi(String MaNH, boolean TrangThai) {
        String sql = "SELECT * FROM SanPham WHERE HSDTruoc <= (getdate()+7) "
                + "AND HSDTruoc >= getdate()";
        if (!MaNH.equalsIgnoreCase("0"))
            sql += " AND MaNhomHang = '" + MaNH + "'";
        if (!TrangThai)
            sql += " AND TrangThai = 0";
        sql += " ORDER BY CAST(RIGHT(MaSanPham,LEN(MaSanPham)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm lọc sp hết HSD trong tháng này
     */
    public List<SanPham> locHSDThangNay(String MaNH, boolean TrangThai) {
        String sql = "SELECT * FROM SanPham WHERE "
                + "YEAR(HSDTruoc) = YEAR(getdate()) "
                + "AND MONTH(HSDTruoc) = MONTH(getdate()) "
                + "AND HSDTruoc >= getdate()";
        if (!MaNH.equalsIgnoreCase("0"))
            sql += " AND MaNhomHang = '" + MaNH + "'";
        if (!TrangThai)
            sql += " AND TrangThai = 0";
        sql += " ORDER BY CAST(RIGHT(MaSanPham,LEN(MaSanPham)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm lọc sp hết HSD trong tháng tới
     */
    public List<SanPham> locHSDThangToi(String MaNH, boolean TrangThai) {
        String sql = "SELECT * FROM SanPham WHERE "
                + "YEAR(HSDTruoc) = YEAR(dateadd(MONTH, 1, getdate())) "
                + "AND MONTH(HSDTruoc) = MONTH(dateadd(MONTH, 1, getdate()))";
        if (!MaNH.equalsIgnoreCase("0"))
            sql += " AND MaNhomHang = '" + MaNH + "'";
        if (!TrangThai)
            sql += " AND TrangThai = 0";
        sql += " ORDER BY CAST(RIGHT(MaSanPham,LEN(MaSanPham)-2) AS int)";
        return select(sql);
    }
        
    /*
     * Hàm thêm mới SP
     */
    public int themSanPham(SanPham model) {
        String sql = "INSERT INTO SanPham(MaSanPham, TenSanPham, MaVach, MaNhomHang, "
                + "MaNCC, MaDVT, TonKho, DinhMucNhoNhat, DinhMucLonNhat, GiaVon, "
                + "GiaBan, HSDTruoc, HSDMoiNhat, HinhAnh, TrangThai) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcHelper.executeUpdate(sql,
                model.getMaSanPham(),
                model.getTenSanPham(),
                model.getMaVach(),
                model.getMaNhomHang(),
                model.getMaNCC(),
                model.getMaDVT(),
                model.getTonKho(),
                model.getDinhMucNhoNhat(),
                model.getDinhMucLonNhat(),
                model.getGiaVon(),
                model.getGiaBan(),
                model.getHSDTruoc(),
                model.getHSDMoiNhat(),
                model.getHinhAnh(),
                model.getTrangThai());
    }
    
    /*
     * Hàm cập nhật tồn kho sản phẩm
           - sử dụng kèm nghiệp vụ xuất - nhập - huỷ - kiểm kê
     */
    public int capnhatTonKho(String MaSP, int TonKho) {
        String sql = "UPDATE SanPham SET TonKho = ? WHERE MaSanPham = ?";
        return jdbcHelper.executeUpdate(sql, TonKho, MaSP);
    }
    
    /*
     * Hàm cập nhật giá vốn sản phẩm
           - sử dụng kèm nghiệp vụ xuất - nhập - huỷ - kiểm kê
     */
    public int capnhatGiaVon(String MaSP, float GiaVonMoi) {
        String sql = "UPDATE SanPham SET GiaVon = ? WHERE MaSanPham = ?";
        return jdbcHelper.executeUpdate(sql, GiaVonMoi, MaSP);
    }
    
    /*
     * Hàm cập nhật HSD Mới nhất cho sản phẩm
           - sử dụng kèm nghiệp vụ xuất - nhập - huỷ - kiểm kê
     */
    public int capnhatHSDMoi(String MaSP, Date HSDMoiNhat) {
        String sql = "UPDATE SanPham SET HSDMoiNhat = ? WHERE MaSanPham = ?";
        return jdbcHelper.executeUpdate(sql, HSDMoiNhat, MaSP);
    }
    
    /*
     * Hàm cập nhật thông tin San Pham
          - không cập nhật giá vốn (vì tính theo công thức riêng)
          - không cập nhật tồn kho (phụ thuộc nghiệp vụ nhập - xuất - kiểm kho)
     */
    public int capnhatSP(SanPham model) {
        String sql = "UPDATE SanPham SET "
                + "TenSanPham = ?, MaVach = ?, MaNhomHang = ?, "
                + "MaNCC = ?, MaDVT = ?, DinhMucNhoNhat = ?, "
                + "DinhMucLonNhat = ?, GiaBan = ?, HSDTruoc = ?, "
                + "HSDMoiNhat = ?, HinhAnh = ?, TrangThai = ? "
                + "WHERE MaSanPham = ?";
        return jdbcHelper.executeUpdate(sql,
                model.getTenSanPham(),
                model.getMaVach(),
                model.getMaNhomHang(),
                model.getMaNCC(),
                model.getMaDVT(),
                model.getDinhMucNhoNhat(),
                model.getDinhMucLonNhat(),
                model.getGiaBan(),
                model.getHSDTruoc(),
                model.getHSDMoiNhat(),
                model.getHinhAnh(),
                model.getTrangThai(),
                model.getMaSanPham());
    }
    
    /*
     * Hàm đếm tổng số sản phẩm
     */
    public int demSanPham() throws SQLException {
        int dem = 0;
        String sql = "SELECT COUNT(*) AS 'COUNT' FROM SanPham";
        ResultSet rs = jdbcHelper.executeQuery(sql);
        while (rs.next()) {
            dem = rs.getInt("COUNT");
        }
        return dem;
    }
    
    /*
     * Hàm chuyển trạng thái ngừng kinh doanh
     */
    public int ngungKinhDoanh(String MaSP) {
        String sql = "UPDATE SanPham SET TrangThai = 0 "
                + "WHERE MaSanPham = ?";
        return jdbcHelper.executeUpdate(sql, MaSP);
    }
    
    /*
     * Hàm tìm sản phẩm theo mã Nhà cung cấp
     */
    public List<SanPham> timTheoNCC(String MaNCC) {
        String sql = "SELECT * FROM SanPham WHERE MaNCC = ? "
                + "ORDER BY CAST(RIGHT(MaSanPham,LEN(MaSanPham)-2) AS int)";
        return select(sql, MaNCC);
    }
        
    /*
     * Hàm tìm sản phẩm theo mã SP hoặc tên SP
     */
    public List<SanPham> timTheoMaHoacTen(String ChuoiTimKiem) {
        String sql = "SELECT * FROM SanPham WHERE MaSanPham LIKE '" + ChuoiTimKiem + "' "
                + "OR TenSanPham LIKE N'%" + ChuoiTimKiem + "%' "
                + "ORDER BY CAST(RIGHT(MaSanPham,LEN(MaSanPham)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm lọc sản phẩm ngừng kinh doanh
     */
    public List<SanPham> locNgungKinhDoanh() {
        String sql = "SELECT * FROM SanPham WHERE TrangThai = 0 "
                + "ORDER BY CAST(RIGHT(MaSanPham,LEN(MaSanPham)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm lọc sản phẩm đang kinh doanh
     */
    public List<SanPham> locDangKinhDoanh() {
        String sql = "SELECT * FROM SanPham WHERE TrangThai = 1 "
                + "ORDER BY CAST(RIGHT(MaSanPham,LEN(MaSanPham)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm lọc sản phẩm hết hàng trong kho
     */
    public List<SanPham> locHetHang() {
        String sql = "SELECT * FROM SanPham WHERE TonKho = 0 "
                + "ORDER BY CAST(RIGHT(MaSanPham,LEN(MaSanPham)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm lọc sản phẩm còn hàng trong kho
     */
    public List<SanPham> locConHang() {
        String sql = "SELECT * FROM SanPham WHERE TonKho > 0 "
                + "ORDER BY CAST(RIGHT(MaSanPham,LEN(MaSanPham)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm lọc sản phẩm vượt định mức tồn kho
     */
    public List<SanPham> locVuotDinhMuc() {
        String sql = "SELECT * FROM SanPham WHERE TonKho > DinhMucLonNhat "
                + "ORDER BY CAST(RIGHT(MaSanPham,LEN(MaSanPham)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Hàm lọc sản phẩm dưới định mức tồn kho
     */
    public List<SanPham> locDuoiDinhMuc() {
        String sql = "SELECT * FROM SanPham WHERE TonKho < DinhMucNhoNhat "
                + "ORDER BY CAST(RIGHT(MaSanPham,LEN(MaSanPham)-2) AS int)";
        return select(sql);
    }
    
    public List<SanPham> select() {
        String sql = "SELECT * FROM SanPham "
                + "ORDER BY CAST(RIGHT(MaSanPham,LEN(MaSanPham)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Tìm kiếm sản phẩm chính xác theo Mã Vạch
     * Kêt quả trả về: 01 sản phẩm
     */
    public SanPham timTheoMaVach(String MaVach){
        String sql = "SELECT * FROM SanPham WHERE MaVach = ?";
        List<SanPham> list = select(sql, MaVach);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    /*
     * Tìm kiếm sản phẩm chính xác theo Mã SP
     * Kêt quả trả về: 01 sản phẩm
     */
    public SanPham timTheoMaSP(String MaSP){
        String sql = "SELECT * FROM SanPham WHERE MaSanPham = ?";
        List<SanPham> list = select(sql, MaSP);
        return list.size() > 0 ? list.get(0) : null;
    }
        
    /*
     * Tìm kiếm tên sản phẩm có điều kiện theo nhóm hàng
     * Kết quả trả về là list các sản phẩm (tìm kiếm tương đối)
     */
    public List<SanPham> timSanPhamTheoTen(String ChuoiTimKiem){
        String sql = "SELECT * FROM SanPham WHERE TenSanPham LIKE N'%" + ChuoiTimKiem + "%' "
                + "ORDER BY CAST(RIGHT(MaSanPham,LEN(MaSanPham)-2) AS int)";
        return select(sql);
    }
    
    /*
     * Lọc sản phẩm theo mã nhóm hàng
     * Kết quả trả về là list các sản phẩm trong nhóm hàng đó
     */
    public List<SanPham> timTheoMaNhom(String MaNhomHang){
        String sql = "SELECT * FROM SanPham WHERE MaNhomHang LIKE ? "
                + "ORDER BY CAST(RIGHT(MaSanPham,LEN(MaSanPham)-2) AS int)";
        return select(sql, MaNhomHang);
    }
    
    /*
     * Tìm kiếm tên sản phẩm có điều kiện theo nhóm hàng
     * Kết quả trả về là list các sản phẩm (tìm kiếm tương đối)
     */
    public List<SanPham> timKetHopNhomHang(String ChuoiTimKiem, String MaNhomHang){
        String sql = "SELECT * FROM SanPham WHERE TenSanPham LIKE N'%" + ChuoiTimKiem + "%' "
                + "AND MaNhomHang LIKE '" + MaNhomHang + "' "
                + "ORDER BY CAST(RIGHT(MaSanPham,LEN(MaSanPham)-2) AS int)";
        List<SanPham> list = select(sql);
        return list.size() > 0 ? list : null;
    }
    
    private List<SanPham> select(String sql, Object... args) {
        List<SanPham> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    SanPham model = readFromResultSet(rs);
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

    private SanPham readFromResultSet(ResultSet rs) throws SQLException {
        SanPham model = new SanPham();
        model.setMaSanPham(rs.getString("MaSanPham"));
        model.setTenSanPham(rs.getString("TenSanPham"));
        model.setMaVach(rs.getString("MaVach"));
        model.setMaNhomHang(rs.getString("MaNhomHang"));
        model.setMaNCC(rs.getString("MaNCC"));
        model.setMaDVT(rs.getInt("MaDVT"));
        model.setTonKho(rs.getInt("TonKho"));
        model.setDinhMucNhoNhat(rs.getInt("DinhMucNhoNhat"));
        model.setDinhMucLonNhat(rs.getInt("DinhMucLonNhat"));
        model.setGiaVon(rs.getFloat("GiaVon"));
        model.setGiaBan(rs.getFloat("GiaBan"));
        model.setHSDTruoc(rs.getDate("HSDTruoc"));
        model.setHSDMoiNhat(rs.getDate("HSDMoiNhat"));
        model.setHinhAnh(rs.getString("HinhAnh"));
        model.setTrangThai(rs.getBoolean("TrangThai"));
        return model;
    }
}
