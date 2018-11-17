package club.javalearn.ims.repository;

import club.javalearn.ims.utils.IdWorker;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author king-pan
 * Date: 2018/11/17
 * Time: 下午12:22
 * Description: No Description
 */
public class IdWorkGenerator  implements IdentifierGenerator{
    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        return new IdWorker(1).nextId();
    }
}
