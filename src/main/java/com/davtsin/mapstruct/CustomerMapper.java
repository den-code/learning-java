package com.davtsin.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = AddressMapper.class)
// componentModel = "cdi" - для спринга: сгенерирует @ApplicationScoped над имплементацией
//@Mapper(uses = AddressMapper.class, componentModel = "cdi")
public interface CustomerMapper {

    @Mapping(target = "customerId", source = "id")
    @Mapping(target = "dateOfBirth", dateFormat = "dd.MM.yyyy")
    @Mapping(target = "fullName", expression = "java(customer.getFirstName() + customer.getLastName())")
    CustomerDto customerToDto(Customer customer);

    default String toString(Title title) {
        return title.getValue();
    }
}
