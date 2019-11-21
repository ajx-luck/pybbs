package co.yiiu.pybbs.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * @Description: 分类
 * @Author hemingming
 * @Date 2019/11/21
 **/
public class Category implements Serializable {


    private static final long serialVersionUID = 3864095945614714315L;
    @TableId(type = IdType.AUTO)
    private Integer id;
    //区域id
    private Integer cid;

    private String name;

    public Integer getId() {
        return id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
