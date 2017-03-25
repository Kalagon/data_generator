package Generator;

import Main.DataOutput;

import java.util.ArrayList;

class DataOutputMock implements DataOutput {
	private ArrayList<SensorData> savedList = new ArrayList<SensorData>();

	@Override
	public void save(SensorData data) {
		this.savedList.add(data);
	}

	public void flush() {}

	public ArrayList<SensorData> getSavedList() {
		return savedList;
	}
}
