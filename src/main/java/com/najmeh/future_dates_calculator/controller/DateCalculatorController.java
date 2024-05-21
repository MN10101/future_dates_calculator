package com.najmeh.future_dates_calculator.controller;

import com.najmeh.future_dates_calculator.model.DateForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

@Controller
public class DateCalculatorController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("dateForm", new DateForm());
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(@ModelAttribute DateForm dateForm, Model model) {
        try {
            LocalDate startingDate = LocalDate.parse(dateForm.getStartingDate());
            LocalTime time = LocalTime.of(dateForm.getFutureHours(), dateForm.getFutureMinutes());
            LocalDateTime startingDateTime = LocalDateTime.of(startingDate, time);
            LocalDateTime futureDateTime = startingDateTime.plusDays(dateForm.getFutureDays());
            model.addAttribute("futureDate", futureDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));

            if (dateForm.getSecondDate() != null && !dateForm.getSecondDate().isEmpty()) {
                LocalDate secondDate = LocalDate.parse(dateForm.getSecondDate());
                long daysBetween = ChronoUnit.DAYS.between(startingDate, secondDate);
                model.addAttribute("daysBetween", daysBetween);
            }

            return "result";
        } catch (DateTimeParseException e) {
            model.addAttribute("error", "Invalid date format. Please enter the date in the format YYYY-MM-DD.");
            return "index";
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred. Please check your input and try again.");
            return "index";
        }
    }
}