import java.util.Random;
import java.util.Scanner;

class Player {
    String name;

    Player(String str) {
	this.name = str;
    }

    String getName() {
	return this.name;
    }

    void Greeting() {
	System.out.println("Hello, " + getName() + "!");
    }

    
}

class Die {
    int faceValue;
    Random r = new Random();

    Die() {
	this.roll();
    }

    void roll() {
	this.faceValue = r.nextInt(6) + 1;
    }

    int getFaceValue() {
	return faceValue;
    }

}



class DiceGame {
    public static void main(String[] args) {
	Scanner s = new Scanner(System.in);

	int i = 0, sum = 0, flag = 0;
	Die[]  di;
	Random r = new Random();


	di = new Die[r.nextInt(5)+2];
	for(i = 0 ; i < di.length ; i++) {
	    di[i] = new Die();
	}
	
	System.out.println("What is your name?");
	System.out.print("> ");

	Player p = new Player(s.nextLine());
	p.Greeting();
	
	System.out.println("Rolling the dice . . .");
	System.out.printf("Die 1: %d\n",di.length);
	System.out.printf("You can throw %d dices\n",di.length);

	
	for(i = 0 ; i < di.length ; i++) {
	    System.out.printf("Die %d: %d\n",i+1,di[i].getFaceValue());
	    sum += di[i].getFaceValue();
	}

	for(i = 1 ; i < di.length ; i++) {
	    if(di[0].getFaceValue() != di[i].getFaceValue()) {
		flag = 0;
		break;
	    }
	    else flag = 1;
	}

	if(flag == 1) {
	    System.out.println("Dices show the same number!");
	    System.out.println("You can throw the dice again!");
	    Die chance = new Die();
	    System.out.printf("Die %d: %d\n",di.length + 1, chance.getFaceValue());
	    sum += chance.getFaceValue();
	}
	else flag = 0;

	System.out.printf("Total value: %d\n",sum);

	if(sum > (6*di.length) / 2) System.out.println(p.getName() + " won!");
	else System.out.println(p.getName() + " lost");
    }  
}
