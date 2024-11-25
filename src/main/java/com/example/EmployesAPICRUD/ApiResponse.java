package com.example.EmployesAPICRUD;

import java.util.List;

public class ApiResponse<T> {
  boolean success;
  String message;
  int subCode;
  List<Object> data;

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public int getSubCode() {
    return subCode;
  }

  public void setSubCode(int subCode) {
    this.subCode = subCode;
  }

  public List<Object> getData() {
    return data;
  }

  public void setData(List<Object> data) {
    this.data = data;
  }

  public ApiResponse(boolean success, String message, int subCode, List<Object> data) {
    super();
    this.success = success;
    this.message = message;
    this.subCode = subCode;
    this.data = data;
  }
}
