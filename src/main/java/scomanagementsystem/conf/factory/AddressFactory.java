package scomanagementsystem.conf.factory;

import scomanagementsystem.domain.Address;

import java.util.Map;

/**
 * Created by student on 2015/05/21.
 */
public class AddressFactory {
    public static Address createAddress(int houseNo,String streetNm, Map<String, String> values, int code){

        Address address = new Address
                .Builder(houseNo)
                .streetNm(streetNm)
                .suburb(values.get("suburb"))
                .city(values.get("city"))
                .code(code)
                .build();
        return address;
    }
}
