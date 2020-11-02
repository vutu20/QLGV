package com.example.qlgv.Object;

import java.io.Serializable;

public class giaovien implements Serializable {
    public String maGV;
    public String hoten;
    public String gioitinh;
    public String ngaysinh;
    public String sdt;
    public String diachi;
    public String email;
    public String bangcap;
    public String trinhdo;
    public String cmnd;
    public String matobomon;
    public String getMaGV() {
        return maGV;
    }

    public String getHoten() {
        return hoten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public String getSdt() {
        return sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public String getEmail() {
        return email;
    }

    public String getBangcap() {
        return bangcap;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBangcap(String bangcap) {
        this.bangcap = bangcap;
    }
    public void setTrinhdo(String trinhdo) {
        this.trinhdo = trinhdo;
    }
    public String getTrinhdo() {
        return trinhdo;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String mamonhoc) {
        this.cmnd = mamonhoc;
    }

    public String getMatobomon() {
        return matobomon;
    }

    public void setMatobomon(String matobomon) {
        this.matobomon = matobomon;
    }
    public giaovien(String magv, String hoten, String gioitinh, String ngaysinh, String sdt, String diachi, String email, String bangcap, String trinhdo,String cmnd, String matobomon) {
        this.maGV = magv;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.sdt = sdt;
        this.diachi = diachi;
        this.email = email;
        this.bangcap = bangcap;
        this.trinhdo = trinhdo;
        this.cmnd = cmnd;
        this.matobomon = matobomon;
    }
    public giaovien() {
    }
    public String toString() {
        return "Mã giáo viên: " + maGV + "\nHọ tên: " + hoten ;
    }



}
