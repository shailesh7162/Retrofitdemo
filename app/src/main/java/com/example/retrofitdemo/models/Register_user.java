package com.example.retrofitdemo.models;

public class Register_user
{
    private Integer connection;

    private Integer result;

    public Integer getConnection() {
        return connection;
    }

    public void setConnection(Integer connection) {
        this.connection = connection;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "RegisterData{" +
                "connection=" + connection +
                ", result=" + result +
                '}';
    }
}
