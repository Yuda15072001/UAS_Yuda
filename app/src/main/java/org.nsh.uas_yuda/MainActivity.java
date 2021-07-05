package org.nsh.uas_yuda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText inputCode, inputJumlah;
    private TextView nama_barang, harga_barang, total_harga;

    private final Object[][] barang = {
            {"B001", "Pena", 2000},
            {"B002", "Buku", 4000},
            {"B003", "Pensil", 1000},
            {"B004", "Map", 3000},
            {"B005", "Penggaris", 7000},
            {"B006", "Penghapus", 3000},
            {"B007", "Meja Belajar", 30000},
            {"B008", "Spidol", 8000},
            {"B009", "Gunting", 6000},
            {"B010", "Fotocoy/lembar", 250}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_barang);
    }
    public void input(View view) {
        setContentView(R.layout.uas);

        inputCode = findViewById(R.id.etKodeBarang);
        inputJumlah = findViewById(R.id.etJumlahBarang);
        Button btnBayar = findViewById(R.id.btnKalkulasi);
        nama_barang = findViewById(R.id.tvNama_Barang);
        harga_barang = findViewById(R.id.tvHarga_Barang);
        total_harga = findViewById(R.id.tvTotal_Harga);

        btnBayar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnKalkulasi) {
            String itemInput = inputCode.getText().toString().trim();
            String itemTotal = inputJumlah.getText().toString().trim();
            String itemCode = itemInput.substring(0,4);


            //nomor item array
            int i, noItem = 0;
            for (i = 0; i <10; i++) {
                if (itemCode.equals((barang[i][0].toString()))) {
                    noItem = i;
                    i = 6;
                }
            }

            //
            String itemName = barang[noItem][1].toString();
            String itemPrice = barang[noItem][2].toString();
            String totalPrice = String.valueOf(Integer.parseInt(itemPrice) * Integer.parseInt(itemTotal));

            nama_barang.setText(itemName);
            harga_barang.setText(itemPrice);
            total_harga.setText(totalPrice);
        }
    }
}