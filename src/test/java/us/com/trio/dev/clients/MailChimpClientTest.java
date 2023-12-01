package us.com.trio.dev.clients;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import us.com.trio.dev.dto.MailchimpInputDto;
import us.com.trio.dev.dto.MailchimpResponseDto;

@SpringBootTest(properties = {"spring.profiles.active=dev"})
public class MailChimpClientTest {

  @MockBean
  private MailChimpClient mailChimpClient;

  @Test
  public void testAddContact() {
    // Arrange
    MailchimpInputDto input = new MailchimpInputDto(); // Set properties as needed
    MailchimpResponseDto expectedResponse = new MailchimpResponseDto(); // Set properties as needed

    when(mailChimpClient.addContact(input)).thenReturn(expectedResponse);

    // Act
    MailchimpResponseDto actualResponse = mailChimpClient.addContact(input);

    // Assert
    assertEquals(expectedResponse, actualResponse);
  }
}