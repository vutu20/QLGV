package com.example.qlgv;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtuser, edtpassword;
    Button btdangnhap, btthoat;
    String ten, matkhau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        taosk();
    }

    public void Anhxa() {
        edtuser =  findViewById(R.id.edttaikhoan);
        edtpassword =  findViewById(R.id.edtmatkhau);
        btdangnhap =  findViewById(R.id.btnok);
        btthoat =  findViewById(R.id.btnthoat);
    }

    public void taosk() {
        btthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Bạn có chắc muốn thoát khỏi ứng dụng?");
                builder.setMessage("Bấm vào bên dưới để xác nhận!");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                //Tạo biến mới để bắt sự kiện
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);//Thoát khỏi áp
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.show();
            }
        });
        btdangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, menu.class);
                //Kiểm tra tài khoản, mật khẩu đã có ký tự nào chưa
                if (edtuser.getText().length() != 0 && edtpassword.getText().length() != 0) {
                    //Kiểm tra xem đúng tên tài khoản, mật khẩu người dùng hay không
                    if (edtuser.getText().toString().equals(ten) && edtpassword.getText().toString().equals(matkhau)) {
                        //Hiển thị thông báo chuỗi trên màn hình chính
                        Toast.makeText(MainActivity.this, "Bạn đã đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                        //Câu lệnh chuyển màn hình
                        startActivity(intent);
                    } else if (edtuser.getText().toString().equals("admin") && edtpassword.getText().toString().equals("admin")) {
                        //Hiển thị thông báo chuỗi trên màn hình chính
                        Toast.makeText(MainActivity.this, "Bạn đã đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                        //Câu lệnh chuyển màn hình, từ màn hình chính sang màn hình mong muốn
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Bạn đã đăng nhập thất bại!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Mời bạn nhập đủ thông tin cần thiết để đăng nhập!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
