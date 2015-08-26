package com.bitacademy.customer;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bitacademy.college.College;
import com.bitacademy.college.CollegeDAO;
import com.bitacademy.dept.Dept;
import com.bitacademy.dept.DeptDAO;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

@Controller
public class CustomerService {

	
	@RequestMapping(value="addCustomerForm.do")
	public ModelAndView addCustomerForm () throws Exception{
	//1.CollegeDAO.selectCollegeList()를 호출해서 리턴된 전체 학과 정보를 List에 저장
		CollegeDAO collegeDAO=new CollegeDAO();
		List<College> collegeList=collegeDAO.selectCollegeList();
	//2. DepartmentDAO.selectStudentList(100)메서드를 호출하고 
	//리턴된 단과대학 100의 전체 학과정보를  List에 저장
		DeptDAO deptDAO=new DeptDAO();
		List<Dept> deptList=deptDAO.selectDeptList("100");
	//3.ModelAndView 객체 생성
		ModelAndView mav=new ModelAndView();
	//4. 1의 전체단대리스트를 3객체에 저장 : 이름: COLLEGE_LIST
		mav.addObject("COLLEGE_LIST", collegeList);
	//5. 2의 단대 100의 전체학과리스트를 3객체에 저장 이름:DEPT_LIST
		mav.addObject("DEPT_LIST", deptList);
	//6. 3객체의 이동할 페이지는 /customer/addCustomerForm.jsp 로 이동하도록 3객체의 setViewName에 /customer/addCustomerForm 대입
		mav.setViewName("/customer/addCustomerForm");
	//7.3객체 리턴
		return mav;
	}
	
	@RequestMapping(value="viewDeptList.do")
	@ResponseBody
	public void viewDeptList(HttpServletResponse response,String colno) throws Exception{
		DeptDAO deptDAO=new DeptDAO();
		//2.DeptDAO.selectDeptList(colno) 호출해서 단대에 소속된 학과리스트를 변수에 저장
		List<Dept> deptList=deptDAO.selectDeptList(colno);
		//3.응답정보의 한글 설정
		response.setContentType("text/xml;charset=UTF-8");
		//4.객체를 XML로 변환시키는 XStream객체 생성
		XStream xstream=new XStream(new DomDriver());
		//5.Dept 객체의 태그 이름을 dept로 설정
		xstream.alias("dept", Dept.class);
		//6.List 객체의 태그 이름을 deptlist로 설정
		xstream.alias("deptlist", List.class);
		//7.2의 리스트를 xml문서로 변환
		String xml=xstream.toXML(deptList);
		//8.7을 클라이언트에게 전송
		PrintWriter out= response.getWriter();
		out.println(xml);
		out.flush();
		out.close();
		//AjaxService3를 참조해서 구현할것
	}
	
	@RequestMapping("/idcheck.do")
	public void  idchek(HttpServletResponse response,
			@RequestParam("id") String id) throws Exception{
		String result=null;
		CustomerDAO customerDAO=new CustomerDAO();
		Customer customer=customerDAO.selectCustomerById(id);
		if(customer==null) {
			result="사용가능한 아이디입니다";
		} else {
			result="이미 사용중인 아이디입니다";
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println(result);
		out.flush();
		out.close();
	}

	@RequestMapping(value="addCustomer.do")
	public ModelAndView addCustomer(Customer customer) throws Exception{
		//1.CustomerDAO.insertCustomer() 호출
		CustomerDAO customerDAO=new CustomerDAO();
		customerDAO.insertCustomer(customer);
		//2.ModelAndView 객체 생성
		ModelAndView mav=new ModelAndView();
		//3. 2객체의 이동할 페이지로 forward:/viewBoardList.do 설정
		mav.setViewName("forward:/viewBoardList.do");
		//4.2객체 리턴
		return mav;
	}

}
