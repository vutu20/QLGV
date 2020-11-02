package com.example.qlgv;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qlgv.Object.giaovien;
import com.example.qlgv.listgiaovien.hienthigv;

import java.util.ArrayList;

public class tkgioitinh extends AppCompatActivity {
    DatabaseHandler db = new DatabaseHandler(this);
    TextView txttknam,txttknu,txttkronggt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tkgioitinh);
        txttknam=findViewById(R.id.txttknam);
        txttknu=findViewById(R.id.txttknu);
        txttkronggt=findViewById(R.id.txttktonggt);
        int nam = db.GetCount( "SELECT * FROM GiaoVien where GioiTinh='Nam'" );
        int nu = db.GetCount( "SELECT * FROM GiaoVien where GioiTinh='Nữ'" );
        int sbg = db.GetCount( "SELECT * FROM GiaoVien" );
        txttknam.setText(""+nam);
        txttknu.setText(""+nu);
        txttkronggt.setText(""+sbg);
        //back tren ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }
    //nut back
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent in = new Intent(this, thongke.class);
            startActivity(in);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
