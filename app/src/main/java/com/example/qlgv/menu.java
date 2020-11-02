package com.example.qlgv;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qlgv.listgiaovien.qlgv;
import com.example.qlgv.listlop.qllop;
import com.example.qlgv.listmonhoc.qlmh;
import com.example.qlgv.listphancong.qlpcgd;
import com.example.qlgv.listtobomon.qltbm;

public class menu extends AppCompatActivity {
    ImageButton giaovien,monhoc,lop,tobomon,phancong,thongke;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        anhxa();
        event();
    }
    public void anhxa(){
        giaovien= findViewById(R.id.btgiaovien);
       monhoc= findViewById(R.id.btmonhoc);
        lop= findViewById(R.id.btnlop);
        tobomon= findViewById(R.id.bttobomon);
        phancong= findViewById(R.id.btthoigian);
       thongke= findViewById(R.id.btthongke);

    }
    public void event(){
        giaovien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(menu.this,qlgv.class);
                startActivity(intent);
            }
        });
        monhoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(menu.this,qlmh.class);
                startActivity(intent);
            }
        });
        lop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(menu.this,qllop.class);
                startActivity(intent);
            }
        });
        tobomon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(menu.this,qltbm.class);
                startActivity(intent);
            }
        });
        phancong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(menu.this,qlpcgd.class);
                startActivity(intent);
            }
        });
        thongke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(menu.this,thongke.class);
                startActivity(intent);
            }
        });
    }
}
