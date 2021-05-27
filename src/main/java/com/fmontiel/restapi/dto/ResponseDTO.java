package com.fmontiel.restapi.dto;

import lombok.Builder;
import lombok.Data;

/**
 * The class Response dto.
 *
 * @author Fernando Montiel Meza.
 */
@Data
@Builder
public class ResponseDTO {

    /** The Response. */
    private HourDTO response;
}
