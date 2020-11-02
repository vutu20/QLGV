package com.example.qlgv.listtobomon;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qlgv.DatabaseHandler;
import com.example.qlgv.Object.monhoc;
import com.example.qlgv.Object.tobomon;
import com.example.qlgv.R;
import com.example.qlgv.menu;

import java.util.ArrayList;
public class qltbm extends AppCompatActivity {
    ArrayList<tobomon> arrList = null;
    ArrayAdapter<tobomon> adap = null;
    int ps;
    DatabaseHandler db = new DatabaseHandler(this);
    ListView lv;
    EditText edttimkiemtbm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qltbm);
        db.copyDB2SDCard();
        int sbg = db.GetCount( "SELECT * FROM ToBoMon" );
        Toast.makeText( this, "số bản ghi:" + sbg, Toast.LENGTH_SHORT ).show();
        edttimkiemtbm=findViewById(R.id.edttimkiemtbm);
        lv=findViewById(R.id.lvdanhsachtbm);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        db.copyDB2SDCard();
        DB2ListView();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(qltbm.this, hienthitbm.class);
                intent.putExtra("MaTBM", arrList.get(position).getMatbm().toString());
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
    public void DB2ListView() {
        tobomon row;
        arrList = new ArrayList<tobomon>();
        Cursor c = db.getCursor("select * from ToBoMon");
        Toast.makeText(this, "Số tổ bộ môn: " + c.getCount(), Toast.LENGTH_SHORT).show();
        c.moveToFirst();
        while (!c.isAfterLast()){
            row = new tobomon();
            row.matbm = c.getString(0);
            row.tentbm = c.getString(1);
            arrList.add(row);
            c.moveToNext()     ;
        }
        adap = new ArrayAdapter<tobomon>(this, android.R.layout.simple_list_item_1, arrList);
        lv.setAdapter(adap);
        adap.notifyDataSetChanged();
        c.close();
        registerForContextMenu( lv );
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent in = new Intent(this, qltbm.class);
            startActivity(in);
        }
        return super.onOptionsItemSelected(item);
    }
    public void nhapthongtintbm(View view) {
        Intent in= new Intent(view.getContext(), themtbm.class);
        startActivity(in);
    }
    public void xoathongtintbm(View view) {
        Intent in= new Intent(view.getContext(), xoatbm.class);
        startActivity(in);
    }
    public void capnhapthongtintbm(View view) {
        Intent in= new Intent(view.getContext(), suatbm.class);
        startActivity(in);
    }
    public void TimKiemtbm(View v) {
        tobomon row;
        if (db.GetCount("select * from ToboMon where MaTBM like '%" + edttimkiemtbm.getText().toString().trim() + "%'  or  TenTBM like '%" + edttimkiemtbm.getText().toString().trim() + "%'") == 0) {
            Toast.makeText(this, "Thông tin chưa tồn tại. Vui lòng nhập lại!", Toast.LENGTH_LONG).show();
        } else {
            arrList = new ArrayList<tobomon>();
            Cursor c = db.getCursor("select * from ToBoMon where MaTBM like '%" + edttimkiemtbm.getText().toString().trim() + "%'  or  TenTBM like '%" + edttimkiemtbm.getText().toString().trim() + "%'");
            //tro con chuot tu dau den cuoi
            c.moveToFirst();
            do {
                row = new tobomon();
                row.matbm = c.getString(0);
                row.tentbm = c.getString(1);
                arrList.add(row);
            } while (c.moveToNext());
            // den con tro tiep theo
            adap = new ArrayAdapter<tobomon>(this, android.R.layout.simple_list_item_1, arrList);
            lv.setAdapter(adap);
        }
    }
}
