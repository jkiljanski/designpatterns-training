package biz.craftware;

import org.mockito.Mockito;
import org.mockito.internal.util.MockUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class MocksHandler implements ApplicationContextAware {


	private static ApplicationContext applicationContext;

	private MockUtil mockUtil = new MockUtil();


	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	public void resetMocks() {
		applicationContext.getBeansOfType(Object.class)
				.values()
				.stream()
				.filter(mockUtil::isMock)
				.forEach(mockUtil::resetMock);
	}

}
