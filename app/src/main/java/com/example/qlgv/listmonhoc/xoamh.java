package com.example.qlgv.listmonhoc;

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

public class xoamh extends AppCompatActivity {
    DatabaseHandler db = new DatabaseHandler(this);
    EditText edtxoamh;
Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xoamh);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        edtxoamh = (EditText) findViewById(R.id.edtxoamh);
        delete=findViewById(R.id.btnxoamh);
        event();
    }
    public void event() {
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Xoamh();
            }
        });
    }
    public void Xoamh() {
        Intent in = new Intent(this, qlmh.class);
        if (db.GetCount("select * from MonHoc where MaMH='" + edtxoamh.getText().toString().trim() + "'  ") == 0) {
            Toast.makeText(this, "Mã môn học chưa có. Vui lòng chọn mã khác!", Toast.LENGTH_LONG).show();
        } else {
            db.executeSQL("delete from MonHoc where MaMH='" + edtxoamh.getText().toString().trim() + "'");
            db.executeSQL("delete from PhanCong where MaMH='" + edtxoamh.getText().toString().trim() + "'");
            Toast.makeText(this, "Bản ghi đã được xóa!", Toast.LENGTH_LONG).show();
            edtxoamh.setText("");
            startActivity(in);
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
