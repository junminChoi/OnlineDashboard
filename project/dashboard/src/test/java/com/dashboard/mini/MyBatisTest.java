package com.dashboard.mini;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//Runner Ŭ����(�׽�Ʈ �޼ҵ带 �����ϴ� Ŭ����) �� SpringJUnit4ClassRunner�� ��
@RunWith(SpringJUnit4ClassRunner.class)
//location �Ӽ� ��ο� �ִ� xml ������ �̿��ؼ� �������� �ε���
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")

public class MyBatisTest {
	
	//SqlSessionFactory ��ü�� �ڵ����� ����
	@Inject
	private SqlSessionFactory sqlFactory;
	
	//SqlSessionFactory ��ü�� ����� ����������� Test
	@Test
	public void testFactory() {
		System.out.println(sqlFactory);
	}
	
	//MyBatis�� Mysql ������ ����� ����Ǿ����� Test
	@Test
	public void testSession() throws Exception{
		try(SqlSession session = sqlFactory.openSession()){
			System.out.println(session);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}