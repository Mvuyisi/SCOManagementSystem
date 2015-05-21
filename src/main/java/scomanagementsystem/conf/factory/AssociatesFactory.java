package scomanagementsystem.conf.factory;


import scomanagementsystem.domain.Associates;

/**
 * Created by student on 2015/05/10.
 */
public class AssociatesFactory {
    public static Associates createAssociate(String idNo,String alumniStatus){

        Associates associate = new Associates
                .Builder(idNo)
                .alumniStatus(alumniStatus)
                .build();
        return associate;
    }
}
