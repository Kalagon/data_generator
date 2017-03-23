package Generator;

import java.util.Random;

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
