package com.example.qlgv.listlop;

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

public class sualop extends AppCompatActivity {
    DatabaseHandler db = new DatabaseHandler(this);
    EditText edtmalop, edttenlop;
Button update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        setContentView(R.layout.sualop);
        edtmalop =  findViewById(R.id.edtmalop);
        edttenlop = findViewById(R.id.edttenlop);
        update=findViewById(R.id.btnsualop);
        event();
    }
    public void event() {
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sualop();
            }
        });
    }
    //Sua
    public void sualop()
    {
        Intent in = new Intent(this, qllop.class);
        if (db.GetCount("select * from Lop where MaLop='"+ edtmalop.getText().toString().trim() +"'  ")==0) {
            Toast.makeText(this, "Mã chưa có. Vui lòng chọn mã khác!", Toast.LENGTH_LONG).show();
        } else {
            db.executeSQL("update lop set TenLop ='" + edttenlop.getText().toString().trim() + "' where MaLop='" + edtmalop.getText().toString().trim() + "'");
            Toast.makeText(this, "Bản ghi được cập nhật vào CSDL!", Toast.LENGTH_LONG).show();
            edtmalop.setText("");
            edttenlop.setText("");
            startActivity(in);
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            Intent in = new Intent(this, qllop.class);
            startActivity(in);
        }
        return super.onOptionsItemSelected(item);
    }
}
