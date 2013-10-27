package david.javaenum;

import java.util.EnumMap;
import java.util.Random;

interface Competitor<T extends Competitor<T>> {
    GameResult compete(T Competitor);
}

enum GameObj implements Competitor<GameObj> {
    石头, 剪刀, 布;
    // 每个游戏对象分别填充，他对应的3种结果所以用EnumMap保存
    static EnumMap<GameObj, EnumMap<GameObj, GameResult>> table = new EnumMap<GameObj, EnumMap<GameObj, GameResult>>(
	    GameObj.class);

    /*
     * 初始化3个对象的保存容器EnumMap
     */
    static {
	for (GameObj key : GameObj.values()) {
	    table.put(key, new EnumMap<GameObj, GameResult>(GameObj.class));
	}
	init(石头, GameResult.平, GameResult.输, GameResult.赢); // 注意 =>
							    // key为后者，参数为前者
	init(剪刀, GameResult.赢, GameResult.平, GameResult.输);
	init(布, GameResult.输, GameResult.赢, GameResult.平);
    }

    /*
     * 初始化容器
     */
    public static void init(GameObj obj, GameResult rock, GameResult siccors,
	    GameResult paper) {
	EnumMap<GameObj, GameResult> map = table.get(obj);
	map.put(石头, rock);
	map.put(剪刀, siccors);
	map.put(布, paper);
    }

    @Override
    public GameResult compete(GameObj item) {
	// TODO Auto-generated method stub
	return table.get(item).get(this);
    }
}

public class RockSiccorsPaperEnumMap {

    /*
     * 测试使用EnumMap使用二路分发
     */
    public static void testGame(int count) {
	for (int i = 0; i < count; i++) {
	    GameObj a = random();
	    GameObj b = random();
	    System.out.println(String.format("%s vs %s => %s", a.toString(),
		    b.toString(), a.compete(b)));
	}
    }

    public static GameObj random() {

	Random rand = new Random();
	GameObj go;
	switch (rand.nextInt() % 3) {
	case 0:
	    go = GameObj.石头;
	    break;
	case 1:
	    go = GameObj.剪刀;
	    break;
	case 2:
	    go = GameObj.布;
	    break;
	default:
	    go = GameObj.石头;
	    break;
	}

	return go;
    }
}
