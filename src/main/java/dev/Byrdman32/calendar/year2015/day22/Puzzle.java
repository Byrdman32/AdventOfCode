package dev.Byrdman32.calendar.year2015.day22;

import java.util.List;
import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle  {

    static int min = 2000;
    static boolean level2 = false;

    private static void boss(int bossHit, int bossDamage, int playerHit, int playerMoney, int moneySpent, int shieldCounter, int poisonCounter, int rechargeCounter) {
        if (playerMoney < 0 || moneySpent > min) return;
        int playerShield = shieldCounter > 0 ? 7 : 0;
        if (poisonCounter > 0) bossHit -= 3;
        if (rechargeCounter > 0) playerMoney += 101;
        shieldCounter = Math.max(0, shieldCounter - 1);
        poisonCounter = Math.max(0, poisonCounter - 1);
        rechargeCounter = Math.max(0, rechargeCounter - 1);

        if (bossHit <= 0) {
            if (moneySpent < min) min = moneySpent;
            return;
        }
        player(bossHit, bossDamage, playerHit - Math.max(1, bossDamage - playerShield), playerMoney, moneySpent, shieldCounter, poisonCounter, rechargeCounter);
    }

    private static void player(int bossHit, int bossDamage, int playerHit, int playerMoney, int moneySpent, int shieldCounter, int poisonCounter, int rechargeCounter) {
        if (level2) playerHit -= 1;
        if (playerHit <= 0 || playerMoney < 0 || moneySpent > min) return;
        if (poisonCounter > 0) bossHit -= 3;
        if (rechargeCounter > 0) playerMoney += 101;
        shieldCounter = Math.max(0, shieldCounter - 1);
        poisonCounter = Math.max(0, poisonCounter - 1);
        rechargeCounter = Math.max(0, rechargeCounter - 1);

        if (playerMoney >= 53)
            boss(bossHit - 4, bossDamage, playerHit, playerMoney - 53, moneySpent + 53, shieldCounter, poisonCounter, rechargeCounter);

        if (playerMoney >= 73)
            boss(bossHit - 2, bossDamage, playerHit + 2, playerMoney - 73, moneySpent + 73, shieldCounter, poisonCounter, rechargeCounter);

        if (shieldCounter == 0 && playerMoney >= 113)
            boss(bossHit, bossDamage, playerHit, playerMoney - 113, moneySpent + 113, 6, poisonCounter, rechargeCounter);

        if (poisonCounter == 0 && playerMoney >= 173)
            boss(bossHit, bossDamage, playerHit, playerMoney - 173, moneySpent + 173, shieldCounter, 6, rechargeCounter);

        if (rechargeCounter == 0 && playerMoney >= 229)
            boss(bossHit, bossDamage, playerHit, playerMoney - 229, moneySpent + 229, shieldCounter, poisonCounter, 5);
    }

    public Object solvePart1(List<String> input) {

        String[] boss = input.get(0).split(": ");
        int bossHit = Integer.parseInt(boss[1]);
        boss = input.get(1).split(": ");
        int bossDamage = Integer.parseInt(boss[1]);

        player(bossHit, bossDamage, 50, 500, 0, 0, 0, 0);

        return min;
    }

    public Object solvePart2(List<String> input) {

        min = 2000;
        level2 = true;

        String[] boss = input.get(0).split(": ");
        int bossHit = Integer.parseInt(boss[1]);
        boss = input.get(1).split(": ");
        int bossDamage = Integer.parseInt(boss[1]);

        player(bossHit, bossDamage, 50, 500, 0, 0, 0, 0);

        return min;
    }
}