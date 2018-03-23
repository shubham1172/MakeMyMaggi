package com.shubham1172.makemymaggi;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "HOME_ACTIVITY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void makeMyMaggi(View view){
        Snackbar.make(findViewById(R.id.home_layout),
                "Snack missing, so here's a snack-bar!",
                Snackbar.LENGTH_LONG).show();
    }

    public void signOut(View view){
        Log.d(TAG, "signOut called");
        FirebaseAuth.getInstance().signOut();
        finish();
    }
}
