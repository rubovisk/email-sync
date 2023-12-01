package us.com.trio.dev.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import us.com.trio.dev.clients.MailChimpClient;
import us.com.trio.dev.clients.TrioChallengeClient;
import us.com.trio.dev.dto.MailchimpInputDto;
import us.com.trio.dev.dto.MailchimpResponseDto;
import us.com.trio.dev.dto.TrioDevReponseDto;
import us.com.trio.dev.mapper.MailchimpMapper;
import us.com.trio.dev.model.SyncedContact;

@Service
@RequiredArgsConstructor
public class EmailSyncService {
	private final TrioChallengeClient trioChallengeClient;
	private final MailChimpClient mailChimpClient;
	private final MailchimpMapper mailchimpMapper;
	Integer totalSyncedContacts;

	public TrioDevReponseDto syncData() {
 		totalSyncedContacts = 0;
		TrioDevReponseDto trioDevResponse = TrioDevReponseDto.builder().build();
		trioDevResponse.setContacts(new ArrayList<>());
		
		List<MailchimpInputDto> mailchimpList = trioChallengeClient.getContacts().stream()
				.map(mailchimpMapper::asMailchimpInputDto)
				.toList();
		
		mailchimpList.forEach(contact -> {
			MailchimpResponseDto mailchimpResponseDto = mailChimpClient.addContact(contact);
			if(mailchimpResponseDto.getId() != null && !mailchimpResponseDto.getId().isBlank()) {
				SyncedContact syncedContactDto = SyncedContact.builder().build();
				syncedContactDto.setEmail(contact.getEmailAddress());
				syncedContactDto.setFirstName(contact.getMergeFields().getFname());
				syncedContactDto.setLastName(contact.getMergeFields().getLname());
				trioDevResponse.getContacts().add(syncedContactDto);
				totalSyncedContacts++;
			}
		});
		
		trioDevResponse.setSyncedContacts(totalSyncedContacts);
		
		return trioDevResponse;
	}
}
