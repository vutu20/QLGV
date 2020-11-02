package com.example.qlgv.listgiaovien;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qlgv.DatabaseHandler;
import com.example.qlgv.Object.giaovien;
import com.example.qlgv.R;

public class hienthigv extends AppCompatActivity {
    String magv;

    DatabaseHandler db = new DatabaseHandler(this);
    TextView txtmagv, txthoten, txtgioitinh, txtnamsinh, txtsdt, txtdiachi, txtemail, txtbangcap, txttrinhdo, txtcmnd, txttbm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hienthigv);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        txtmagv =  findViewById(R.id.txtmagv);
        txthoten =  findViewById(R.id.txthoten);
        txtgioitinh =  findViewById(R.id.txtgioitinh);
        txtnamsinh =  findViewById(R.id.txtnamsinh);
        txtsdt =  findViewById(R.id.txtsdt);
        txtdiachi =  findViewById(R.id.txtdiachi);
        txtemail =  findViewById(R.id.txtemail);
        txtbangcap = findViewById(R.id.txtbangcap);
        txttrinhdo =  findViewById(R.id.txttrinhdo);
        txtcmnd =  findViewById(R.id.txtcmnd);
        txttbm = findViewById(R.id.txttobomon);
        Bundle bundle = getIntent().getExtras();
        magv= bundle.getString("MaGV");
        Cursor cursor = db.getCursor("select * from GiaoVien where MaGV='"+magv+"'");
        cursor.moveToFirst();
        com.example.qlgv.Object.giaovien bk = new giaovien();
        bk.setMaGV(cursor.getString(0));
        bk.setHoten(cursor.getString(1));
        bk.setGioitinh(cursor.getString(2));
        bk.setNgaysinh(cursor.getString(3));
        bk.setSdt(cursor.getString(4));
        bk.setEmail(cursor.getString(5));
        bk.setDiachi(cursor.getString(6));
        bk.setBangcap(cursor.getString(7));
        bk.setCmnd(cursor.getString(8));
        bk.setTrinhdo(cursor.getString(9));
        bk.setMatobomon(cursor.getString(10));

        txtmagv.setText(""+bk.getMaGV());
        txthoten.setText(""+bk.getHoten());
        txtgioitinh.setText(""+bk.getGioitinh());
        txtnamsinh.setText(""+bk.getNgaysinh());
        txtsdt.setText(""+bk.getSdt());
        txtemail.setText(""+bk.getEmail());
        txtdiachi.setText(""+bk.getDiachi());
        txtbangcap.setText(""+bk.getBangcap());
        txtcmnd.setText(""+bk.getCmnd());
        txttrinhdo.setText(""+bk.getTrinhdo());
        txttbm.setText(""+bk.getMatobomon());
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            Intent in = new Intent(this, qlgv.class);
            startActivity(in);
        }
        return super.onOptionsItemSelected(item);
    }
}
