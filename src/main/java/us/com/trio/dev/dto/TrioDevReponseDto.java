package us.com.trio.dev.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import us.com.trio.dev.model.SyncedContact;

@Data
@Builder
public class TrioDevReponseDto {
	private Integer syncedContacts;
	private List<SyncedContact> contacts;
}
