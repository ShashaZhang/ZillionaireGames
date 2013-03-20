package main.java.TerritoryPacket;

import main.java.MapPacket.MapBsc;
import main.java.PlayerPacket.Player;

public class Start extends TerritoryBsc{

	public Start(){
		super(0,'S');
	}

	@Override
	public void EnterTerritory(Player player,MapBsc Map) {
		
	}

}
