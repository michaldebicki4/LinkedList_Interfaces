package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Song> getSong() {
        return songs;
    }
    public boolean newSong(String songName, double songDuration){
        if(findSong(songName) == null){
            this.songs.add(new Song(songName, songDuration));
            return true;
        }
            return false;
    }
    private Song findSong(String songName){
        for (int i = 0; i<this.songs.size();i++){
            Song checkedSong = this.songs.get(i);
            if(checkedSong.getTitle().equals(songName)){
                return checkedSong;
            }
        }
        return null;
    }
    public boolean addToPlayList(int trackNumber, List<Song> playlist){
        int index = trackNumber -1;
        if((index >=0) && (index <= this.songs.size())){
            playlist.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlaylist (String title, List<Song> playlist){
        Song checkedSong = findSong(title);
        if(checkedSong != null){
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }




}
