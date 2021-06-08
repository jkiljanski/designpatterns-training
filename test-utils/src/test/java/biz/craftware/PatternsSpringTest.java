package biz.craftware;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AllClassesConfig.class})
@ExtendWith(SpringExtension.class)
public abstract class PatternsSpringTest {

    @Autowired
    private MocksHandler mocksHandler;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mocksHandler.resetMocks();
        beforeMethod();
    }

    protected void beforeMethod() {

    }
}
