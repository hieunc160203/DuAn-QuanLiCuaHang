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
public class PhieuNhapChiTiet {
    
    private int MaPNCT;
    private String MaPhieuNhap;
    private String MaSanPham;
    private int SoLuong;
    private float GiaNhap;
    private double ThanhTien;
    private Date HSDMoiNhat;

    public PhieuNhapChiTiet() {
    
    }

    public PhieuNhapChiTiet(int MaPNCT, String MaPhieuNhap, String MaSanPham, int SoLuong, float GiaNhap, double ThanhTien, Date HSDMoiNhat) {
        this.MaPNCT = MaPNCT;
        this.MaPhieuNhap = MaPhieuNhap;
        this.MaSanPham = MaSanPham;
        this.SoLuong = SoLuong;
        this.GiaNhap = GiaNhap;
        this.ThanhTien = ThanhTien;
        this.HSDMoiNhat = HSDMoiNhat;
    }

    public int getMaPNCT() {
        return MaPNCT;
    }

    public void setMaPNCT(int MaPNCT) {
        this.MaPNCT = MaPNCT;
    }

    public String getMaPhieuNhap() {
        return MaPhieuNhap;
    }

    public void setMaPhieuNhap(String MaPhieuNhap) {
        this.MaPhieuNhap = MaPhieuNhap;
    }

    public String getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(String MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public float getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(float GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public Date getHSDMoiNhat() {
        return HSDMoiNhat;
    }

    public void setHSDMoiNhat(Date HSDMoiNhat) {
        this.HSDMoiNhat = HSDMoiNhat;
    }
    
}