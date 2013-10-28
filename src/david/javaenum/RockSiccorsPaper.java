package david.javaenum;

import java.util.Random;

/*
 * ʯͷ��������Ϸ����һ���򵥵Ķ�·�ַ����ӣ���·�ַ���
 */
enum GameResult {
    ��, Ӯ, ƽ
}

interface IGame {
    GameResult complete(IGame item);

    GameResult eval(Rock item);

    GameResult eval(Siccors item);

    GameResult eval(Paper item);
}

/*
 * ʯͷ��
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
	return GameResult.ƽ;
    }

    @Override
    public GameResult eval(Siccors item) {
	// TODO Auto-generated method stub
	return GameResult.��;
    }

    @Override
    public GameResult eval(Paper item) {
	// TODO Auto-generated method stub
	return GameResult.Ӯ;
    }

    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return "ʯͷ";
    }
}

/*
 * ������
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
	return GameResult.Ӯ;
    }

    @Override
    public GameResult eval(Siccors item) {
	// TODO Auto-generated method stub
	return GameResult.ƽ;
    }

    @Override
    public GameResult eval(Paper item) {
	// TODO Auto-generated method stub
	return GameResult.��;
    }

    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return "����";
    }
}

/*
 * ����
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
	return GameResult.��;
    }

    @Override
    public GameResult eval(Siccors item) {
	// TODO Auto-generated method stub
	return GameResult.Ӯ;
    }

    @Override
    public GameResult eval(Paper item) {
	// TODO Auto-generated method stub
	return GameResult.ƽ;
    }

    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return "��";
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
     * ��Ϸ��ʼ
     */
    public static void gameStart(int count) {
	for (int i = 0; i < count; i++) {
	    gameStart(nextItem(), nextItem());
	}
    }
}
