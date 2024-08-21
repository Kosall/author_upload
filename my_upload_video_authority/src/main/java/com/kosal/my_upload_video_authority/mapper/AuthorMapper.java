package com.kosal.my_upload_video_authority.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kosal.my_upload_video_authority.entities.Author;
import com.kosal.my_upload_video_authority.entities.DTO.AuthorDTO;

@Mapper
public interface AuthorMapper {
	AuthorMapper INSTANCE=Mappers.getMapper(AuthorMapper.class);
	
	Author toAuthor(AuthorDTO authorDTO);
	AuthorDTO toAuthorDTO(Author author);
}
