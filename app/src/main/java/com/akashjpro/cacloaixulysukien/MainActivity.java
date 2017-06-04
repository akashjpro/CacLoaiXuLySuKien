package com.akashjpro.cacloaixulysukien;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {

    EditText edtSoA, edtSoB;

    Button btnTru, btnNhan, btnChia, btnAn, btnThoat, btnDoiManHinhKhac;

    View.OnClickListener chiSeXuKien = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyTru();
            }

            
        });
        chiSeXuKien = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.btnNhan){
                    xuLyNhan();
                }
                else if(view.getId()==R.id.btnChia) {
                    xuLyChia();
                }
            }
        };
        btnNhan.setOnClickListener(chiSeXuKien);
        btnChia.setOnClickListener(chiSeXuKien);
        btnAn.setOnLongClickListener(this);
        btnThoat.setOnClickListener(new MyEvent());
    }

    private void xuLyChia() {
        int a = Integer.parseInt(edtSoA.getText().toString());
        int b = Integer.parseInt(edtSoB.getText().toString());
        int c = a / b;
        ShowToast("Thương = ", c);
    }

    private void xuLyNhan() {
        int a = Integer.parseInt(edtSoA.getText().toString());
        int b = Integer.parseInt(edtSoB.getText().toString());
        int c = a * b;
        ShowToast("Tích = ", c);
    }


    private void xuLyTru() {
        int a = Integer.parseInt(edtSoA.getText().toString());
        int b = Integer.parseInt(edtSoB.getText().toString());
        int c = a - b;
        ShowToast("Hiệu = ", c);
    }


    private void addControls() {
        edtSoA = (EditText) findViewById(R.id.txtSoA);
        edtSoB = (EditText) findViewById(R.id.txtSoB);

        btnTru  = (Button) findViewById(R.id.btnTru);
        btnNhan = (Button) findViewById(R.id.btnNhan);
        btnChia = (Button) findViewById(R.id.btnChia);
        btnAn   = (Button) findViewById(R.id.btnAn);
        btnThoat = (Button) findViewById(R.id.btnThoat);
        btnDoiManHinhKhac  = (Button) findViewById(R.id.btnDoiManHinh);

    }



    private void ShowToast(String thongBao, int giaTri) {
        Toast.makeText(MainActivity.this, thongBao + giaTri, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onLongClick(View view) {
        if(view.getId()==R.id.btnAn) {
            btnAn.setVisibility(View.INVISIBLE);
        }
        return false;
    }

    public void xuLyPhepCong(View view){
        int a = Integer.parseInt(edtSoA.getText().toString());
        int b = Integer.parseInt(edtSoB.getText().toString());

        int c = a + b;
        ShowToast("Tổng = ", c);
    }

    public class  MyEvent implements View.OnClickListener, View.OnLongClickListener{

        @Override
        public void onClick(View view) {
            if(view.getId()==R.id.btnThoat){
                finish();
            }
        }

        @Override
        public boolean onLongClick(View view) {
            return false;
        }
    }

    public void xuLyDoiManHinhKhac(View view){
        Button btnMoi = new Button(MainActivity.this){
            @Override
            public boolean performClick() {
                Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
                setContentView(R.layout.activity_main);

                addControls();
                addEvents();

                return super.performClick();
            }
        };

        btnMoi.setText("Quay về");
        btnMoi.setWidth(200);
        btnMoi.setHeight(200);

        setContentView(btnMoi);
    }
}
