package co.yiiu.pybbs.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 支付记录
 * @Author hemingming
 * @Date 2019/11/20
 **/
public class PayInfo implements Serializable {

    private static final long serialVersionUID = 5274393945684511935L;
    @TableId(type = IdType.AUTO)
    private Integer id;

    //用户id
    private Integer uid;

    //标价金额
    private Long money;

    //会员类型id
    private Integer typeId;

    //会员名称 普通会员，季度会员，年费会员
    private String name;

    //支付成功 1, 支付失败为2 ，其他状态为3
    private Integer payStatus;

    //创建时间
    private Date startTime;

    //支付成功时间
    private Date endTime;
    //支付订单号
    private String tradeNo;
    //支付方式
    private String payType;
    //商户id
    private String pid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
