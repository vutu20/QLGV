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
public class xoalop extends AppCompatActivity {
    DatabaseHandler db = new DatabaseHandler(this);
    EditText edtxoalop;
    Button delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xoalop);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        edtxoalop =  findViewById(R.id.edtxoalop);
        delete=findViewById(R.id.btnxoalop);
        event();
    }
    public void event() {
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Xoalop();
            }
        });
    }
    public void Xoalop() {
        Intent in = new Intent(this, qllop.class);
        if (db.GetCount("select * from Lop where MaLop='" + edtxoalop.getText().toString().trim() + "'  ") == 0) {
            Toast.makeText(this, "Mã lớp chưa có. Vui lòng chọn mã khác!", Toast.LENGTH_LONG).show();
        } else {
            db.executeSQL("delete from Lop where MaLop='" + edtxoalop.getText().toString().trim() + "'");
            Toast.makeText(this, "Bản ghi đã được xóa!", Toast.LENGTH_LONG).show();
            edtxoalop.setText("");
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
