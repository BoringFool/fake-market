package com.zm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_person")
public class Person
{
    private int id;
    private String name;
    private IDCard card;
    
    @OneToOne(mappedBy="person")//ָ����OneToOne�Ĺ�����ϵ��mappedByͬ��ָ���ɶԷ�������ά��������ϵ
    public IDCard getCard()
    {
        return card;
    }
    public void setCard(IDCard card)
    {
        this.card = card;
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
