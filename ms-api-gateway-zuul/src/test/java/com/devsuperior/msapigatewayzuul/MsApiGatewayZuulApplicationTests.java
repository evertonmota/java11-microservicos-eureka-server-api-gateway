package com.devsuperior.msapigatewayzuul;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableEurekaClient
@EnableZuulProxy
@SpringBootTest
class MsApiGatewayZuulApplicationTests {

	@Test
	void contextLoads() {
	}

}
