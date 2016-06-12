package com.example.administrator.myking;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/6/12.
 */
public class Ex40Activity extends BaseActivity {
    EditText _id;
    EditText sname;
    EditText sbirth;
    EditText fileName;
    Button btu;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.ex40_layout);
        _id = (EditText) findViewById(R.id._id);
        sname = (EditText) findViewById(R.id.sname);
        sbirth = (EditText) findViewById(R.id.sbirth);
        fileName = (EditText) findViewById(R.id.fileName);
        fileName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Ex40Activity.this,Ex40ActivityImg.class);
                startActivityForResult(i,0);
            }
        });
        btu = (Button) findViewById(R.id.btntt);
    }
    public void btn5(View view) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.88:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Ex40StudentService upSInfo = retrofit.create(Ex40StudentService.class);
        File file = new File(fileName.getText().toString());
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        Call<Message> call = upSInfo.uploadStudentInfo(_id.getText().toString(),sname.getText().toString(),sbirth.getText().toString(),file.getName(),requestBody);
        call.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                    Message m = response.body();
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                Log.e("we",t.getMessage());
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 123)
        {
            String brith = data.getStringExtra("brith");
           // Log.e("23",brith);
            fileName.setText(brith);
        }
    }
}
