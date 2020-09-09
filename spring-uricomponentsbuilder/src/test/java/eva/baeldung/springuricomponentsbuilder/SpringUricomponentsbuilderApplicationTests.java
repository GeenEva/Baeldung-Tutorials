package eva.baeldung.springuricomponentsbuilder;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SpringUricomponentsbuilderApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void constructURI(){
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.scheme("http").host("www.baeldung.com").path("/junit-5").build();

		assertEquals("http://www.baeldung.com/junit-5", uriComponents.toUriString());
	}

}
