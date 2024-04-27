package com.example.coderunners;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login2 extends AppCompatActivity {

    EditText emailView,passView;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mAuth = FirebaseAuth.getInstance();
        emailView=findViewById(R.id.emailText);
        passView=findViewById(R.id.passwordText);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

      /*  if(user != null){
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        } */
    }
    public void RegisterActivity(View view) {
        Intent intent=new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }

    public void LoginAccount(View view)
    {
        String email=emailView.getText().toString();
        String password=emailView.getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(getApplicationContext(),"Login successful!", Toast.LENGTH_LONG).show();
                            Intent intent= new Intent(view.getContext(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(
                                    getApplicationContext(),
                                    "Login failed!!"
                                            + " Please try again",
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    }
                });

    }
}