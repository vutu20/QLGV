package com.example.qlgv.listtobomon;

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

public class xoatbm extends AppCompatActivity {
    DatabaseHandler db = new DatabaseHandler(this);
    EditText edtxoatbm;
Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xoatbm);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        edtxoatbm = findViewById(R.id.edtxoatbm);
        delete=findViewById(R.id.btnxoatbm);
        event();
    }
    public void event() {
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Xoatbm();
            }
        });
    }
    public void Xoatbm() {
        Intent in = new Intent(this, qltbm.class);
        if (db.GetCount("select * from ToBoMon where MaTBM='" + edtxoatbm.getText().toString().trim() + "'  ") == 0) {
            Toast.makeText(this, "Mã tổ bộ môn chưa có. Vui lòng chọn mã khác!", Toast.LENGTH_LONG).show();
        } else {
            db.executeSQL("delete from ToBoMon where MaTBM='" + edtxoatbm.getText().toString().trim() +  "'");
            Toast.makeText(this, "Bản ghi đã được xóa!", Toast.LENGTH_LONG).show();
            edtxoatbm.setText("");
            startActivity(in);
        }
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent in = new Intent(this, qltbm.class);
            startActivity(in);
        }
        return super.onOptionsItemSelected(item);
    }
}
