package com.example.administrator.myking;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/6/12.
 */
public class Ex39Activity extends BaseActivity {
    EditText chaxun;
    EditText huoqu;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex39_layout);

        chaxun = (EditText) findViewById(R.id.chaxun);
        huoqu = (EditText) findViewById(R.id.huoqu);
    }
    public void gupiao(View view)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://apis.baidu.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Ex39GupianLei gupianLei = retrofit.create(Ex39GupianLei.class);
        Call<GupianLei> call = gupianLei.GupiaoZhi("562bafef6007883e2e8fffbbdfa9e6ac",chaxun.getText().toString(),"0");
        call.enqueue(new Callback<GupianLei>() {
            @Override
            public void onResponse(Call<GupianLei> call, Response<GupianLei> response) {
                GupianLei gl = response.body();
                huoqu.setText("股票名称:"+gl.getRetData().getStockinfo().getName()+"\n"+"开盘价:"+gl.getRetData().getStockinfo().getOpenningPrice()+"\n"+"昨日收盘价:"+gl.getRetData().getStockinfo().getClosingPrice()+"\n"+"今日最高价:"+gl.getRetData().getStockinfo().getHPrice()+"\n"+"今日最低价:"+gl.getRetData().getStockinfo().getLPrice()+"\n"+"当前价:"+gl.getRetData().getStockinfo().getCurrentPrice()+"\n"+"价格涨幅:"+gl.getRetData().getStockinfo().getGrowth()
                        +"\n"+"成交量股:"+gl.getRetData().getStockinfo().getDealnumber()+"\n"+"成交金额，单位港币:"+gl.getRetData().getStockinfo().getTurnover()+"\n"+"周最高价:"+gl.getRetData().getStockinfo().getValue52hPrice()+"\n"+"周最低价"+gl.getRetData().getStockinfo().getValue52lPrice());
            }

            @Override
            public void onFailure(Call<GupianLei> call, Throwable t) {

            }
        });
    }
}
