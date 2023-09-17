/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author Administrator
 */
public class PhieuNhap {
    
    private String MaPhieuNhap;
    private String MaNhanVien;
    private Date NgayNhap;
    private String MaNCC;
    private int TongSoLuong;
    private float ChietKhau;
    private float VAT;
    private double ThanhTien;
    private String GhiChu;
    private TreeMap<SanPham, List<String>> DSSP = new TreeMap<>();

    public PhieuNhap() {
    
    }

    public PhieuNhap(String MaPhieuNhap, String MaNhanVien, Date NgayNhap, String MaNCC, int TongSoLuong, float ChietKhau, float VAT, double ThanhTien, String GhiChu) {
        this.MaPhieuNhap = MaPhieuNhap;
        this.MaNhanVien = MaNhanVien;
        this.NgayNhap = NgayNhap;
        this.MaNCC = MaNCC;
        this.TongSoLuong = TongSoLuong;
        this.ChietKhau = ChietKhau;
        this.VAT = VAT;
        this.ThanhTien = ThanhTien;
        this.GhiChu = GhiChu;
    }

    public String getMaPhieuNhap() {
        return MaPhieuNhap;
    }

    public void setMaPhieuNhap(String MaPhieuNhap) {
        this.MaPhieuNhap = MaPhieuNhap;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public Date getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(Date NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
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

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public TreeMap<SanPham, List<String>> getDSSP() {
        return DSSP;
    }

    public void setDSSP(TreeMap<SanPham, List<String>> DSSP) {
        this.DSSP = DSSP;
    }

}