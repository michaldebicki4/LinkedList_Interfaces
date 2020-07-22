package com.company;

import java.util.*;

public class Main {
// ALBUMY I PIOSENKI Z ALBUMÓW I TWORZENIE WŁASNEJ LISTY
    private static List<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {

        Album album = new Album("Strombringer", "Deep Purple");
        album.newSong("Stormbringer", 4.6);
        album.newSong("Smoke", 4.22);
        album.newSong("Holy Man", 4.3);
        album.newSong("Unholy Man", 5.6);
        album.newSong("Church", 3.21);
        album.newSong("Waterloo", 6.23);
        album.newSong("Otherside", 4.27);
        album.newSong("Whiskas moja żono", 4.1);
        albums.add(album);

        album = new Album("By The Way", "Red Hot Chilli Peppers");
        album.newSong("Minor Thing", 4.5);
        album.newSong("Midnight", 4.23);
        album.newSong("By The Way", 3.12);
        album.newSong("Venice Queen", 4.6);
        album.newSong("Can't Stop", 5.23);
        album.newSong("Does", 4.6);
        album.newSong("Cabron", 5.2);
        albums.add(album);


        List<Song> yourPlayList = new ArrayList<>();
        albums.get(0).addToPlaylist("Waterloo", yourPlayList);
        albums.get(0).addToPlaylist("Church", yourPlayList);
        albums.get(0).addToPlaylist("Speaking", yourPlayList); //Does not exist in 1rst album
        albums.get(0).addToPlayList(8, yourPlayList);
        albums.get(1).addToPlayList(3, yourPlayList);
        albums.get(1).addToPlayList(10, yourPlayList); //Does not exist in 2nd album
        albums.get(1).addToPlayList(30, yourPlayList);//Does not exist in 2nd album
        play(yourPlayList);


    }


    private static void play(List<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingforward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("No song in playlist ");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }
        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Playlist is over");
                    quit = true;
                    break;
                case 1:
                    if (!goingforward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingforward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next());
                    } else {
                        System.out.println("Reached the end of the list");
                        goingforward = false;
                    }
                    break;
                case 2:
                    if (goingforward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingforward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous());
                    } else {
                        System.out.println("We are at the start of the list");
                        goingforward = true;
                    }
                    break;
                case 3:
                    if(goingforward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            goingforward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if(listIterator.hasNext()){
                            System.out.println("Now replaying " + listIterator.next().toString());
                            goingforward = true;
                        }
                        else {
                            System.out.println("We are at the start of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size() >0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next());
                        }
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;
            }
        }
    }
    private static void printMenu() {
        System.out.println("Avaliable actions: \npress ");
        System.out.println("0 - to quit\n" +
                "1 -go to next song\n" +
                "2 - go to the previous song\n" +
                "3 - replay a song\n" +
                "4 - lists songs in the playlist\n " +
                "5 - print available actions\n" +
                "6 - delete current song from playList");
    }
    private  static  void printList (List<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("-------");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("----------");
    }
}
