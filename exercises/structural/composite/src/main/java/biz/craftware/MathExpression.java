package biz.craftware;

import java.util.Map;

public interface MathExpression {

	int calculate(Map<String, Integer> values);

	String getNotation();
}
