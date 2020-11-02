package com.example.qlgv.listgiaovien;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.qlgv.DatabaseHandler;
import com.example.qlgv.Object.giaovien;
import com.example.qlgv.R;
import com.example.qlgv.menu;
import java.util.ArrayList;
public class qlgv extends AppCompatActivity {
    DatabaseHandler db = new DatabaseHandler(this);
    ListView lv;
    ArrayList<giaovien> arrList = null;
    ArrayAdapter<giaovien> adap = null;
    int ps;
    ImageButton ibttimkiem;
    EditText edttimkiem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qlgv);
        db.copyDB2SDCard();
        int sbg = db.GetCount( "SELECT * FROM GiaoVien" );
         Toast.makeText( this, "số bản ghi:" + sbg, Toast.LENGTH_SHORT ).show();
        lv = findViewById(R.id.lvdanhsachgv);
        ibttimkiem = findViewById(R.id.imbtimkiemgv);
        edttimkiem =  findViewById(R.id.edttimkiemgv);
        //back tren ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        db.copyDB2SDCard();
       DB2ListView();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(qlgv.this, hienthigv.class);
                intent.putExtra("MaGV", arrList.get(position).getMaGV().toString());
                startActivity(intent);

            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                ps = position;
                return false;
            }
        });

    }
    //Phương thức 5: Load dữ liệu lên ListView
    public void DB2ListView() {
        giaovien row;
        arrList = new ArrayList<giaovien>();
        Cursor c = db.getCursor("select * from GiaoVien");
        Toast.makeText(this, "Số giáo viên: " + c.getCount(), Toast.LENGTH_SHORT).show();
        c.moveToFirst();
        while (!c.isAfterLast()){
            row = new giaovien();
            row.maGV = c.getString(0);
            row.hoten = c.getString(1);
            row.gioitinh = c.getString(2);
            row.ngaysinh = c.getString(3);
            row.sdt = c.getString(4);
            row.email = c.getString(5);
            row.diachi = c.getString(6);
            row.bangcap = c.getString(7);
            row.cmnd = c.getString(8);
            row.trinhdo = c.getString(9);
            row.matobomon = c.getString(10);
            arrList.add(row);
            c.moveToNext()     ;
        }
        adap = new ArrayAdapter<giaovien>(this, android.R.layout.simple_list_item_1, arrList);
        lv.setAdapter(adap);
        adap.notifyDataSetChanged();
        c.close();
        registerForContextMenu( lv );
    }
    public void TimKiem(View v) {
        giaovien row;
        if (db.GetCount("select * from GiaoVien where MaGV like '%" + edttimkiem.getText().toString().trim() + "%'  or  HoTen like '%" + edttimkiem.getText().toString().trim() + "%'") == 0) {
            Toast.makeText(this, "Thông tin chưa tồn tại. Vui lòng nhập lại!", Toast.LENGTH_LONG).show();
        } else {
            arrList = new ArrayList<giaovien>();
            Cursor c = db.getCursor("select * from GiaoVien where MaGV like '%" + edttimkiem.getText().toString().trim() + "%'  or  HoTen like '%" + edttimkiem.getText().toString().trim() + "%'");
            //tro con chuot tu dau den cuoi
            c.moveToFirst();
            do {
                row = new giaovien();
                row.maGV = c.getString(0);
                row.hoten = c.getString(1);
                row.gioitinh = c.getString(2);
                row.ngaysinh = c.getString(3);
                row.sdt = c.getString(4);
                row.diachi = c.getString(5);
                row.email = c.getString(6);
                row.bangcap = c.getString(7);
                row.trinhdo = c.getString(9);
                row.cmnd = c.getString(8);
                row.matobomon = c.getString(10);
                arrList.add(row);
            } while (c.moveToNext());
            // den con tro tiep theo
            adap = new ArrayAdapter<giaovien>(this, android.R.layout.simple_list_item_1, arrList);
            lv.setAdapter(adap);
        }
    }
    //nut back
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent in = new Intent(this, menu.class);
            startActivity(in);
        }
        return super.onOptionsItemSelected(item);
    }
    public void nhapthongtingv(View view) {
        Intent in = new Intent(view.getContext(), themgv.class);
        startActivity(in);
    }
    public void xoathongtingv(View view) {
        Intent in = new Intent(view.getContext(), xoagv.class);
        startActivity(in);
    }
    public void capnhapthongtingv(View view) {
        Intent in = new Intent(view.getContext(), suagv.class);
        startActivity(in);
    }
}
