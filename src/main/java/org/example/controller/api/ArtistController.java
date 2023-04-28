package org.example.controller.api;

import org.example.dto.ArtistDTO;
import org.example.payload.ApiResponse;
import org.example.service.IArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/artistes")
public class ArtistController {
    @Autowired
    private IArtistService artistService;

    @GetMapping
    public ResponseEntity<List<ArtistDTO>> getAllArtist() {
        return artistService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ArtistDTO> getArtist(@PathVariable("id") long id){
        return artistService.findOne(id);
    }
    @PostMapping
    public ResponseEntity<ArtistDTO> addArtist(@RequestBody ArtistDTO artistDTO){
        return artistService.save(artistDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ArtistDTO> updateArtist(@PathVariable("id") long id,@RequestBody ArtistDTO artistDTO){
        artistDTO.setArtistId(id);
        return artistService.save(artistDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteArtist(@PathVariable("id") long id){
        return artistService.delete(id);
    }
}
