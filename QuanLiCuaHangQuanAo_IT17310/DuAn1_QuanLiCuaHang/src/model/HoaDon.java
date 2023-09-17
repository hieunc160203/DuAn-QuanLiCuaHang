/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.TreeMap;

/**
 *
 * @author Administrator
 */
public class HoaDon {
    
    private String MaHoaDon;
    private String MaKhachHang;
    private String MaNhanVien;
    private Date NgayBan;
    private int TongSoLuong;
    private float ChietKhau;
    private float VAT;
    private float ThanhTien;
    private float TienKhachTra;
    private TreeMap<SanPham,Integer> DSSP;
    
    public HoaDon(){
        this.DSSP = new TreeMap<>();
        this.ChietKhau = 0;
    }

    public HoaDon(String MaHoaDon, String MaKhachHang, String MaNhanVien, Date NgayBan, int TongSoLuong, float ChietKhau, float VAT, float ThanhTien, float TienKhachTra, TreeMap<SanPham,Integer> DSSP) {
        this.MaHoaDon = MaHoaDon;
        this.MaKhachHang = MaKhachHang;
        this.MaNhanVien = MaNhanVien;
        this.NgayBan = NgayBan;
        this.TongSoLuong = TongSoLuong;
        this.ChietKhau = ChietKhau;
        this.VAT = VAT;
        this.ThanhTien = ThanhTien;
        this.TienKhachTra = TienKhachTra;
        this.DSSP = DSSP;
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public String getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(String MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public Date getNgayBan() {
        return NgayBan;
    }

    public void setNgayBan(Date NgayBan) {
        this.NgayBan = NgayBan;
    }

    public int getTongSoLuong() {
        return TongSoLuong;
    }

    public void setTongSoLuong(int TongSoLuong) {
        this.TongSoLuong = TongSoLuong;
    }

    public float getChietKhau() {
        return ChietKhau;
    }

    public void setChietKhau(float ChietKhau) {
        this.ChietKhau = ChietKhau;
    }

    public float getVAT() {
        return VAT;
    }

    public void setVAT(float VAT) {
        this.VAT = VAT;
    }

    public float getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(float ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public float getTienKhachTra() {
        return TienKhachTra;
    }

    public void setTienKhachTra(float TienKhachTra) {
        this.TienKhachTra = TienKhachTra;
    }

    public TreeMap<SanPham, Integer> getDSSP() {
        return DSSP;
    }

    public void setDSSP(TreeMap<SanPham, Integer> DSSP) {
        this.DSSP = DSSP;
    }
    
    public void themSP(SanPham SP, Integer SoLuong){
        boolean chkTonTai = DSSP.containsKey(SP);
        if(chkTonTai){
            int SoLuongTruoc = DSSP.get(SP);
            SoLuong += SoLuongTruoc;
            DSSP.put(SP, SoLuong);
        }
        else{
            DSSP.put(SP, SoLuong);
        }
    }
    
    public void truSP(SanPham SP, Integer SoLuong){
        boolean chkTonTai = DSSP.containsKey(SP);
        if(chkTonTai){
            int SoLuongTruoc = DSSP.get(SP);
            SoLuong = SoLuongTruoc - SoLuong;
            /*
             * Nếu số lượng sau khi trừ xong <= 0 thì xoá sản phẩm khỏi danh sách
             * Nếu số lượng sau khi trừ xong > 0 thì xoá sản phẩm 
                   và cập nhật lại sản phẩm cùng số lượng mới
             */
            if(SoLuong <= 0){
                DSSP.remove(SP);    
            }
            else {
                DSSP.remove(SP);
                DSSP.put(SP, SoLuong);
            }
        }
    }
    
    public void xoaSP(SanPham SP){
        boolean kiemtra = DSSP.containsKey(SP);
        if(kiemtra){
            DSSP.remove(SP);
        }
    }

}
