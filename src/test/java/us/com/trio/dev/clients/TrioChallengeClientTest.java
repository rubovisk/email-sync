package us.com.trio.dev.clients;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import us.com.trio.dev.dto.MockApiResponseDto;

@SpringBootTest(properties = {"spring.profiles.active=dev"})
public class TrioChallengeClientTest {

  @MockBean
  private TrioChallengeClient trioChallengeClient;

  @Test
  public void testGetContacts() {
    MockApiResponseDto mockResponse = new MockApiResponseDto();
    List<MockApiResponseDto> expectedResponse = Arrays.asList(mockResponse);

    when(trioChallengeClient.getContacts()).thenReturn(expectedResponse);

    List<MockApiResponseDto> actualResponse = trioChallengeClient.getContacts();

    assertEquals(expectedResponse, actualResponse);
  }
}