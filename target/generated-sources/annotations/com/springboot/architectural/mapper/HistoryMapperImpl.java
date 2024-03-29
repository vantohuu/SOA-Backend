package com.springboot.architectural.mapper;

import com.springboot.architectural.dto.HistoryDTO;
import com.springboot.architectural.entity.History;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-29T23:36:57+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
public class HistoryMapperImpl implements HistoryMapper {

    @Override
    public HistoryDTO historyToHistoryDto(History history) {
        if ( history == null ) {
            return null;
        }

        HistoryDTO historyDTO = new HistoryDTO();

        historyDTO.setId( history.getId() );
        historyDTO.setEpisode( history.getEpisode() );
        historyDTO.setMovieUser( history.getMovieUser() );
        historyDTO.setTimeStamp( history.getTimeStamp() );

        return historyDTO;
    }

    @Override
    public History historyDtoToHistory(HistoryDTO historyDTO) {
        if ( historyDTO == null ) {
            return null;
        }

        History history = new History();

        history.setId( historyDTO.getId() );
        history.setEpisode( historyDTO.getEpisode() );
        history.setMovieUser( historyDTO.getMovieUser() );
        history.setTimeStamp( historyDTO.getTimeStamp() );

        return history;
    }
}
