package com.hailang.weixiaoshuo.bean;

public class ContentBean {
	private long contentId;//微小说内容Id
	private String strContent;//微小说内容
	private long userId;//用户Id
	private String strUserName;//用户名
	private String strCreateDate;//创建日期
	private String strTransmitNum;//转发数
	private String strFavoriteNum;//收藏数
	private String strCommentNum;//评论数
	public long getContentId() {
		return contentId;
	}
	public void setContentId(long contentId) {
		this.contentId = contentId;
	}
	public String getStrContent() {
		return strContent;
	}
	public void setStrContent(String strContent) {
		this.strContent = strContent;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getStrUserName() {
		return strUserName;
	}
	public void setStrUserName(String strUserName) {
		this.strUserName = strUserName;
	}
	public String getStrCreateDate() {
		return strCreateDate;
	}
	public void setStrCreateDate(String strCreateDate) {
		this.strCreateDate = strCreateDate;
	}
	public String getStrTransmitNum() {
		return strTransmitNum;
	}
	public void setStrTransmitNum(String strTransmitNum) {
		this.strTransmitNum = strTransmitNum;
	}
	public String getStrFavoriteNum() {
		return strFavoriteNum;
	}
	public void setStrFavoriteNum(String strFavoriteNum) {
		this.strFavoriteNum = strFavoriteNum;
	}
	public String getStrCommentNum() {
		return strCommentNum;
	}
	public void setStrCommentNum(String strCommentNum) {
		this.strCommentNum = strCommentNum;
	}
	
}
