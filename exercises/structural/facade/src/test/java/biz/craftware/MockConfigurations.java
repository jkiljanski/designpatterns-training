package biz.craftware;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

@Configuration
public class MockConfigurations {

	@Bean
	public IRSOffice createIRSOffice(){
		return mock(IRSOffice.class);
	}
			@Bean
	public MarkingService createMarkingService(){
				return mock(MarkingService.class);
			}
	@Bean
	public MilkBuyer createMilkBuyer(){
		return mock(MilkBuyer.class);
	}
			@Bean
	public Veterinary createVeterinary(){
				return mock(Veterinary.class);
			}
}
