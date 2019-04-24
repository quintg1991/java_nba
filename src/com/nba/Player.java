package com.nba;

/**
 * Description: implementation of the Player class
 * 
 * @version 1.0
 * @date 10/27/2018
 * @author Franklin Glover
 */

import java.util.HashMap;

public class Player
{
  private int age;
  private String first;
  private String last;
  private String position;

  /**
   * Default Player implementation
   * @param first
   * @param last
   * @param position
   * @param age
   */
  public Player(String first, String last, String position, int age)
  {
    this.first = first;
    this.last = last;
    this.position = position;
    this.age = age;
  }

  // Compare ages of players
  public int compareTo(Player p)
  {
    Integer age = new Integer(this.age);

    if(age.equals(p.getAge()))
    {
      return 0;
    }
    else
    {
      return 1;
    }
  }

  public int getAge()
  {
    return age;
  }

  public String getFirst()
  {
    return first;
  }

  public String getLast()
  {
    return last;
  }

  public String getPosition()
  {
    return position;
  }

  public void setAge(int age)
  {
    this.age = age;
  }

  public void setFirst(String first)
  {
    this.first = first;
  }

  public void setLast(String last)
  {
    this.last = last;
  }

  public void setPosition(String position)
  {
    this.position = position;
  }

  // Unimplemented
  public void setStats(HashMap<String, Double> stats)
  {
    
  }

  @Override
  public String toString()
  {
    return "Player [first=" + first + ", last=" + last + ", position="
        + position + ", age=" + age + "]";
  }

}
