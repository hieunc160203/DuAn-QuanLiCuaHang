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
public class NhomHang {
    
    private String MaNhomHang;
    private String TenNhomHang;
    private String GhiChu;
    
    public NhomHang(){
        
    }

    public NhomHang(String MaNhomHang, String TenNhomHang, String GhiChu) {
        this.MaNhomHang = MaNhomHang;
        this.TenNhomHang = TenNhomHang;
        this.GhiChu = GhiChu;
    }

    public String getMaNhomHang() {
        return MaNhomHang;
    }

    public void setMaNhomHang(String MaNhomHang) {
        this.MaNhomHang = MaNhomHang;
    }

    public String getTenNhomHang() {
        return TenNhomHang;
    }

    public void setTenNhomHang(String TenNhomHang) {
        this.TenNhomHang = TenNhomHang;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
    @Override
    public String toString() {
        return this.TenNhomHang;
    }
}
