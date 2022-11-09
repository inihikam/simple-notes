package id.my.fahrifirdaus.simplenotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText edtUsername;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername = findViewById(R.id.edtUsername);
        pref = this.getSharedPreferences("KeyData", Context.MODE_PRIVATE);

        String username = pref.getString("KeyUser", "-");
        if (!username.equals("-")){
            Intent it = new Intent(this, MainActivity.class);
            it.addFlags((Intent.FLAG_ACTIVITY_CLEAR_TASK) | (Intent.FLAG_ACTIVITY_NEW_TASK));
            startActivity(it);
        }
    }

    public void login(View v){
        String username = edtUsername.getText().toString();
        pref.edit().putString("KeyUser", username).apply();

        Intent it = new Intent(this, MainActivity.class);
        it.addFlags((Intent.FLAG_ACTIVITY_CLEAR_TASK) | (Intent.FLAG_ACTIVITY_NEW_TASK));
        startActivity(it);
    }
}