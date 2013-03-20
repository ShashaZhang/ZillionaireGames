package main.java.ControlPacket;

import main.java.MapPacket.MapBsc;
import main.java.PlayerPacket.Player;
import main.java.TerritoryPacket.Land;

public class SellCommand extends Command{

	private int HouseID;
	
	public SellCommand(int HouseID){
		this.HouseID = HouseID;
	}
	
	@Override
	public void ActCommand(Player player, MapBsc Map) {
		Land Territory = (Land) Map.GetMapPointList().get(HouseID);
		player.SellArea(Territory,Map);
	}

}
