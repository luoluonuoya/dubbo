---
title: springboot+dubbo简单实现
date: 2017-07-17 14:51:31
categories: [Java]
tags: [Java,springboot,dubbo]
---
### 一、目录结构
#### zoro-dubbo-parent（maven父模块）
#### zoro-dubbo-provider （生产者）
#### zoro-dubbo-bg （消费者）
#### zoro-dubbo-facade （公用）
### 二、配置
#### pom.xml
习惯性将springboot所有项目的tomcat去掉，因为这块应该交给运维统一管理
#### 生产者配置
这里以dubbo使用zookeeper作为注册中心为例：
```XML
spring:
  dubbo:
    application:
      name: zoro-dubbo-provider
    registry:
      address: zookeeper://127.0.0.1:2181
    protocol:
      name: dubbo
      prot: 20880
    scan: zoro.dubbo.openapi
```
#### 消费者配置
```XML
spring:
  dubbo:
    application:
      name: zoro-dubbo-bg
    registry:
      address: zookeeper://127.0.0.1:2181
    scan: zoro.dubbo.openapi
```
**a)** dubbo.application.name随便填，只是作为一个标识名
**b)** dubbo.registry.address填注册中心的地址，这里用zookeeper，启动项目前需要先启动zookeeper，zookeeper的端口配置在conf/zoo.cfg文件中，默认是2181，启动在bin/文件夹下，windows运行zkServer.cmd，linux运行zkServer.sh
**c)** dubbo.scan表示映射的包路径
### 四、生产者启动
这里使用注入的方法，很简单，注意使用的是dubbo的service注解
```Java
package zoro.dubbo.openapi.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;

import zoro.dubbo.openapi.facade.CityDubboFacade;
import zoro.dubbo.openapi.model.City;
import zoro.dubbo.openapi.service.CityDubboService;

import com.alibaba.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class CityDubboFacadeImpl implements CityDubboFacade {
	
	@Autowired
	private CityDubboService cityDubboService;

	@Override
	public City findCityByName(String cityName) {
		return cityDubboService.findCityByName(cityName);
	}

}
```
### 五、消费者调用
调用也很简单，使用@Reference就可以了
```Java
package zoro.dubbo.openapi.city.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zoro.dubbo.openapi.facade.CityDubboFacade;
import zoro.dubbo.openapi.model.City;

import com.alibaba.dubbo.config.annotation.Reference;

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
```
### 六、测试
先运行zookeeper，然后运行provider，再运行bg，访问http://localhost:port/zoro-dubbo-openapi/test 控制台打印即表示调用成功
```
City [name=广州, desc=羊城]
```
这里zoro-dubbo-facade抽出来作为依赖的目的是生产者跟消费者都需要写一遍service和model，甚是麻烦，而且容易出现不统一的情况，如果是内部子系统之间的调用，建议抽出来作为一个依赖包来使用。