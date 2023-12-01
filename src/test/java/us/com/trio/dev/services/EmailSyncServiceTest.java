package us.com.trio.dev.services;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import us.com.trio.dev.clients.MailChimpClient;
import us.com.trio.dev.clients.TrioChallengeClient;
import us.com.trio.dev.dto.MailchimpResponseDto;
import us.com.trio.dev.dto.MockApiResponseDto;
import us.com.trio.dev.dto.TrioDevReponseDto;

@SpringBootTest
@ActiveProfiles("dev")
public class EmailSyncServiceTest {

  @MockBean
  private TrioChallengeClient trioChallengeClient;

  @MockBean
  private MailChimpClient mailChimpClient;

  @Autowired
  private EmailSyncService emailSyncService;

  @Test
  public void shouldNotSyncDataWhenIdIsNotNull() {
    List<MockApiResponseDto> mockApiResponseList = new ArrayList<>();
    MockApiResponseDto response1 = new MockApiResponseDto();
    response1.setEmail("test1@example.com");
    
    MockApiResponseDto response2 = new MockApiResponseDto();
    response2.setEmail("test2@example.com");
    mockApiResponseList.add(response1);
    mockApiResponseList.add(response2);

    when(trioChallengeClient.getContacts()).thenReturn(mockApiResponseList);
    when(mailChimpClient.addContact(Mockito.any())).thenReturn(createMailchimpResponse(Boolean.TRUE));

    TrioDevReponseDto actualResponse = emailSyncService.syncData();

    assertEquals(mockApiResponseList.size(), actualResponse.getSyncedContacts());
    
  }
  
  @Test
  public void shouldNotSyncDataWhenIdIsNull() {
    List<MockApiResponseDto> mockApiResponseList = new ArrayList<>();
    MockApiResponseDto response1 = new MockApiResponseDto();
    response1.setEmail("test1@example.com");
    
    MockApiResponseDto response2 = new MockApiResponseDto();
    response2.setEmail("test2@example.com");
    mockApiResponseList.add(response1);
    mockApiResponseList.add(response2);

    when(trioChallengeClient.getContacts()).thenReturn(mockApiResponseList);
    when(mailChimpClient.addContact(Mockito.any())).thenReturn(createMailchimpResponse(Boolean.FALSE));

    TrioDevReponseDto actualResponse = emailSyncService.syncData();

    assertEquals(0, actualResponse.getSyncedContacts());
    
  }
  
  @Test
  public void shouldNotSyncDataWhenIdIsBlank() {
    List<MockApiResponseDto> mockApiResponseList = new ArrayList<>();
    MockApiResponseDto response1 = new MockApiResponseDto();
    response1.setEmail("test1@example.com");
    
    MockApiResponseDto response2 = new MockApiResponseDto();
    response2.setEmail("test2@example.com");
    mockApiResponseList.add(response1);
    mockApiResponseList.add(response2);

    when(trioChallengeClient.getContacts()).thenReturn(mockApiResponseList);
    MailchimpResponseDto mockMailChimpResponse = createMailchimpResponse(Boolean.FALSE);
    mockMailChimpResponse.setId("");
    when(mailChimpClient.addContact(Mockito.any())).thenReturn(mockMailChimpResponse);

    TrioDevReponseDto actualResponse = emailSyncService.syncData();

    assertEquals(0,actualResponse.getSyncedContacts());
    
  }

  private MailchimpResponseDto createMailchimpResponse(Boolean fillId) {
    MailchimpResponseDto mailchimpResponseDto = new MailchimpResponseDto();
    mailchimpResponseDto.setId(fillId ? String.valueOf( new Random().nextInt(1000)) : null);
    return mailchimpResponseDto;
  }
}