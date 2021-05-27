package com.fmontiel.restapi.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.stereotype.Service;

import com.fmontiel.restapi.dto.HourDTO;
import com.fmontiel.restapi.dto.ResponseDTO;
import com.fmontiel.restapi.service.HourService;

import lombok.extern.slf4j.Slf4j;

/**
 * The class Hour service.
 *
 * @author Fernando Montiel Meza.
 */
@Service
@Slf4j
public class HourServiceImpl implements HourService {

    @Override
    public ResponseDTO getHourByTimeZone(HourDTO hourDTO) {
        log.info("Dato de entrada - hourDTO: {}", hourDTO);

        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.of(LocalDate.now(), hourDTO.getTime()),
                hourDTO.getTimeZone());
        ZonedDateTime zonedDateTimeUTC = zonedDateTime.withZoneSameInstant(ZoneId.of("UTC"));

        return ResponseDTO.builder()
                .response(HourDTO.builder()
                        .time(zonedDateTimeUTC.toLocalTime())
                        .timeZone(zonedDateTimeUTC.getZone())
                        .build())
                .build();
    }
}
