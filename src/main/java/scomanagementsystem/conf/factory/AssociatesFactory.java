package scomanagementsystem.conf.factory;


import scomanagementsystem.domain.Address;
import scomanagementsystem.domain.Associates;
import scomanagementsystem.domain.PersonalDetails;

/**
 * Created by student on 2015/05/10.
 */
public class AssociatesFactory {
    public static Associates createAssociate(String idNo,String alumniStatus, Address address, PersonalDetails personalDetails){

        Associates associate = new Associates
                .Builder(idNo)
                .alumniStatus(alumniStatus)
                .address(address)
                .personalDetails(personalDetails)
                .build();
        return associate;
    }
}
