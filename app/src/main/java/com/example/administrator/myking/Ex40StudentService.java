package com.example.administrator.myking;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by Administrator on 2016/6/12.
 */
public interface Ex40StudentService {
    @Multipart
    @POST("/Test/fileUpload.do")
    Call<Message> uploadStudentInfo(@Part("_id") String _id, @Part("sname") String sname, @Part("sbirth") String sbirth, @Part("fileName") String fileName, @Part("file\"; filename=\"image.png\"") RequestBody imgs);
        //return null;
}
