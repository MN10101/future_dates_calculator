package com.najmeh.future_dates_calculator;

import com.najmeh.future_dates_calculator.controller.DateCalculatorController;
import com.najmeh.future_dates_calculator.model.DateForm;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@ExtendWith(MockitoExtension.class)
class DateCalculatorControllerTest {

    @Mock
    private DateForm dateForm;

    @InjectMocks
    private DateCalculatorController controller;

    @Test
    void testCalculate() throws Exception {
        LocalDate startingDate = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime startingDateTime = LocalDateTime.of(startingDate, time);

        when(dateForm.getStartingDate()).thenReturn(startingDate.toString());
        when(dateForm.getFutureDays()).thenReturn(1);
        when(dateForm.getFutureHours()).thenReturn(1);
        when(dateForm.getFutureMinutes()).thenReturn(0);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                        .flashAttr("dateForm", dateForm))
                .andExpect(MockMvcResultMatchers.view().name("result"))
                .andExpect(model().attributeExists("futureDate"));
    }
}
