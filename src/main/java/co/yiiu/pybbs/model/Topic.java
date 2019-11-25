package co.yiiu.pybbs.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by tomoya.
 * Copyright (c) 2018, All Rights Reserved.
 * https://yiiu.co
 */
public class Topic implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId(type = IdType.AUTO)
  private Integer id;
  private String title;
  private String content;
  private Date inTime;
  private Date modifyTime;
  private Integer userId;
  // 评论数
  private Integer commentCount;
  // 收藏数
  private Integer collectCount;
  // 浏览数
  private Integer view;
  // 置顶
  private Boolean top;
  // 加精
  private Boolean good;
  // 点赞用户的id英文,隔开的，要计算被多少人点赞过，可以通过英文,分隔这个字符串计算数量
  private String upIds;
  //审核失败原因
  private String backContent;
  //审核状态，0未审核，1审核通过，2审核失败
  private Integer checkStatus;
  //观看需要的分数
  private Integer score;
  //上级区域id
  private Integer paid;
  //区域id
  private Integer aid;
  //分类id
  private Integer cid;

  private String provice;

  private String city;

  private String category;

  private String address;//详细地址

  private String infocome;//信息来源

  private String missnumber;//数量

  private String missage;//年龄

  private String missquality;//质量

  private String missappearance;//外貌

  private String sextype;//服务类型

  private String price;//价格

  private String bustime;//时间

  private String env;//环境

  private String safety;//安全

  private String contact;//联系方式

  private String evaluate;//评价

  public String getProvice() {
    return provice;
  }

  public void setProvice(String provice) {
    this.provice = provice;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getInfocome() {
    return infocome;
  }

  public void setInfocome(String infocome) {
    this.infocome = infocome;
  }

  public String getMissnumber() {
    return missnumber;
  }

  public void setMissnumber(String missnumber) {
    this.missnumber = missnumber;
  }

  public String getMissage() {
    return missage;
  }

  public void setMissage(String missage) {
    this.missage = missage;
  }

  public String getMissquality() {
    return missquality;
  }

  public void setMissquality(String missquality) {
    this.missquality = missquality;
  }

  public String getMissappearance() {
    return missappearance;
  }

  public void setMissappearance(String missappearance) {
    this.missappearance = missappearance;
  }

  public String getSextype() {
    return sextype;
  }

  public void setSextype(String sextype) {
    this.sextype = sextype;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getBustime() {
    return bustime;
  }

  public void setBustime(String bustime) {
    this.bustime = bustime;
  }

  public String getEnv() {
    return env;
  }

  public void setEnv(String env) {
    this.env = env;
  }

  public String getSafety() {
    return safety;
  }

  public void setSafety(String safety) {
    this.safety = safety;
  }

  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  public String getEvaluate() {
    return evaluate;
  }

  public void setEvaluate(String evaluate) {
    this.evaluate = evaluate;
  }

  public String getUpIds() {
    return upIds;
  }

  public void setUpIds(String upIds) {
    this.upIds = upIds;
  }

  public Integer getCollectCount() {
    return collectCount;
  }

  public void setCollectCount(Integer collectCount) {
    this.collectCount = collectCount;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  public Date getInTime() {
    return inTime;
  }

  public void setInTime(Date inTime) {
    this.inTime = inTime;
  }

  public Date getModifyTime() {
    return modifyTime;
  }

  public void setModifyTime(Date modifyTime) {
    this.modifyTime = modifyTime;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Integer getCommentCount() {
    return commentCount;
  }

  public void setCommentCount(Integer commentCount) {
    this.commentCount = commentCount;
  }

  public Integer getView() {
    return view;
  }

  public void setView(Integer view) {
    this.view = view;
  }

  public Boolean getTop() {
    return top;
  }

  public void setTop(Boolean top) {
    this.top = top;
  }

  public Boolean getGood() {
    return good;
  }

  public void setGood(Boolean good) {
    this.good = good;
  }

  public Integer getCheckStatus() {
    return checkStatus;
  }

  public void setCheckStatus(Integer checkStatus) {
    this.checkStatus = checkStatus;
  }

  public String getBackContent() {
    return backContent;
  }

  public void setBackContent(String backContent) {
    this.backContent = backContent;
  }

  public Integer getScore() {
    return score;
  }

  public void setScore(Integer score) {
    this.score = score;
  }

  public Integer getPaid() {
    return paid;
  }

  public void setPaid(Integer paid) {
    this.paid = paid;
  }

  public Integer getAid() {
    return aid;
  }

  public void setAid(Integer aid) {
    this.aid = aid;
  }

  public Integer getCid() {
    return cid;
  }

  public void setCid(Integer cid) {
    this.cid = cid;
  }
}
