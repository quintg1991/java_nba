package com.nba;

import java.util.*;

/**
 * Description: implementation of the Team class
 * 
 * @version 1.0
 * @date 10/27/2018
 * @author Franklin Glover
 */

public class Team
{
  public Collection<Player> members = new ArrayList<>();
  public String name;

  public Team(String name)
  {
    this.name = name;
  }

  /**
   * Default Team implementation
   * @param name
   * @param members
   */
  public Team(String name, ArrayList<Player> members)
  {
    super();
    this.name = name;
    this.members = new ArrayList<>();
  }

  /**
   * Add a player to the members list
   * @param p
   */
  public void addPlayer(Player p)
  {
    members.add(
        new Player(p.getFirst(), p.getLast(), p.getPosition(), p.getAge()));
  }

  /**
   * Display team either sorted or unsorted based on sort input
   * @param sort
   */
  public void displayTeam(boolean sort)
  {
    if(sort)
    {
      Collections.sort((ArrayList<Player>) members, new PlayerComparator());
      for(Player person : members)
      {
        System.out.println(person);
      }
    }
    else
    {
      for(Player person : members)
      {
        System.out.println(person);
      }
    }
  }

  /**
   * Determine if two Teams are equal
   */
  public boolean equals(Object o)
  {
    if(this.hashCode() == o.hashCode())
    {
      return true;
    }
    else
      return false;
  }

  public Collection<Player> getMembers()
  {
    return members;
  }

  public String getName()
  {
    return name;
  }

  public int getTeamSize()
  {
    return members.size();
  }

  public int hashCode()
  {
    return Objects.hashCode(name);
  }

  public void setMembers(Queue<Player> members)
  {
    this.members = members;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  @Override
  public String toString()
  {
    return "Team [name=" + name + ", members=" + members + "]\n";
  }
}
