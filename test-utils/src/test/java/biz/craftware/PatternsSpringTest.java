package biz.craftware;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;

@ContextConfiguration(classes={ AllClassesConfig.class })
public abstract class PatternsSpringTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private MocksHandler mocksHandler;

	@BeforeMethod
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		mocksHandler.resetMocks();
		beforeMethod();
	}

	public void beforeMethod(){

	}
}
