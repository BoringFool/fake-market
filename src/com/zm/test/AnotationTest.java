package com.zm.test;

import java.lang.reflect.Field;
import java.lang.annotation.*;

public class AnotationTest {

	public static void main(String[] args) {
		Class<DataBean> d = DataBean.class;

		Field fs[] = d.getFields();
		for (Field f : fs) {
			System.out.println(f);
			
			DataField da=f.getAnnotation(DataField.class);
			Annotation a = f.getAnnotation(DataField.class);

			if (a != null) {
				System.out.println(f.getName());
				System.out.println(da.value());
			}
		}
	}
}

class DataBean {
	@DataField
	public String name;

	@DataField("1")
	public String data;

	public String description;
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface DataField {
	String value() default "0";
}
