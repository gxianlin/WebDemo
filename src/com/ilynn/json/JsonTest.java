package com.ilynn.json;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.ilynn.model.Box;
import com.ilynn.model.News;
import com.ilynn.model.SchoolClass;
import com.ilynn.model.Student;
import com.ilynn.model.Teacher;

public class JsonTest {
	public static void main(String[] args) {
		// 模拟从数据库获取数据，可将此处改为用JDBC从数据库读取数据
		Teacher c1 = new Teacher(10010, "颜老师", "教授");
		// 添加学生信息到集合
		Student s1 = new Student(201520800, "张三", "2015-12-01", "男");
		Student s2 = new Student(201520800, "李四", "2015-08-01", "男");
		Student s3 = new Student(201520800, "如花", "2015-06-01", "女");
		Student s4 = new Student(201520800, "如柳", "2015-07-01", "女");
		List<Student> sList = new ArrayList<Student>();
		sList.add(s1);
		sList.add(s2);
		sList.add(s3);
		sList.add(s4);
		// 创建班级，包涵其他JavaBean对象以及数组
		SchoolClass sc = new SchoolClass(101, "软件1班", c1, sList);
		// 创建一个新闻类，包涵Date类型对象
		News newOne = new News(110, "日本地震", "日本福田发生了7级地震", new Date(System.currentTimeMillis()), "www.baidu.com");

		// 调用GSON jar工具包封装好的toJson方法，可直接生成JSON字符串
		Gson gson = new Gson();
		String sJson = gson.toJson(c1);
		String scJson = gson.toJson(sc);
		String nJson = gson.toJson(newOne);

		// 输出JSON
		System.err.println(nJson);
		System.out.println(sJson);
		System.out.println(scJson);

		// 反序列化JSON为对象
		String teJsonString = "{\"tId\":10010,\"name\":\"张老师\",\"title\":\"教授\"}";
		Teacher teacher = gson.fromJson(teJsonString, Teacher.class);
		System.out.println(teacher.getName());

		// 泛型模拟
		Box<String> name = new Box<String>("corn");
		Box<Integer> age = new Box<Integer>(712);
		Box<Number> number = new Box<Number>(314);

		getData(name);
		getData(age);
		getData(number);
		// 上限
		getUpperIntegerData(age);
		getUpperIntegerData(number);
		// 下限
		getUnderIntegerData(age);
	}

	public static void getData(Box<?> data) {
		System.out.println("data :" + data.getData());
	}

	public static void getUpperIntegerData(Box<? super Integer> data) {
		System.out.println("data :" + data.getData());
	}

	public static void getUnderIntegerData(Box<? extends Integer> data) {
		System.out.println("data :" + data.getData());
	}

}