package main.java.ControlPacket;

import main.java.MapPacket.MapBsc;
import main.java.PlayerPacket.Player;

public abstract class Command {
	public abstract void ActCommand(Player player ,MapBsc map);
}
