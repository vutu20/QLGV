package com.example.qlgv.Object;

import java.io.Serializable;

public class phancong implements Serializable {

    public String getMaGV1() {
        return maGV1;
    }

    public void setMaGV1(String maGV1) {
        this.maGV1 = maGV1;
    }

    public String getMaMH1() {
        return maMH1;
    }

    public void setMaMH1(String maMH1) {
        this.maMH1 = maMH1;
    }

    public String getHocky() {
        return hocky;
    }

    public void setHocky(String hocky) {
        this.hocky = hocky;
    }

    public String getNamhoc() {
        return namhoc;
    }

    public void setNamhoc(String namhoc) {
        this.namhoc = namhoc;
    }

    public String getMalop1() {
        return malop1;
    }

    public void setMalop1(String malop1) {
        this.malop1 = malop1;
    }

    public String maGV1, maMH1, hocky, namhoc, malop1;
    public phancong(){

    }
    public phancong(String maGV, String maMH, String hocky, String namhoc, String malop1){
        this.maGV1=maGV;
        this.maMH1=maMH;
        this.hocky=hocky;
        this.namhoc=namhoc;
        this.malop1=malop1;
    }
    public String toString(){
        return "Mã GV: "+maGV1+"\nMã MH:"+maMH1+"\nHọc kỳ: "+hocky+"\nNăm học: "+namhoc+"\nMã Lớp: "+malop1;
    }
}
