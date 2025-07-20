package com.example.hotelapplicationexam.data.remote.models.request;

import com.google.gson.annotations.SerializedName;

public class BaseRequest{

	@SerializedName("limit")
	private int limit = 16;

	@SerializedName("page")
	private int page = 1;

	@SerializedName("id")
	private int id = 0;

	@SerializedName("userId")
	private int userId = 0;

	@SerializedName("status")
	private String status = "ACT";

	public void setLimit(int limit){
		this.limit = limit;
	}

	public int getLimit(){
		return limit;
	}

	public void setPage(int page){
		this.page = page;
	}

	public int getPage(){
		return page;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId(){
		return userId;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"BaseRequest{" + 
			"limit = '" + limit + '\'' + 
			",page = '" + page + '\'' + 
			",id = '" + id + '\'' + 
			",userId = '" + userId + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}