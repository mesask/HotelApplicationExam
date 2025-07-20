package com.example.hotelapplicationexam.data.remote.models.response;

import com.google.gson.annotations.SerializedName;

public class Category {

	@SerializedName("createBy")
	private String createBy;

	@SerializedName("updateBy")
	private Object updateBy;

	@SerializedName("imageUrl")
	private Object imageUrl;

	@SerializedName("name")
	private String name;

	@SerializedName("updateAt")
	private Object updateAt;

	@SerializedName("id")
	private int id;

	@SerializedName("createAt")
	private String createAt;

	@SerializedName("status")
	private String status;

	public void setCreateBy(String createBy){
		this.createBy = createBy;
	}

	public String getCreateBy(){
		return createBy;
	}

	public void setUpdateBy(Object updateBy){
		this.updateBy = updateBy;
	}

	public Object getUpdateBy(){
		return updateBy;
	}

	public void setImageUrl(Object imageUrl){
		this.imageUrl = imageUrl;
	}

	public Object getImageUrl(){
		return imageUrl;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setUpdateAt(Object updateAt){
		this.updateAt = updateAt;
	}

	public Object getUpdateAt(){
		return updateAt;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setCreateAt(String createAt){
		this.createAt = createAt;
	}

	public String getCreateAt(){
		return createAt;
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
			"DataItem{" + 
			"createBy = '" + createBy + '\'' + 
			",updateBy = '" + updateBy + '\'' + 
			",imageUrl = '" + imageUrl + '\'' + 
			",name = '" + name + '\'' + 
			",updateAt = '" + updateAt + '\'' + 
			",id = '" + id + '\'' + 
			",createAt = '" + createAt + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}