package com.ilynn.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ilynn.model.NewTotal;
import com.ilynn.model.News;

public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 创建多个新闻类，模拟从数据库获取数据，可将此处改为用JDBC从数据库读取数据
		News new1 = new News(110, "日本地震", "日本福田发生了7级地震", "2016-5-16 10:22:20", "www.baidu.com");
		News new2 = new News(112, "Apple库克第八次访华", "近日库克第八次访华，与滴滴高层会谈", "2016-5-16 10:22:20", "www.baidu.com");
		News new3 = new News(112, "Google I/O大会开幕", "Google开发者大会即将举办，是否推出Android7.0?", "2016-5-16 10:22:20",
				"www.baidu.com");
		News new4 = new News(112, "格力营收下滑400亿", "格里营收下滑400亿，董明珠说我活得好的很", "2016-5-16 10:22:20", "www.baidu.com");
		// 将数据添加到数组
		List<News> newslist = new ArrayList<News>();
		newslist.add(new1);
		newslist.add(new2);
		newslist.add(new3);
		newslist.add(new4);
		// 将数据封装到新闻总计类
		NewTotal nt = new NewTotal(newslist.size(), newslist);

		// 调用GSON jar工具包封装好的toJson方法，可直接生成JSON字符串
		Gson gson = new Gson();
		String json = gson.toJson(nt);

		// 输出到界面
		System.out.println(json);
		resp.setHeader("Content-Type", "text/html;charset=UTF-8");
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("gb2312");
		PrintWriter out = new PrintWriter(resp.getOutputStream());
		out.print(json);
		out.flush();
		// 更多Gson使用请看JsonTest类
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}