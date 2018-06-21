package com.briup.many2many;

import java.util.List;

import com.briup.one2marry.Course2;
import com.briup.pojo.Student2;

public interface Many2ManyMapper {
	//����student����
	public void insertStudent(Student2 student);
	//����course����
	public void insertCourse(Course2 course);
	//ͨ��id��ѯѧ��
	public Student2 getStudentById(Integer id);
	//ͨ��id��ѯ�γ�
	public Course2 getCourseById(Integer id);
	//ѧ��xѡ��y
	public void studentSelectCourse(Student2 student, Course2 course);
	//��ѯ��ָ��idֵС��ѧ����Ϣ
	public List<Student2> getStudentByIdOnCondition(Integer id);
	// ��ѯstudent������ѯ����ѡ��course������װ�������Ķ���
	public Student2 getStudentByIdWithCourses(Integer id);
}
