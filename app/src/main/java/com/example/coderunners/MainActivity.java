package com.example.coderunners;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity
{
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void formularactivity(View view)
    {
        Intent intent= new Intent(this, FormularActivity.class);
        startActivity(intent);
    }

    public void clasamentactivity(View view)
    {
        Intent intent1= new Intent(this, ClasamentActivity.class);
        startActivity(intent1);
    }

    public void LogOut(View view)
    {
        //mAuth.signOut();
        Intent intent= new Intent(this, login2.class);
        startActivity(intent);
    }
}