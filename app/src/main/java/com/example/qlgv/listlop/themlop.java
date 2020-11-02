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
import com.example.qlgv.listtobomon.qltbm;

public class themlop extends AppCompatActivity {

    DatabaseHandler db = new DatabaseHandler(this);
    EditText edtmalop, edttenlop;
Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.themlop);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        edtmalop =  findViewById(R.id.edtmalop);
        edttenlop =  findViewById(R.id.edttenlop);
        add=findViewById(R.id.btnthemlop);
        event();
    }
    public void event() {
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Themlop();
            }
        });
    }
    public void Themlop() {
        Intent in = new Intent(this, qllop.class);
        if (db.GetCount("select * from Lop where MaLop='" + edtmalop.getText().toString().trim() + "'  ") == 1) {
            Toast.makeText(this, "Mã lớp đã tồn tại. Vui lòng chọn mã khác!", Toast.LENGTH_LONG).show();
        } else {
            db.executeSQL("Insert into Lop values('" + edtmalop.getText().toString().trim() + "','" + edttenlop.getText().toString().trim()+"')");
            Toast.makeText(this, "Bản ghi được thêm vào CSDL!", Toast.LENGTH_LONG).show();
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
