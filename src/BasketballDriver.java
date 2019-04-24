import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.nba.League;
import com.nba.Player;
import com.nba.Team;

public class BasketballDriver
{

  public static void main(String[] args)
  {

    League nba = null;

    try
    {
      BufferedReader br = new BufferedReader(
          new FileReader("NBAstats2018.csv"));
      String[] header = null;

      // read the first line and save these labels for later...
      if(br.ready())
      {
        String columnLabels = br.readLine();
        header = columnLabels.split(",");
      }

      nba = new League("NBA");

      while(br.ready())
      {
        String line = br.readLine();
        String[] data = line.split(",");

        // fields for Player constructor
        String name = data[1];
        String[] partsName = name.split(" ");
        String pos = data[2];
        String age = data[3];

        // team
        String teamName = data[4];
        if(teamName.equals("TOT"))
        {
          continue;
        }
        Team currentTeam = nba.getTeam(teamName);
        if(currentTeam == null)
        {
          currentTeam = new Team(teamName);
          nba.add(currentTeam);
        }

        Player p = new Player(partsName[0], partsName[1], pos,
            Integer.parseInt(age));

        // create a single map object for all stats
        HashMap<String, Double> stats = new HashMap<>();
        for(int i = 5; i < data.length; i++)
        {
          Double value = 0.0;
          if(data[i].length() > 0)
          {
            value = Double.parseDouble(data[i]);
          }
          stats.put(header[i], value);
        }
        p.setStats(stats);

        // System.out.println("the current team is: " + currentTeam);
        // System.out.println("the current player is: " + p);
        // System.out.println(p);
        currentTeam.addPlayer(p);

        
      } // end while
      br.close();
    }
    catch(FileNotFoundException e)
    {
      System.err.println("File not found: " + e.getMessage());
    }
    catch(IOException ioe)
    {
      System.err.println("Error reading data: " + ioe.getMessage());
    }

    Scanner input = new Scanner(System.in);
    while(true)
    {
      // System.out.println(nba);
      System.out.print("Pick a team (q to quit): ");
      String teamName = input.nextLine();
      if(teamName.equals("q"))
      {
        break;
      }
      Team team = nba.getTeam(teamName);
      if(team != null)
      {
        team.displayTeam(false);
        System.out.println(
            "----------------------------------------- by age -------------------------");
        team.displayTeam(true);
      }
    }
    input.close();

  }

}
