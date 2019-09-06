package biz.craftware;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//I=1      V=5      X=10      L=50      C=100      D=500       M=1000.
@Component
@Scope("prototype")
public class RomanToArabicTranslator {
	public int translate(String romanNumber) {
		return 0;
	}
}
