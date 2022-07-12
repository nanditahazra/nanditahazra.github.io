package Application;

import java.util.Scanner;

public class Driver {
    private static MusicLibrary app = new MusicLibrary();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter(System.lineSeparator());
        String addAgain;
        int userId, artistId, songId;

        registerUsers(sc);
        registerArtists(sc);
        releaseSongs(sc);

        do{
            try {
                System.out.println("Please choose the operation you'd like to perform: " +
                        "\n1. Play a song." +
                        "\n2. Get top 10 songs of a user." +
                        "\n3. Get top 10 songs overall." +
                        "\n4. Get all songs of an artist.");
                System.out.print("Your choice : ");
                int operationChoice = Integer.parseInt(sc.nextLine());

                switch(operationChoice){
                    case 1:
                        try {
                            System.out.print("Please enter the user ID : ");
                            userId = Integer.parseInt(sc.nextLine());
                            System.out.print("Please enter the song ID : ");
                            songId = Integer.parseInt(sc.nextLine());
                            app.playSong(songId, userId);
                        }
                        catch (Exception ex){
                            System.out.println(ex.getMessage());
                        }
                        break;

                    case 2:
                        try {
                            System.out.print("Please enter the user ID : ");
                            userId = Integer.parseInt(sc.nextLine());
                            app.getTop10SongsForUser(userId);
                        }
                        catch (Exception ex){
                            System.out.println(ex.getMessage());
                        }
                        break;

                    case 3:
                        app.getTop10Songs();
                        break;

                    case 4:
                        try {
                            System.out.println("Please select an artist(enter the sequence number only)");
                            app.printArtists();
                            System.out.print("Please select the artist ID : ");
                            artistId = Integer.parseInt(sc.nextLine());
                            app.getSongsByArtist(artistId);
                        }
                        catch (Exception ex){
                            System.out.println(ex.getMessage());
                        }
                        break;

                    default:
                        System.out.println("Please enter a valid choice");
                }
            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
            }

            System.out.println("Would you like to perform another operation?(Y/N)");
            addAgain = sc.nextLine();
        } while (addAgain.equals("Y"));

    }

    public static void registerUsers(Scanner sc){
        System.out.println("----------- User registration -----------");
        String addAgain;
        do {
            System.out.println("Please enter user details to add a user.");
            try {
                System.out.print("First name : ");
                String firstName = sc.nextLine();
                System.out.print("Last name : ");
                String lastName = sc.nextLine();
                // registering user in music library
                app.registerUser(firstName, lastName);
            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
            }
            System.out.println("Would you like to add another user?(Y/N)");
            addAgain = sc.nextLine();
        }while(addAgain.equals("Y"));
    }

    public static void registerArtists(Scanner sc) {
        System.out.println("----------- Artist registration -----------");
        String addAgain;
        do {
            try {
                System.out.println("Please enter user details to add an artist.");
                System.out.print("First Name : ");
                String firstName = sc.nextLine();
                System.out.print("Last Name : ");
                String lastName = sc.nextLine();
                app.registerArtist(firstName, lastName);
            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
            }
            System.out.println("Would you like to add another user?(Y/N)");
            addAgain = sc.nextLine();
        } while (addAgain.equals("Y"));
    }

    public static void releaseSongs(Scanner sc){
        System.out.println("----------- Releasing Song -----------");
        String addAgain;
        do {
            try{
                System.out.println("Please enter user details to add an song.");
                System.out.print("Title  : ");
                String title = sc.nextLine();
                System.out.print("Genre : ");
                String genre = sc.nextLine();
                System.out.print("Release year : ");
                int releaseYear = Integer.parseInt(sc.nextLine());
                System.out.print("Audio language : ");
                String language = sc.nextLine();
                System.out.println("Please select an artist(enter the sequence number only)");
                app.printArtists();
                int artistId = Integer.parseInt(sc.nextLine());
                app.addSong(artistId, title, genre, releaseYear, language);
            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
            }
            System.out.println("Would you like to add another song?(Y/N)");
            addAgain = sc.nextLine();
        } while (addAgain.equals("Y"));
    }
}
