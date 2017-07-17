package zoro.dubbo.openapi.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;

import zoro.dubbo.openapi.facade.CityDubboFacade;
import zoro.dubbo.openapi.model.City;
import zoro.dubbo.openapi.service.CityDubboService;

import com.alibaba.dubbo.config.annotation.Service;

/**  
 * @Title: CityDubboFacadeImpl.java
 * @Package zoro.dubbo.openapi.facade.impl
 * @company：     
 * @Description: TODO
 * @author zoro
 * @date 2017年7月17日 上午11:42:39
 * @version V1.0  
 */
@Service(version = "1.0.0")
public class CityDubboFacadeImpl implements CityDubboFacade {
	
	@Autowired
	private CityDubboService cityDubboService;

	@Override
	public City findCityByName(String cityName) {
		return cityDubboService.findCityByName(cityName);
	}

}
