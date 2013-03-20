package main.java.ControlPacket;

import main.java.MapPacket.MapBsc;
import main.java.PlayerPacket.Player;

public class QuitCommand extends Command{

	public QuitCommand(){}
	
	@Override
	public void ActCommand(Player player, MapBsc Map) {
		System.exit(-1);
	}
}
