package us.com.trio.dev.dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class MockApiResponseDto {
	private String firstName;
	private String lastName;
	private String email;
	private String avatar;
	private Integer id;
	private LocalDateTime createdAt;
}
