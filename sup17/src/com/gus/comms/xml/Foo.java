package com.gus.comms.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)

// XML文件中的根标识
@XmlRootElement(name = "Foo")

// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = { "id", "name", "boos" })
public class Foo {

	public Foo() {

	}

	public Foo(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	private int id;
	private String name;

	private List<Boo> boos;

	public List<Boo> getBoos() {
		return boos;
	}

	public void setBoos(List<Boo> boos) {
		this.boos = boos;
	}

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

	public static void main(String[] args) {
		Foo foo = new Foo(1, "gus");

		List<Boo> boos = new ArrayList<Boo>();
		
		boos.add( new Boo(1001, "b1001"));
		boos.add( new Boo(1002, "b1002"));
		
		foo.setBoos(boos);
		String str = XMLUtil.convertToXml(foo);

		System.out.println(str);
		
		Foo foo2 = (Foo) XMLUtil.convertXmlStrToObject(Foo.class,str);
		
		System.out.println(foo2.getBoos().get(1).getBname());
		
	}
}
