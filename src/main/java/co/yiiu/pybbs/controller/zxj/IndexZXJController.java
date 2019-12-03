package co.yiiu.pybbs.controller.zxj;

import co.yiiu.pybbs.model.Topic;
import co.yiiu.pybbs.service.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class IndexZXJController extends BaseZXJController{

    @Autowired
    private ITopicService topicService;

    // 首页
    @GetMapping("/he")
    public String hello(Model model) {
        Topic topic = topicService.selectById(2);
        List<Map<String,Object>> list = topicService.selectAllTopics(1).getRecords();
        model.addAttribute("username","freeMarker");
        model.addAttribute("topic",topic);
        model.addAttribute("topics",list);
        return format("hello");
    }
}
