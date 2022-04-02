package unittest;

public class Calculator {
	// 引数に与えられた数値を二乗して返すメソッド
	public int square(int x) {
		return x * x;
	}

	// 引数に与えられた数値の平方根を返すメソッド
	public double root(double x) {
		if (x < 0) {
			throw new IllegalArgumentException("負の値の平方根は求められません。");
		}
		return Math.sqrt(x);
	}

}
