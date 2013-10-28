package david.javaenum;

import java.util.Random;

/*
 * 石头剪刀布游戏描述一个简单的多路分发例子（两路分发）
 */
enum GameResult {
    输, 赢, 平
}

interface IGame {
    GameResult complete(IGame item);

    GameResult eval(Rock item);

    GameResult eval(Siccors item);

    GameResult eval(Paper item);
}

/*
 * 石头类
 */
class Rock implements IGame {

    @Override
    public GameResult complete(IGame item) {
	// TODO Auto-generated method stub
	return item.eval(this);
    }

    @Override
    public GameResult eval(Rock item) {
	// TODO Auto-generated method stub
	return GameResult.平;
    }

    @Override
    public GameResult eval(Siccors item) {
	// TODO Auto-generated method stub
	return GameResult.输;
    }

    @Override
    public GameResult eval(Paper item) {
	// TODO Auto-generated method stub
	return GameResult.赢;
    }

    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return "石头";
    }
}

/*
 * 剪刀类
 */
class Siccors implements IGame {

    @Override
    public GameResult complete(IGame item) {
	// TODO Auto-generated method stub
	return item.eval(this);
    }

    @Override
    public GameResult eval(Rock item) {
	// TODO Auto-generated method stub
	return GameResult.赢;
    }

    @Override
    public GameResult eval(Siccors item) {
	// TODO Auto-generated method stub
	return GameResult.平;
    }

    @Override
    public GameResult eval(Paper item) {
	// TODO Auto-generated method stub
	return GameResult.输;
    }

    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return "剪刀";
    }
}

/*
 * 布类
 */
class Paper implements IGame {

    @Override
    public GameResult complete(IGame item) {
	// TODO Auto-generated method stub
	return item.eval(this);
    }

    @Override
    public GameResult eval(Rock item) {
	// TODO Auto-generated method stub
	return GameResult.输;
    }

    @Override
    public GameResult eval(Siccors item) {
	// TODO Auto-generated method stub
	return GameResult.赢;
    }

    @Override
    public GameResult eval(Paper item) {
	// TODO Auto-generated method stub
	return GameResult.平;
    }

    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return "布";
    }
}

public class RockSiccorsPaper {

    private static IGame nextItem() {
	Random rand = new Random();
	IGame gameObj;

	switch (rand.nextInt() % 3) {
	case 0:
	    gameObj = new Rock();
	    break;
	case 1:
	    gameObj = new Siccors();
	    break;
	case 2:
	    gameObj = new Paper();
	    break;
	default:
	    gameObj = new Rock();
	    break;
	}

	return gameObj;
    }

    private static void gameStart(IGame a, IGame b) {
	System.out.println(a + " vs " + b + " = " + a.complete(b));
    }

    /*
     * 游戏开始
     */
    public static void gameStart(int count) {
	for (int i = 0; i < count; i++) {
	    gameStart(nextItem(), nextItem());
	}
    }
}
