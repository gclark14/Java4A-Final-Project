/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafinal;

import java.io.Serializable;

/**
 *
 * @author gabriel
 */
public class CoursePoints implements Serializable{
    private String ID;
    private int gradeHomework;
    private int gradeQuiz;
    private int gradeMidterm;
    private int gradeFinal;
    
    public double getTotalGrade(){
        return (gradeHomework + gradeQuiz + gradeMidterm
                + gradeFinal)/4.0;
    }
    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getGradeHomework() {
        return gradeHomework;
    }

    public void setGradeHomework(int gradeHomework) {
        this.gradeHomework = gradeHomework;
    }

    public int getGradeQuiz() {
        return gradeQuiz;
    }

    public void setGradeQuiz(int gradeQuiz) {
        this.gradeQuiz = gradeQuiz;
    }

    public int getGradeMidterm() {
        return gradeMidterm;
    }

    public void setGradeMidterm(int gradeMidterm) {
        this.gradeMidterm = gradeMidterm;
    }

    public int getGradeFinal() {
        return gradeFinal;
    }

    public void setGradeFinal(int gradeFinal) {
        this.gradeFinal = gradeFinal;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("ID: " + ID);
        builder.append("\nHomework ").append(gradeHomework);
        builder.append("\nQuiz Grade ").append(gradeQuiz);
        builder.append("\nMidterm Grade ").append(gradeMidterm);
        builder.append("\nFinal Grade ").append(gradeFinal);
        return builder.toString();
    }
}
