package us.com.trio.dev.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import us.com.trio.dev.dto.TrioChallengeResponseDto;
import us.com.trio.dev.services.EmailSyncService;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EmailSyncController {
	private final EmailSyncService emailSyncService;
	
	@GetMapping(path = "/contacts/sync")
	public ResponseEntity<List<TrioChallengeResponseDto>> syncContacts(){
		List<TrioChallengeResponseDto> r = emailSyncService.fetchData();
		return new ResponseEntity<>(r, HttpStatus.OK);
	}
	
}
