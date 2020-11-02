package com.example.qlgv.listphancong;

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
import com.example.qlgv.Object.phancong;
import com.example.qlgv.R;
import com.example.qlgv.menu;

import java.util.ArrayList;

public class qlpcgd extends AppCompatActivity {

    ArrayList<phancong> arrList = null;
    ArrayAdapter<phancong> adap = null;
    ListView lv;
    DatabaseHandler db = new DatabaseHandler(this);
    EditText edttimkiempcgd;
    int ps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qlpcgd);
        db.copyDB2SDCard();
        int sbg = db.GetCount( "SELECT * FROM PhanCongGiangDay" );
        Toast.makeText( this, "số bản ghi:" + sbg, Toast.LENGTH_SHORT ).show();
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            edttimkiempcgd=(EditText)findViewById(R.id.edttimkiempcgd);
            lv = (ListView) findViewById(R.id.lvdanhsachpcgd);
        }
        db.copyDB2SDCard();
        //Gọi phương thức
        DB2ListView();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(qlpcgd.this, hienthipcgd.class);
                intent.putExtra("MaGV", arrList.get(position).getMaGV1().toString());
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
        phancong row;
        arrList = new ArrayList<phancong>();
        Cursor c = db.getCursor("select * from PhanCongGiangDay");
        Toast.makeText(this, "Số bản ghi : " + c.getCount(), Toast.LENGTH_LONG).show();
        c.moveToFirst();
        while (!c.isAfterLast()){
            row = new phancong();
            row.maGV1 = c.getString(0);
            row.maMH1 = c.getString(1);
            row.malop1 = c.getString(2);
            row.hocky = c.getString(3);
            row.namhoc = c.getString(4);
            arrList.add(row);
            c.moveToNext()     ;
        }
        adap = new ArrayAdapter<phancong>(this, android.R.layout.simple_list_item_1, arrList);
        lv.setAdapter(adap);
        adap.notifyDataSetChanged();
        c.close();
        registerForContextMenu( lv );
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent in = new Intent(this, qlpcgd.class);
            startActivity(in);
        }
        return super.onOptionsItemSelected(item);
    }

    public void nhapthongtinpcgd(View view) {
        Intent in= new Intent(view.getContext(), thempcgd.class);//hien thi class duoc goi
        startActivity(in);
    }
    public void capnhapthongtinpcgd(View view) {
        Intent in= new Intent(view.getContext(), suapcgd.class);//hien thi class duoc goi
        startActivity(in);
    }
    public void xoathongtinpcgd(View view) {
        Intent in= new Intent(view.getContext(), xoapcgd.class);//hien thi class duoc goi
        startActivity(in);
    }
    public void TimKiempcgd(View v) {
        phancong row;
        if (db.GetCount("select * from PhanCongGiangDay where MaGV like '%" + edttimkiempcgd.getText().toString().trim() + "%'  or  MaMH like '%" + edttimkiempcgd.getText().toString().trim() + "%'") == 0) {
            Toast.makeText(this, "Thông tin chưa tồn tại. Vui lòng nhập lại!", Toast.LENGTH_LONG).show();
        } else {
            arrList = new ArrayList<phancong>();
            Cursor c = db.getCursor("select * from PhanCongGiangDay where MaGV like '%" + edttimkiempcgd.getText().toString().trim() + "%'  or  MaMH like '%" + edttimkiempcgd.getText().toString().trim() + "%'");
            //tro con chuot tu dau den cuoi
            c.moveToFirst();
            do {
                row = new phancong();
                row.maGV1 = c.getString(0);
                row.maMH1 = c.getString(1);
                row.malop1 = c.getString(2);
                row.hocky = c.getString(3);
                row.namhoc = c.getString(4);
                arrList.add(row);
            } while (c.moveToNext());
            // den con tro tiep theo
            adap = new ArrayAdapter<phancong>(this, android.R.layout.simple_list_item_1, arrList);
            lv.setAdapter(adap);
        }
    }
}
