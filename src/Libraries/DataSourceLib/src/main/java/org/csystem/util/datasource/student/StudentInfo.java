package org.csystem.util.datasource.student;

/**
 * Represents a student with their name, grades, and assigned lecture.
 */
public class StudentInfo {
    private String m_name;
    private int m_midtermGrade;
    private int m_finalGrade;
    private String m_lecture;

    /**
     * Constructs a {@code StudentInfo} with all required fields.
     *
     * @param name          the student's name
     * @param midtermGrade  the midterm exam grade
     * @param finalGrade    the final exam grade
     * @param lecture       the name of the lecture/course
     */
    public StudentInfo(String name, int midtermGrade, int finalGrade, String lecture)
    {
        m_name = name;
        m_midtermGrade = midtermGrade;
        m_finalGrade = finalGrade;
        m_lecture = lecture;
    }

    /**
     * Returns the student's name.
     *
     * @return the student's name
     */
    public String getName()
    {
        return m_name;
    }

    /**
     * Sets the student's name.
     *
     * @param name the student's name
     */
    public void setName(String name)
    {
        m_name = name;
    }

    /**
     * Returns the student's midterm grade.
     *
     * @return the midterm grade
     */
    public int getMidtermGrade()
    {
        return m_midtermGrade;
    }

    /**
     * Sets the student's midterm grade.
     *
     * @param midtermGrade the midterm grade
     */
    public void setMidtermGrade(int midtermGrade)
    {
        m_midtermGrade = midtermGrade;
    }

    /**
     * Returns the student's final exam grade.
     *
     * @return the final grade
     */
    public int getFinalGrade()
    {
        return m_finalGrade;
    }

    /**
     * Sets the student's final exam grade.
     *
     * @param finalGrade the final grade
     */
    public void setFinalGrade(int finalGrade)
    {
        m_finalGrade = finalGrade;
    }

    /**
     * Returns the name of the lecture/course the student is enrolled in.
     *
     * @return the lecture name
     */
    public String getLecture()
    {
        return m_lecture;
    }

    /**
     * Sets the name of the lecture/course.
     *
     * @param lecture the lecture name
     */
    public void setLecture(String lecture)
    {
        m_lecture = lecture;
    }

    @Override
    public String toString()
    {
        return String.format("%s, %d, %d, %s", m_name, m_midtermGrade, m_finalGrade, m_lecture);
    }
}
