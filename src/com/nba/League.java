package com.nba;

import java.util.*;

/**
 * Description: implementation of the League class
 * 
 * @version 1.0
 * @date 10/27/2018
 * @author Franklin Glover
 */

public class League
{
  private String name;
  private Set<Team> teams = new HashSet<>();

  /**
   * Default League implementation
   * @param name
   */
  public League(String name)
  {
    this.name = name;
  }

  // If team is in set add it otherwise, return false
  public boolean add(Team team)
  {
    if(teams.contains(team))
    {
      return false;
    }
    else
    {
      teams.add(new Team(team.getName()));
      return true;
    }
  }
  
  // Get a list of teams
  public Team getTeam(String name)
  {
    for(Team team : teams)
    {
      String str1 = team.getName();
      String str2 = name;
      if(str1.equals(str2))
      {
        return team;
      }
    }
    return null;
  }

  @Override
  public String toString()
  {
    return "League [name=" + name + ", teams=" + teams + "]";
  }

}
