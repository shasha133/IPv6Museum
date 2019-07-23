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
		req.setCharacterEncoding("utf-8"); // ���ñ���
		// ��ô����ļ���Ŀ����
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// ��ȡ�ļ���Ҫ�ϴ�����·��
		String path = req.getRealPath("/images");
		factory.setRepository(new File(path));
		// ���� ����Ĵ�С�����ϴ��ļ������������û���ʱ��ֱ�ӷŵ� ��ʱ�洢��
		factory.setSizeThreshold(1024 * 1024);
		// ��ˮƽ��API�ļ��ϴ�����
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			// �����ϴ�����ļ�
			List<FileItem> list = (List<FileItem>) upload.parseRequest(req);
			for (FileItem item : list) {
				// ��ȡ������������
				String name = item.getFieldName();
				// �����ȡ�� ����Ϣ����ͨ�� �ı� ��Ϣ
				if (item.isFormField()) {
					// ��ȡ�û�����������ַ��� ���������ͦ�ã���Ϊ���ύ�������� �ַ������͵�
					String value = item.getString();
					req.setAttribute(name, value);
				} else {// �Դ���ķ� �򵥵��ַ������д��� ������˵�����Ƶ� ͼƬ����Ӱ��Щ
					/**
					 * ������������Ҫ��ȡ �ϴ��ļ�������
					 */
					// ��ȡ·����
					String value = item.getName();
					// ���������һ����б��
					int start = value.lastIndexOf("\\");
					// ��ȡ �ϴ��ļ��� �ַ������֣���1�� ȥ����б�ܣ�
					String filename = value.substring(start + 1);
					nImage = "\\mymuseum\\images\\"+filename;//�����µ����ݿ�ͷ������
					
					req.setAttribute(name, filename);
					OutputStream out = new FileOutputStream(new File(path,
							filename));
					InputStream in = item.getInputStream();
					int length = 0;
					byte[] buf = new byte[1024];
					System.out.println("��ȡ�ϴ��ļ����ܹ���������" + item.getSize());
					// in.read(buf) ÿ�ζ��������ݴ���� buf ������
					while ((length = in.read(buf)) != -1) {
						// �� buf ������ ȡ������ д�� ���������������
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
