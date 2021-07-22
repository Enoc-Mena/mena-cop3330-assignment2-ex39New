/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Enoc Mena
 */

package com.ex39;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SortingRecords {

    public static void main(String[] args) {

        Employees[] employeesNames = {
                new Employees("John","Johnson","Manager",20161231),
                new Employees("Tou","Xiong","Software Engineer",20161005),
                new Employees("Michaela", "Michaelson", "District Manager", 20151219),
                new Employees("Jake","Jacobson","Programmer",00000000),
                new Employees("Jackquelyn", "Jackson", "DBA",00000000),
                new Employees("Sally","Webber","Web Developer",20151218)
        };


        List<Employees> list = Arrays.asList(employeesNames);


        System.out.println("Complete Employee list:");
        list.stream().forEach(System.out::println);


        Function<Employees, String> byFirstName = Employees::FirstName;
        Function<Employees, String> byLastName = Employees::LastName;


        Comparator<Employees> lastThenFirst =
                Comparator.comparing(byLastName).thenComparing(byFirstName);


        System.out.printf(
                "%nEmployees in ascending order by last name then first:%n");
        list.stream()
                .sorted(lastThenFirst)
                .forEach(System.out::println);
    }
}

class Employees {
    private String firstName;
    private String lastName;

    private String department;
    private double separationDate;

    public Employees(String firstName, String lastName,
                     String department,double separationDate)
    {
        this.firstName = firstName;
        this.lastName = lastName;

        this.department = department;
        this.separationDate=separationDate;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String FirstName()
    {
        return firstName;
    }

    // set lastName
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String LastName()
    {
        return lastName;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }

    // get department
    public String getDepartment()
    {
        return department;
    }

    public void setseparationDate(double separationDate)
    {
        this.separationDate = separationDate;
    }

    public double Date()
    {
        return separationDate;
    }

    public String getName()
    {
        return String.format("%s %s", FirstName(), LastName());
    }

    @Override
    public String toString()
    {
        return String.format("%-10s %-10s %s %30.0f",
                FirstName(), LastName(), getDepartment(),Date());
    }
}

