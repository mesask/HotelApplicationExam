package com.example.hotelapplicationexam.data.remote.models.response;

//import java.util.List;
import com.google.gson.annotations.SerializedName;

public class BaseResponse <T>{

	@SerializedName("code")
	private String code;

	@SerializedName("data")
	private T data;

	@SerializedName("message")
	private String message;

	@SerializedName("messageKh")
	private String messageKh;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessageKh() {
		return messageKh;
	}

	public void setMessageKh(String messageKh) {
		this.messageKh = messageKh;
	}

	@Override
	public String toString() {
		return "BaseResponse{" +
				"code='" + code + '\'' +
				", data=" + data +
				", message='" + message + '\'' +
				", messageKh='" + messageKh + '\'' +
				'}';
	}

	//	public void setCode(String code){
//		this.code = code;
//	}
//
//	public String getCode(){
//		return code;
//	}
//
//	public void setData(List<Category> data){
//		this.data = data;
//	}
//
//	public List<Category> getData(){
//		return data;
//	}
//
//	public void setMessage(String message){
//		this.message = message;
//	}
//
//	public String getMessage(){
//		return message;
//	}
//
//	public void setMessageKh(String messageKh){
//		this.messageKh = messageKh;
//	}
//
//	public String getMessageKh(){
//		return messageKh;
//	}
//
//	@Override
// 	public String toString(){
//		return
//			"BaseResponse{" +
//			"code = '" + code + '\'' +
//			",data = '" + data + '\'' +
//			",message = '" + message + '\'' +
//			",messageKh = '" + messageKh + '\'' +
//			"}";
//		}
}