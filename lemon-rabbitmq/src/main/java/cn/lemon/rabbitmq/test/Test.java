package cn.lemon.rabbitmq.test;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.lemon.rabbitmq.producer.TestProducerService;

@Component
@EnableScheduling
public class Test {
	
	@Resource
	private TestProducerService testService;

	@Scheduled(fixedDelay = 2)
	public void send() {
		testService.send("MQ_" + System.currentTimeMillis());
		System.out.println("服务提供者-提供");
	}
}
