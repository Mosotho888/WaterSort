import java.util.Random;
import java.util.Scanner;


/**
 * Write a description of class Watersort here.
 *
 * @author (Tebogo Mofokeng 35551178)
 * @version (a version number or a date)
 */
public class Watersort
{
    private static Character red= new Character('r');
    private static Character green = new Character('g');
    private static Character blue = new Character('b');
        
    public static void main(String [] args)
    {
        System.out.printf("\f");
        
        int moves = 0;
        int source = 0; 
        int target = 0; 
        int max = 4; 
        int full = 4;
        
        Random randomNum = new Random();
         
        StackAsMyArrayList<Character> bottles[] = new StackAsMyArrayList[5];
         
        bottles[0] = new StackAsMyArrayList<Character>();
        bottles[1] = new StackAsMyArrayList<Character>();
        bottles[2] = new StackAsMyArrayList<Character>();
        bottles[3] = new StackAsMyArrayList<Character>();
        bottles[4] = new StackAsMyArrayList<Character>();
         
         
         while (moves<4) 
        {
          
          target = randomNum.nextInt(max+1);
          while (bottles[target].getStackSize() == full)
          {
              target = randomNum.nextInt(max);
          }
          bottles[target].push(blue);
          target = randomNum.nextInt(max+1);
          while (bottles[target].getStackSize() == full)
          {
              target = randomNum.nextInt(max);
          }
          bottles[target].push(red);
          target = randomNum.nextInt(max+1);
          while (bottles[target].getStackSize() == full)
          {
              target = randomNum.nextInt(max);
          }
          bottles[target].push(green);
          
          moves++;
        }
        
        showAll(bottles);
        playTheGame(bottles);

    }
    
    public static void showAll(StackAsMyArrayList [] bottles)
    {
        for (int i = 0; i < bottles.length; i++)
        {
            System.out.println("bottle" + (i+1) + ": "+ bottles[i].toString());
        }
    }
    
