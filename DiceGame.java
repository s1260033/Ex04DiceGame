import java.util.Random;

class Player {
    String name;

    Player(String str) {
	this.name = str;
    }
}

class Die {
    int faceValue;
    Random r = new Random();

    Die() {
	this.roll();
    }

    void roll() {
	this.faceValue = r.nextInt(5) + 1;
    }

    int getFaceValue() {
	return faceValue;
    }

}



class DiceGame {
    public static void main(String[] args) {
	int i = 0, sum = 0;
	Die[]  di = {
	    new Die(),
	    new Die(),
	};

  

	System.out.println("Rolling the dice . . .");


	for(i = 0 ; i < di.length ; i++) {
	    System.out.printf("Die %d: %d\n",i+1,di[i].getFaceValue());
	    sum += di[i].getFaceValue();
	}

	System.out.printf("Total value: %d\n",sum);
    }  
}
