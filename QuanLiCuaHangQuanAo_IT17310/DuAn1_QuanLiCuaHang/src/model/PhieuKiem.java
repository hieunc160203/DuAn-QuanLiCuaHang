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
public class PhieuKiem {
    
    private String MaPhieuKiem;
    private String MaNhanVien;
    private Date NgayTao;
    private Date NgayCanBang;
    private double GiaTriLech;
    private String GhiChu;
    private int TrangThai; // 0: chua can bang; 1: da can bang; 2: da huy
    private TreeMap<SanPham,Integer> DSSP;

    public PhieuKiem() {
    
    }

    public PhieuKiem(String MaPhieuKiem, String MaNhanVien, Date NgayTao, Date NgayCanBang, double GiaTriLech, String GhiChu, int TrangThai, TreeMap<SanPham, Integer> DSSP) {
        this.MaPhieuKiem = MaPhieuKiem;
        this.MaNhanVien = MaNhanVien;
        this.NgayTao = NgayTao;
        this.NgayCanBang = NgayCanBang;
        this.GiaTriLech = GiaTriLech;
        this.GhiChu = GhiChu;
        this.TrangThai = TrangThai;
        this.DSSP = DSSP;
    }

    public String getMaPhieuKiem() {
        return MaPhieuKiem;
    }

    public void setMaPhieuKiem(String MaPhieuKiem) {
        this.MaPhieuKiem = MaPhieuKiem;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public Date getNgayCanBang() {
        return NgayCanBang;
    }

    public void setNgayCanBang(Date NgayCanBang) {
        this.NgayCanBang = NgayCanBang;
    }

    public double getGiaTriLech() {
        return GiaTriLech;
    }

    public void setGiaTriLech(double GiaTriLech) {
        this.GiaTriLech = GiaTriLech;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public TreeMap<SanPham, Integer> getDSSP() {
        return DSSP;
    }

    public void setDSSP(TreeMap<SanPham, Integer> DSSP) {
        this.DSSP = DSSP;
    }
    
}