    public static void playTheGame(StackAsMyArrayList [] bottles)
    {
        Scanner input = new Scanner(System.in);
        int source;
        int target;
        
        Character temp;
        while (checkSolved(bottles) == false)
        {
            
            do
            {
                System.out.print("\nEnter the source bottle number (1 to 5): ");
                source = input.nextInt();
                
            } while (source <= 0 || source >= 6);
            

            do
            {
                System.out.print("Enter the target bottle number (1 to 5): ");
                target = input.nextInt();
            }while (target <= 0 || target >= 6);
            
            Move move = new Move(source, target);
            
            switch(move.getSource())
            {
                case 1: 
                       if (move.getTarget() == 1)
                       {
                           System.out.println("Cannot move into the same bottle");
                        }
                        
                       if (move.getTarget() == 2)
                       {
                           if ((bottles[1].getStackSize() == 0) || (bottles[1].peek() == bottles[0].peek()))
                           {
                               temp = (Character) bottles[0].peek();
                               while (temp == bottles[0].peek() && (bottles[1].getStackSize() < 4))
                               {
                                   bottles[1].push(bottles[0].pop());
                                }
                                 
                           }
                           else 
                           {
                               System.out.println("Bottle 1 colour not the same as bottle 2 colour");
                           }
                        }
                        
                       if (move.getTarget() == 3)
                       {
                           if ((bottles[2].getStackSize() == 0) || (bottles[2].peek() == bottles[0].peek()))
                           {
                               temp = (Character) bottles[0].peek();
                               while (temp == bottles[0].peek() && (bottles[2].getStackSize() < 4))
                               {
                                   bottles[2].push(bottles[0].pop());
                                }
                                
                           }
                           else
                           {
                               System.out.println("Bottle 1 colour not the same as bottle 3 colour");
                           }
                        }
                        
                       if (move.getTarget() == 4)
                       {
                           if ((bottles[3].getStackSize() == 0) || (bottles[3].peek() == bottles[0].peek()))
                           {
                               temp = (Character) bottles[0].peek();
                               while (temp == bottles[0].peek() && (bottles[3].getStackSize() < 4))
                               {
                                   bottles[3].push(bottles[0].pop());
                                } 
                           }
                           else
                           {
                               System.out.println("Bottle 1 colour not the same as bottle 4 colour");
                           }
                        }
                        
                       if (move.getTarget() == 5)
                       {
                           if ((bottles[4].getStackSize() == 0) || (bottles[4].peek() == bottles[0].peek()))
                           {
                               temp = (Character) bottles[0].peek();
                               while (temp == bottles[0].peek() && (bottles[4].getStackSize() < 4))
                               {
                                   bottles[4].push(bottles[0].pop());
                                }
                                 
                           }
                           else
                           {
                               System.out.println("Bottle 1 colour not the same as bottle 5 colour");
                           }
                        }
                        showAll(bottles);
                        break;
                            
                case 2:
                       if (move.getTarget() == 1)
                       {
                           if ((bottles[0].getStackSize() == 0) || (bottles[0].peek() == bottles[1].peek()))
                           {
                               temp = (Character) bottles[1].peek();
                               while (temp == bottles[1].peek() && (bottles[0].getStackSize() < 4))
                               {
                                   bottles[0].push(bottles[1].pop());
                                } 
                           }
                           else
                           {
                               System.out.println("Bottle 2 colour not the same as bottle 2 colour");
                           }
                           
                        }
                        
                       if (move.getTarget() == 2)
                       {
                           System.out.println("Cannot move into the same bottle");
                        }
                        
                       if (move.getTarget() == 3)
                       {
                           if ((bottles[2].getStackSize() == 0) || (bottles[2].peek() == bottles[1].peek()))
                           {
                               temp = (Character) bottles[1].peek();
                               while (temp == bottles[1].peek() && (bottles[2].getStackSize() < 4))
                               {
                                   bottles[2].push(bottles[1].pop());
                                } 
                           }
                           else
                           {
                               System.out.println("Bottle 2 colour not the same as bottle 3 colour");
                           }
                        }
                        
                       if (move.getTarget() == 4)
                       {
                           if ((bottles[3].getStackSize() == 0) || (bottles[3].peek() == bottles[1].peek()))
                           {
                               temp = (Character) bottles[1].peek();
                               while (temp == bottles[1].peek() && (bottles[3].getStackSize() < 4))
                               {
                                   bottles[3].push(bottles[1].pop());
                                }  
                           }
                           else
                           {
                               System.out.println("Bottle 2 colour not the same as bottle 4 colour");
                           }
                        }
                        
                       if (move.getTarget() == 5)
                       {
                           if ((bottles[4].getStackSize() == 0) || (bottles[4].peek() == bottles[1].peek()))
                           {
                               temp = (Character) bottles[1].peek();
                               while (temp == bottles[1].peek() && (bottles[4].getStackSize() < 4))
                               {
                                   bottles[4].push(bottles[1].pop());
                                }   
                           }
                           else
                           {
                               System.out.println("Bottle 2 colour not the same as bottle 5 colour");
                           }
                        }
                        showAll(bottles);
                        break;
                        
                case 3:
                       if (move.getTarget() == 1)
                       {
                           if ((bottles[0].getStackSize() == 0) || (bottles[0].peek() == bottles[2].peek()))
                           {
                               temp = (Character) bottles[2].peek();
                               while (temp == bottles[2].peek() && (bottles[0].getStackSize() < 4))
                               {
                                   bottles[0].push(bottles[2].pop());
                                } 
                           }
                           else
                           {
                               System.out.println("Bottle 3 colour not the same as bottle 1 colour");
                           }
                           
                        }
                        
                       if (move.getTarget() == 2)
                       {
                           if ((bottles[1].getStackSize() == 0) || (bottles[1].peek() == bottles[2].peek()))
                           {
                               temp = (Character) bottles[2].peek();
                               while (temp == bottles[2].peek() && (bottles[1].getStackSize() < 4))
                               {
                                   bottles[1].push(bottles[2].pop());
                                } 
                           }
                           else
                           {
                               System.out.println("Bottle 3 colour not the same as bottle 2 colour");
                           }
                        }
                        
                       if (move.getTarget() == 3)
                       {
                           System.out.println("Cannot move into the same bottle");
                           
                        }
                        
                       if (move.getTarget() == 4)
                       {
                           if ((bottles[3].getStackSize() == 0) || (bottles[3].peek() == bottles[2].peek()))
                           {
                               temp = (Character) bottles[2].peek();
                               while (temp == bottles[2].peek() && (bottles[3].getStackSize() < 4))
                               {
                                   bottles[3].push(bottles[2].pop());
                                }  
                           }
                           else
                           {
                               System.out.println("Bottle 3 colour not the same as bottle 4 colour");
                           }
                        }
                        
                       if (move.getTarget() == 5)
                       {
                           if ((bottles[4].getStackSize() == 0) || (bottles[4].peek() == bottles[2].peek()))
                           {
                               temp = (Character) bottles[2].peek();
                               while (temp == bottles[2].peek() && (bottles[4].getStackSize() < 4))
                               {
                                   bottles[4].push(bottles[2].pop());
                                }
                           }
                           else
                           {
                               System.out.println("Bottle 3 colour not the same as bottle 5 colour");
                           }
                        }
                        showAll(bottles);
                        break;
                case 4:
                       if (move.getTarget() == 1)
                       {
                           if ((bottles[0].getStackSize() == 0) || (bottles[0].peek() == bottles[3].peek()))
                           {
                               temp = (Character) bottles[3].peek();
                               while (temp == bottles[3].peek() && (bottles[0].getStackSize() < 4))
                               {
                                   bottles[0].push(bottles[3].pop());
                                }  
                           }
                           else
                           {
                               System.out.println("Bottle 4 colour not the same as bottle 1 colour");
                           }
                           
                        }
                        
                       if (move.getTarget() == 2)
                       {
                           if ((bottles[1].getStackSize() == 0) || (bottles[1].peek() == bottles[3].peek()))
                           {
                               temp = (Character) bottles[3].peek();
                               while (temp == bottles[3].peek() && (bottles[1].getStackSize() < 4))
                               {
                                   bottles[1].push(bottles[3].pop());
                                } 
                           }
                           else
                           {
                               System.out.println("Bottle 4 colour not the same as bottle 2 colour");
                           }
                        }
                        
                       if (move.getTarget() == 3)
                       {
                           if ((bottles[2].getStackSize() == 0) || (bottles[2].peek() == bottles[3].peek()))
                           {
                               temp = (Character) bottles[3].peek();
                               while (temp == bottles[3].peek() && (bottles[2].getStackSize() < 4))
                               {
                                   bottles[2].push(bottles[3].pop());
                                } 
                           }
                           else
                           {
                               System.out.println("Bottle 4 colour not the same as bottle 3 colour");
                           }
                           
                        }
                        
                       if (move.getTarget() == 4)
                       {
                           System.out.println("Cannot move into the same bottle");
                           
                        }
                        
                       if (move.getTarget() == 5)
                       {
                           if ((bottles[4].getStackSize() == 0) || (bottles[4].peek() == bottles[3].peek()))
                           {
                               temp = (Character) bottles[3].peek();
                               while (temp == bottles[3].peek() && (bottles[4].getStackSize() < 4))
                               {
                                   bottles[4].push(bottles[3].pop());
                                }  
                           }
                           else
                           {
                               System.out.println("Bottle 4 colour not the same as bottle 5 colour");
                           }
                        }
                        showAll(bottles);
                        break;
                        
                case 5:
                       if (move.getTarget() == 1)
                       {
                           if ((bottles[0].getStackSize() == 0) || (bottles[0].peek() == bottles[4].peek()))
                           {
                               temp = (Character) bottles[4].peek();
                               while (temp == bottles[4].peek() && (bottles[0].getStackSize() < 4))
                               {
                                   bottles[0].push(bottles[4].pop());
                                }  
                           }
                           else
                           {
                               System.out.println("Bottle 5 colour not the same as bottle 1 colour");
                           }
                           
                        }
                        
                       if (move.getTarget() == 2)
                       {
                           if ((bottles[1].getStackSize() == 0) || (bottles[1].peek() == bottles[4].peek()))
                           {
                               temp = (Character) bottles[4].peek();
                               while (temp == bottles[4].peek() && (bottles[1].getStackSize() < 4))
                               {
                                   bottles[1].push(bottles[4].pop());
                                }  
                           }
                           else
                           {
                               System.out.println("Bottle 5 colour not the same as bottle 2 colour");
                           }
                        }
                        
                       if (move.getTarget() == 3)
                       {
                           if ((bottles[2].getStackSize() == 0) || (bottles[2].peek() == bottles[4].peek()))
                           {
                               temp = (Character) bottles[4].peek();
                               while (temp == bottles[4].peek() && (bottles[2].getStackSize() < 4))
                               {
                                   bottles[2].push(bottles[4].pop());
                                } 
                           }
                           else
                           {
                               System.out.println("Bottle 5 colour not the same as bottle 3 colour");
                           }
                           
                        }
                        
                       if (move.getTarget() == 4)
                       {
                           if ((bottles[3].getStackSize() == 0) || (bottles[3].peek() == bottles[4].peek()))
                           {
                               temp = (Character) bottles[4].peek();
                               while (temp == bottles[4].peek() && (bottles[3].getStackSize() < 4))
                               {
                                   bottles[3].push(bottles[4].pop());
                                }  
                           }
                           else
                           {
                               System.out.println("Bottle 5 colour not the same as bottle 4 colour");
                           }
                           
                        }
                        
                       if (move.getTarget() == 5)
                       {
                           System.out.println("Cannot move into the same bottle");
                           
                        }
                        showAll(bottles);
                        break;
                        
            }
        }
        
        System.out.println("\nYou won!!!!!!");
    }
    
