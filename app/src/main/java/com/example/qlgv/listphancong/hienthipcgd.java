package com.example.qlgv.listphancong;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qlgv.DatabaseHandler;
import com.example.qlgv.Object.phancong;
import com.example.qlgv.R;

import java.util.ArrayList;

public class hienthipcgd extends AppCompatActivity {
    String magv;
    DatabaseHandler db = new DatabaseHandler(this);
    TextView tvmagv, tvmamh, tvhocky, tvnamhoc, tvlop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hienthipcgd);
        //back tren ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        tvmagv =  findViewById(R.id.tvgv);
        tvmamh =  findViewById(R.id.tvmh);
        tvhocky =  findViewById(R.id.tvhocky);
        tvnamhoc =  findViewById(R.id.tvnamhoc);
        tvlop =  findViewById(R.id.tvlop);
        Bundle bundle = getIntent().getExtras();
        magv= bundle.getString("MaGV");
        Cursor cursor = db.getCursor("select * from PhanCongGiangDay where MaGV='"+magv+"'");
        cursor.moveToFirst();
        phancong bk = new phancong();
        bk.setMaGV1(cursor.getString(0));
        bk.setMaMH1(cursor.getString(1));
        bk.setMalop1(cursor.getString(2));
        bk.setHocky(cursor.getString(3));
        bk.setNamhoc(cursor.getString(4));
        tvmagv.setText(""+bk.getMaGV1());
        tvmamh.setText(""+bk.getMaMH1());
        tvlop.setText(""+bk.getMalop1());
        tvhocky.setText(""+bk.getHocky());
        tvnamhoc.setText(""+bk.getNamhoc());
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent in = new Intent(this, qlpcgd.class);
            startActivity(in);
        }
        return super.onOptionsItemSelected(item);
    }
}
