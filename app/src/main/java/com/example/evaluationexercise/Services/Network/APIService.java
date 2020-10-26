package com.example.evaluationexercise.Services.Network;

import com.example.evaluationexercise.Models.AnswerBody;
import com.example.evaluationexercise.Models.BranchInfo;
import com.example.evaluationexercise.Models.SubmitResponse;

import java.util.List;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIService {

    @POST("AllBranches/")
    Single<List<BranchInfo>> getBranchList(@Body Object o);


    @POST("SubmitAnswer/")
    Single<SubmitResponse> SubmitAnswer(@Body AnswerBody answerBody);

}
