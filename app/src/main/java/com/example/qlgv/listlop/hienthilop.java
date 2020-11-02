package com.example.qlgv.listlop;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.qlgv.DatabaseHandler;
import com.example.qlgv.Object.lop;
import com.example.qlgv.R;
public class hienthilop extends AppCompatActivity {
    String malop;
    DatabaseHandler db = new DatabaseHandler(this);
    TextView txtmalop, txttenlop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hienthilop);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        txtmalop =  findViewById(R.id.txtlop);
        txttenlop =  findViewById(R.id.tenlop);
        Bundle bundle = getIntent().getExtras();
        malop = bundle.getString("MaLop");
        Cursor cursor = db.getCursor("select * from Lop where MaLop='" + malop + "'");
        if (cursor.moveToFirst()) {
            lop l = new lop();
            l.setMalop(cursor.getString(0));
            l.setTenlop(cursor.getString(1));
            txtmalop.setText("" + l.getMalop());
            txttenlop.setText("" + l.getTenlop());
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
