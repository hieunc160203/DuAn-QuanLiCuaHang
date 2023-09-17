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
public class PhieuKiemChiTiet {
    
    private int MaPKCT;
    private String MaPhieuKiem;
    private String MaSanPham;
    private float DonGia;
    private String DVT;
    private int TonKho;
    private int ThucTe;
    private int SoLuongLech;
    private double GiaTriLech;

    public PhieuKiemChiTiet() {
    
    }

    public PhieuKiemChiTiet(int MaPKCT, String MaPhieuKiem, String MaSanPham, float DonGia, String DVT, int TonKho, int ThucTe, int SoLuongLech, double GiaTriLech) {
        this.MaPKCT = MaPKCT;
        this.MaPhieuKiem = MaPhieuKiem;
        this.MaSanPham = MaSanPham;
        this.DonGia = DonGia;
        this.DVT = DVT;
        this.TonKho = TonKho;
        this.ThucTe = ThucTe;
        this.SoLuongLech = SoLuongLech;
        this.GiaTriLech = GiaTriLech;
    }

    public int getMaPKCT() {
        return MaPKCT;
    }

    public void setMaPKCT(int MaPKCT) {
        this.MaPKCT = MaPKCT;
    }

    public String getMaPhieuKiem() {
        return MaPhieuKiem;
    }

    public void setMaPhieuKiem(String MaPhieuKiem) {
        this.MaPhieuKiem = MaPhieuKiem;
    }

    public String getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(String MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public float getDonGia() {
        return DonGia;
    }

    public void setDonGia(float DonGia) {
        this.DonGia = DonGia;
    }

    public String getDVT() {
        return DVT;
    }

    public void setDVT(String DVT) {
        this.DVT = DVT;
    }

    public int getTonKho() {
        return TonKho;
    }

    public void setTonKho(int TonKho) {
        this.TonKho = TonKho;
    }

    public int getThucTe() {
        return ThucTe;
    }

    public void setThucTe(int ThucTe) {
        this.ThucTe = ThucTe;
    }

    public int getSoLuongLech() {
        return SoLuongLech;
    }

    public void setSoLuongLech(int SoLuongLech) {
        this.SoLuongLech = SoLuongLech;
    }

    public double getGiaTriLech() {
        return GiaTriLech;
    }

    public void setGiaTriLech(double GiaTriLech) {
        this.GiaTriLech = GiaTriLech;
    }
    
}
