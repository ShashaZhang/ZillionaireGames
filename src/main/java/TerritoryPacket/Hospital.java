package main.java.TerritoryPacket;

import main.java.MapPacket.MapBsc;
import main.java.PlayerPacket.Player;

public class Hospital extends TerritoryBsc {

    public Hospital(int ID){
    	super(ID,'H');
    }

	@Override
	public void EnterTerritory(Player player,MapBsc Map) {
		player.SetStopTimes(3);
	}
}
