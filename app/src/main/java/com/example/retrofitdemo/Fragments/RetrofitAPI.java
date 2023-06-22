package com.example.retrofitdemo.Fragments;

import com.example.retrofitdemo.Models.Register_user;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitAPI
{
    @FormUrlEncoded
    @POST("Register.php")
    Call<Register_user> RegisterUser(@Field("name") String name, @Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("login.php")
    Call<Register_user> RegisterUser( @Field("email") String email, @Field("password") String password);


}