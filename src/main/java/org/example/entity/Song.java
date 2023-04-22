package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "Song")
public class Song extends UserDateAudit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SongId")
    private long songId;

    @ManyToOne
    @JoinColumn(name = "CategoryId")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "ArtistId")
    private Artist artist;

    @Column(name = "SongName")
    private String songName;
    @Column(name = "Image")
    private String image;
    @Column(name = "File")
    private String file;

}
