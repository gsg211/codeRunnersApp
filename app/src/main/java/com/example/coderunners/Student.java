package com.example.coderunners;

public class Student
{
    private String Lastname,FirstName;
    private double grade;
    private double credits;
    int opt;

    public Student(String firstname, String lastname, double credits,double grade,int opt)
    {
        Lastname = lastname;
        FirstName = firstname;
        this.grade = grade;
        this.credits = credits;
        this.opt=opt;
    }

    public String getLastname()
    {
        return Lastname;
    }

    public void setLastname(String lastname)
    {
        Lastname = lastname;
    }

    public String getFirstName()
    {
        return FirstName;
    }

    public void setFirstName(String firstName)
    {
        FirstName = firstName;
    }

    public double getGrade()
    {
        return grade;
    }

    public void setGrade(double grade)
    {
        this.grade = grade;
    }

    public double getCredits()
    {
        return credits;
    }

    public void setCredits(double credits)
    {
        this.credits = credits;
    }



}
