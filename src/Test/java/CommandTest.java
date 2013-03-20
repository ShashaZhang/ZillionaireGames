package Test.java;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import java.util.ArrayList;

import main.java.ControlPacket.Command;
import main.java.ControlPacket.CommandFactory;
import main.java.MapPacket.FirstMap;
import main.java.PlayerPacket.Player;
import main.java.PropPacket.Prop;
import main.java.TerritoryPacket.Land;
import main.java.TerritoryPacket.TerritoryBsc;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertThat;

public class CommandTest {
	private Player Qianfuren;
	private FirstMap firstMap;
	@Before
	public void Setup(){
		Qianfuren = new Player(1);
		firstMap = new FirstMap();
	}
	@Test
	public void player_begin_roll(){
		//Given
		//When
		Command RollCommand = CommandFactory.MakeCommand("roll", -100, Qianfuren,firstMap);
		RollCommand.ActCommand(Qianfuren,firstMap);
		boolean flag = Qianfuren.GetPosition() >= 0 && Qianfuren.GetPosition() <= 69;
		//Then
		assertThat(flag,is(equalTo(true)));
	}
	@Test
	public void player_setup_block_and_effect_others(){
		//Given
		//When
		Qianfuren.AddPoint(50);
		Qianfuren.GetUserInput().SetInput("3");
		Qianfuren.BuyProp();
		
		Command BlockCommand = CommandFactory.MakeCommand("block", 3, Qianfuren,firstMap);
		ArrayList<TerritoryBsc> MapPointList  = firstMap.GetMapPointList();
		TerritoryBsc territory = MapPointList.get(3);
		int BlockSetUpBy = territory.GetRoadBlock().getSetupBy();
		//Then
		assertThat(BlockSetUpBy,is(equalTo(1)));
		
		Player Atubo = new Player(2);
		Atubo.SetPosition(3);
		BlockCommand.ActCommand(Atubo,firstMap);
		Prop RoadBlock = territory.GetRoadBlock();
		//Then
		assertThat(RoadBlock,is(equalTo(null)));
	} 
	@Test
	public void return_player_assets_when_query_comman_activate(){
		Command QueryCommand = CommandFactory.MakeCommand("query", null, Qianfuren, firstMap);
		QueryCommand.ActCommand(Qianfuren, firstMap);
	}

	@Test
	public void player_setup_bomb_and_effect_others(){
		//Given
		//When
		Qianfuren.AddPoint(50);
		Qianfuren.GetUserInput().SetInput("3");
		Qianfuren.BuyProp();
		
		Command BombCommand = CommandFactory.MakeCommand("bomb", 3, Qianfuren,firstMap);
		ArrayList<TerritoryBsc> MapPointList  = firstMap.GetMapPointList();
		TerritoryBsc territory = MapPointList.get(3);
		int BlockSetUpBy = territory.GetBomb().getSetupBy();
		//Then
		assertThat(BlockSetUpBy,is(equalTo(1)));
		
		Player Atubo = new Player(2);
		Atubo.SetPosition(3);
		BombCommand.ActCommand(Atubo,firstMap);
		Prop RoadBlock = territory.GetBomb();
		//Then
		assertThat(RoadBlock,is(equalTo(null)));
		assertThat(Atubo.GetPosition(),is(equalTo(14)));
	} 
	
	@Test
	public void player_setup_Robot_and_effect(){
		//Given
		//When
		Qianfuren.AddPoint(50);
		Qianfuren.GetUserInput().SetInput("3");
		Qianfuren.BuyProp();
		
		CommandFactory.MakeCommand("block", 3, Qianfuren,firstMap);
		ArrayList<TerritoryBsc> MapPointList  = firstMap.GetMapPointList();
		TerritoryBsc territory = MapPointList.get(3);
		int BlockSetUpBy = territory.GetRoadBlock().getSetupBy();
		//Then
		assertThat(BlockSetUpBy,is(equalTo(1)));
		
		Player Atubo = new Player(2);
		Command RobotCommand = CommandFactory.MakeCommand("robot", null, Atubo, firstMap);
		RobotCommand.ActCommand(Atubo, firstMap);
		Prop RoadBlock = territory.GetRoadBlock();
		//Then
		assertThat(RoadBlock,is(equalTo(null)));
	}
	@Test
	public void return_extra_money_when_sell_area(){
		//Given
		Land land = new Land(1,200,0);
		Qianfuren.GetUserInput().SetInput("Y");
		Qianfuren.SetMoney(200);
		Qianfuren.BuyArea(land, firstMap);
		
		//when
		Command SellCommand = CommandFactory.MakeCommand("sell", 1, Qianfuren, firstMap);
		
		SellCommand.ActCommand(Qianfuren, firstMap);
		String FixedAssets = Qianfuren.GetFixedAssets();
		int Money = Qianfuren.GetMoney();
		//Then
		assertThat(FixedAssets,is(equalTo("地产：空地0处；茅屋0处；洋房0处；摩天楼0处。")));
		assertThat(Money,is(equalTo(400)));
	}
	
	@Test
	public void return_extra_money_when_sell_prop(){
		//Given
		Qianfuren.SetPoint(50);
		Qianfuren.GetUserInput().SetInput("1");
		Qianfuren.BuyProp();
		//when
		Command SellPropCommand = CommandFactory.MakeCommand("selltool", 1, Qianfuren, firstMap);
		SellPropCommand.ActCommand(Qianfuren, firstMap);
		String FixedAssets = Qianfuren.GetProp();
		int Point = Qianfuren.GetPoint();
		//Then
		assertThat(FixedAssets,is(equalTo("道具：路障0个；炸弹0个；机器娃娃0个。")));
		assertThat(Point,is(equalTo(50)));
	}
}