    public static boolean checkSolved(StackAsMyArrayList [] bottles)
    {
        boolean item = true;
        
        for (int i = 0; i < bottles.length; i++)
        {
            item = bottles[i].checkStackUniform();
            
            if (!item)
            {
                break;
            }
        }
        
        return item;
    }
    
    public static int checkNumOfColors(int color, int counterRed, int counterGreen, int counterBlue, Random rand)
    {
        color = 1+ rand.nextInt(3);
        
        if (counterRed >= 4)
        {
            while (color == 1)
            {
                color = 1+ rand.nextInt(3);
            }
            
            if (color == 2 && counterGreen >= 4)
            {
                color += 1;
            }
            else if (color == 3 && counterBlue >= 4)
            {
                color -= 1;
            }
            
        }
        else if (counterGreen >= 4)
        {
            while (color == 2)
            {
                color = 1+ rand.nextInt(3);
            }
            
            if (color == 1 && counterRed >= 4)
            {
                color += 2;
            }
            else if (color == 3 && counterBlue >= 4)
            {
                color -= 2;
            }
            
        }
        else if (counterBlue >= 4)
        {
            while (color == 3)
            {
                color = 1+ rand.nextInt(3);
            }
            
            if (color == 1 && counterRed >= 4)
            {
                color += 1;
            }
            else if (color == 2 && counterGreen >= 4)
            {
                color -= 1;
            }
            
        }
        else
        {
            return color;
        }
        
        return color;
    }
}
