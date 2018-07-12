package com.zm.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="t_classroom")
public class ClassRoom
{
    private int id;
    private String className;
    private Set<Student> students;
    public String toString(){
    	StringBuffer sb=new StringBuffer();
    	for(Student s:students){
    		Student st=s;
    		sb.append(st.getName());
    	}
    	return id+className+sb;
    }
    
    public ClassRoom()
    {
        students = new HashSet<Student>();
    }
    
    public void addStudent(Student student)
    {
        students.add(student);
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

    public String getClassName()
    {
        return className;
    }

    public void setClassName(String className)
    {
        this.className = className;
    }
    /*OneToManyָ����һ�Զ�Ĺ�ϵ��mappedBy="room"ָ�����ɶ����һ����ά��������ϵ��
     *mappedByָ���Ƕ��һ����1����һ�������������ԣ�(ע�⣺���û��ָ����˭��ά����
     *����ϵ����ϵͳ������Ǵ���һ���м��)*/
    @OneToMany(mappedBy="room")
    /*LazyCollection�������ó�EXTRAָ���˵������ѯ���ݵĸ���ʱ��ֻ�ᷢ��һ�� count(*)
     *����䣬�������*/
    @LazyCollection(LazyCollectionOption.EXTRA)
    public Set<Student> getStudents()
    {
        return students;
    }

    public void setStudents(Set<Student> students)
    {
        this.students = students;
    }
    
}
