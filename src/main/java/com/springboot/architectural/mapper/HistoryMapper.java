package com.springboot.architectural.mapper;

import com.springboot.architectural.dto.CountryDTO;
import com.springboot.architectural.dto.HistoryDTO;
import com.springboot.architectural.entity.Country;
import com.springboot.architectural.entity.History;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HistoryMapper {
    HistoryMapper INSTANCE = Mappers.getMapper(HistoryMapper.class );
    HistoryDTO historyToHistoryDto(History history);
    History historyDtoToHistory(HistoryDTO historyDTO);
}
