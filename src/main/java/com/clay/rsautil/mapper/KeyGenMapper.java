package com.clay.rsautil.mapper;

import com.clay.rsautil.model.KeyGenResponse;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface KeyGenMapper {

    KeyGenResponse entityToModel(com.clay.rsautil.entity.KeyGenData keyGenData);

    com.clay.rsautil.entity.KeyGenData modelToEntity(final KeyGenResponse keyGenRequest);

    @IterableMapping(elementTargetType = KeyGenResponse.class)
    List<KeyGenResponse> entityToModel(List<com.clay.rsautil.entity.KeyGenData> keyGenList);

    @IterableMapping(elementTargetType = com.clay.rsautil.entity.KeyGenData.class)
    List<com.clay.rsautil.entity.KeyGenData> modelToEntity(List<KeyGenResponse> keyGenList);
}
