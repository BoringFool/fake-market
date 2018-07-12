package com.zm.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_student")
public class Student
{
    private int id;
    private String name;
    private int age;
    private ClassRoom room;
    
    @ManyToOne(fetch=FetchType.LAZY)//ManyToOneָ���˶��һ�Ĺ�ϵ��fetch=FetchType.LAZY���Ա�ʾ�ڶ����һ��ͨ���ӳټ��صķ�ʽ���ض���(Ĭ�ϲ����ӳټ���)
    @JoinColumn(name="rid")//ͨ�� JoinColumn ��name����ָ������������� rid��(ע�⣺������ǲ�ͨ��JoinColum��ָ����������ƣ�ϵͳ�����������һ������)
    public ClassRoom getRoom()
    {
        return room;
    }
    public void setRoom(ClassRoom room)
    {
        this.room = room;
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
    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    
}
