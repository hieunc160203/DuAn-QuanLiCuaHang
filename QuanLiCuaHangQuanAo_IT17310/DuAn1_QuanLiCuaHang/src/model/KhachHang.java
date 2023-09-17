/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class KhachHang {
    
    private String MaKhachHang;
    private String HoTen;
    private int DiemThuong;
    private String DienThoai;
    private boolean GioiTinh;
    private Date NgaySinh;
    private String NVQuanLy;
    private String Email;
    private String DiaChi;
    private String GhiChu;
    private boolean TrangThai;
    
    public KhachHang(){
        
    }

    public KhachHang(String MaKhachHang, String HoTen, int DiemThuong, String DienThoai, boolean GioiTinh, Date NgaySinh, String NVQuanLy, String Email, String DiaChi, String GhiChu, boolean TrangThai) {
        this.MaKhachHang = MaKhachHang;
        this.HoTen = HoTen;
        this.DiemThuong = DiemThuong;
        this.DienThoai = DienThoai;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.NVQuanLy = NVQuanLy;
        this.Email = Email;
        this.DiaChi = DiaChi;
        this.GhiChu = GhiChu;
        this.TrangThai = TrangThai;
    }

    public String getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(String MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public int getDiemThuong() {
        return DiemThuong;
    }

    public void setDiemThuong(int DiemThuong) {
        this.DiemThuong = DiemThuong;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String DienThoai) {
        this.DienThoai = DienThoai;
    }

    public boolean getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getNVQuanLy() {
        return NVQuanLy;
    }

    public void setNVQuanLy(String NVQuanLy) {
        this.NVQuanLy = NVQuanLy;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public boolean getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }
        
}