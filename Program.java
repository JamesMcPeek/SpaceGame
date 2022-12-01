import java.util.Scanner;

    public class Program{
        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);
            String command = "";
            int money = 0;
            
            Ship ship = new Ship();
            System.out.println("Ship created");

            Ship enemyShip = new Ship();
            System.out.println("Enemy ship created");

            do{
                System.out.println("\nCurrent money: " + money);
                System.out.println("List of Commands:");
                System.out.println("get attack");
                System.out.println("get health");
                System.out.println("get x");
                System.out.println("upgrade");
                System.out.println("move");
                System.out.println("attack");
                System.out.print("What is your command? ");
                command = scanner.nextLine();

                switch(command){
                    case "get attack":{
                        System.out.println("Ship attack: " + ship.getAttack());
                    }
                    break;

                    case "get health":{
                        System.out.println("Ship health: " + ship.getHealth());
                    }
                    break;

                    case "get x":{
                        System.out.println("Ship xLoc: " + ship.getXLoc());
                    }
                    break;

                    case "upgrade":{
                        System.out.print("Upgrade ship attack +5 for 30 coins. Proceed? ");
                        String proceed = scanner.nextLine();

                        if(proceed.equals("yes") && money >= 30){
                            ship.upgradeAttack();
                            money -= 30;
                            System.out.println("Upgrade complete.");
                        }else{
                            System.out.println("Come back again.");
                        }
                        
                    }   
                    break;

                    case "move":{
                        System.out.print("Move how many spaces? ");
                        int move = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Ship move: " + ship.moveX(move));
                    }
                    break;
                    
                    case "attack":{
                        System.out.println("Ship attacks enemy: " + ship.attack(enemyShip));
                        if(enemyShip.getHealth() <= 0){
                            money += 10;
                            enemyShip = null;
                            enemyShip = new Ship();
                            System.out.println("New enemy spawned at (0,0)");
                        }
                    }
                    break;
                }
            }while(!(command.equals("exit")));
        }//end main

    }//end Program