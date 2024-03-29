package com.springboot.architectural.mapper;

import com.springboot.architectural.dto.CommentDTO;
import com.springboot.architectural.dto.HistoryDTO;
import com.springboot.architectural.entity.Comment;
import com.springboot.architectural.entity.History;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class );
    @Mapping(target = "name", source = "comment.movieUser.name")
    @Mapping(target = "avatar", source = "comment.movieUser.avatar")
    @Mapping(target = "movieId", source = "comment.movie.movieId")
    @Mapping(target = "username", source = "comment.movieUser.username")

    CommentDTO commentToCommentDto(Comment comment);
    Comment commentDtoToComment(CommentDTO commentDTO);
}
