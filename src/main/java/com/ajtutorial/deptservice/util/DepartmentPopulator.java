package com.ajtutorial.deptservice.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.ajtutorial.deptservice.bean.Department;

public class DepartmentPopulator {

	private static List<Department> list = new ArrayList<Department>();

	static {
		Random r = new Random();
		Department d1 = new Department(r.nextInt(), "Mechanical");
		Department d2 = new Department(r.nextInt(), "Mechanical2");
		Department d3 = new Department(r.nextInt(), "Mechanical3");
		Department d4 = new Department(r.nextInt(), "Mechanical4");
		list.add(d1);
		list.add(d2);
		list.add(d3);
		list.add(d4);
	}

	public static List<Department> getDepartmentList() {
		return list;
	}

	public static Department getDeptById(Integer deptId) {
		List<Department> l = getDepartmentList();
		Predicate<Department> dptPred = (d) -> {
			if (d.getDeptId().equals(deptId)) {
				return true;
			}
			return false;
		};
		l = l.stream().filter(dptPred).collect(Collectors.toList());
		if (!l.isEmpty()) {
			return l.get(0);
		}
		return null;
	}

	public static List<Department> addDepartment(Department dept) {
		Random r = new Random();
		dept.setDeptId(r.nextInt());
		list.add(dept);
		return list;
	}
	
	public static List<Department> updateDepartment(Department dept){
		List<Department> l = getDepartmentList();
		Predicate<Department> dptPred = (d) -> {
			if (d.getDeptId().equals(dept.getDeptId())) {
				return true;
			}
			return false;
		};
		Department l1 = l.stream().filter(dptPred).findFirst().orElse(null);
		l1.setDeptName(dept.getDeptName());
		return list;
	}

	public static List<Department> deleteDepartment(Integer id) {
		List<Department> l = getDepartmentList();
		Predicate<Department> dptPred = (d) -> {
			if (d.getDeptId().equals(id)) {
				return false;
			}
			return true;
		};
		list = l.stream().filter(dptPred).collect(Collectors.toList());
		if (!list.isEmpty()) {
			return list;
		}
		return null;
	}
}
