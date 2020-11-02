package com.example.qlgv.listmonhoc;

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

public class themmh extends AppCompatActivity {
    EditText edtmamh, edttenmh, edtsotiet;
    DatabaseHandler db = new DatabaseHandler(this);
Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.themmh);
        //back tren ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        edtmamh =  findViewById(R.id.edtmamh);
        edttenmh =  findViewById(R.id.edttenmh);
        edtsotiet =  findViewById(R.id.edtsotiet);
        add=findViewById(R.id.btnthemmh);
        event();
    }
    public void event() {
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Themmh();
            }
        });
    }
    //Thêm
    public void Themmh() {
        Intent in = new Intent(this, qlmh.class);
        if(!(edtmamh.getText().toString().equals("")||edttenmh.getText().toString().equals("")||edtsotiet.getText().toString().equals("")
                ||edtmamh.length()!=3)) {
            if (db.GetCount("select * from MonHoc where MaMH='" + edtmamh.getText().toString().trim() + "'  ") == 1) {
                Toast.makeText(this, "Mã môn học đã tồn tại. Vui lòng chọn mã khác!", Toast.LENGTH_LONG).show();
            } else {
                db.executeSQL("Insert into MonHoc values('" + edtmamh.getText().toString().trim() + "','" + edttenmh.getText().toString().trim() + "','" + edtsotiet.getText().toString().trim() + "')");
                Toast.makeText(this, "Bản ghi được thêm vào CSDL!", Toast.LENGTH_LONG).show();
                edtmamh.setText("");
                edttenmh.setText("");
                edtsotiet.setText("");
                startActivity(in);
            }
        }
        else {
            Toast.makeText(themmh.this,"Thông tin nhập chưa đủ hoặc sai! vui lòng nhập lại",Toast.LENGTH_SHORT).show();
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
