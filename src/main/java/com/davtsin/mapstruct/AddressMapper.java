package com.davtsin.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AddressMapper {

    @Mapping(target = "cityDto", source = "city")
    @Mapping(target = "arriveDate", dateFormat = "dd.MM.yyyy")
    AddressDto toAddressDto(Address address);
}
