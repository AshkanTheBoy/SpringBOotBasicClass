package org.AshInc.service;

import org.AshInc.model.Song;
import org.AshInc.repo.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {
private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> findAll(){
        return songRepository.findAll();
    }
    public Song findById(int id){
        Optional<Song> foundSong= songRepository.findById(id);
        return foundSong.orElse(null);
    }
    public void save(Song song){
        songRepository.save(song);
    }
    public void update(int id, Song updatedSong){
        updatedSong.setId(id);
        songRepository.save(updatedSong);
    }

    public void delete(int id){
       songRepository.deleteById(id);
    }
} 