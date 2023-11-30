package us.com.trio.dev.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SyncedContact {
	private String email;
	private String firstName;
	private String lastName;
	@JsonIgnore
	private Boolean isSynced;
}
