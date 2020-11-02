package com.example.qlgv.listlop;

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
import com.example.qlgv.Object.lop;
import com.example.qlgv.R;
import com.example.qlgv.menu;
import java.util.ArrayList;

public class qllop extends AppCompatActivity {

    ArrayList<lop> arrList = null;
    ArrayAdapter<lop> adap = null;
    int ps;
    DatabaseHandler db = new DatabaseHandler(this);
    ListView lv;
    EditText edttimkiemlop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qllop);
        db.copyDB2SDCard();
        int sbg = db.GetCount( "SELECT * FROM Lop" );
        Toast.makeText( this, "số bản ghi:" + sbg, Toast.LENGTH_SHORT ).show();
        edttimkiemlop=findViewById(R.id.edttimkiemlop);
        lv=findViewById(R.id.lvdanhsachlop);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        db.copyDB2SDCard();
        DB2ListView();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(qllop.this, hienthilop.class);
                intent.putExtra("MaLop", arrList.get(position).getMalop().toString());
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
        lop row;
        arrList = new ArrayList<lop>();
        Cursor c = db.getCursor("select * from Lop");
        Toast.makeText(this, "Số lớp: " + c.getCount(), Toast.LENGTH_SHORT).show();
        c.moveToFirst();
        while (!c.isAfterLast()){
            row = new lop();
            row.malop = c.getString(0);
            row.tenlop = c.getString(1);
            arrList.add(row);
        c.moveToNext()     ;
        }
    adap = new ArrayAdapter<lop>(this, android.R.layout.simple_list_item_1, arrList);
        lv.setAdapter(adap);
        adap.notifyDataSetChanged();
        c.close();
    registerForContextMenu( lv );
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            Intent in = new Intent(this, menu.class);
            startActivity(in);
        }
        return super.onOptionsItemSelected(item);
    }
    public void nhapthongtinlop(View view) {
        Intent in= new Intent(view.getContext(), themlop.class);//load giao dien them lop
        startActivity(in);
    }
    public void xoathongtinlop(View view) {
        Intent in= new Intent(view.getContext(), xoalop.class);//load giao dien xoa lop
        startActivity(in);
    }
    public void capnhapthongtinlop(View view) {
        Intent in= new Intent(view.getContext(), sualop.class);//load giao dien sua lop
        startActivity(in);
    }
    public void TimKiemlop(View v) {
        lop row;
        if (db.GetCount("select * from Lop where MaLop like '%" + edttimkiemlop.getText().toString().trim() + "%'  or  TenLop like '%" + edttimkiemlop.getText().toString().trim() + "%'") == 0) {
            Toast.makeText(this, "Thông tin chưa tồn tại. Vui lòng nhập lại!", Toast.LENGTH_LONG).show();
        } else {
            arrList = new ArrayList<lop>();
            Cursor c = db.getCursor("select * from Lop where MaLop like '%" + edttimkiemlop.getText().toString().trim() + "%'  or  TenLop like '%" + edttimkiemlop.getText().toString().trim() + "%'");
            //tro con chuot tu dau den cuoi
            c.moveToFirst();
            do {
                row = new lop();
                row.malop = c.getString(0);
                row.tenlop = c.getString(1);
                arrList.add(row);
            } while (c.moveToNext());
            // den con tro tiep theo
            adap = new ArrayAdapter<lop>(this, android.R.layout.simple_list_item_1, arrList);
            lv.setAdapter(adap);

        }
    }
}
