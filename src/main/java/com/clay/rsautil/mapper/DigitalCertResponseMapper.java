package com.clay.rsautil.mapper;

import com.clay.rsautil.entity.DigitalCertData;
import com.clay.rsautil.model.DigitalCertResponse;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DigitalCertResponseMapper {

    DigitalCertResponse entityToModel(DigitalCertData certData);

    DigitalCertData modelToEntity(final DigitalCertResponse certResponse);

    @IterableMapping(elementTargetType = DigitalCertResponse.class)
    List<DigitalCertResponse> entityToModel(List<DigitalCertData> digitalCertDataList);

    @IterableMapping(elementTargetType = DigitalCertData.class)
    List<DigitalCertData> modelToEntity(List<DigitalCertResponse> digitalCertResponses);
}
