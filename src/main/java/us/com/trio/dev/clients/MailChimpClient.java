package us.com.trio.dev.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import us.com.trio.dev.config.FeignClientConfig;
import us.com.trio.dev.dto.MailchimpInputDto;
import us.com.trio.dev.dto.MailchimpResponseDto;

@FeignClient(name = "${mailchimp.client.name}", url = "${mailchimp.client.url}", configuration = FeignClientConfig.class)
public interface MailChimpClient {
	@PostMapping("/lists/${mailchimp.list.id}/members")
	public MailchimpResponseDto addContact(MailchimpInputDto input);	
}
