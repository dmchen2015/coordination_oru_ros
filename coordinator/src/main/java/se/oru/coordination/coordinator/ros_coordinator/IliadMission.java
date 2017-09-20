package se.oru.coordination.coordinator.ros_coordinator;

import java.util.ArrayList;

import org.metacsp.multi.spatioTemporal.paths.Pose;
import org.metacsp.multi.spatioTemporal.paths.PoseSteering;

import se.oru.coordination.coordination_oru.Mission;

public class IliadMission extends Mission {

	public static enum OPERATION_TYPE {LOAD_PALLET, UNLOAD_PALLET, PICK_ITEMS};
	private IliadItem[] items;
	private OPERATION_TYPE operationType;
	
	public IliadMission(int robotID, String fromLocation, String toLocation, Pose fromPose, Pose toPose, OPERATION_TYPE opType) {
		this(robotID, null, fromLocation, toLocation, fromPose, toPose);
		this.items = null;
		this.operationType = opType;
	}
	
	public IliadMission(int robotID, String fromLocation, String toLocation, Pose fromPose, Pose toPose, IliadItem ... items) {
		this(robotID, null, fromLocation, toLocation, fromPose, toPose);
		this.items = items;
		this.operationType = OPERATION_TYPE.PICK_ITEMS;
	}
	
	private IliadMission(int robotID, PoseSteering[] path, String fromLocation, String toLocation, Pose fromPose, Pose toPose) {
		super(robotID, path, fromLocation, toLocation, fromPose, toPose);
		// TODO Auto-generated constructor stub
	}
	
	public void setPath(PoseSteering[] path) {
		this.path = path;
	}
	
	public OPERATION_TYPE getOperationType() {
		return this.operationType;
	}
	
	public IliadItem[] getItems() {
		return this.items;
	}
	
	public IliadItem getItem(int i) {
		if (i >= 0 && i < items.length) return items[i];
		throw new Error("Item " + i + " does not exist");
	}

	public IliadItem[] getItems(String name) {
		ArrayList<IliadItem> ret = new ArrayList<IliadItem>();
		for (IliadItem item : items) if (item.getName().equals(name)) ret.add(item);
		if (ret.isEmpty()) return null;
		return ret.toArray(new IliadItem[ret.size()]);
	}

}