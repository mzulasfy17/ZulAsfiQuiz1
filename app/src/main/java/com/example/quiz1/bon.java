package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class bon extends AppCompatActivity implements View.OnClickListener {
    DecimalFormat df = new DecimalFormat("#,###,##");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bon);
        DecimalFormat formt = new DecimalFormat("#,###.##");

       TextView name1 = findViewById(R.id.tvname1);
       TextView memberType = findViewById(R.id.tvmembertype);
       TextView itemcode = findViewById(R.id.tvitemcode);
       TextView namaBarang = findViewById(R.id.tvnamabarang);
        TextView harga = findViewById(R.id.tvharga);
        TextView total = findViewById(R.id.tvtotal);
        TextView discHarga = findViewById(R.id.tvdischarga);
        TextView discMember = findViewById(R.id.tvdiscmember);
        TextView TotalBayar = findViewById(R.id.tvtotalBayar);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button btnShare = findViewById(R.id.btnShare);

        btnShare.setOnClickListener(this);

        String kode = getIntent().getStringExtra("code");
        String namaB = getIntent().getStringExtra("nama");
        String hargab = getIntent().getStringExtra("harga");
        double totalb = getIntent().getDoubleExtra("totall",0);
        String diskon = getIntent().getStringExtra("diskon");
        double member = getIntent().getDoubleExtra("member", 0);
        double totals = getIntent().getDoubleExtra("total Semua", 0);
        String memberstr = getIntent().getStringExtra("memberstr");
        String name = getIntent().getStringExtra("NamaP");


        itemcode.setText(kode);
        namaBarang.setText(namaB);
        harga.setText(hargab);
        total.setText(formt.format(totalb));
        discHarga.setText(diskon);
        discMember.setText(formt.format(member));
        TotalBayar.setText(formt.format(totals));
        memberType.setText(memberstr);
        name1.setText(name);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnShare){
            shareContent();
        }
    }
    private void shareContent() {

        String kode = getIntent().getStringExtra("code");
        String namaB = getIntent().getStringExtra("nama");
        String hargab = getIntent().getStringExtra("harga");
        double totalb = getIntent().getDoubleExtra("totall",0);
        String diskon = getIntent().getStringExtra("diskon");
        double member = getIntent().getDoubleExtra("member", 0);
        double totals = getIntent().getDoubleExtra("total Semua", 0);
        String memberstr = getIntent().getStringExtra("memberstr");
        String name = getIntent().getStringExtra("NamaP");

        // Membuat pesan yang akan dibagikan
        String shareMessage = "Kode: " + kode + "\n" +
                "Nama Barang: " + namaB + "\n" +
                "Harga: " + hargab + "\n" +
                "Total: " + df.format(totalb) + "\n" +
                "Diskon Harga: " + diskon + "\n" +
                "Diskon Member: " + member + "\n" +
                "Total Bayar: " + df.format(totals) + "\n" +
                "Tipe Member: " + memberstr + "\n" +
                "Nama: " + name;

        // Membuat intent untuk berbagi
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);

        // Memunculkan dialog untuk memilih aplikasi yang ingin digunakan untuk berbagi
        startActivity(Intent.createChooser(shareIntent, "Bagikan dengan"));
    }
}