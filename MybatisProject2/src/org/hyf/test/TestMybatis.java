package org.hyf.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hyf.entity.Student;

//基础方式的CRUD
public class TestMybatis {

	// 查询单个学生
	public static void queryStudentByStuno() throws IOException {
		// Connection -- SqlSession操作mybatis
		// 硬盘 -- 内存 ;将文件变成了对象
		Reader reader = Resources.getResourceAsReader("conf.xml");
		// reader -- SqlSession
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String statement = "org.hyf.entity.studentMapper.selectStudentByStuno";
		Student student = sqlSession.selectOne(statement, 2);
		System.out.println(student);
		sqlSession.close();
	}

	// 查询全部学生
	public static void queryAllStudent() throws IOException {
		// Connection -- SqlSession操作mybatis
		// 硬盘 -- 内存 ;将文件变成了对象
		Reader reader = Resources.getResourceAsReader("conf.xml");
		// reader -- SqlSession
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String statement = "org.hyf.entity.studentMapper.queryAllStudent";
		List<Student> students = sqlSession.selectList(statement);
		for (Student student : students) {
			System.out.println(student);
		}
		sqlSession.close();
	}

	// 增加学生
	public static void addStudent() throws IOException {
		// Connection -- SqlSession操作mybatis
		// 硬盘 -- 内存 ;将文件变成了对象
		Reader reader = Resources.getResourceAsReader("conf.xml");
		// reader -- SqlSession
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String statement = "org.hyf.entity.studentMapper.addStudent";
		Student student = new Student(3,"ww",17,"h3");
		sqlSession.insert(statement,student);
		System.out.println("增加成功");
		sqlSession.commit();
		sqlSession.close();
	}
	
	//删除学生
	public static void deleteStudentByStuno() throws IOException {
		// Connection -- SqlSession操作mybatis
		// 硬盘 -- 内存 ;将文件变成了对象
		Reader reader = Resources.getResourceAsReader("conf.xml");
		// reader -- SqlSession
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String statement = "org.hyf.entity.studentMapper.deleteStudentByStuno";
//		Student student = new Student(3,"ww",17,"h3");
		sqlSession.delete(statement, 3);
		System.out.println("删除成功");
		sqlSession.commit();
		sqlSession.close();
	}
	
	//修改学生
	public static void updateStudentByStuno() throws IOException {
		// Connection -- SqlSession操作mybatis
		// 硬盘 -- 内存 ;将文件变成了对象
		Reader reader = Resources.getResourceAsReader("conf.xml");
		// reader -- SqlSession
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String statement = "org.hyf.entity.studentMapper.updateStudentByStuno";
		Student student = new Student(1,"zxs",17,"h3");
		sqlSession.update(statement, student);
		System.out.println("修改");
		sqlSession.commit();
		sqlSession.close();
	}

	public static void main(String[] args) throws IOException {
//		queryStudentByStuno();
//		addStudent();
		deleteStudentByStuno();
//		updateStudentByStuno();
		queryAllStudent();
	}

}
