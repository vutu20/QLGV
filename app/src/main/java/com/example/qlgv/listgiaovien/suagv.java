package com.example.qlgv.listgiaovien;

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
public class suagv extends AppCompatActivity {
    DatabaseHandler db = new DatabaseHandler(this);
    EditText edtmaGV, edthoten, edtgioitinh, edtnamsinh, edtsdt, edtdiachi, edtemail, edthocvi, edttrinhdo, edtcmnd, edttobomon;
    Button upadte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.suagv);
        //back tren ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        upadte=findViewById(R.id.btnsuagv);
        edtmaGV =  findViewById(R.id.edtmagv);
        edthoten = findViewById(R.id.edthoten);
        edtgioitinh =  findViewById(R.id.edtgioitinh);
        edtnamsinh = findViewById(R.id.edtnamsinh);
        edtsdt =  findViewById(R.id.edtsdt);
        edtemail = findViewById(R.id.edtemail);
        edtdiachi =  findViewById(R.id.edtdiachi);
        edthocvi =  findViewById(R.id.edthocvi);
        edttrinhdo =  findViewById(R.id.edttrinhdo);
        edtcmnd =  findViewById(R.id.edtcmnd);
        edttobomon =  findViewById(R.id.edttobomon);
        event();
    }
    public void event() {
        upadte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Suagv();
            }
        });
    }
    public void Suagv() {
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
            if (db.GetCount("select * from GiaoVien where MaGV='" + edtmaGV.getText().toString().trim() + "'  ") == 0) {
                Toast.makeText(this, "Mã chưa tồn tại. Vui lòng chọn mã khác!", Toast.LENGTH_LONG).show();
            } else {
                db.executeSQL("update GiaoVien set HoTen ='" + edthoten.getText().toString().trim() + "' where MaGV='" + edtmaGV.getText().toString().trim() + "'");
                db.executeSQL("update GiaoVien set GioiTinh ='" + edtgioitinh.getText().toString().trim() + "' where MaGV='" + edtmaGV.getText().toString().trim() + "'");
                db.executeSQL("update GiaoVien set NgaySinh ='" + edtnamsinh.getText().toString().trim() + "' where MaGV='" + edtmaGV.getText().toString().trim() + "'");
                db.executeSQL("update GiaoVien set SDT ='" + edtsdt.getText().toString().trim() + "' where MaGV='" + edtmaGV.getText().toString().trim() + "'");
                db.executeSQL("update GiaoVien set Email ='" + edtemail.getText().toString().trim() + "' where MaGV='" + edtmaGV.getText().toString().trim() + "'");
                db.executeSQL("update GiaoVien set DiaChi ='" + edtdiachi.getText().toString().trim() + "' where MaGV='" + edtmaGV.getText().toString().trim() + "'");
                db.executeSQL("update GiaoVien set BangCap ='" + edthocvi.getText().toString().trim() + "' where MaGV='" + edtmaGV.getText().toString().trim() + "'");
                db.executeSQL("update GiaoVien set CMND ='" + edtcmnd.getText().toString().trim() + "' where MaGV='" + edtmaGV.getText().toString().trim() + "'");
                db.executeSQL("update GiaoVien set TrinhDo ='" + edttrinhdo.getText().toString().trim() + "' where MaGV='" + edtmaGV.getText().toString().trim() + "'");
                db.executeSQL("update GiaoVien set MaTBM ='" + edttobomon.getText().toString().trim() + "' where MaGV='" + edtmaGV.getText().toString().trim() + "'");
                Toast.makeText(this, "Bản ghi được cập nhật vào CSDL!", Toast.LENGTH_LONG).show();
                edtmaGV.setText("");
                edthoten.setText("");
                edtnamsinh.setText("");
                edtgioitinh.setText("");
                edtsdt.setText("");
                edtemail.setText("");
                edtdiachi.setText("");
                edthocvi.setText("");
                edtcmnd.setText("");
                edttrinhdo.setText("");
                edttobomon.setText("");
                startActivity(in);
            }
        } else {
            Toast.makeText(suagv.this, "Thông tin nhập lỗi! Mời nhập lại!", Toast.LENGTH_SHORT).show();
        }
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent in = new Intent(this, qlgv.class);
            startActivity(in);
        }
        return super.onOptionsItemSelected(item);
    }
}
