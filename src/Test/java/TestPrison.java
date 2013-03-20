package Test.java;

import main.java.MapPacket.FirstMap;
import main.java.PlayerPacket.Player;
import main.java.TerritoryPacket.Prison;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestPrison {
    @Test
    public void Test_XiaoLi_In_Hospital(){
        Prison prison=new Prison(49);
        Player Q = new Player(1);
        prison.EnterTerritory(Q, new FirstMap());
        int flag = Q.GetStopTimes();
        assertThat(flag,is(2));
    }
}
