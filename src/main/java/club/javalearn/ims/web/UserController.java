package club.javalearn.ims.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 *
 * @author king-pan
 * Date: 2018/11/16
 * Time: 下午11:18
 * Description: No Description
 */
@Slf4j
@RestController
public class UserController {
    @RequestMapping("/user/")
    public ModelAndView page(){
        return new ModelAndView("system/user");
    }
}
