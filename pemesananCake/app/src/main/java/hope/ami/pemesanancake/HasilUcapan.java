package hope.ami.pemesanancake;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by acer on 10/31/2016.
 */

public class HasilUcapan extends AppCompatActivity {
    @BindView(R.id.textCake)
    TextView _tampilCake;
    @BindView(R.id.textTujuan)
    TextView _tampilTujuan;
    @BindView(R.id.textUcapan)
    TextView _tampilUcapan;
    @BindView(R.id.textPengirim)
    TextView _tampilPengirim;

    String cake, tujuan, ucapan, pengirim;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        ButterKnife.bind(this);
        Bundle c = getIntent().getExtras();

        cake = c.getString("kirimCake");
        tujuan = c.getString("kirimTo");
        ucapan = c.getString("kirimPesan");
        pengirim = c.getString("kirimPengirim");

        _tampilCake.setText(cake);
        _tampilTujuan.setText(tujuan);
        _tampilUcapan.setText(ucapan);
        _tampilPengirim.setText(pengirim);

        ImageView gambar = (ImageView) findViewById(R.id.img_gambar);
        if (_tampilCake.getText().equals("Tiramisu")) {
            gambar.setImageResource(R.drawable.froyo_logo);
        } else if (_tampilCake.getText().equals("BearCake")) {
            gambar.setImageResource(R.drawable.gingerbread_logo);
        } else if (_tampilCake.getText().equals("CreamCake")) {
            gambar.setImageResource(R.drawable.ice_cream_sandwich_logo);
        } else if (_tampilCake.getText().equals("JellyrCake")) {
            gambar.setImageResource(R.drawable.jelly_bean_logo);
        }
    }
}
