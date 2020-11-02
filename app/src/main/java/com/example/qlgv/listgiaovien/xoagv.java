package com.example.qlgv.listgiaovien;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qlgv.DatabaseHandler;
import com.example.qlgv.R;

import java.util.ArrayList;

public class xoagv extends AppCompatActivity {
    DatabaseHandler db = new DatabaseHandler(this);
    EditText edtxoagv;
Button delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xoagv);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        edtxoagv = findViewById(R.id.edtxoagv);
        delete=findViewById(R.id.btnxoagv);
        event();
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            Intent in = new Intent(this,qlgv.class);
            startActivity(in);
            //finish();
        }
        return super.onOptionsItemSelected(item);
    }
    public void event() {
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Xoagv();
            }
        });
    }
    public void Xoagv(){
        Intent in = new Intent(this, qlgv.class);
        if (db.GetCount("select * from GiaoVien where MaGV='"+ edtxoagv.getText().toString().trim() +"'  ")==0) {
            Toast.makeText(this, "Mã giáo viên chưa có. Vui lòng chọn mã khác!", Toast.LENGTH_LONG).show();
        } else {
            db.executeSQL("delete from GiaoVien where MaGV='"+edtxoagv.getText().toString().trim()+"'");
            db.executeSQL("delete from PhanCongGiangDay where MaGV='"+edtxoagv.getText().toString().trim()+"'");
            Toast.makeText(this, "Bản ghi đã được xóa!", Toast.LENGTH_LONG).show();
            edtxoagv.setText("");
            startActivity(in);
        }
    }
}
