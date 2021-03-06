package club.javalearn.ims.shiro;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author king-pan
 * Date: 2018/11/20
 * Time: 下午9:48
 * Description: No Description
 */
@Getter
@Setter
@ToString
@Component
@ConfigurationProperties(prefix = "shiro")
public class ShiroProperties {

    PasswordProperties password = new PasswordProperties();

}
