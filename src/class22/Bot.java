package class22;

public class Bot {
    private String name;
    private int health;
    private int attack;
    private int block;
    
    Bot(String name, int health, int attack, int block, double attackChance, double blockChance) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.block = block;
    }
    
    public String toString() {
        return "Bot-" + this.name;
    }
    
    public String getName() {
        return name;
    }
    
    public double getAttackChance() {
        return 0.4;
    }
    
    public double getBlockChance() {
        return 0.2;
    }
    
    public int getAttack() {
        return this.attack;
    }
    
    public int getBlock() {
        return this.block;
    }
    
    public int getHealth() {
        return this.health;
    }
    
    public void updateHealth(int change) {
        this.health += change;
        if (this.health < 0) {
            this.health = 0;
        }
    }
    
    /**
     * Attack another bot. Return true if damage was done.
     */
    public boolean attack(Bot other) {
        boolean attackSucceeds = Math.random() < this.getAttackChance();
        int damage = 0;
        
        if (attackSucceeds) {
            damage += this.getAttack();

            boolean blockSucceeds = Math.random() < this.getBlockChance();
            if (blockSucceeds) {
                damage -= this.getBlock();
                if (damage < 0) {
                    damage = 0;
                }
            }

            other.updateHealth(-damage);
        }
        
        return damage > 0;
    }
}
