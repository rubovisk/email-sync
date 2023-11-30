package us.com.trio.dev.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import us.com.trio.dev.model.MergeFields;

@Data
public class MailchimpInputDto {
	@JsonProperty("email_address")
	private String emailAddress;
	@JsonProperty("merge_fields")
	private MergeFields mergeFields;
	@JsonIgnore
	private Boolean isSynced;

	public String getStatus() {
		return "subscribed";
	}
}
