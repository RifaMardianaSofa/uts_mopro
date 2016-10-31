package hope.ami.pemesanancake;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    SessionManager session;
    int[] gambar={
            R.drawable.froyo_logo,
            R.drawable.gingerbread_logo,
            R.drawable.ice_cream_sandwich_logo,
            R.drawable.jelly_bean_logo,
    };

    ListView list;

    String[] judul ={
            "Tiramisu",
            "BearCake",
            "CreamCake",
            "JellyCake	",

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new SessionManager(getApplicationContext());
        Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();
        session.checkLogin();
        // Inisialisasi CustomAdapter dengan Array yang telah dibuat
        CustomAdapter adapter = new CustomAdapter(this, gambar, judul);

        // Inisialisasi ListView
        list = (ListView) findViewById(R.id.ListGambar);

        // set Adapter ke dalam ListView
        list.setAdapter(adapter);

        // action ketika ListView di klik
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub

                // String untuk mengambil judul pada Listview
                String Selecteditem = judul[position];
                String apa = Selecteditem;
                Intent iOri= new Intent(MainActivity.this, PesanCake.class);
                iOri.putExtra("param",apa);
                startActivity(iOri);
                finish();



                // menampilkan judul dengan Toast
                Toast.makeText(getApplicationContext(), Selecteditem, Toast.LENGTH_SHORT).show();

            }
        });

    }
}
