package paixaoporti.com.br.sharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class ProfileActivity extends Activity {
    private static final String PREF_NAME = "LoginActivityPreferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
    }

    public void signOut(View view){
        SharedPreferences sp = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear().commit();

        finish();
    }
}
