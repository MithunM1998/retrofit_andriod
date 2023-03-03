package com.example.retrofit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView;


    //public static String JSON_URL = "https://catfact.ninja";
  //ArrayList<userModel> userModels=new ArrayList<>();
    Call<userModel>  call;
    userModel userModel=new userModel();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);


        Retrofit retrofit = new Retrofit.Builder().baseUrl( "https://catfact.ninja/").addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

     call  = apiInterface.getUser();
       // Log.d("Mi",call+"retroffffffiiit");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadData();
            }
        });


    }

    public void loadData(){
        call.enqueue(new Callback <userModel>() {
            @Override
            public void onResponse(@NonNull Call<userModel> call, @NonNull Response<userModel> response) {
                //assert response.body() != null;
                userModel  userModels=  response.body();


                // assert mList != null;
                //assert mList != null;


                // Log.d("Mi", response.body());

                textView.setText(userModels.getsFact());
            }

            @Override
            public void onFailure(@NonNull Call<userModel> call, @NonNull Throwable t) {
                Toast.makeText(getApplicationContext(), "No data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}