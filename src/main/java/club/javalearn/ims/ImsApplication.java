package club.javalearn.ims;

import club.javalearn.ims.repository.BaseRepositoryImpl;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
public class ImsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImsApplication.class, args);
	}

	/**
	 *   让Spring管理JPAQueryFactory
	 */
	@Bean
	public JPAQueryFactory jpaQueryFactory(EntityManager entityManager){
		return new JPAQueryFactory(entityManager);
	}
}
