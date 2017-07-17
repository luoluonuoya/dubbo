package zoro.dubbo.openapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**  
 * @Title: ProviderApplication.java
 * @Package zoro.dubbo.openapi
 * @company：     
 * @Description: TODO
 * @author zoro
 * @date 2017年7月7日 下午3:00:03
 * @version V1.0  
 */
@SpringBootApplication
public class ProviderApplication extends SpringBootServletInitializer {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ProviderApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ProviderApplication.class, args);
	}

}
