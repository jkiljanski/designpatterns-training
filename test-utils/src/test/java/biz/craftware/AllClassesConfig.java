package biz.craftware;

import biz.craftware.domain.farm.other.api.FarmInfoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

@Configuration
@ComponentScan("biz.craftware")
public class AllClassesConfig {

	@Bean
	public FarmInfoRepository mockExternalSystem(){
		return mock(FarmInfoRepository.class);
	}
}
