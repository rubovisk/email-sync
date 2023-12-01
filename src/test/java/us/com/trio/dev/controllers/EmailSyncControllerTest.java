package us.com.trio.dev.controllers;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import us.com.trio.dev.services.EmailSyncService;

@WebMvcTest(properties = {"spring.profiles.active=dev"}, controllers = EmailSyncController.class)
public class EmailSyncControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private EmailSyncService emailSyncService;

  @InjectMocks
  private EmailSyncController emailSyncController;

  @Test
  public void testSyncContacts() throws Exception {
    ResultActions resultActions = mockMvc.perform(get("/api/v1/contacts/sync")
        .contentType(MediaType.APPLICATION_JSON));

    resultActions.andExpect(status().isOk());
  }
}