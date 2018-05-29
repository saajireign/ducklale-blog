package com.ducklale.metadata.dao;

import com.ducklale.config.DataSourceProperties;
import com.ducklale.enums.SourceType;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
public class ShardingDao {
    DataSource metaDataSource;
    public DataSource getMetaDataSource() {
        return metaDataSource;
    }

    public void setMetaDataSource(DataSource metaDataSource) {
        this.metaDataSource = metaDataSource;
    }

    public Map<Object,Object> getAllShards(DataSourceProperties dsproperties){
       DataSource dataSource = this.getMetaDataSource();
       StringBuffer sb = new StringBuffer();
       Map<Object,Object> rtn = new HashMap<>();
       sb.append("select s.id,d.db_url,d.db_username,d.db_password ");
       sb.append(" from ducklale_meta_shard s left outer join ducklale_meta_shard_info d  ");
       sb.append(" on s.id=d.shard_id ");

       Connection conn = null;
       Statement st=null;
       ResultSet resultset=null;
       try {
           conn = dataSource.getConnection();
           st = conn.createStatement();
           resultset = st.executeQuery(sb.toString());
           while(resultset.next()){
               String key = resultset.getString(1);
               String url = resultset.getString(2);
               String username = resultset.getString(3);
               String password = resultset.getString(4);
                rtn.put(key,getDataSource(url,username,password,dsproperties));
           }
       }catch(Exception ex){
            ex.printStackTrace();
       }finally{
           if(resultset!=null){
               try {
                   resultset.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           }
           if(st!=null){
               try {
                   st.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           }
            if( conn!=null ){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

       }
       return rtn;
    }
    public String searchShardNameByIdAndSourceType(Long id, SourceType type){
        DataSource dataSource = this.getMetaDataSource();
        StringBuffer sb = new StringBuffer();
        Map<Object,Object> rtn = new HashMap<>();
        sb.append("select s.id ");
        sb.append(" from ducklale_meta_shard_group g left outer join ducklale_meta_shard s   ");
        sb.append(" on s.group_id=g.id ");
        sb.append(" where g.start_id<=");
        sb.append(id);
        sb.append(" and g.end_id>");
        sb.append(id);
        sb.append(" and g.writable='1'");
        sb.append(" and s.read_or_write=");
        sb.append(type.getValue());
        Connection conn = null;
        Statement st=null;
        ResultSet resultset=null;
        try {
            conn = dataSource.getConnection();
            st = conn.createStatement();
            resultset = st.executeQuery(sb.toString());
            if(resultset.next()){
                String key = resultset.getString(1);
                return key;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(resultset!=null){
                try {
                    resultset.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(st!=null){
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if( conn!=null ){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        return null;

    }
    public DataSource getDataSource(String url,String username,String password,DataSourceProperties dsproperties){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setInitialSize(dsproperties.getInitialSize());
        dataSource.setMaxActive(dsproperties.getMaxActive());
        dataSource.setMaxIdle(dsproperties.getMaxIdle());
        dataSource.setMinIdle(dsproperties.getMinIdle());
        dataSource.setMaxWait(dsproperties.getMaxWait());
        return dataSource;
    }

}
