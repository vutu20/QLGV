package com.example.qlgv;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class thongke extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongke);
        //back tren ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }
    public void gioitinh(View view) {
        Intent in = new Intent(view.getContext(), tkgioitinh.class);//hien thi class duoc goi
        startActivity(in);
    }
    public void thongkemonhoc(View view) {
        Intent in = new Intent(view.getContext(), tksgd.class);//hien thi class duoc goi
        startActivity(in);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent in = new Intent(this, menu.class);
            startActivity(in);
        }
        finish();
        return super.onOptionsItemSelected(item);
    }
}
