package com.fmontiel.restapi.service;

import com.fmontiel.restapi.dto.HourDTO;
import com.fmontiel.restapi.dto.ResponseDTO;

/**
 * The interface Hour service.
 *
 * @author Fernando Montiel Meza.
 */
public interface HourService {

    /**
     * Gets hour by time zone.
     *
     * @param hourDTO the hour dto
     * @return the hour by time zone
     */
    ResponseDTO getHourByTimeZone(HourDTO hourDTO);
}
