package scomanagementsystem.conf.factory;

import scomanagementsystem.domain.GatheringTimes;
import scomanagementsystem.domain.Membership;
import scomanagementsystem.domain.SubcomsAndMinistries;

import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/05/21.
 */
public class SubcomsAndMinistriesFactory {
    public static SubcomsAndMinistries createSubcomOrMinistry(Integer smNo,String name, Map<String, String> values, String studNo, List<Membership> membership,GatheringTimes gatheringTimes){

        SubcomsAndMinistries subcomOrMinistry = new SubcomsAndMinistries
                .Builder(smNo)
                .name(name)
                .leader(values.get("leader"))
                .venue(values.get("venue"))
                .studNo(studNo)
                .membership(membership)
                .gatheringTimes(gatheringTimes)
                .build();
        return subcomOrMinistry;
    }
}
