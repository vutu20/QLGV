package com.example.qlgv.listmonhoc;

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
import com.example.qlgv.R;
import com.example.qlgv.menu;

import java.util.ArrayList;
public class qlmh extends AppCompatActivity {
    DatabaseHandler db = new DatabaseHandler(this);
    ArrayList<monhoc> arrList = null;
    ArrayAdapter<monhoc> adap = null;
    EditText edttimkiemmh;
    ListView lv;
    int ps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qlmh);
        db.copyDB2SDCard();
        int sbg = db.GetCount( "SELECT * FROM MonHoc" );
        Toast.makeText( this, "số bản ghi:" + sbg, Toast.LENGTH_SHORT ).show();
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        edttimkiemmh = (EditText) findViewById(R.id.edttimkiemmh);
        lv = (ListView) findViewById(R.id.lvdanhsachmh);
        db.copyDB2SDCard();
        DB2ListView();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(qlmh.this, hienthimh.class);
                Bundle bundle = new Bundle();
                bundle.putString("MaMH", arrList.get(position).mamh);
                intent.putExtras(bundle);
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
        monhoc row;
        arrList = new ArrayList<monhoc>();
        Cursor c = db.getCursor("select * from MonHoc");
        Toast.makeText(this, "Số môn học: " + c.getCount(), Toast.LENGTH_SHORT).show();
        c.moveToFirst();
        while (!c.isAfterLast()){
            row = new monhoc();
            row.mamh = c.getString(0);
            row.tenmh = c.getString(1);
            row.sotet = c.getString(2);
            arrList.add(row);
            c.moveToNext()     ;
        }
        adap = new ArrayAdapter<monhoc>(this, android.R.layout.simple_list_item_1, arrList);
        lv.setAdapter(adap);
        adap.notifyDataSetChanged();
        c.close();
        registerForContextMenu( lv );
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            Intent in = new Intent(this, qlmh.class);
            startActivity(in);
        }
        return super.onOptionsItemSelected(item);
    }
    public void nhapthongtinmh(View view) {
        Intent in = new Intent(view.getContext(), themmh.class);//hien thi class duoc goi
        startActivity(in);
    }
    public void capnhapthongtinmh(View view) {
        Intent in = new Intent(view.getContext(), suamh.class);//hien thi class duoc goi
        startActivity(in);
    }
    public void xoathongtinmh(View view) {
        Intent in = new Intent(view.getContext(), xoamh.class);//hien thi class duoc goi
        startActivity(in);
    }
    public void TimKiemmh(View v) {
        monhoc row;
        if (db.GetCount("select * from MonHoc where MaMH like '%" + edttimkiemmh.getText().toString().trim() + "%'  or  TenMH like '%" + edttimkiemmh.getText().toString().trim() + "%'") == 0) {
            Toast.makeText(this, "Thông tin chưa tồn tại. Vui lòng nhập lại!", Toast.LENGTH_LONG).show();
        } else {
            arrList = new ArrayList<monhoc>();
            Cursor c = db.getCursor("select * from MonHoc where MaMH like '%" + edttimkiemmh.getText().toString().trim() + "%'  or  TenMH like '%" + edttimkiemmh.getText().toString().trim() + "%'");
            //tro con chuot tu dau den cuoi
            c.moveToFirst();
            do {
                row = new monhoc();
                row.mamh = c.getString(0);
                row.tenmh = c.getString(1);
                row.sotet = c.getString(2);
                arrList.add(row);
            } while (c.moveToNext());
            // den con tro tiep theo
            adap = new ArrayAdapter<monhoc>(this, android.R.layout.simple_list_item_1, arrList);
            lv.setAdapter(adap);
        }
    }
}
