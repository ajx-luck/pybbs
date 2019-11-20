package co.yiiu.pybbs.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 会员
 * @Author hemingming
 * @Date 2019/11/20
 **/
public class Member implements Serializable {
    private static final long serialVersionUID = -5051120314572047163L;

    @TableId(type = IdType.AUTO)
    private Integer id;
    //用户id
    private Integer uid;
    //会员类型id
    private Integer typeId;
    //过期时间
    private Date endTime;
    //会员名称
    private String name;
    //开通时间
    private Date startTime;
    //付费金额,单位为分
    private Long money;
    //最近的成功支付记录
    private Integer payId;
}
