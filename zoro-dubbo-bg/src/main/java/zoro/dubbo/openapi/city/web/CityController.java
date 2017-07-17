package zoro.dubbo.openapi.city.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zoro.dubbo.openapi.facade.CityDubboFacade;
import zoro.dubbo.openapi.model.City;

import com.alibaba.dubbo.config.annotation.Reference;

/**  
 * @Title: CityController.java
 * @Package zoro.dubbo.openapi.city.web
 * @company：    
 * @Description: TODO
 * @author zoro
 * @date 2017年7月7日 下午4:19:41
 * @version V1.0  
 */
@RestController
public class CityController {
	
	@Reference(version = "1.0.0")
    private CityDubboFacade cityDubboFacade;

	@RequestMapping("/test")
	public void test() {
		String cityName = "广州";
		City city = cityDubboFacade.findCityByName(cityName);
		System.out.println(city.toString());
	}
	
}