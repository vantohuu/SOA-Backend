package com.springboot.architectural.service;

import com.springboot.architectural.dto.HistoryDTO;

import java.util.List;

public interface HistoryService {
    HistoryDTO getById(int id);
    List<HistoryDTO> getAll();
    HistoryDTO add(HistoryDTO historyDTO);
    HistoryDTO update(HistoryDTO historyDTO);
    boolean delete(Integer id);
}
