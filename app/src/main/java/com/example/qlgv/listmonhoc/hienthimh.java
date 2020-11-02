package com.example.qlgv.listmonhoc;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qlgv.DatabaseHandler;
import com.example.qlgv.Object.monhoc;
import com.example.qlgv.R;
public class hienthimh extends AppCompatActivity {
    String mamh;
    DatabaseHandler db = new DatabaseHandler(this);
    TextView txtmamh, txttenmh, txtsotiet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hienthimh);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        txtmamh =  findViewById(R.id.mamonhoc);
        txttenmh =  findViewById(R.id.tenmonhoc);
        txtsotiet =  findViewById(R.id.sotiet);
        Bundle bundle = getIntent().getExtras();
        mamh = bundle.getString("MaMH");
        Cursor cursor = db.getCursor("select * from MonHoc where MaMH='" + mamh + "'");
        if (cursor.moveToFirst()) {
            monhoc mh = new monhoc();
            mh.setMamh(cursor.getString(0));
            mh.setTenmh(cursor.getString(1));
            mh.setSotet(cursor.getString(2));
            txtmamh.setText("" + mh.getMamh());
            txttenmh.setText("" + mh.getTenmh());
            txtsotiet.setText("" + mh.getSotet());
        }
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            Intent in = new Intent(this, qlmh.class);
            startActivity(in);
        }
        return super.onOptionsItemSelected(item);
    }
}
