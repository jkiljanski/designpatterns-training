package biz.craftware;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RomanNumberTranslateTest extends PatternsSpringTest{

	@Autowired
	RomanToArabicTranslator romanToArabicTranslator;

	//I=1      V=5      X=10      L=50      C=100      D=500       M=1000.
	@DataProvider
	public Object[][] romanNumbersToArabic(){
		return new Object[][]{
				{"MCCXII", 1212},
				{"MDCLXXXVII", 1687},
				{"MCMXLII", 1942},
				{"CMXCV", 995},
				{"LXIV", 64},
				{"CCXXVI", 226},
				{"MDCCXII", 1712}
		};
	}


	@Test(dataProvider = "romanNumbersToArabic")
	public void translateSomeNumbers(String romanNumber, int expectedArabic){
		//given

		//when
		int arabicResult = romanToArabicTranslator.translate(romanNumber);

		//then
		assertThat(arabicResult).isEqualTo(expectedArabic);

	}
}
