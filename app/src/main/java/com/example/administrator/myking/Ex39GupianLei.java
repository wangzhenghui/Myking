package com.example.administrator.myking;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/6/12.
 */
public interface Ex39GupianLei {
    @GET("/apistore/stockservice/hkstock")
    Call<GupianLei> GupiaoZhi(@Header("apikey") String apikey, @Query("stockid") String stockid ,@Query("list") String list);
}
