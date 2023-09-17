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
public class SanPham implements Comparable<SanPham>{
    
    private String MaSanPham;
    private String TenSanPham;
    private String MaVach;
    private String MaNhomHang;
    private String MaNCC;
    private int MaDVT;
    private int TonKho;
    private int DinhMucNhoNhat;
    private int DinhMucLonNhat;
    private float GiaVon;
    private float GiaBan;
    private Date HSDTruoc;
    private Date HSDMoiNhat;
    private String HinhAnh;
    private boolean TrangThai;
    
    public SanPham(){
        
    }

    public SanPham(String MaSanPham, String TenSanPham, String MaVach, String MaNhomHang, String MaNCC, int MaDVT, int TonKho, int DinhMucNhoNhat, int DinhMucLonNhat, float GiaVon, float GiaBan, Date HSDTruoc, Date HSDMoiNhat, String HinhAnh, boolean TrangThai) {
        this.MaSanPham = MaSanPham;
        this.TenSanPham = TenSanPham;
        this.MaVach = MaVach;
        this.MaNhomHang = MaNhomHang;
        this.MaNCC = MaNCC;
        this.MaDVT = MaDVT;
        this.TonKho = TonKho;
        this.DinhMucNhoNhat = DinhMucNhoNhat;
        this.DinhMucLonNhat = DinhMucLonNhat;
        this.GiaVon = GiaVon;
        this.GiaBan = GiaBan;
        this.HSDTruoc = HSDTruoc;
        this.HSDMoiNhat = HSDMoiNhat;
        this.HinhAnh = HinhAnh;
        this.TrangThai = TrangThai;
    }

    public String getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(String MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public String getMaVach() {
        return MaVach;
    }

    public void setMaVach(String MaVach) {
        this.MaVach = MaVach;
    }

    public String getMaNhomHang() {
        return MaNhomHang;
    }

    public void setMaNhomHang(String MaNhomHang) {
        this.MaNhomHang = MaNhomHang;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public int getMaDVT() {
        return MaDVT;
    }

    public void setMaDVT(int MaDVT) {
        this.MaDVT = MaDVT;
    }

    public int getTonKho() {
        return TonKho;
    }

    public void setTonKho(int TonKho) {
        this.TonKho = TonKho;
    }

    public int getDinhMucNhoNhat() {
        return DinhMucNhoNhat;
    }

    public void setDinhMucNhoNhat(int DinhMucNhoNhat) {
        this.DinhMucNhoNhat = DinhMucNhoNhat;
    }

    public int getDinhMucLonNhat() {
        return DinhMucLonNhat;
    }

    public void setDinhMucLonNhat(int DinhMucLonNhat) {
        this.DinhMucLonNhat = DinhMucLonNhat;
    }

    public float getGiaVon() {
        return GiaVon;
    }

    public void setGiaVon(float GiaVon) {
        this.GiaVon = GiaVon;
    }

    public float getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(float GiaBan) {
        this.GiaBan = GiaBan;
    }

    public Date getHSDTruoc() {
        return HSDTruoc;
    }

    public void setHSDTruoc(Date HSDTruoc) {
        this.HSDTruoc = HSDTruoc;
    }

    public Date getHSDMoiNhat() {
        return HSDMoiNhat;
    }

    public void setHSDMoiNhat(Date HSDMoiNhat) {
        this.HSDMoiNhat = HSDMoiNhat;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    public boolean getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    @Override
    public int compareTo(SanPham o) {
        return this.MaSanPham.compareTo(o.MaSanPham);
    }
    
}
