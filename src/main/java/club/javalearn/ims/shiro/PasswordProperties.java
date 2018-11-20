package club.javalearn.ims.shiro;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 *
 * @author king-pan
 * Date: 2018/11/20
 * Time: 下午9:50
 * Description: No Description
 */
@Getter
@Setter
@ToString
public class PasswordProperties {
    /**
     * 加密次数
     */
    private int hashIterations;
    /**
     * 加密算法
     */
    private String algorithmName;
}

