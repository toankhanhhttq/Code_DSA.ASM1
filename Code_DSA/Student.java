/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author DO KHANH TOAN
 */
public class Student {

    private int id;
    private String name;
    private double marks;
    private String rank; // Added to store the rank

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.rank = calculateRank(marks); // Calculate rank based on marks
    }

    // Getter and setter methods for id, name, marks, and rank
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
        this.rank = calculateRank(marks); // Update rank if marks change
    }

    public String getRank() {
        return rank;
    }

    private String calculateRank(double marks) {
        if (marks >= 9.0) {
            return "Excellent";
        } else if (marks >= 7.5) {
            return "Very Good";
        } else if (marks >= 6.5) {
            return "Good";
        } else if (marks >= 5.0) {
            return "Medium";
        } else {
            return "Fail";
        }
    }

    @Override
    public String toString() {
        return "Student "
                + " Id: " + id + ", Name: " + name + ", Mark: " + marks + ", Rank: " + rank + "";
    }
}

