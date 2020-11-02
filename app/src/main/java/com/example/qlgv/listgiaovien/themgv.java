package com.example.qlgv.listgiaovien;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.qlgv.DatabaseHandler;
import com.example.qlgv.Object.giaovien;
import com.example.qlgv.R;
import java.util.ArrayList;
public class themgv extends AppCompatActivity {
    DatabaseHandler db = new DatabaseHandler(this);
    EditText edtmaGV, edthoten, edtgioitinh, edtnamsinh, edtsdt, edtdiachi, edtemail, edthocvi, edttrinhdo, edtcmnd, edttobomon;
    Button add;
    ArrayList<giaovien> arrList = null;
    ArrayAdapter<giaovien> adap = null;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.themgv);
        //back tren ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        edtmaGV = findViewById(R.id.edtmagv);
        edthoten = findViewById(R.id.edthoten);
        edtgioitinh = findViewById(R.id.edtgioitinh);
        edtnamsinh = findViewById(R.id.edtnamsinh);
        edtsdt = findViewById(R.id.edtsdt);
        edtemail = findViewById(R.id.edtemail);
        edtdiachi = findViewById(R.id.edtdiachi);
        edthocvi = findViewById(R.id.edthocvi);
        edttrinhdo = findViewById(R.id.edttrinhdo);
        edtcmnd = findViewById(R.id.edtcmnd);
        edttobomon = findViewById(R.id.edttobomon);
        add = findViewById(R.id.btnthemgv);
        lv = findViewById(R.id.lvdanhsachgv);
        event();
    }
    public void event() {
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Themgv();
            }
        });
    }
    //Thêm
    public void Themgv() {
        Intent in = new Intent(this, qlgv.class);
        if (!(edtmaGV.getText().toString().equals("") ||
                edthoten.getText().toString().equals("") ||
                edtnamsinh.getText().toString().equals("") ||
                edtgioitinh.getText().toString().equals("") ||
                edtsdt.getText().toString().equals("") ||
                edtdiachi.getText().toString().equals("") ||
                edtemail.getText().toString().equals("") ||
                edthocvi.getText().toString().equals("") ||
                edttrinhdo.getText().toString().equals("") ||
                edtcmnd.getText().toString().equals("") ||
                edttobomon.getText().toString().equals(""))) {
            if (db.GetCount("select * from GiaoVien where MaGV='" + edtmaGV.getText().toString().trim() + "'  ") == 1) {
                Toast.makeText(this, "Mã đã tồn tại. Vui lòng nhập mã khác!", Toast.LENGTH_LONG).show();
            } else {
                db.executeSQL("Insert into GiaoVien values('" + edtmaGV.getText().toString().trim() + "','" + edthoten.getText().toString().trim() + "','" + edtgioitinh.getText().toString().trim() +
                        "','" + edtnamsinh.getText().toString().trim() + "','" + edtsdt.getText().toString().trim() + "','"
                        + edtdiachi.getText().toString().trim() + "','" + edtemail.getText().toString().trim() + "','"
                        + edthocvi.getText().toString().trim() + "','" + edttrinhdo.getText().toString().trim() + "','" + edtcmnd.getText().toString().trim() +
                        "','" + edttobomon.getText().toString().trim() + "')");
                Toast.makeText(this, "Bản ghi được thêm vào CSDL!", Toast.LENGTH_LONG).show();
                edtmaGV.setText("");
                edthoten.setText("");
                edtnamsinh.setText("");
                edtgioitinh.setText("");
                edtsdt.setText("");
                edtdiachi.setText("");
                edtemail.setText("");
                edthocvi.setText("");
                edttrinhdo.setText("");
                edtcmnd.setText("");
                edttobomon.setText("");
            }
        } else {
            Toast.makeText(themgv.this, "Thông tin nhập lỗi! Mời nhập lại!", Toast.LENGTH_SHORT).show();
        }
        startActivity(in);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent in = new Intent(this, qlgv.class);
            startActivity(in);
        }
        return super.onOptionsItemSelected(item);
    }
}
