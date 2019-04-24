package com.nba;

import java.util.Comparator;

/**
 * Description: Implementation of the PlayerComparator class
 * 
 * @version 1.0
 * @date 10/27/2018
 * @author Franklin Glover
 *
 */
public class PlayerComparator implements Comparator<Player>
{

   @Override
   public int compare(Player p1, Player p2)
   {
     return p1.getAge() - p2.getAge();
   }

}
