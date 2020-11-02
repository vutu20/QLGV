package com.example.qlgv.listphancong;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qlgv.DatabaseHandler;
import com.example.qlgv.R;
public class xoapcgd extends AppCompatActivity {
    DatabaseHandler db = new DatabaseHandler(this);
    EditText edtxoapc;
Button delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xoapcgd);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        edtxoapc =  findViewById(R.id.edtxoapcgd);
        delete=findViewById(R.id.btnxoapcgd);
        event();
    }
    public void event() {
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xoapcgd();
            }
        });
    }
    public void xoapcgd() {
        Intent in = new Intent(this, qlpcgd.class);
        if (db.GetCount("select * from PhanCongGiangDay where MaGV='" + edtxoapc.getText().toString().trim() + "'  ") == 0) {
            Toast.makeText(this, "Mã môn học chưa có. Vui lòng chọn mã khác!", Toast.LENGTH_LONG).show();
        } else {
            db.executeSQL("delete from PhanCongGiangDay where MaGV='" + edtxoapc.getText().toString().trim() + "'");
            Toast.makeText(this, "Bản ghi đã được xóa!", Toast.LENGTH_LONG).show();
            edtxoapc.setText("");
            startActivity(in);
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
