package com.zm.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.zm.model.User;
import com.zm.myuntil.FileUpload;
import com.zm.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserAction {

	@Resource
	private IUserService userservice;

	

	@RequestMapping("/register")
	public @ResponseBody Long register(@RequestBody User u) {
		User user = userservice.getByName(u.getName());
		if (user == null) {
			userservice.save(u);
			return 1l;
		} else {
			return 0l;
		}
	}

	/*
	 * login判断
	 */
	@RequestMapping("/in")
	public @ResponseBody
	Long in(@RequestBody User u, HttpServletRequest req) {
		Long tof;
		User user = userservice.getByName(u.getName());
		if (user == null) {
			return tof = 3l;
		} else {
			if (u.getPassword().equals(user.getPassword())) {
				tof = 1l;
				req.getSession().setAttribute("logoin", "ok");
				req.getSession().setAttribute("username", u.getName());
			} else {
				tof = 0l;
			}
			return tof;
		}
	}

	// form在succ.jsp中
	@RequestMapping("/upload")
	public String a(HttpServletRequest request) {
		String a="docFile";
		String b="image";
		HttpServletRequest req=request;
		FileUpload.picUpdate(a,b,req);
		return "succ";

	}
	
	
	public void picUpdate(HttpServletRequest req){
		// 获取支持文件上传的Request对象 MultipartHttpServletRequest
				MultipartHttpServletRequest mtpreq = (MultipartHttpServletRequest) req;
				// 通过 mtpreq 获取文件域中的文件，文件名是file元素的id
				MultipartFile file = mtpreq.getFile("docFile");
				// 通过MultipartFile 对象获取文件的原文件名
				String fileName = file.getOriginalFilename();
				// 生成一个uuid 的文件名
				UUID randomUUID = UUID.randomUUID();
				// 获取文件的后缀名
				int i = fileName.lastIndexOf(".");
				String uuidName = randomUUID.toString() + fileName.substring(i);
				// 获取服务器的路径地址（被上传文件的保存地址）
				// C:\Users\Administrator\Documents\GitHub\market\WebContent\image
				String realPath = req.getSession().getServletContext().getRealPath("image");
				// 将路径转化为文件夹 并 判断文件夹是否存在
				File dir = new File(realPath);
				if (!dir.exists()) {
					dir.mkdir();
				}
				// 获取一个文件的保存路径
				String path = realPath + "\\" + uuidName;

				// 为文件这服务器中开辟一给新的空间,*没有数据
				// File newFile = new File(path);

				try {
					file.transferTo(new File(path));
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				System.err.println("-----服务器的路径地址为：:" + realPath);
				System.err.println("-----图片名称为：:" + fileName);
				System.err.println("-----图片新名称为：:" + uuidName);
				System.err.println("-----图片新路径为：:" + path);
	}
}
