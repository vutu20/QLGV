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

public class themtbm extends AppCompatActivity {
    DatabaseHandler db = new DatabaseHandler(this);
    EditText edtmatbm, edttentbm;
Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.themtbm);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        edtmatbm =  findViewById(R.id.edtmatbm);
        edttentbm =  findViewById(R.id.edttentbm);
        add=findViewById(R.id.btnthemtbm);
        event();
    }
    public void event() {
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Themtbm();
            }
        });
    }
    public void Themtbm() {
        Intent in = new Intent(this, qltbm.class);
        if (db.GetCount("select * from ToBoMon where MaTBM='" + edtmatbm.getText().toString().trim() + "'  ") == 1) {
            Toast.makeText(this, "Mã tổ bộ môn đã tồn tại. Vui lòng chọn mã khác!", Toast.LENGTH_LONG).show();
        } else {
            db.executeSQL("Insert into ToBoMon values('" + edtmatbm.getText().toString().trim() + "','" + edttentbm.getText().toString().trim()+ "')");
            Toast.makeText(this, "Bản ghi được thêm vào CSDL!", Toast.LENGTH_LONG).show();
            edtmatbm.setText("");
            edttentbm.setText("");
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
