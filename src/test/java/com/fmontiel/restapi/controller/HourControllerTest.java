package com.fmontiel.restapi.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalTime;
import java.time.ZoneId;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.fmontiel.restapi.dto.HourDTO;
import com.fmontiel.restapi.dto.ResponseDTO;
import com.fmontiel.restapi.service.HourService;

/**
 * The class Hour controller test.
 *
 * @author Fernando Montiel Meza.
 */
class HourControllerTest {

    /** The Hour controller. */
    @InjectMocks
    private HourController hourController;

    /** The Hour service. */
    @Mock
    private HourService hourService;

    /** The Closeable. */
    private AutoCloseable closeable;

    /**
     * Init service.
     */
    @BeforeEach
    void initService() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    /**
     * Close service.
     *
     * @throws Exception the exception
     */
    @AfterEach
    void closeService() throws Exception {
        closeable.close();
    }

    /**
     * Gets hour by time zone test.
     */
    @Test
    void getHourByTimeZoneTest() {
        // Dummy
        HourDTO request = HourDTO.builder()
                .time(LocalTime.now())
                .timeZone(ZoneId.of("-3"))
                .build();
        ResponseDTO expected = ResponseDTO.builder()
                .response(HourDTO.builder()
                        .time(LocalTime.now())
                        .timeZone(ZoneId.of("UTC"))
                        .build())
                .build();

        // Mock
        when(hourService.getHourByTimeZone(any(HourDTO.class))).thenReturn(expected);

        // Call
        ResponseEntity<ResponseDTO> response = hourController.getHourByTimeZone(request);

        // Assert
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody()).isEqualTo(expected);
    }
}
