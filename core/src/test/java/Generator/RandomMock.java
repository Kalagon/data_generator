package Generator;

import java.util.Random;

/**
 * Created by oskar on 02/02/17.
 */
class RandomMock extends Random {
	@Override
	public int nextInt(int input) {
		return 10;
	}

	@Override
	public float nextFloat() {
		return 0f;
	}

	@Override
	public boolean nextBoolean() {
		return true;
	}
}
