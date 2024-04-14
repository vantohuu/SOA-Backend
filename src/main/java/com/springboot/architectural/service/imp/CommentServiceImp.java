package com.springboot.architectural.service.imp;

import com.springboot.architectural.dto.CommentDTO;
import com.springboot.architectural.dto.HistoryDTO;
import com.springboot.architectural.entity.*;
import com.springboot.architectural.mapper.CommentMapper;
import com.springboot.architectural.mapper.HistoryMapper;
import com.springboot.architectural.mapper.MovieMapper;
import com.springboot.architectural.repository.*;
import com.springboot.architectural.service.CommentService;
import com.springboot.architectural.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentServiceImp implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private MovieUserRepository movieUserRepository;
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public CommentDTO getById(int id) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.map(CommentMapper.INSTANCE::commentToCommentDto).orElse(null);
    }

    public List<CommentDTO> getAll() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream().map(CommentMapper.INSTANCE::commentToCommentDto).collect(Collectors.toList());
    }

    @Override
    public CommentDTO add(CommentDTO commentDTO) {
        Comment entity = CommentMapper.INSTANCE.commentDtoToComment(commentDTO);
        if (commentDTO.getMovieId() == null || commentDTO.getUsername() == null) return null;
        Optional<Movie> movie = movieRepository.findById(commentDTO.getMovieId());
        Optional<Movie_User> movieUser = movieUserRepository.findById(commentDTO.getUsername());
        if (movie.isEmpty() || movieUser.isEmpty()) return null;
        entity.setMovie(movie.get());
        entity.setMovieUser(movieUser.get());
        return  CommentMapper.INSTANCE.commentToCommentDto(commentRepository.save(entity));
    }

    @Override
    public CommentDTO update(CommentDTO commentDTO) {
        if (commentDTO.getIdComment() == null) return  null;
        Optional<Comment> checkRR = commentRepository.findById(commentDTO.getIdComment());
        if (checkRR.isEmpty()) return null;
        Comment entity = CommentMapper.INSTANCE.commentDtoToComment(commentDTO);
        if (commentDTO.getMovieId() == null || commentDTO.getUsername() == null) return null;
        Optional<Movie> movie = movieRepository.findById(commentDTO.getMovieId());
        Optional<Movie_User> movieUser = movieUserRepository.findById(commentDTO.getUsername());
        if (movie.isEmpty() || movieUser.isEmpty()) return null;
        entity.setMovie(movie.get());
        entity.setMovieUser(movieUser.get());
        return  CommentMapper.INSTANCE.commentToCommentDto(commentRepository.save(entity));
    }

    @Override
    public List<CommentDTO> findByMovieWithPaginationAndSorting(String searchContent, Integer movieId, int offset, int pageSize, String field) {
        Page<Comment> comments = commentRepository.paginationAndSortingByMovie(searchContent,movieId, PageRequest.of(offset, pageSize).withSort(Sort.by(field).descending()));
        return  comments.getContent().stream().map(CommentMapper.INSTANCE::commentToCommentDto).collect(Collectors.toList());
    }

    @Override
    public boolean delete(Integer id) {
        Optional<Comment> c = commentRepository.findById(id);
        if (c.isPresent())
        {
            commentRepository.delete(c.get());
            return true;
        }
        return false;
    }
}
