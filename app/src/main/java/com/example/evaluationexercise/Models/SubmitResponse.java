package com.example.evaluationexercise.Models;

import com.google.gson.annotations.SerializedName;

public class SubmitResponse {

    @SerializedName("data")
    Data data ;

    @SerializedName("error")
    String error;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "SubmitResponse{" +
                "data=" + data +
                ", error='" + error + '\'' +
                '}';
    }

    class  Data {
        @SerializedName("Id")
        String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "Id=" + id + '\'' +
                    '}';
        }
    }
}
