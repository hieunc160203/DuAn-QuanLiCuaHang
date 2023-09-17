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
public class DonViTinh {
    
    private int MaDVT;
    private String MoTa;

    public DonViTinh() {
    
    }

    public DonViTinh(int MaDVT, String MoTa) {
        this.MaDVT = MaDVT;
        this.MoTa = MoTa;
    }

    public int getMaDVT() {
        return MaDVT;
    }

    public void setMaDVT(int MaDVT) {
        this.MaDVT = MaDVT;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }
    
    @Override
    public String toString() {
        return this.MoTa;
    }
}
