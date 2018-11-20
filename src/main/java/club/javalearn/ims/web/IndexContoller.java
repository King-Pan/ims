package club.javalearn.ims.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author king-pan
 * @date 2018/11/20
 * @Description 首页控制器
 */
@RestController
public class IndexContoller {

    @RequestMapping(value = {"/","/index","/home"})
    public ModelAndView indexPage(){
        return new ModelAndView("index");
    }
}
