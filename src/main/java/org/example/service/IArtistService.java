package org.example.service;

import org.example.dto.ArtistDTO;
import org.example.payload.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IArtistService {
    ResponseEntity<List<ArtistDTO>> findAll();
    ResponseEntity<ArtistDTO> findOne(long id);
    ResponseEntity<ArtistDTO> save(ArtistDTO artistDTO);
    ResponseEntity<ApiResponse> delete(long id);
}
