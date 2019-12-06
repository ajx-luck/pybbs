package co.yiiu.pybbs.controller.api;

import co.yiiu.pybbs.service.MemberTypeService;
import co.yiiu.pybbs.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pay")
public class PayApiController extends BaseApiController{

    @Autowired
    private MemberTypeService memberTypeService;

    //商品列表
    @GetMapping("/list")
    public Result list() {
        return success(memberTypeService.getAll());
    }
}
