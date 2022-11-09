package id.my.fahrifirdaus.simplenotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class NewNotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_notes);
    }

    public void saveNotes(View v){
        finish();
    }

    public void cancel(View v){
        finish();
    }
}