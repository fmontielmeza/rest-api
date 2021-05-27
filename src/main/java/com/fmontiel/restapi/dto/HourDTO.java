package com.fmontiel.restapi.dto;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.TimeZone;

import lombok.Builder;
import lombok.Data;

/**
 * The class Hour dto.
 *
 * @author Fernando Montiel Meza.
 */
@Data
@Builder
public class HourDTO {

    /** The Time. */
    LocalTime time;

    /** The Time zone. */
    ZoneId timeZone;
}
