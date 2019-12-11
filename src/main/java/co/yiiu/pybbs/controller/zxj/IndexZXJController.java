package co.yiiu.pybbs.controller.zxj;

import co.yiiu.pybbs.model.Area;
import co.yiiu.pybbs.model.MemberType;
import co.yiiu.pybbs.model.Topic;
import co.yiiu.pybbs.service.ITopicService;
import co.yiiu.pybbs.service.MemberTypeService;
import co.yiiu.pybbs.util.MyPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/home")
    public String home(Model model){
        return format("index");
    }

    @GetMapping("/detail")
    public String detail(Model model){
        return format("detail");
    }

    @GetMapping("/topicCity")
    public String showList(Model model, @RequestParam Integer pageNo,@RequestParam String city){
        MyPage<Map<String,Object>> myPage = topicService.selectByCity(pageNo,30,city);
        Area area = topicService.selectByName(city);
        List<Area> citys = topicService.area(area.getProvice());
        model.addAttribute("page", myPage);
        model.addAttribute("city",area.getName());
        model.addAttribute("provice",area.getProvice());
        model.addAttribute("citys",citys);
        return format("topiclist");
    }

    @GetMapping("/topicProvice")
    public String showProvice(Model model, @RequestParam Integer pageNo,@RequestParam String provice){
        MyPage<Map<String,Object>> myPage = topicService.selectByProvice(pageNo,30,provice);
        List<Area> citys = topicService.area(provice);
        model.addAttribute("page", myPage);
        model.addAttribute("provice",provice);
        model.addAttribute("citys",citys);
        return format("topiclist");
    }
}
