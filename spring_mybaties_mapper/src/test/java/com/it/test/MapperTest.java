package com.it.test;

import com.it.domain.User;
import com.it.domain.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MapperTest {
    @Test
    public  void test1() throws IOException {
        InputStream inputStream= Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session=sqlSessionFactory.openSession();

        User user=new User();
        user.setId(8);
        user.setPassword("abc");
        user.setUsername("tom");
        UserMapper userMapper=session.getMapper(UserMapper.class);
        List<User> list=userMapper.findByCondition(user);
        System.out.println(list);

    }
    @Test
    public  void test2() throws IOException {
        InputStream inputStream= Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session=sqlSessionFactory.openSession();
        List<Integer>list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        UserMapper userMapper=session.getMapper(UserMapper.class);
        List<User> byIds = userMapper.findByIds(list);
        System.out.println(byIds);
    }
}

class Solution {
    int[]parent;
    public int largestComponentSize(int[] nums) {
        int n=0;
        for(int i=0;i<nums.length;i++){
            n=Math.max(n,nums[i]);
        }
        parent=new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i]=i;
        }
        for(int i=0;i<nums.length;i++){
            int k=nums[i];
            for(int j=2;j*j<=k;j++){
                if(k%j==0){
                    union(j,k);
                    union(j,k/j);
                }
            }
        }
        int max=0;
        int []count=new int[n+1];
        for(int i=0;i<nums.length;i++){
            int root=findroot(nums[i]);
            count[root]++;
            max=Math.max(max,count[root]);
        }
        return max;
    }

    //联通
    public void union(int root1,int root2){
        int k1=findroot(root1);
        int k2=findroot(root2);
        if(k1==k2)return;
        if(k1<k2)
            parent[k1]=k2;
        else parent[k2]=k1;
    }

    //寻找跟，路径压缩
    public int findroot(int x){
        if(parent[x]!=x){
            parent[x]=findroot(parent[x]);
        }
        return parent[x];
    }
}