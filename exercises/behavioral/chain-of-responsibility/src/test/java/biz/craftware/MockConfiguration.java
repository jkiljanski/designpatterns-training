package biz.craftware;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

@Configuration
public class MockConfiguration {

	@Bean
	CattleRegistration createCattleRegistration(){
		return mock(CattleRegistration.class);
	}
}
