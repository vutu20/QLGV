package com.example.qlgv.listphancong;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qlgv.DatabaseHandler;
import com.example.qlgv.R;

public class thempcgd extends AppCompatActivity {

    DatabaseHandler db = new DatabaseHandler(this);
    EditText edtmagv1, edtmamh1, edthocky, edtnamhoc, edtlop;
Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thempcgd);
        //back tren ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        edtmagv1 =  findViewById(R.id.edtmagv);
        edtmamh1 =  findViewById(R.id.edtmamh);
        edthocky =  findViewById(R.id.edthocky);
        edtnamhoc =  findViewById(R.id.edtnamhoc);
        edtlop =  findViewById(R.id.edtmalop);
        add=findViewById(R.id.btnthempcgd);
        event();
    }
    public void event() {
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thempcgd();
            }
        });
    }
    public void Thempcgd() {
        Intent in = new Intent(this, qlpcgd.class);
        if (edtmagv1.length() == 0||edtmamh1.length()==0||edthocky.length()==0||edtnamhoc.length()==0||edtlop.length()==0){
            Toast.makeText(thempcgd.this, "Thông tin nhập lỗi! Mời nhập lại!", Toast.LENGTH_SHORT).show();
        }
        else {
            int checkmagvchua = db.GetCount("select * from GiaoVien where MaGV='" + edtmagv1.getText().toString().trim() + "'  ");
            int checkmamhchua = db.GetCount("select * from MonHoc where MaMH='" + edtmamh1.getText().toString().trim() + "'  ");
            int checkmalopchua = db.GetCount("select * from Lop where MaLop='" + edtlop.getText().toString().trim() + "'  ");
            if (checkmagvchua == 0) {
                Toast.makeText(this, "Mã chưa tồn tại. Vui lòng nhập mã khác!", Toast.LENGTH_SHORT).show();
            } else if (checkmamhchua == 0) {
                Toast.makeText(this, "Mã chưa tồn tại. Vui lòng nhập mã khác!", Toast.LENGTH_SHORT).show();
            } else if (checkmalopchua == 0) {
                Toast.makeText(this, "Mã chưa tồn tại. Vui lòng nhập mã khác!", Toast.LENGTH_SHORT).show();
            } else {
                db.executeSQL("Insert into PhanCongGiangDay values('" + edtmagv1.getText().toString().trim() + "','" + edtmamh1.getText().toString().trim() + "','" + edtlop.getText().toString().trim()+ "','" + edthocky.getText().toString().trim()+ "','" + edtnamhoc.getText().toString().trim() + "')");
                Toast.makeText(this, "Thêm thành công!", Toast.LENGTH_SHORT).show();
                edtmagv1.setText("");
                edtmamh1.setText("");
                edtlop.setText("");
                edthocky.setText("");
                edtnamhoc.setText("");
                startActivity(in);
            }
        }
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            Intent in = new Intent(this, qlpcgd.class);
            startActivity(in);
        }
        return super.onOptionsItemSelected(item);
    }
}
