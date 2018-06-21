package com.briup.typehandlers;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.briup.pojo.PhoneNumber;

public class PhoneTypeHandler extends BaseTypeHandler<PhoneNumber>{

	//����PhoneNumber������ʱ��Ӧ�������ps������ֵ
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, PhoneNumber parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setString(i, parameter.getAsString());
	}

	//��ѯ������PhoneNumber���͵�Ӧ����η�װ(ʹ��������װ)
	@Override
	public PhoneNumber getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return new PhoneNumber(rs.getString(columnName));
	}

	//��ѯ������PhoneNumber���͵�Ӧ����η�װ(ʹ���е��±�)
	@Override
	public PhoneNumber getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return new PhoneNumber(rs.getString(columnIndex));
	}

	//CallableStatementʹ����������PhoneNumber���͵�Ӧ����η�װ
	@Override
	public PhoneNumber getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return new PhoneNumber(cs.getString(columnIndex));
	}

}
