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
public class suatbm extends AppCompatActivity {
    DatabaseHandler db = new DatabaseHandler(this);
    EditText edtmatbm, edttentbm;
Button update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        setContentView(R.layout.suatbm);
        edtmatbm =  findViewById(R.id.edtmatbm);
        edttentbm =  findViewById(R.id.edttentbm);
        update=findViewById(R.id.btnsuatbm);
        event();
    }
    public void event() {
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                suatbm();
            }
        });
    }
    //Sua
    public void suatbm()
    {
        Intent in = new Intent(this, qltbm.class);
        if (db.GetCount("select * from ToBoMon where MaTBM='"+ edtmatbm.getText().toString().trim() +"'  ")==0) {
            Toast.makeText(this, "Mã chưa có. Vui lòng chọn mã khác!", Toast.LENGTH_LONG).show();
        } else {
            db.executeSQL("update ToBoMon set TenTBM ='" + edttentbm.getText().toString().trim() + "' where MaTBM='" + edtmatbm.getText().toString().trim() + "'");
            Toast.makeText(this, "Bản ghi được cập nhật vào CSDL!", Toast.LENGTH_LONG).show();
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
