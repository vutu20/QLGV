package com.example.qlgv.Object;

import java.io.Serializable;

public class tobomon implements Serializable {
    public String getMatbm() {
        return matbm;
    }

    public void setMatbm(String matbm) {
        this.matbm = matbm;
    }

    public String getTentbm() {
        return tentbm;
    }

    public void setTentbm(String tentbm) {
        this.tentbm = tentbm;
    }
    public tobomon(){
    }
    public String matbm, tentbm;

    public tobomon(String matbm, String tentbm){
        this.matbm=matbm;
        this.tentbm=tentbm;
    }
    public String toString(){
        return "Mã tổ bộ môn: "+matbm+"\nTên tổ bộ môn: "+tentbm;
    }
}
