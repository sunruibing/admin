package com.po;

//百科
public class Cyclopedia {

	private Integer id;// 文章id

	private String icon;// 列表页图片

	private String cover;// 缩略图

	private String title;// 标题

	private String content;// 内容

	private String time;// 发布时间

	private Integer collectCount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getCollectCount() {
		return collectCount;
	}

	public void setCollectCount(Integer collectCount) {
		this.collectCount = collectCount;
	}

	@Override
	public String toString() {
		return "Cyclopedia [id=" + id + ", icon=" + icon + ", cover=" + cover + ", title=" + title + ", content="
				+ content + ", time=" + time + ", collectCount=" + collectCount + "]";
	}

}
