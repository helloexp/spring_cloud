package com.didispace.web;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class HelloController {

	private final Logger logger = Logger.getLogger(getClass());

	 @Autowired
	private RabbitTemplate rabbitTemplate;
//
//	@RequestMapping(value = "/hello", method = RequestMethod.GET)
//	public String hello() throws Exception {
//		ServiceInstance instance = client.getLocalServiceInstance();
//
//		// 测试超时触发断路器
////		int sleepTime = new Random().nextInt(3000);
////		logger.info("sleepTime:" + sleepTime);
////		Thread.sleep(sleepTime);
//
//		logger.info("/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
//		return "Hello World";
//	}
//	
	@RequestMapping(value = "/notic")
    public String notic() {
	    System.err.println("start");
	   
	    rabbitTemplate.convertAndSend("hmex.direct", "hmqu.operationLog", "TestAndTest");
	    Message msg = rabbitTemplate.receive("hmqu.operationLog");
        System.err.println("msg"+String.valueOf(msg));
	    return "ssss";
    }
//
//	@RequestMapping(value = "/hello1", method = RequestMethod.GET)
//	public String hello(@RequestParam String name) {
//		ServiceInstance instance = client.getLocalServiceInstance();
//		logger.info("/hello1, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
//		return "Hello " + name;
//	}
//
//	@RequestMapping(value = "/hello2", method = RequestMethod.GET)
//	public User hello(@RequestHeader String name, @RequestHeader Integer age) {
//		ServiceInstance instance = client.getLocalServiceInstance();
//		logger.info("/hello2, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
//		return new User(name, age);
//	}
//
//	@RequestMapping(value = "/hello3", method = RequestMethod.POST)
//	public String hello(@RequestBody User user) {
//		ServiceInstance instance = client.getLocalServiceInstance();
//		logger.info("/hello3, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
//		return "Hello "+ user.getName() + ", " + user.getAge();
//	}

}