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
public class PhieuHuyHang {
    
    private String MaPhieuHuy;
    private int LoaiPhieuHuy; // 0: huỷ hết hsd; 1: huỷ lỗi
    private String MaNhanVien;
    private Date NgayHuy;
    private int SoLuongHuy;
    private float GiaTriHuy;
    private String GhiChu;
    private TreeMap<SanPham, Integer> DSSP;

    public PhieuHuyHang() {
    
    }

    public PhieuHuyHang(String MaPhieuHuy, int LoaiPhieuHuy, String MaNhanVien, Date NgayHuy, int SoLuongHuy, float GiaTriHuy, String GhiChu, TreeMap<SanPham, Integer> DSSP) {
        this.MaPhieuHuy = MaPhieuHuy;
        this.LoaiPhieuHuy = LoaiPhieuHuy;
        this.MaNhanVien = MaNhanVien;
        this.NgayHuy = NgayHuy;
        this.SoLuongHuy = SoLuongHuy;
        this.GiaTriHuy = GiaTriHuy;
        this.GhiChu = GhiChu;
        this.DSSP = DSSP;
    }

    public String getMaPhieuHuy() {
        return MaPhieuHuy;
    }

    public void setMaPhieuHuy(String MaPhieuHuy) {
        this.MaPhieuHuy = MaPhieuHuy;
    }

    public int getLoaiPhieuHuy() {
        return LoaiPhieuHuy;
    }

    public void setLoaiPhieuHuy(int LoaiPhieuHuy) {
        this.LoaiPhieuHuy = LoaiPhieuHuy;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public Date getNgayHuy() {
        return NgayHuy;
    }

    public void setNgayHuy(Date NgayHuy) {
        this.NgayHuy = NgayHuy;
    }

    public int getSoLuongHuy() {
        return SoLuongHuy;
    }

    public void setSoLuongHuy(int SoLuongHuy) {
        this.SoLuongHuy = SoLuongHuy;
    }

    public float getGiaTriHuy() {
        return GiaTriHuy;
    }

    public void setGiaTriHuy(float GiaTriHuy) {
        this.GiaTriHuy = GiaTriHuy;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public TreeMap<SanPham, Integer> getDSSP() {
        return DSSP;
    }

    public void setDSSP(TreeMap<SanPham, Integer> DSSP) {
        this.DSSP = DSSP;
    }

}