package com.briup.xml;

import com.briup.gather.Gather;
import com.briup.jdbc.DBImple;
import com.briup.socket.ClientImpl;
import com.briup.socket.ServerImpl;

public interface Configuration {
	ServerImpl getServer() throws Exception;
	DBImple getDbStore() throws Exception;
    ClientImpl getClient() throws Exception;
    Gather getGather() throws Exception;
}
