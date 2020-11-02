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
public class suapcgd extends AppCompatActivity {
    DatabaseHandler db = new DatabaseHandler(this);
    EditText edtmagv1, edtmamh1, edthocky, edtnamhoc, edtlop;
Button update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.suapcgd);
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
        update=findViewById(R.id.btnsuapcgd);
        event();
    }
    public void event() {
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                suapcgd();
            }
        });
    }
    //Sua
    public void suapcgd()
    {
        Intent in = new Intent(this, qlpcgd.class);
        if (db.GetCount("select * from PhanCongGiangDay where MaGV='"+ edtmagv1.getText().toString().trim() +"'  ")==0) {
            Toast.makeText(this, "Mã chưa có. Vui lòng chọn mã khác!", Toast.LENGTH_LONG).show();
        } else {
            db.executeSQL("update PhanCongGiangDay set MaMH ='" + edtmamh1.getText().toString().trim() + "' where MaGV='" + edtmagv1.getText().toString().trim() + "'");
            db.executeSQL("update PhanCongGiangDay set MaLop ='" + edtlop.getText().toString().trim() + "' where MaGV='" + edtmagv1.getText().toString().trim() + "'");
            db.executeSQL("update PhanCongGiangDay set HocKy ='" + edthocky.getText().toString().trim() + "' where MaGV='" + edtmagv1.getText().toString().trim() + "'");
            db.executeSQL("update PhanCongGiangDay set NamHoc ='" + edtnamhoc.getText().toString().trim() + "' where MaGV='" + edtmagv1.getText().toString().trim() + "'");
            Toast.makeText(this, "Bản ghi được cập nhật vào CSDL!", Toast.LENGTH_LONG).show();
            edtmagv1.setText("");
            edtmamh1.setText("");
            edtlop.setText("");
            edthocky.setText("");
            edtnamhoc.setText("");
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
