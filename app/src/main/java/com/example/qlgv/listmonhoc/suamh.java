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

public class suamh extends AppCompatActivity {
    DatabaseHandler db = new DatabaseHandler(this);
    EditText edtmamh, edttenmh, edtsotiet;
Button update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.suamh);
        //back tren ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        edtmamh =  findViewById(R.id.edtmamh);
        edttenmh = findViewById(R.id.edttenmh);
        edtsotiet =  findViewById(R.id.edtsotiet);
        update=findViewById(R.id.btnsuamh);
        event();
    }
    public void event() {
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Suamh();
            }
        });
    }
    //Sua
    public void Suamh()
    {
        Intent in = new Intent(this, qlmh.class);
        if(!(edtmamh.getText().toString().equals("")||edttenmh.getText().toString().equals("")||edtsotiet.getText().toString().equals("")
                ||edtmamh.length()!=3)) {
            if (db.GetCount("select * from MonHoc where MaMH='" + edtmamh.getText().toString().trim() + "'  ") == 0) {
                Toast.makeText(this, "Mã chưa có. Vui lòng chọn mã khác!", Toast.LENGTH_LONG).show();
            } else {
                db.executeSQL("update MonHoc set TenMH ='" + edttenmh.getText().toString().trim() + "' where MaMH='" + edtmamh.getText().toString().trim() + "'");
                db.executeSQL("update MonHoc set SoTiet ='" + edtsotiet.getText().toString().trim() + "' where MaMH='" + edtmamh.getText().toString().trim() + "'");
                Toast.makeText(this, "Bản ghi được cập nhật vào CSDL!", Toast.LENGTH_LONG).show();
                edtmamh.setText("");
                edttenmh.setText("");
                edtsotiet.setText("");
                startActivity(in);
            }
        }else {
            Toast.makeText(suamh.this,"Thông tin nhập chưa đủ hoặc sai! vui lòng nhập lại",Toast.LENGTH_SHORT).show();
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
