package mongo.base;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.Indexes;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by suny on 2016/12/15.
 */
public class MongoSample {

    /**
     * 连接1
     */
    public static MongoDatabase getDB(){
        return getDB("localhost" ,27017,"mongotest");
    }

    /**
     * 连接1
     */
    public static MongoDatabase getDB(String host, int port,String dbname){
        MongoDatabase mongoDatabase = null;
        try{
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient( host , port );

            // 连接到数据库
            mongoDatabase = mongoClient.getDatabase(dbname);
            System.out.println("Connect to database successfully");

        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        return mongoDatabase;
    }


    /**
     * 连接2
     */
    public static void conn2(){
        try {
            //连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址
            //ServerAddress()两个参数分别为 服务器地址 和 端口
            ServerAddress serverAddress = new ServerAddress("localhost",27017);
            List<ServerAddress> addrs = new ArrayList<ServerAddress>();
            addrs.add(serverAddress);

//            //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
//            MongoCredential credential = MongoCredential.createScramSha1Credential("username", "databaseName", "password".toCharArray());
//            List<MongoCredential> credentials = new ArrayList<MongoCredential>();
//            credentials.add(credential);
//
//            //通过连接认证获取MongoDB连接
//            MongoClient mongoClient = new MongoClient(addrs,credentials);
            MongoClient mongoClient = new MongoClient(addrs);

            //连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mongotest");
            System.out.println("Connect to database successfully");
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    /**
     * 创建集合
     */
    public static void createCol(){
        try{
            // 连接到数据库
            MongoDatabase mongoDatabase = getDB();
            System.out.println("Connect to database successfully");
            mongoDatabase.createCollection("test");
            System.out.println("集合创建成功");

        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    /**
     * 获取集合
     */
    public static void getCol(){
        try{
            // 连接到数据库
            MongoDatabase mongoDatabase = getDB();
            System.out.println("Connect to database successfully");

            MongoCollection<Document> collection = mongoDatabase.getCollection("test");
            System.out.println("集合 test 选择成功");
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    /**
     * 插入文档
     */
    public static void insertDoc(){
        try{
            // 连接到数据库
            MongoDatabase mongoDatabase = getDB();
            System.out.println("Connect to database successfully");

            MongoCollection<Document> collection = mongoDatabase.getCollection("test");
            System.out.println("集合 test 选择成功");
            //插入文档
            /**
             * 1. 创建文档 org.bson.Document 参数为key-value的格式
             * 2. 创建文档集合List<Document>
             * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document)
             * */
            Document document = new Document("title", "MongoDB").
                    append("description", "database").
                    append("likes", 50).
                    append("by", "Wind").
                    append("create_time", new Date());
            List<Document> documents = new ArrayList<>();
            documents.add(document);
            collection.insertMany(documents);
            System.out.println("文档插入成功");
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    /**
     * 获取文档
     */
    public static void getDoc(){
        try{
            // 连接到数据库
            MongoDatabase mongoDatabase = getDB();
            System.out.println("Connect to database successfully");

            MongoCollection<Document> collection = mongoDatabase.getCollection("test");
            System.out.println("集合 test 选择成功");

            //检索所有文档
            /**
             * 1. 获取迭代器FindIterable<Document>
             * 2. 获取游标MongoCursor<Document>
             * 3. 通过游标遍历检索出的文档集合
             * */
            FindIterable<Document> findIterable = collection.find();
            MongoCursor<Document> mongoCursor = findIterable.iterator();
            while(mongoCursor.hasNext()){
                System.out.println(mongoCursor.next());
            }

        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    /**
     * 更新文档
     */
    public static void updateDoc(){
        try{
            // 连接到数据库
            MongoDatabase mongoDatabase = getDB();
            System.out.println("Connect to database successfully");

            MongoCollection<Document> collection = mongoDatabase.getCollection("test");
            System.out.println("集合 test 选择成功");

            //更新文档   将文档中likes=100的文档修改为likes=200
            collection.updateMany(Filters.eq("likes", 100), new Document("$set",new Document("likes",1000)));

//            UpdateResult updateResult = collection.updateMany(Filters.lt("likes", 100), new Document("$inc", new Document("likes", 100)));
//            System.out.println(updateResult.getModifiedCount());

//            //检索查看结果
//            FindIterable<Document> findIterable = collection.find();
//            MongoCursor<Document> mongoCursor = findIterable.iterator();
//            while(mongoCursor.hasNext()){
//                System.out.println(mongoCursor.next());
//            }

        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    /**
     * 删除文档
     */
    public static void deleteDoc(){
        try{
            // 连接到数据库
            MongoDatabase mongoDatabase =getDB();
            System.out.println("Connect to database successfully");

            MongoCollection<Document> collection = mongoDatabase.getCollection("test");
            System.out.println("集合 test 选择成功");

            //删除符合条件的第一个文档
            collection.deleteOne(Filters.eq("likes", 200));
            //删除所有符合条件的文档
//            collection.deleteMany (Filters.eq("likes", 200));
            //检索查看结果
            FindIterable<Document> findIterable = collection.find();
            MongoCursor<Document> mongoCursor = findIterable.iterator();
            while(mongoCursor.hasNext()){
                System.out.println(mongoCursor.next());
            }

        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    public static void findRange(){
        MongoCollection table = getDB().getCollection("test");

        BasicDBObject dbObject = new BasicDBObject();

        //mongodb实现大于小于区间的查询，注意大于是$gt,小于是$lt

        dbObject.put("likes", new BasicDBObject("$gt", 100).append("$lt",500));

        MongoCursor<Document> cursor = table.find(dbObject).iterator();

        while (cursor.hasNext()) {

            System.out.println(cursor.next());
            System.out.println(cursor.next().toJson());
        }

    }

    public static void createIndexes(){
        MongoCollection<Document> collection = getDB().getCollection("test");
//        collection.createIndex(new Document("title", 1));
//        collection.createIndex(Indexes.ascending("create_time"));
//        collection.createIndex(Indexes.compoundIndex(Indexes.ascending("create_time"), Indexes.ascending("likes")));
//        IndexOptions indexOptions = new IndexOptions().unique(true);
        collection.createIndex(Indexes.hashed("_id"));
    }

    public static void findLimit(){

        MongoDatabase mongoDatabase =getDB();
        MongoCollection<Document> collection = mongoDatabase.getCollection("test");
        FindIterable<Document> findIterable = collection.find(Filters.eq("title", "MongoDB")).limit(10).sort(new BasicDBObject("likes",1));

        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while(mongoCursor.hasNext()){
            System.out.println(mongoCursor.next().toJson());
        }
    }

    public static void main( String args[] ){
        updateDoc();
    }
}
