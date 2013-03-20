package Test.java;

import main.java.MapPacket.FirstMap;
import main.java.PlayerPacket.Player;
import main.java.TerritoryPacket.Hospital;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
public class TestHosptal {
    @Test
    public void Test_XiaoLi_In_Hospital(){
        Hospital hospital=new Hospital(14);
        Player Q = new Player(1);
        hospital.EnterTerritory(Q, new FirstMap());
        int StopTime = Q.GetStopTimes();
        assertThat(StopTime,is(3));
    }


}
