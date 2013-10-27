package david.javaenum;

import java.util.Random;

enum GameObject {
	ʯͷ, ����, ��;

	/*
	 * ʯͷ��������ά���飨˳��: ʯͷ��������
	 */
	private GameResult[][] table = {{GameResult.ƽ, GameResult.��, GameResult.Ӯ},
			{GameResult.Ӯ, GameResult.ƽ, GameResult.��},
			{GameResult.��, GameResult.Ӯ, GameResult.ƽ}};

	public GameResult compete(GameObject obj) {
		return table[obj.ordinal()][this.ordinal()];
	}
}

public class RockSiccorsPaperArray {
	/*
	 * ����ʹ�ö�ά������ж�·�ַ�
	 */
	public static void testGame(int count) {
		for (int i = 0; i < count; i++) {
			GameObject a = random();
			GameObject b = random();
			System.out.println(String.format("%s vs %s => %s", a.toString(),
					b.toString(), a.compete(b)));
		}
	}

	public static GameObject random() {

		Random rand = new Random();
		GameObject go;
		switch (rand.nextInt() % 3) {
			case 0 :
				go = GameObject.ʯͷ;
				break;
			case 1 :
				go = GameObject.����;
				break;
			case 2 :
				go = GameObject.��;
				break;
			default :
				go = GameObject.ʯͷ;
				break;
		}

		return go;
	}
}
