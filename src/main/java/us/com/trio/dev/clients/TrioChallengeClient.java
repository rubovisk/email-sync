package us.com.trio.dev.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import us.com.trio.dev.dto.MockApiResponseDto;

@FeignClient(name = "${mockapi.client.name}", url = "${mockapi.client.url}")
public interface TrioChallengeClient {
	@GetMapping("/contacts")
	public List<MockApiResponseDto> getContacts();
}
