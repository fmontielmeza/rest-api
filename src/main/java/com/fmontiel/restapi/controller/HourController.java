package com.fmontiel.restapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmontiel.restapi.dto.HourDTO;
import com.fmontiel.restapi.dto.ResponseDTO;
import com.fmontiel.restapi.service.HourService;

/**
 * The class Hour controller.
 *
 * @author Fernando Montiel Meza.
 */
@RestController
@RequestMapping("hour")
public class HourController {

    /** The Hour service. */
    private final HourService hourService;

    /**
     * Instantiates a new Hour controller.
     *
     * @param hourService the hour service
     */
    public HourController(HourService hourService) {
        this.hourService = hourService;
    }

    /**
     * Gets hour by time zone.
     *
     * @param hourDTO the hour dto
     * @return the hour by time zone
     */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> getHourByTimeZone(@RequestBody HourDTO hourDTO) {
        ResponseDTO result = hourService.getHourByTimeZone(hourDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
