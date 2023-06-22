package com.example.retrofitdemo.Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.retrofitdemo.R;
import com.example.retrofitdemo.Models.Register_user;
import com.example.retrofitdemo.Fragments.Retro_Instance_Class;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Retro_Instance_Class.CallApi().RegisterUser("mahesh","mahesh@gmail.com","12345").enqueue(new Callback<Register_user>() {
            @Override
            public void onResponse(Call<Register_user> call, Response<Register_user> response)
            {
                Log.d("TTT","onResponse: Response="+response.body().toString());
                if (response.body().getConnection()==1)
                {
                    if (response.body().getResult()==1)
                    {
                        Toast.makeText(MainActivity.this, "Successfully Registered", Toast.LENGTH_LONG).show();
                    }
                    else if (response.body().getResult()==2)
                    {
                        Toast.makeText(MainActivity.this, "Already Registered", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
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
                Log.e("TTT","onResponse: Response="+t.getLocalizedMessage());
            }
        });
    }
}