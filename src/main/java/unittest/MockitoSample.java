package unittest;

public class MockitoSample {

	private Calculator calc;

	public MockitoSample() {
		calc = new Calculator();
	}

	public String getSquareResult(int x) {
		int result = calc.square(x);
		return x + "の二乗の結果は" + result;
	}
}
