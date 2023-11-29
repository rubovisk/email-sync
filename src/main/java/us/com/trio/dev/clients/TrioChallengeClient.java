package us.com.trio.dev.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import us.com.trio.dev.dto.TrioChallengeResponseDto;

@FeignClient(name = "${feign.client.name}", url = "${feign.client.url}")
public interface TrioChallengeClient {
	@GetMapping("/contacts")
	public List<TrioChallengeResponseDto> getContacts();	
}
