package com.zm.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="t_course")
public class Course
{
    private int id;
    private String name;
    private Set<Teacher> teachers;
    
    public Course()
    {
        teachers = new HashSet<Teacher>();
    }
    public void addTeacher(Teacher teacher)
    {
        teachers.add(teacher);
    }
    @ManyToMany//��ManyToManyָ����Զ�Ĺ�����ϵ
    //��Ϊ��Զ�֮���ͨ��һ���м����ά������ֱ�ӵĹ�ϵ������ͨ�� JoinTable ���ע����������name����
    //ָ�����м������֣�JoinColumns��һ�� @JoinColumn���͵����飬��ʾ�������ⷽ�ڶԷ��е�������ƣ���
    //����Course�������ڶԷ���������ƾ��� rid��inverseJoinColumnsҲ��һ�� @JoinColumn���͵����飬��ʾ��
    //�ǶԷ���������е�������ƣ��Է���Teacher���������ҷ���������ƾ��� tid
    @JoinTable(name="t_teacher_course", joinColumns={ @JoinColumn(name="cid")}, 
    inverseJoinColumns={ @JoinColumn(name = "tid") })
    public Set<Teacher> getTeachers()
    {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers)
    {
        this.teachers = teachers;
    }

    @Id
    @GeneratedValue
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

}
