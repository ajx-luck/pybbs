package co.yiiu.pybbs.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * @Description: 地区
 * @Author hemingming
 * @Date 2019/11/21
 **/
public class Area implements Serializable {

    private static final long serialVersionUID = 2675379507628154365L;

    @TableId(type = IdType.AUTO)
    private Integer id;
    //区域id
    private Integer aid;

    private String name;

    public Integer getId() {
        return id;
    }


    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
