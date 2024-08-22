package org.AshInc.controller;

import org.AshInc.model.Song;
import org.AshInc.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class SongController {

    private final SongService songService;
    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }


    @GetMapping("/songs")
    public String showSongs(Model model) {
        List<Song> songs = songService.findAll();
        songs.stream().forEach(System.out::println);
        model.addAttribute("songs", songs);
        return "songs";
    }

    @GetMapping("upload")
    public String addSong(@ModelAttribute("song") Song song){
        return "addSong";
    }

    @PostMapping("/songs")
    public String createSong(@ModelAttribute Song song,
                             @RequestParam("audioFile") MultipartFile audioFile,
                             @RequestParam("imageFile") MultipartFile imageFile) throws IOException {

        if (!audioFile.isEmpty()) {
            File dir = new File("src/main/resources/static/songs");
            audioFile.transferTo(new File(dir.getAbsolutePath()+"/"+audioFile.getOriginalFilename()));
            song.setAudioFilePath("songs/"+audioFile.getOriginalFilename());
        }

        if (!imageFile.isEmpty()) {
            File dir = null; //Файловая система
            //dir = new File("src/main/resources/static/album_photo");
            dir = new File("target/classes/static/photos");
            imageFile.transferTo(new File(dir.getAbsolutePath()+"/"+imageFile.getOriginalFilename()));
            song.setPhotoFilePath("photos/"+imageFile.getOriginalFilename());
        }
        //System.out.println(song);
        // Сохранение сущности Song в базу данных
        songService.save(song);
        return "redirect:/songs";
    }
} 