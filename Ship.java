public class Ship {
    int attack;
    int health;
    int speed;
    int xLoc;
    int yLoc;
    int range;

    Ship(){
        attack = 5;
        health = 10;
        speed = 2;
        xLoc = 0;
        yLoc = 0;
        range = 3;
    }

    public Boolean inRange(Ship shipToHit){
        int distance = Math.abs(shipToHit.getXLoc() - xLoc);
        if(distance <= range){
            return true;
        }else{
            return false;
        }
    }

    public String attack(Ship shipToHit){
        String results = "";

        if(inRange(shipToHit)){
            shipToHit.health -= attack;

            if(shipToHit.health <= 0){
                results = "Your ship has destroyed the enemy ship.";
                return results;
            }else{
                results = "Your ship has hit enemy ship for " + attack + " points of damange. Enemey ship has " + shipToHit.getHealth() + " remaining.";
                return results;
            }
        }else{
            results = "Not in range.";
            return results;
        }

    }

    public int getAttack(){
        return attack;
    }

    public void upgradeAttack(){
        attack += 5;
    }

    public int getHealth(){
        return health;
    }

    public int getSpeed(){
        return speed;
    }

    public int getXLoc(){
        return xLoc;
    }

    public int getYLoc(){
        return yLoc;
    }

    public String moveX(int xValue){
        xLoc += xValue;
        String confirmX = "Ship has moved " + xValue + " places horizontally.";
        return confirmX;
    }

    public String moveY(int yValue){
        yLoc += yValue;
        String confirmY = "Ship has moved " + yValue + " places vertically.";
        return confirmY;
    }
}
