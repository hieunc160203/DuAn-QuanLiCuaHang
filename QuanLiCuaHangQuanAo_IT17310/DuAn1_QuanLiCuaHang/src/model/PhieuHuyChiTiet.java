/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Administrator
 */
public class PhieuHuyChiTiet {
    
    private int MaPHCT;
    private String MaPhieuHuy;
    private String MaSanPham;
    private String DVT;
    private int SoLuong;
    private float GiaVon;
    private float ThanhTien;

    public PhieuHuyChiTiet() {
    
    }

    public PhieuHuyChiTiet(int MaPHCT, String MaPhieuHuy, String MaSanPham, String DVT, int SoLuong, float GiaVon, float ThanhTien) {
        this.MaPHCT = MaPHCT;
        this.MaPhieuHuy = MaPhieuHuy;
        this.MaSanPham = MaSanPham;
        this.DVT = DVT;
        this.SoLuong = SoLuong;
        this.GiaVon = GiaVon;
        this.ThanhTien = ThanhTien;
    }

    public int getMaPHCT() {
        return MaPHCT;
    }

    public void setMaPHCT(int MaPHCT) {
        this.MaPHCT = MaPHCT;
    }

    public String getMaPhieuHuy() {
        return MaPhieuHuy;
    }

    public void setMaPhieuHuy(String MaPhieuHuy) {
        this.MaPhieuHuy = MaPhieuHuy;
    }

    public String getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(String MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public String getDVT() {
        return DVT;
    }

    public void setDVT(String DVT) {
        this.DVT = DVT;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public float getGiaVon() {
        return GiaVon;
    }

    public void setGiaVon(float GiaVon) {
        this.GiaVon = GiaVon;
    }

    public float getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(float ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
    
}