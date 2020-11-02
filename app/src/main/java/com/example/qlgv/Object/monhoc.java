package com.example.qlgv.Object;

import java.io.Serializable;

public class monhoc implements Serializable {
    public String getMamh() {
        return mamh;
    }

    public void setMamh(String mamh) {
        this.mamh = mamh;
    }

    public String getTenmh() {
        return tenmh;
    }

    public void setTenmh(String tenmh) {
        this.tenmh = tenmh;
    }

    public String getSotet() {
        return sotet;
    }

    public void setSotet(String sotet) {
        this.sotet = sotet;
    }

    public String mamh, tenmh, sotet;
    public monhoc(String mamh, String tenmh, String sotet){
        this.mamh=mamh;
        this.tenmh=tenmh;
        this.sotet=sotet;
    }
    public monhoc(){

    }
    public String toString(){
        return "Mã môn học: "+mamh+"\nTên môn học: "+tenmh;

    }
}
