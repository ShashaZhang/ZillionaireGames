package main.java.ControlPacket;

import main.java.MapPacket.MapBsc;
import main.java.PlayerPacket.Player;
import main.java.PropPacket.Prop;

public class SellToolCommand extends Command {

	private Prop prop;
	
	public SellToolCommand(int ID){
		prop = new Prop(ID);
	}
	@Override
	public void ActCommand(Player player,MapBsc Map) {
		player.SellProp(prop);
	}

}
