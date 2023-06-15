package com.example.retrofitdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
{
    EditText editname,editemail,editpassword;
    Button btnok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editname=findViewById(R.id.editname);
        editemail=findViewById(R.id.editemail);
        editpassword=findViewById(R.id.editePassword);
        btnok=findViewById(R.id.btmok);

        Retro_Instance_Class.CallApi().RegisterUser("shai","sha@gmail.com","123").enqueue(new Callback<Register_user>() {
            @Override
            public void onResponse(Call<Register_user> call, Response<Register_user> response) {
                Log.d("TTT", "onResponse: Response="+response.body().toString());
                if(response.body().getConnection()==1)
                {
                    if(response.body().getResult()==1)
                    {
                        Toast.makeText(MainActivity.this, "Successfully Registered", Toast.LENGTH_LONG).show();
                    }
                    else if(response.body().getResult()==2)
                    {
                        Toast.makeText(MainActivity.this, "Already Registered", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "User not Registered", Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Something went Wrong", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Register_user> call, Throwable t)
            {
                Log.e("TTT", "onResponse: Response="+t.getLocalizedMessage());
            }
        });
    }
}