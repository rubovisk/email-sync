package us.com.trio.dev.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import us.com.trio.dev.clients.TrioChallengeClient;
import us.com.trio.dev.dto.TrioChallengeResponseDto;

@Service
@RequiredArgsConstructor
public class EmailSyncService {
	private final TrioChallengeClient trioChallengeClient;
	
	public List<TrioChallengeResponseDto> fetchData() {
		return trioChallengeClient.getContacts();
	}
}
