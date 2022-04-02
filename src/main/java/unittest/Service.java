package unittest;

public class Service {

	private DatabaseAccess db = new DatabaseAccess();

	public String getData(String key) {
		if (key == null) {
			throw new NullPointerException("引数がnullです。");
		}

		if (!db.exists(key)) {
			throw new IllegalArgumentException("データが存在しません。");
		}
		return db.getData(key);
	}
}
