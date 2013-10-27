package david.javaenum;

import java.util.EnumMap;
import java.util.Random;

interface Competitor<T extends Competitor<T>> {
    GameResult compete(T Competitor);
}

enum GameObj implements Competitor<GameObj> {
    ʯͷ, ����, ��;
    // ÿ����Ϸ����ֱ���䣬����Ӧ��3�ֽ��������EnumMap����
    static EnumMap<GameObj, EnumMap<GameObj, GameResult>> table = new EnumMap<GameObj, EnumMap<GameObj, GameResult>>(
	    GameObj.class);

    /*
     * ��ʼ��3������ı�������EnumMap
     */
    static {
	for (GameObj key : GameObj.values()) {
	    table.put(key, new EnumMap<GameObj, GameResult>(GameObj.class));
	}
	init(ʯͷ, GameResult.ƽ, GameResult.��, GameResult.Ӯ); // ע�� =>
							    // keyΪ���ߣ�����Ϊǰ��
	init(����, GameResult.Ӯ, GameResult.ƽ, GameResult.��);
	init(��, GameResult.��, GameResult.Ӯ, GameResult.ƽ);
    }

    /*
     * ��ʼ������
     */
    public static void init(GameObj obj, GameResult rock, GameResult siccors,
	    GameResult paper) {
	EnumMap<GameObj, GameResult> map = table.get(obj);
	map.put(ʯͷ, rock);
	map.put(����, siccors);
	map.put(��, paper);
    }

    @Override
    public GameResult compete(GameObj item) {
	// TODO Auto-generated method stub
	return table.get(item).get(this);
    }
}

public class RockSiccorsPaperEnumMap {

    /*
     * ����ʹ��EnumMapʹ�ö�·�ַ�
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
	    go = GameObj.ʯͷ;
	    break;
	case 1:
	    go = GameObj.����;
	    break;
	case 2:
	    go = GameObj.��;
	    break;
	default:
	    go = GameObj.ʯͷ;
	    break;
	}

	return go;
    }
}
