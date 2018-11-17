package club.javalearn.ims.web;

import club.javalearn.ims.entity.User;
import club.javalearn.ims.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

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


    @Autowired
    private UserService userService;

    @RequestMapping("/user/")
    public ModelAndView page(){
        return new ModelAndView("system/user");
    }
}
