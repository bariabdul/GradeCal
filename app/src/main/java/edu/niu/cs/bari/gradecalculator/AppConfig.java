package edu.niu.cs.bari.gradecalculator;

import com.google.gson.JsonElement;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;

public class AppConfig
    {

    public interface database {
        @FormUrlEncoded
        @POST("/insert")
        void grades(
                @Field("quiz") Integer quiz,
                @Field("assignment") Integer assignment,
                Callback<Response> callback);
    }
    }
