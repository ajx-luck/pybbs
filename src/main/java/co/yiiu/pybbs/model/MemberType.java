package co.yiiu.pybbs.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 会员类型
 * @Author hemingming
 * @Date 2019/11/20
 **/
public class MemberType implements Serializable {

    private static final long serialVersionUID = 5834302239706729683L;

    @TableId(type = IdType.AUTO)
    private Integer id;
    //会员名称 普通会员，季度会员，年费会员
    private String name;
    //使用时长
    private Long useTime;
    //实际金额
    private Long currentMoney;
    //标价金额
    private Long money;

    //创建时间
    private Date createTime;

    //更新时间
    private Date updateTime;

    public Integer getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUseTime() {
        return useTime;
    }

    public void setUseTime(Long useTime) {
        this.useTime = useTime;
    }

    public Long getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(Long currentMoney) {
        this.currentMoney = currentMoney;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
