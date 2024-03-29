package com.springboot.architectural.mapper;

import com.springboot.architectural.dto.CommentDTO;
import com.springboot.architectural.entity.Comment;
import com.springboot.architectural.entity.Movie;
import com.springboot.architectural.entity.Movie_User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-29T23:36:57+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
public class CommentMapperImpl implements CommentMapper {

    @Override
    public CommentDTO commentToCommentDto(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentDTO commentDTO = new CommentDTO();

        commentDTO.setName( commentMovieUserName( comment ) );
        commentDTO.setAvatar( commentMovieUserAvatar( comment ) );
        commentDTO.setMovieId( commentMovieMovieId( comment ) );
        commentDTO.setUsername( commentMovieUserUsername( comment ) );
        commentDTO.setIdComment( comment.getIdComment() );
        commentDTO.setComment( comment.getComment() );
        commentDTO.setValue( comment.getValue() );
        commentDTO.setDate( comment.getDate() );

        return commentDTO;
    }

    @Override
    public Comment commentDtoToComment(CommentDTO commentDTO) {
        if ( commentDTO == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setIdComment( commentDTO.getIdComment() );
        comment.setComment( commentDTO.getComment() );
        comment.setValue( commentDTO.getValue() );
        comment.setDate( commentDTO.getDate() );

        return comment;
    }

    private String commentMovieUserName(Comment comment) {
        if ( comment == null ) {
            return null;
        }
        Movie_User movieUser = comment.getMovieUser();
        if ( movieUser == null ) {
            return null;
        }
        String name = movieUser.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String commentMovieUserAvatar(Comment comment) {
        if ( comment == null ) {
            return null;
        }
        Movie_User movieUser = comment.getMovieUser();
        if ( movieUser == null ) {
            return null;
        }
        String avatar = movieUser.getAvatar();
        if ( avatar == null ) {
            return null;
        }
        return avatar;
    }

    private Integer commentMovieMovieId(Comment comment) {
        if ( comment == null ) {
            return null;
        }
        Movie movie = comment.getMovie();
        if ( movie == null ) {
            return null;
        }
        Integer movieId = movie.getMovieId();
        if ( movieId == null ) {
            return null;
        }
        return movieId;
    }

    private String commentMovieUserUsername(Comment comment) {
        if ( comment == null ) {
            return null;
        }
        Movie_User movieUser = comment.getMovieUser();
        if ( movieUser == null ) {
            return null;
        }
        String username = movieUser.getUsername();
        if ( username == null ) {
            return null;
        }
        return username;
    }
}
