package main.java.MapPacket;

import java.util.ArrayList;

import main.java.TerritoryPacket.TerritoryBsc;


public abstract class MapBsc {
	private ArrayList<TerritoryBsc> MapPointList=new ArrayList<TerritoryBsc>();

	public ArrayList<TerritoryBsc> GetMapPointList() {
		return MapPointList;
	}

	public void SetMapPointList(ArrayList<TerritoryBsc> mapPointList) {
		MapPointList = mapPointList;
	}
	
	public abstract ArrayList<Character> GetMapPointDisplayList();
}
