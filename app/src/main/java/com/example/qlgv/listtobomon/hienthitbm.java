package com.example.qlgv.listtobomon;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.qlgv.DatabaseHandler;
import com.example.qlgv.Object.tobomon;
import com.example.qlgv.R;
public class hienthitbm  extends AppCompatActivity {
    String matbm;
    DatabaseHandler db = new DatabaseHandler(this);
    TextView txtmatbm, txttentbm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hienthitbm);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        txtmatbm =  findViewById(R.id.txttbm);
        txttentbm =  findViewById(R.id.txttentbm);
        Bundle bundle = getIntent().getExtras();
        matbm = bundle.getString("MaTBM");
        Cursor cursor = db.getCursor("select * from ToBoMon where MaTBM='" + matbm + "'");
        if (cursor.moveToFirst()) {
            tobomon tbm = new tobomon();
            tbm.setMatbm(cursor.getString(0));
            tbm.setTentbm(cursor.getString(1));
            txtmatbm.setText("" + tbm.getMatbm());
            txttentbm.setText("" + tbm.getTentbm());
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
