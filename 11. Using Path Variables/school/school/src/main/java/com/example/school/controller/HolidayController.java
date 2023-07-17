package com.example.school.controller;

import com.example.school.model.Holiday;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HolidayController {

    @GetMapping("/holidays/{display}")
    public String displayHolidays(@PathVariable String display, Model model)
    {
        if ( display != null && display.equals("all")) {
            model.addAttribute("festival", true);
            model.addAttribute("federal", true);
        } else if (display!=null && display.equals("festivale")) {
            model.addAttribute("festival", true);
        } else if (display != null && display.equals("federal")) {
            model.addAttribute("federal", true);
        }
        List<Holiday> holidays = Arrays.asList(

                new Holiday("Jan 1","New Year", Holiday.Type.FESTIVAL),
                new Holiday("Oct 31","Halloween", Holiday.Type.FESTIVAL),
                new Holiday("Nov 24","Thanks Giving Day", Holiday.Type.FESTIVAL),
                new Holiday("Dec 25","Chrismas", Holiday.Type.FESTIVAL),
                new Holiday("Jan 17","Martin Luthar", Holiday.Type.FEDERAL),
                new Holiday("July 4","Independence Day", Holiday.Type.FEDERAL),
                new Holiday("Sep 5","Labor day", Holiday.Type.FEDERAL),
                new Holiday("Nov 11","Veterns Day", Holiday.Type.FEDERAL)
        );

        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types) {
            model.addAttribute(type.toString(),
                    (holidays.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList())));
        }
        return "holidays.html";
    }
}
