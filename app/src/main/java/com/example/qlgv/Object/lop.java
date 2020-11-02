package com.example.qlgv.Object;

import java.io.Serializable;

public class lop implements Serializable {
    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    public String malop, tenlop;
    public lop(String malop, String tenlop){
        this.malop=malop;
        this.tenlop=tenlop;
    }
    public lop(){
    }
    public String toString(){
        return "Mã lớp: "+malop+"\nTên lớp: "+tenlop;

    }
}
