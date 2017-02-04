package Generator;

import java.util.ArrayList;

/**
 * Created by oskar on 02/02/17.
 */
class DataOutputMock implements DataOutput {
	private ArrayList<SensorData> savedList = new ArrayList<SensorData>();

	@Override
	public void save(SensorData data) {
		this.savedList.add(data);
	}

	public ArrayList<SensorData> getSavedList() {
		return savedList;
	}
}
