package org.bibliofem.model;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Genre {
    private int idGenre;
    private String genre;

    public Genre(){

    }

    public Genre(String genre) {
        this.genre = genre;
    }
}



