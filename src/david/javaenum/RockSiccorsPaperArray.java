package david.javaenum;

import java.util.Random;

enum GameObject {
	石头, 剪刀, 布;

	/*
	 * 石头剪刀布二维数组（顺序: 石头剪刀布）
	 */
	private GameResult[][] table = {{GameResult.平, GameResult.输, GameResult.赢},
			{GameResult.赢, GameResult.平, GameResult.输},
			{GameResult.输, GameResult.赢, GameResult.平}};

	public GameResult compete(GameObject obj) {
		return table[obj.ordinal()][this.ordinal()];
	}
}

public class RockSiccorsPaperArray {
	/*
	 * 测试使用二维数组进行二路分发
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
				go = GameObject.石头;
				break;
			case 1 :
				go = GameObject.剪刀;
				break;
			case 2 :
				go = GameObject.布;
				break;
			default :
				go = GameObject.石头;
				break;
		}

		return go;
	}
}
