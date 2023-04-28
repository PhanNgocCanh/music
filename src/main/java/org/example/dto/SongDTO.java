package org.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SongDTO {
    private long songId;
    private long categoryId;
    private long artistId;
    private String songName;
    private String image;
    private String file;

}
