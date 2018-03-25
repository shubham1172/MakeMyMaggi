package com.shubham1172.makemymaggi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "HOME_ACTIVITY";
    private FirebaseDatabase mData;
    private Button makeButton;
    private TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mData = FirebaseDatabase.getInstance();
        mData.getReference().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    String key = child.getKey().toString();
                    String val = child.getValue().toString();
                    if (key.equals("order"))
                        if (val.equals("0"))
                            makeButton.setClickable(true);
                        else
                            makeButton.setClickable(false);
                    else
                        status.setText(val);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        makeButton = findViewById(R.id.make_maggi_button);
        status = findViewById(R.id.status_text);
    }

    public void makeMyMaggi(View view) {
        /** update stuff */
        mData.getReference("order").setValue(1);
    }

    public void signOut(View view) {
        Log.d(TAG, "signOut called");
        FirebaseAuth.getInstance().signOut();
        finish();
    }
}
