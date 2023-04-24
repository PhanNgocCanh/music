package org.example.mapper;

import org.example.dto.SongDTO;
import org.example.entity.Song;
import org.example.repository.ArtistRepository;
import org.example.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SongMapper {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public Song toEntity(SongDTO songDTO){
        Song song = modelMapper.map(songDTO,Song.class);
        song.setArtist(artistRepository.findById(songDTO.getArtistId()).get());
        song.setCategory(categoryRepository.findById(songDTO.getCategoryId()).get());
        return song;
    }

    public SongDTO toDTO(Song song){
        SongDTO songDTO = modelMapper.map(song, SongDTO.class);
        songDTO.setArtistId(song.getArtist().getArtistId());
        songDTO.setCategoryId(song.getCategory().getCategoryId());
        return songDTO;
    }
}
