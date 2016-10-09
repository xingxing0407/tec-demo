package mdb;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.util.JSON;

import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class TestMongoDriver {

    @Test
    public void testCRUD() throws UnknownHostException {
        // ���ӵ�mongodb
        Mongo mongo = new Mongo("localhost", 27017);

        // �����ݿ�test
        DB db = mongo.getDB("test");

        // �������м��ϵ�����
        Set<String> colls = db.getCollectionNames();
        for (String s : colls) {
            System.out.println(s);
            // ��ɾ������Collection(�����ڹ�ϵ���ݿ��е�"��")
            if (!s.equals("system.indexes")) {
                db.getCollection(s).drop();
            }
        }

        // ȡ�ü���emp(����emp�����ڣ�mongodb���Զ������ü���)
        DBCollection coll = db.getCollection("emp");

        // delete all
        DBCursor dbCursor = coll.find();
        for (DBObject dbObject : dbCursor) {
            coll.remove(dbObject);
        }

        // create
        BasicDBObject doc = new BasicDBObject("name", "���").append("sex", "��")
                .append("address",
                        new BasicDBObject("postcode", "201202").append(
                                "street", "����·888��").append("city", "�Ϻ�"));
        coll.insert(doc);

        // retrieve
        BasicDBObject docFind = new BasicDBObject("name", "���");
        DBObject findResult = coll.findOne(docFind);
        System.out.println(findResult);

        // update
       /* doc.put("sex", "MALE");// ��sex���Դ�"��"���ĳ�"MALE"
        coll.update(docFind, doc);
        findResult = coll.findOne(docFind);
        System.out.println(findResult);

        coll.dropIndexes();// ��ɾ����������
        // create index
        coll.createIndex(new BasicDBObject("name", 1)); // 1��������
*/
        // ���Ӷ���
        UserData userData = new UserData("jimmy", "123456");
        Set<String> pets = new HashSet<String>();
        pets.add("cat");
        pets.add("dog");
        Map<String, String> favoriteMovies = new HashMap<String, String>();
        favoriteMovies.put("dragons", "Dragons II");
        favoriteMovies.put("avator", "Avator I");
        userData.setFavoriteMovies(favoriteMovies);
        userData.setPets(pets);
        userData.setBirthday(getDate(1990, 5, 1));
        BasicDBObject objUser = new BasicDBObject("key", "jimmy").append(
                "value", toDBObject(userData));
        coll.insert(objUser);
        System.out.println(coll.findOne(objUser));
    }

    /**
     * ����ͨObject����ת����mongodb��DBObject����
     * 
     * @param obj
     * @return
     */
    private static DBObject toDBObject(Object obj) {
        Gson gson = new Gson();
        String json = gson.toJson(obj);
        return (DBObject) JSON.parse(json);
    }
    
  
    public void addData(BasicDBObject doc){
    	  Mongo mongo = new Mongo("localhost", 27017);

          DB db = mongo.getDB("test");
          // ȡ�ü���emp(����emp�����ڣ�mongodb���Զ������ü���)
          DBCollection coll = db.getCollection("test");
          coll.insert(doc);
    	
    }
    
    public static DBCollection getColl(String str){
    	Mongo mongo = new Mongo("localhost", 27017);
    	DB db = mongo.getDB("test");
    	DBCollection coll = db.getCollection("str");
    	return coll;
    }

    /**
     * ��ȡָ������
     * 
     * @param year
     * @param month
     * @param day
     * @return
     */
    private Date getDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(year, month - 1, day);
        return calendar.getTime();

    }
    
    
    public static void main(String[] args) {
    	DBCollection coll = getColl("emp");
        BasicDBObject doc = new BasicDBObject();
        
        UserData userData = new UserData();
        userData.setUserName("С��");
        userData.setPassword("123456");
        

        
        DBObject dbObject = toDBObject(userData);
        
        
        coll.insert(dbObject);
        System.out.println("1111");
        DBCursor find = coll.find();
        

        BasicDBObject docFind = new BasicDBObject("sex", "��");
        
        DBCursor find2 = coll.find(docFind);
        
        while(find2.hasNext()){
        	DBObject next = find2.next();
        	System.out.println(next);
        }
	}

}