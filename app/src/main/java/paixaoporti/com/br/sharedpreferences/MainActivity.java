package paixaoporti.com.br.sharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
    // CONSTANTE PARA SETAR O NOME DP PREFERENCE
    private static final String PREF_NAME = "MainActivityPreferences";
    private int count1;

    private SharedPreferences.OnSharedPreferenceChangeListener callback = new SharedPreferences.OnSharedPreferenceChangeListener(){
        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            Log.i("Script", key+" updated");
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("Script", "MainActivity");

        // ACESSANDO O SHAREDPREFERENCE
        SharedPreferences sp1 = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        // SÓ GRAVA PRIMITIVOS
        count1 = sp1.getInt("count_1", 0);
        Log.i("Script", "COUNT 1: "+count1);
        // SETA O LISTENER
        sp1.registerOnSharedPreferenceChangeListener(callback);

    }

    @Override
    public void onStop() {
        super.onStop();

        SharedPreferences sp1 = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        count1 = sp1.getInt("count_1", 0);
        SharedPreferences.Editor editor = sp1.edit();
        editor.putInt("count_1", count1 + 1);
        editor.commit();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        SharedPreferences sp1 = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        sp1.unregisterOnSharedPreferenceChangeListener(callback);

		SharedPreferences.Editor editor = sp1.edit();
		editor.clear();
		editor.commit();

    }

}
