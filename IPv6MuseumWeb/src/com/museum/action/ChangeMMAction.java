package com.museum.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.museum.dao.Impl.ExhibitsDaoImpl;
import com.museum.domain.Collect;
import com.museum.domain.Exhibits;
import com.museum.domain.User;
import com.museum.service.IChangeMMService;
import com.museum.service.IExhibitsJPService;
import com.museum.service.IcollectionService;
import com.museum.service.ImyInService;

@Controller
@RequestMapping("/ChangeMM")
public class ChangeMMAction {

	@Autowired
	private ImyInService service;

	@RequestMapping("/find")
	public String find(HttpServletRequest req, String uid, String yyy,
			String zzz) throws IOException {
		req.setCharacterEncoding("GBK");

		String str = uid;

		User e = new User();

		List<User> list = service.find(str);
		for (User ee : list) {
			e = ee;
		}
		e.setUserPassword(yyy);
		service.update(e);

		req.setAttribute("list", list);

		return "blank";
	}

	@RequestMapping("/find2")
	public String find2(HttpServletRequest req, String uid,HttpServletResponse response) throws IOException {
		req.setCharacterEncoding("GBK");
		
		System.out.println(uid);
		System.out.println(uid);
		System.out.println(uid);
		System.out.println(uid);
		String str = uid;
		List<User> list2 = service.find(str);
		User eee = new User();
		for (User ee : list2) {
			eee = ee;
		}
		String nImage = null;
		req.setAttribute("list", list2);
		req.setCharacterEncoding("utf-8"); // 设置编码
		// 获得磁盘文件条目工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 获取文件需要上传到的路径
		String path = req.getRealPath("/images");
		factory.setRepository(new File(path));
		// 设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室
		factory.setSizeThreshold(1024 * 1024);
		// 高水平的API文件上传处理
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			// 可以上传多个文件
			List<FileItem> list = (List<FileItem>) upload.parseRequest(req);
			for (FileItem item : list) {
				// 获取表单的属性名字
				String name = item.getFieldName();
				// 如果获取的 表单信息是普通的 文本 信息
				if (item.isFormField()) {
					// 获取用户具体输入的字符串 ，名字起得挺好，因为表单提交过来的是 字符串类型的
					String value = item.getString();
					req.setAttribute(name, value);
				} else {// 对传入的非 简单的字符串进行处理 ，比如说二进制的 图片，电影这些
					/**
					 * 以下三步，主要获取 上传文件的名字
					 */
					// 获取路径名
					String value = item.getName();
					// 索引到最后一个反斜杠
					int start = value.lastIndexOf("\\");
					// 截取 上传文件的 字符串名字，加1是 去掉反斜杠，
					String filename = value.substring(start + 1);
					nImage = "\\mymuseum\\images\\"+filename;//创建新的数据库头像名字
					
					req.setAttribute(name, filename);
					OutputStream out = new FileOutputStream(new File(path,
							filename));
					InputStream in = item.getInputStream();
					int length = 0;
					byte[] buf = new byte[1024];
					System.out.println("获取上传文件的总共的容量：" + item.getSize());
					// in.read(buf) 每次读到的数据存放在 buf 数组中
					while ((length = in.read(buf)) != -1) {
						// 在 buf 数组中 取出数据 写到 （输出流）磁盘上
						out.write(buf, 0, length);
					}
					in.close();
					out.close();
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		eee.setUserImage(nImage);
		service.update(eee);
		
		req.getSession().setAttribute("User_image", eee.getUserImage());
		
		return "myInformation";
	}

}
