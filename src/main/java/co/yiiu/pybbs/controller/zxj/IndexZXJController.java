package co.yiiu.pybbs.controller.zxj;

import co.yiiu.pybbs.model.MemberType;
import co.yiiu.pybbs.model.Topic;
import co.yiiu.pybbs.service.ITopicService;
import co.yiiu.pybbs.service.MemberTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class IndexZXJController extends BaseZXJController{

    @Autowired
    private ITopicService topicService;
    @Autowired
    private MemberTypeService memberTypeService;

    // 首页
    @GetMapping("/he")
    public String hello(Model model) {
        Topic topic = topicService.selectById(2);
        List<Map<String,Object>> list = topicService.selectAllTopics(1).getRecords();
        List<MemberType> memberTypes = memberTypeService.getAll();
        model.addAttribute("username","freeMarker");
        model.addAttribute("topic",topic);
        model.addAttribute("topics",list);
        model.addAttribute("memberTypes",memberTypes);
        model.addAttribute("date",new Date());
        return format("hello");
    }
}
