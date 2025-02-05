package com.pl.premier_zone;


import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PlayerCSVGenerator {
    public static void main(String[] args) {
        List<Player> players = List.of(
                new Player(1, "Lionel Messi", "Forward", "Paris Saint-Germain", 37, "Argentina"),
                new Player(2, "Cristiano Ronaldo", "Forward", "Al Nassr", 38, "Portugal"),
                new Player(3, "Neymar Jr", "Forward", "Al Hilal", 31, "Brazil"),
                new Player(4, "Kevin De Bruyne", "Midfielder", "Manchester City", 32, "Belgium"),
                new Player(5, "Kylian Mbappé", "Forward", "Paris Saint-Germain", 25, "France")
        );
        
        // Define CSV file path
        String csvFile = "players.csv";
        
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFile))) {
            // Write header to the CSV file
            writer.writeNext(new String[]{"ID", "Name", "Position", "Team", "Age", "Nationality"});
            
            // Write each player's data to the CSV file
            for (Player player : players) {
                writer.writeNext(new String[]{
                        String.valueOf(player.getId()),
                        player.getName(),
                        player.getPosition(),
                        player.getTeam(),
                        String.valueOf(player.getAge()),
                        player.getNationality()
                });
            }

            System.out.println("CSV file created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Player {
    private int id;
    private String name;
    private String position;
    private String team;
    private int age;
    private String nationality;

    public Player(int id, String name, String position, String team, int age, String nationality) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.team = team;
        this.age = age;
        this.nationality = nationality;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getTeam() {
        return team;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }
}
