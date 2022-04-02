package unittest;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

	@InjectMocks
	private Service service;

	@Mock
	private DatabaseAccess db;

	@Test
	@DisplayName("nullを渡した場合にNullPointerExceptionがスローされる")
	void testGetDataNull() {
		try {
			service.getData(null);
			fail("例外がスローされなかった。");
		} catch (NullPointerException e) {
			assertThat(e.getMessage(), is("引数がnullです。"));
		}
	}

	@Test
	@DisplayName("キーに対応するデータが無い場合にIllegalArgumentExceptionがスローされる")
	void testGetDataNotFound() {

		when(db.exists(anyString())).thenReturn(false);

		try {
			service.getData("test");
			fail("例外がスローされなかった。");
		} catch (IllegalArgumentException e) {
			assertThat(e.getMessage(), is("データが存在しません。"));
		}
	}

	@Test
	@DisplayName("キーに対応するデータがあった場合、データが返される")
	void testGetDataSuccess() {

		when(db.exists(anyString())).thenReturn(true);
		when(db.getData(anyString())).thenReturn("result");

		String result = service.getData("test");
		assertThat(result, is("result"));
	}
}
