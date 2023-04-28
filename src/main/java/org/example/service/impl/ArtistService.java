package org.example.service.impl;

import org.example.dto.ArtistDTO;
import org.example.entity.Artist;
import org.example.exception.ResourceNotFoundException;
import org.example.payload.ApiResponse;
import org.example.repository.ArtistRepository;
import org.example.service.IArtistService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtistService implements IArtistService {
    private static final String RESOURCE_NAME = "Artist";
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<List<ArtistDTO>> findAll() {
        List<Artist> artists = artistRepository.findAll();
        List<ArtistDTO> artistDTOs = new ArrayList<>();
        artists.stream().forEach(artist -> {
            artistDTOs.add(modelMapper.map(artist, ArtistDTO.class));
        });
        return new ResponseEntity<>(artistDTOs, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ArtistDTO> findOne(long id) {
        Artist artist = artistRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(RESOURCE_NAME, "id", id));
        return new ResponseEntity<>(modelMapper.map(artist,ArtistDTO.class),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ArtistDTO> save(ArtistDTO artistDTO) {
        Artist artist = null;
        if(artistDTO.getArtistId()!=0){
            artist = artistRepository.findById(artistDTO.getArtistId()).orElseThrow(()
                    ->new ResourceNotFoundException(RESOURCE_NAME,"id",artistDTO.getArtistId()));
        }
        artist = artistRepository.save(modelMapper.map(artistDTO,Artist.class));
        return new ResponseEntity<>(modelMapper.map(artist,ArtistDTO.class),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse> delete(long id) {
        Artist artist = artistRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(RESOURCE_NAME,"id",id));
        artistRepository.deleteById(id);
        return new ResponseEntity<>(new ApiResponse(Boolean.TRUE,"You successfully deleted Artist with id: "+id),HttpStatus.OK);
    }
}
