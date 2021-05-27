package com.fmontiel.restapi.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import com.fmontiel.restapi.service.impl.HourServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import com.fmontiel.restapi.dto.HourDTO;
import com.fmontiel.restapi.dto.ResponseDTO;

/**
 * The class Hour service test.
 *
 * @author Amaris.
 */
class HourServiceTest {

    /** The Hour service. */
    private HourService hourService;

    /** The Closeable. */
    private AutoCloseable closeable;

    /**
     * Init service.
     */
    @BeforeEach
    void initService() {
        closeable = MockitoAnnotations.openMocks(this);
        hourService = new HourServiceImpl();
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

        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.of(LocalDate.now(), request.getTime()),
                request.getTimeZone());

        ZonedDateTime zonedDateTimeUTC = zonedDateTime.withZoneSameInstant(ZoneId.of("UTC"));

        ResponseDTO expected = ResponseDTO.builder()
                .response(HourDTO.builder()
                        .time(zonedDateTimeUTC.toLocalTime())
                        .timeZone(zonedDateTimeUTC.getZone())
                        .build())
                .build();

        // Call
        ResponseDTO response = hourService.getHourByTimeZone(request);

        // Assert
        assertThat(response).isNotNull();
        assertThat(response).isEqualTo(expected);
    }
}
