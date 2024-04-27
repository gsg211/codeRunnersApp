package com.example.coderunners;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.checkerframework.checker.nullness.qual.NonNull;

public class FormularActivity extends AppCompatActivity {


    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    EditText FirstNameView, LastNameView, CrediteView, MedieView;
    CheckBox Opt1View, Opt2View, Opt3View;

    Student student;

    TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_formular);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        FirstNameView=findViewById(R.id.nume_input);
        LastNameView=findViewById(R.id.prenume_input);
        CrediteView=findViewById(R.id.credite_input);
        MedieView=findViewById(R.id.medie_input);
        Opt1View=findViewById(R.id.opt1);
        Opt2View=findViewById(R.id.opt2);
        Opt3View=findViewById(R.id.opt3);
        res=findViewById(R.id.resultText);
    }

    public void mainActivity(View view)
    {
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void Send(View view)
    {
        String FirstName=FirstNameView.getText().toString();
        String LastName=LastNameView.getText().toString();
        double Credite=Double.parseDouble(CrediteView.getText().toString());
        double Medie=Double.parseDouble(MedieView.getText().toString());
        int opt=0;

        int Opt1,Opt2,Opt3;

        if(Opt1View.isChecked())
        {
            Opt1=1;
        }
        else
        {
            Opt1=0;
        }

        if(Opt2View.isChecked())
        {
            Opt2=1;
        }
        else
        {
            Opt2=0;
        }

        if(Opt3View.isChecked())
        {
            Opt3=1;
        }
        else
        {
            Opt3=0;
        }

        //Toast.makeText(getApplicationContext(),FirstName, Toast.LENGTH_LONG).show();

        if((Opt1==1)&& (Opt2==1) || (Opt1==1) && (Opt3==1) || (Opt2==1) && (Opt3==1))
        {
            Toast.makeText(getApplicationContext(),"Alege doar o optiune!", Toast.LENGTH_LONG).show();
            Intent intent= new Intent(this, FormularActivity.class);
            startActivity(intent);
        }
        else if (Opt1==0 && Opt2==0 && Opt3==0)
        {
            Toast.makeText(getApplicationContext(),"Alege ceva!", Toast.LENGTH_LONG).show();
            Intent intent= new Intent(this, FormularActivity.class);
            startActivity(intent);
        }
        else if(FirstName.isEmpty() || LastName.isEmpty() || Credite==0 || Medie==0)
        {
            Toast.makeText(getApplicationContext(),"Va rugam completati toate campurile!", Toast.LENGTH_LONG).show();
            Intent intent= new Intent(this, FormularActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"to be continued", Toast.LENGTH_LONG).show();
            Intent intent= new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        if(Opt1==1)
        {
            opt=1;
        }
        if(Opt1==2)
        {
            opt=2;
        }
        if(Opt1==3)
        {
            opt=3;
        }
        student= new Student(FirstName,LastName,Credite,Medie,opt);
        res.setText(student.toString());
    }

    public void AddToDb(String firstname, String lastname, double credits,double grade,int opt) {
        Student student=new Student(firstname,lastname,credits,grade,opt);

        mDatabase.setValue(student);
    }

    public void AddTodataBase(View view) {
        AddToDb("ionel","costel", 30,7.50,3);
        Toast.makeText(getApplicationContext(),"Write successful!", Toast.LENGTH_LONG).show();
    }


}


