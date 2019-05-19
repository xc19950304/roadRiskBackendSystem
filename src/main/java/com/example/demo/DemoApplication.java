package com.example.demo;

import com.example.demo.kafka.KafkaSender;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.example.demo.dao")
public class DemoApplication {

	public static void main(String[] args) {

		//System.setProperty("es.set.netty.runtime.available.processors", "false");
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		KafkaSender sender = context.getBean(KafkaSender.class);

		for (int i = 0; i < 3; i++) {
			//调用消息发送类中的消息发送方法
			sender.send();

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
