package class22;

public class Class22 {
    public static void main(String[] args) {
        Bot bot0 = new Bot("One", 10, 5, 2, 0.5, 0.2);
        Bot bot1 = new Bot("Two", 10, 5, 2, 0.5, 0.2);
        System.out.println("Winner is: " + fight(bot0, bot1));
    }

    public static Bot fight(Bot bot0, Bot bot1) {
        System.out.println("Fight between " + bot0 + " and " + bot1);

        int round = 1;
        while (true) {
            System.out.println("Round " + round);

            System.out.println("# " + bot0 + " attacks");
            bot0.attack(bot1);
            if (bot1.getHealth() == 0) {
                System.out.println("# " + bot0 + " wins");
                return bot0;
            }
            System.out.println("# " + bot1 + " health is " + bot1.getHealth());
            
            System.out.println("# " + bot1 + " attacks");
            bot1.attack(bot0);
            if (bot0.getHealth() == 0) {
                System.out.println("# " + bot1 + " wins");
                return bot1;
            }
            System.out.println("# " + bot0 + " health is " + bot0.getHealth());
            
            round++;
        }
    }
}