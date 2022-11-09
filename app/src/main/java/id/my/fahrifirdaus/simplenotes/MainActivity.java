package id.my.fahrifirdaus.simplenotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView txtJudul;
    SharedPreferences pref;

    Gson gson;
    ArrayList<Notes> noteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtJudul = findViewById(R.id.txtJudul);
        pref = this.getSharedPreferences("KeyData", Context.MODE_PRIVATE);

        String username = pref.getString("KeyUser", "-");
        txtJudul.setText("Catatan: "+username);

        gson = new GsonBuilder().create();
    }

    @Override
    protected void onResume() {
        super.onResume();
        String strNotes = pref.getString("Catatan", "[]");
        noteList = gson.fromJson(strNotes, new TypeToken<ArrayList<Notes>>(){}.getType());

        TextView txtKonten = findViewById(R.id.txtShowNotes);
        String konten = "";
        for (Notes note : noteList){
            konten += "==============\n";
            konten += note.judul;
            konten += "\n---\n";
            konten += note.konten;
            konten += "\n==============\n";
        }
        txtKonten.setText(konten);
    }

    public void  logout(View v){
        pref.edit().clear().apply();

        Intent it = new Intent(this, LoginActivity.class);
        it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(it);
    }

    public void  addNotes(View v){
        Intent it = new Intent(this, NewNotesActivity.class);
        startActivity(it);
    }
}