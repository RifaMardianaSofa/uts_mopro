package hope.ami.pemesanancake;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by acer on 10/28/2016.
 */

public class PesanCake extends AppCompatActivity {
    Intent tangkap;
    TextView txtNamaCake;
    @BindView(R.id.txtNamaCake) TextView _txtNamaCake;
    @BindView(R.id.edtTujuan) EditText _edtTujuan;
    @BindView(R.id.edtPesan) EditText _edtPesan;
    @BindView(R.id.edtPengirim) EditText _edtPengirim;
    @BindView(R.id.btnSubmit) Button _Submit;
    String cake, pesan, to, pengirim;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan);
        ButterKnife.bind(this);
        tangkap = getIntent();
        String paramHasil = tangkap.getStringExtra("param");
        txtNamaCake = (TextView) findViewById(R.id.txtNamaCake);
        txtNamaCake.setText(paramHasil);
        _Submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                cake= _txtNamaCake.getText().toString();
                pesan= _edtPesan.getText().toString();
                to= _edtTujuan.getText().toString();
                pengirim= _edtPengirim.getText().toString();

                Bundle c = new Bundle();
                c.putString("kirimCake",cake);
                c.putString("kirimPesan",pesan);
                c.putString("kirimTo",to);
                c.putString("kirimPengirim",pengirim);

                Intent a = new Intent(PesanCake.this, HasilUcapan.class);
                a.putExtras(c);
                startActivity(a);
            }
        });
    }
}