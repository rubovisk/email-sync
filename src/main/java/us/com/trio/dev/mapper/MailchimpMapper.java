package us.com.trio.dev.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import us.com.trio.dev.dto.MailchimpInputDto;
import us.com.trio.dev.dto.MockApiResponseDto;

@Mapper(componentModel = "spring")
public interface MailchimpMapper {
	@Mapping(target = "mergeFields.lname", source = "lastName")
	@Mapping(target = "mergeFields.fname", source = "firstName")
	@Mapping(target = "emailAddress", source = "email")
	MailchimpInputDto asMailchimpInputDto(MockApiResponseDto trioChallengeResponseDto);
}
