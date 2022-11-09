package id.my.fahrifirdaus.simplenotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class NewNotesActivity extends AppCompatActivity {

    Gson gson;
    ArrayList<Notes> noteList;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_notes);

        gson = new GsonBuilder().create();
        pref = this.getSharedPreferences("KeyData", Context.MODE_PRIVATE);
    }

    public void saveNotes(View v){
        EditText edtJudul = findViewById(R.id.edtjudul);
        EditText edtKonten = findViewById(R.id.edtContent);

        Notes newNote = new Notes(edtJudul.getText().toString(),
                                    edtKonten.getText().toString());
        String strNotes = pref.getString("Catatan", "[]");
        noteList = gson.fromJson(strNotes, new TypeToken<ArrayList<Notes>>(){}.getType());
        if (noteList == null) noteList = new ArrayList<>();
        noteList.add(newNote);

        strNotes = gson.toJson(noteList);
        pref.edit().putString("Catatan", strNotes).apply();
        finish();
    }

    public void cancel(View v){
        finish();
    }
}